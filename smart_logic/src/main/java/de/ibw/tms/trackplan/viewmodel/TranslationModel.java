package de.ibw.tms.trackplan.viewmodel;

public class TranslationModel {

    public static class TrackplanEnvironment {


        private static TranslationModel PHausen = new TranslationModel(4534097, 5627729);
        private static TranslationModel BBLU = new TranslationModel(-5415061, -5834664);
        private static TranslationModel Rueck = new TranslationModel(-5401239, -5716705);
        private static TranslationModel EBD = new TranslationModel(700,700);
        private static TrackplanEnvironment P_HausenEnv = new TrackplanEnvironment(PHausen, new ZoomModel(),
                "customised/test_pHausen_l1.ppxml");
        private static TrackplanEnvironment EBDEnv = new TrackplanEnvironment(EBD, new ZoomModel(),
                "customised/EBD_Martinstein_24_06V3.ppxml");


        public static TrackplanEnvironment CurrentEnvironment = EBDEnv;



        public TranslationModel Translation;
        public ZoomModel Zoom;
        public String resourceLocation;

        public TrackplanEnvironment(TranslationModel translation, ZoomModel zoom, String resourceLocation) {
            Translation = translation;
            Zoom = zoom;
            this.resourceLocation = resourceLocation;
        }
    }
    

    public TranslationModel(double x , double y) {
        dMoveX = x;
        dMoveY = y;
    }

    public static TranslationModel getInstance() {
        return TrackplanEnvironment.CurrentEnvironment.Translation;
    }

    //private double dMoveX = -4534097;
    //private double dMoveY = -5627729;
    private double dMoveX = 0;
    private double dMoveY = 0;

    private String sInfo = "";

    public double getdMoveX() {
        return dMoveX;
    }

    public void setdMoveX(double dMoveX) {
        this.dMoveX = dMoveX;
    }

    public double getdMoveY() {
        return dMoveY;
    }

    public void setdMoveY(double dMoveY) {
        this.dMoveY = dMoveY;
    }

    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }
}
