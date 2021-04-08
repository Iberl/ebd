package de.ibw.history;

import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.occupation.MAOccupation;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.occupation.intf.IMoveable;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.util.ThreadedRepo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Manager for occupations on Track
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 2021-04-07
 *
 */
public class TrackAndOccupationManager {

    public static class VehicleStorage extends ThreadedRepo<Class<?>, VehicleStorageItem> { }
    private static class VehicleStorageItem extends ThreadedRepo<MovableObject, ThreadedRepo<TrackEdge, ArrayList<Occupation>>> { }

    public static enum Operations {
        StoreOperation, RemoveOperation
    }





    private static Class<?>[] vehicleTypes = {VehicleOccupation.class, MAOccupation.class, MARequestOccupation.class};


    private static ThreadedRepo<Class<?>, ThreadedRepo<TrackEdge, ArrayList<Occupation>>> Storage = new ThreadedRepo<>();

    private static VehicleStorage VehicleOccStorage = new VehicleStorage();

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
            if(StoreItem == null) StoreItem = new VehicleStorageItem();
            storeVehicleOccupation(OccupationType, StoreItem,  O);
            VehicleOccStorage.update(OccupationType, StoreItem);
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

            storeVehicleOcc(VO,mainStorage);
        } else {
            handleExistingOcc(VO, mainStorage, existingOcc);

        }
        Storage.update(occupationType, mainStorage);
        StoreItem.update(MO, mainStorage);
    }

    private static void handleExistingOcc(Occupation VO, ThreadedRepo mainStorage, ThreadedRepo<TrackEdge,
            ArrayList<Occupation>> existingOcc) {
        ArrayList<Occupation> deleteOccupations = new ArrayList<>();
        ArrayList<TrackEdge> deleteLocations = existingOcc.getKeys();
        for( ArrayList<Occupation> occupations : existingOcc.getAll()) {
            for(Occupation OccToDelete : occupations) {
                if(!deleteOccupations.contains(OccToDelete)) {
                    deleteOccupations.add(OccToDelete);
                }
            }
        }
        storeVehicleOcc( VO, mainStorage);
        for(TrackEdge EdgeOfDeleteLocation : deleteLocations) {
            deleteOccupationOnEdge(mainStorage, deleteOccupations, EdgeOfDeleteLocation);
        }
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

    private static void storeVehicleOcc(Occupation VO, ThreadedRepo mainStorage) {

        ArrayList<TrackEdge> relatedEdges = new ArrayList<>();

        ArrayList<Occupation> vehicleOccupations = new ArrayList<>();
        vehicleOccupations.add(VO);
        ArrayList<TrackEdgeSection> sections = (ArrayList<TrackEdgeSection>) VO.getTrackEdgeSections();
        for(TrackEdgeSection S : sections) {
            TrackEdge T = S.getTrackEdge();
            if(!relatedEdges.contains(T)) {
                storeVehicleOccupation(VO, mainStorage, relatedEdges, T);

            }

        }

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


}
