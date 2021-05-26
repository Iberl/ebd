package de.ibw.history;

import de.ibw.history.data.ComposedRoute;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.occupation.MAOccupation;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.occupation.intf.IMoveable;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.util.ThreadedRepo;
import ebd.internal.util.MA;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

/**
 * Manager der occupations auf Tracks verwaltet
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 2021-04-27
 *
 */
public class TrackAndOccupationManager {


    /**
     * reseverd MA of current Ma communicated by tms is written as blocked for all furhter MaRequest
     *  @param trainId - Integer - Id of Train the MA-Request is refering to
     * @param MAO - Request Occupation
     * @param rbcMa - Ma send to RBC
     * @param r - route Composed by tms
     * @param requestedTrackElementList - Composed Route updated
     *
     */
    public static void transferMaRequestBlockListIntoRealBlockList(int trainId, MARequestOccupation MAO, MA rbcMa, Route r, ComposedRoute requestedTrackElementList) throws InvalidParameterException {
        guardTransfer(MAO, rbcMa,r);
        TopologyGraph.Edge LastEdge = (TopologyGraph.Edge) requestedTrackElementList.get(requestedTrackElementList.size() - 1).getRight();
        int q_scale = rbcMa.q_scale;

        MAOccupation MaoOccup = MAOccupation.generateMaOccupation(trainId, MAO, rbcMa, r, requestedTrackElementList, LastEdge, q_scale);


        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                MAOccupation.class,
                MaoOccup);
        TrackAndOccupationManager.removeOccupation(MARequestOccupation.class, MAO);

    }



    public static class VehicleStorage extends ThreadedRepo<Class<?>, VehicleStorageItem> { }
    private static class VehicleStorageItem extends ThreadedRepo<MovableObject, ThreadedRepo<TrackEdge, ArrayList<Occupation>>> { }


    public static enum Operations {
        StoreOperation, RemoveOperation
    }





    private static Class<?>[] vehicleTypes = {VehicleOccupation.class, MAOccupation.class, MARequestOccupation.class};


    private static ThreadedRepo<Class<?>, ThreadedRepo<TrackEdge, ArrayList<Occupation>>> Storage = new ThreadedRepo<>();

    private static VehicleStorage VehicleOccStorage = new VehicleStorage();

    // speichert Occupation nach Kommunikation - (UUID) UND NICHT nach der UUID zur Identifizierung der Occupation
    public static ThreadedRepo<UUID, TmsMovementPermissionRequest> RequestManager = new ThreadedRepo<>();


    static {
        if(Storage == null) Storage = new ThreadedRepo<>();
        Storage.update(VehicleOccupation.class, new ThreadedRepo<>());
    }

    /**
     * Es wird eine Zuordnung von TrackEdge-Kanten zu Occupations wiedergegeben.
     * Diese werden als Kopie wiedergegeben, damit der TrackAndOccupationManager nicht by reference verändert werden
     * kann.
     * @param OccupationType - Klasse der Occupation als Filter
     * @param MO - Moveable Object ein bestimmtes Vehicle als Filter
     * @return Zuordnung von Kanten zu Occupation als Repository
     * @throws CloneNotSupportedException - falls das Kopieren nicht funktioniert hat
     * @throws InvalidParameterException - falls Occupation Type null angegeben wurde
     */
    public static ThreadedRepo<TrackEdge, ArrayList<Occupation>> getReadOnly(
            Class<?> OccupationType,
            MovableObject MO) throws CloneNotSupportedException, InvalidParameterException {
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> result = new ThreadedRepo<>();
        if(OccupationType == null) {
            throw new InvalidParameterException("Occupation Type must not be null");
        }
        if(Arrays.stream(vehicleTypes).anyMatch(x -> x.equals(OccupationType))) {
            return handleVehicleOccupation(OccupationType, MO, result);
        } else {
            result = Storage.getModel(OccupationType);
            if(result == null) result = new ThreadedRepo<>();
            return (ThreadedRepo<TrackEdge, ArrayList<Occupation>>) result.clone();
        }
    }

    private static ThreadedRepo<TrackEdge, ArrayList<Occupation>> handleVehicleOccupation(Class<?> OccupationType, MovableObject MO, ThreadedRepo<TrackEdge, ArrayList<Occupation>> result) throws CloneNotSupportedException {
        VehicleStorageItem Item = VehicleOccStorage.getModel(OccupationType);
        if(Item == null) Item = new VehicleStorageItem();
        if(MO == null) {

            Iterator<ThreadedRepo<TrackEdge, ArrayList<Occupation>>> it =
                    Item.getAll().iterator();
            while(it.hasNext()) {
                handleMerge(result, it);
            }
            return result;
        } else {
            result = Item.getModel(MO);
            if(result == null) result = new ThreadedRepo<>();
            return (ThreadedRepo<TrackEdge, ArrayList<Occupation>>) result.clone();



        }
    }

    private static void handleMerge(ThreadedRepo<TrackEdge, ArrayList<Occupation>> result, Iterator<ThreadedRepo<TrackEdge, ArrayList<Occupation>>> it) {
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> mergeItem = it.next();
        if(mergeItem == null) return;
        ArrayList<TrackEdge> mergeKeys = mergeItem.getKeys();
        for(TrackEdge E : mergeKeys) {
            mergeItemIntoResult(result, mergeItem, E);
        }
    }

    private static void mergeItemIntoResult(ThreadedRepo<TrackEdge, ArrayList<Occupation>> result, ThreadedRepo<TrackEdge, ArrayList<Occupation>> mergeItem, TrackEdge E) {
        ArrayList<Occupation> toJoin = mergeItem.getModel(E);
        if(toJoin == null) return;
        if(toJoin.isEmpty()) return;
        ArrayList<Occupation> occupations = result.getModel(E);
        if(occupations == null) occupations = new ArrayList<>();
        for(Occupation O : toJoin) {
            if(O == null) continue;
            if(!occupations.contains(O)) occupations.add(O);
        }
        result.update(E, occupations);
    }


    /**
     * Startet eine Speicher oder Entfern operation
     * @param Op - type of operation (Speichern oder Entfernen)
     * @param OccupationType - occ -  Typ der Occupation (Belegung)
     * @param O -  Objekt das gespeichert oder entfernt (freigegeben) werden soll
     * @throws InvalidParameterException - bei invalide null-Werten
     */
    public static synchronized void startOperation(Operations Op, Class<?> OccupationType, Occupation O )
            throws InvalidParameterException {
        guardManager(Op, OccupationType, O);
        if(Op.equals(Operations.StoreOperation)) {
            storeOccupation(OccupationType, O);
        }
        if(Op.equals(Operations.RemoveOperation)) {
            removeOccupation(OccupationType, O);
        }
    }

    private static void guardManager(Operations op, Class<?> occupationType, Occupation o) {
        if(op == null) throw new InvalidParameterException("Operation must not be null");
        if(occupationType == null) throw new InvalidParameterException("Occupation Type must not be null");
        if(o == null) throw new InvalidParameterException("Occupation must not be null");
    }

    /**
     * stores Occupation by Occupation type
     * @param OccupationType - class of Occupation
     * @param O - Occupation
     */
    private static synchronized void storeOccupation(Class<?> OccupationType, Occupation O) {
        if(checkIfVehicleOccupation(OccupationType)) {
            VehicleStorageItem StoreItem = VehicleOccStorage.getModel(OccupationType);
            if(StoreItem == null) {
                StoreItem = new VehicleStorageItem();
            }
            storeVehicleOccupation(OccupationType, StoreItem,  O);

        } else {
            useMainStorage(OccupationType, O);
        }
    }

    private static boolean checkIfVehicleOccupation(Class<?> OccupationType) {
        return Arrays.asList(vehicleTypes).contains(OccupationType);
    }

    /**
     * entfernt die angegebenen Belegung aus den Manager
     * @param OccupationType - typ der angegebenen Belegung
     * @param O - Belegeung die entfernt wird (Eine Belegung wird wieder aufgeloest)
     */
    private static synchronized void removeOccupation(Class<?> OccupationType, Occupation O) {
        ArrayList<TrackEdge> deleteLocations = new ArrayList<>();
        for(TrackEdgeSection sections : O.getTrackEdgeSections()) {
            TrackEdge TE = sections.getTrackEdge();
            if(!deleteLocations.contains(TE)) {
                deleteLocations.add(TE);
            }
        }

        ThreadedRepo mainStorage = Storage.getModel(OccupationType);
        ArrayList<Occupation> deleteOccupations = new ArrayList<>();
        deleteOccupations.add(O);

        for(TrackEdge EdgeOfDeleteLocation : deleteLocations) {
            deleteOccupationOnEdge(mainStorage, deleteOccupations, EdgeOfDeleteLocation);
        }
        Storage.update(OccupationType, mainStorage);
        if(checkIfVehicleOccupation(OccupationType)){
            VehicleStorageItem StoreItem = VehicleOccStorage.getModel(OccupationType);
            if(StoreItem == null) StoreItem = new VehicleStorageItem();
            StoreItem.update(((IMoveable) O).getTargetMoveableObject(), mainStorage);
            VehicleOccStorage.update(OccupationType, StoreItem);
        }


    }


    private static void useMainStorage(Class<?> OccupationType, Occupation O) {
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> typedStorage =  Storage.getModel(OccupationType);
        if(typedStorage == null) {
            typedStorage = new ThreadedRepo<>();
        }
        for(TrackEdgeSection TES : O.getTrackEdgeSections()) {
            handleTrackEdge(O, typedStorage, TES);

        }
        Storage.update(OccupationType, typedStorage);
    }

    private static void handleTrackEdge(Occupation O, ThreadedRepo<TrackEdge, ArrayList<Occupation>> typedStorage, TrackEdgeSection TES) {
        TrackEdge TE = TES.getTrackEdge();
        ArrayList occs = typedStorage.getModel(TE);
        if(occs == null) occs = new ArrayList();
        if(!occs.contains(O)) {
            occs.add(O);
        }
        typedStorage.update(TE, occs);
    }


    /**
     * updates Occupation of Vehicle
     *
     * @param occupationType
     * @param VO - Update Item
     * @throws InvalidParameterException - when Vehicle Occupation having no Movable Object
     */
    private static synchronized void storeVehicleOccupation(Class<?> occupationType, VehicleStorageItem StoreItem, Occupation VO)
            throws InvalidParameterException {
        MovableObject MO = ((IMoveable)VO).getTargetMoveableObject();
        ThreadedRepo mainStorage = Storage.getModel(occupationType);
        if(mainStorage == null) mainStorage = new ThreadedRepo();
        if(MO == null) throw new InvalidParameterException("Vehicle Occupation must have a link to a movable Object");
        ThreadedRepo<TrackEdge, ArrayList<Occupation>> existingOcc = StoreItem.getModel(MO);
        if(existingOcc == null) {
            existingOcc = new ThreadedRepo<>();
        }
        handleExistingOcc(VO, mainStorage, existingOcc, MO, StoreItem);

        Storage.update(occupationType, mainStorage);

        VehicleOccStorage.update(occupationType, StoreItem);
    }

    private static void handleExistingOcc(Occupation VO, ThreadedRepo mainStorage, ThreadedRepo<TrackEdge,
            ArrayList<Occupation>> existingOcc, MovableObject MO, VehicleStorageItem storeItem) {
        ArrayList<Occupation> deleteOccupations = new ArrayList<>();
        ArrayList<TrackEdge> deleteLocations = existingOcc.getKeys();
        for( ArrayList occupations : existingOcc.getAll()) {
            for(Object OccToDelete : occupations) {
                if(!deleteOccupations.contains(OccToDelete)) {
                    deleteOccupations.add((Occupation) OccToDelete);
                }
            }
        }
        for(TrackEdge EdgeOfDeleteLocation : deleteLocations) {
            deleteOccupationOnEdge(mainStorage, deleteOccupations, EdgeOfDeleteLocation);
        }
        storeVehicleOcc(VO, mainStorage, MO, storeItem);

    }

    private static void deleteOccupationOnEdge(ThreadedRepo mainStorage,
                                               ArrayList<Occupation> deleteOccupations,
                                               TrackEdge EdgeOfDeleteLocation) {
        ArrayList<VehicleOccupation> occList =
                (ArrayList<VehicleOccupation>) mainStorage.getModel(EdgeOfDeleteLocation);
        for(Occupation DeleteOcc : deleteOccupations) {
            occList.remove(DeleteOcc);
        }
        mainStorage.update(EdgeOfDeleteLocation, occList);
    }

    private static void storeVehicleOcc(Occupation VO, ThreadedRepo mainStorage, MovableObject MO,
                                        VehicleStorageItem storeItem) {

        ThreadedRepo currentStorageForMo = new ThreadedRepo();
        ArrayList<TrackEdge> relatedEdges = new ArrayList<>();

        ArrayList<Occupation> vehicleOccupations = new ArrayList<>();
        vehicleOccupations.add(VO);
        ArrayList<TrackEdgeSection> sections = (ArrayList<TrackEdgeSection>) VO.getTrackEdgeSections();
        for(TrackEdgeSection S : sections) {
            TrackEdge T = S.getTrackEdge();
            if(!relatedEdges.contains(T)) {
                storeVehicleOccupation(VO, mainStorage, relatedEdges, T);
                MovableObject AcutalMO = ((IMoveable) VO).getTargetMoveableObject();
                if(MO.equals(AcutalMO)) {
                    ArrayList<Occupation> occList = (ArrayList<Occupation>) currentStorageForMo.getModel(T);
                    if(occList == null) occList = new ArrayList<>();
                    occList.add(VO);
                    currentStorageForMo.update(T,occList);
                }
            }

        }
        storeItem.update(MO, currentStorageForMo);

    }

    private static void storeVehicleOccupation(Occupation VO, ThreadedRepo mainStorage,
           ArrayList<TrackEdge> relatedEdges, TrackEdge T) {
        relatedEdges.add(T);
        //existingOcc.update(T, vehicleOccupations);
        ArrayList<Occupation> relatedOccupations =
                (ArrayList<Occupation>) mainStorage.getModel(T);
        if(relatedOccupations == null) relatedOccupations = new ArrayList<>();
        if(!relatedOccupations.contains(VO)) {
            relatedOccupations.add(VO);
            mainStorage.update(T, relatedOccupations);
        }
    }





    private static void guardTransfer(MARequestOccupation mao, MA rbcMa, Route r) throws InvalidParameterException {
        if(mao == null) throw new InvalidParameterException("MARequestOccupation must not be null");
        if(mao.getTrackEdgeSections() == null || mao.getTrackEdgeSections().size() == 0) throw new InvalidParameterException("MARequestionOccupation must have sections");
        if(rbcMa.eoa == null) throw new InvalidParameterException("MA Eoa must not be null");
        if(rbcMa.speedProfile == null) throw new InvalidParameterException("MA SpeedProfile must not be null");
        if(rbcMa.gradientProfile == null) throw new InvalidParameterException("MA Gradient Profile must not be null");
        if(rbcMa.modeProfile == null) throw new InvalidParameterException("MA Mode Profile must not be null");
        if(r == null) throw new InvalidParameterException("Route must not be null");


        // further checks in need

    }

}
