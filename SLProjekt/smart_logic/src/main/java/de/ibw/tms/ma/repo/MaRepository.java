package de.ibw.tms.ma.repo;

import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.util.DefaultRepo;

import java.util.Collection;
import java.util.HashMap;

public class MaRepository {
    private static HashMap<String, MaRequestWrapper> MaMap = new HashMap<String, MaRequestWrapper>();
    public static DefaultRepo<String, MaRequestWrapper> ConfirmedRequestsRepo = new DefaultRepo<>();
    public static void confirmMaRequest(MaRequestWrapper MaReq) {
        String sTrainId = MaReq.getTm().label;
        ConfirmedRequestsRepo.update(sTrainId, MaReq);
    }


    public static void update(MaRequestWrapper MaReq) {
        String sTrainId = MaReq.getTm().label;
        MaMap.put(sTrainId, MaReq);

    }

    public static MaRequestWrapper getRequest(String sId) {
        return MaMap.get(sId);
    }

    public static Collection<MaRequestWrapper> getMaList() {
        return MaMap.values();
    }

    public static void remove(MaRequestWrapper MaWrapper) {
        MaMap.remove(MaWrapper.getTm().label);
    }
}
