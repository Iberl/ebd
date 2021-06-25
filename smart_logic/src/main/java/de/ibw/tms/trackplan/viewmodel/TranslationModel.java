package de.ibw.tms.trackplan.viewmodel;
/**
 * Dieses Model verwaltet die Position innerhalb der Streckenansicht.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-12
 */
public class TranslationModel {
    /**
     * Diese Klasse verwalet die Start-Positionen der unterschiedlichen Karten.
     */
    public static class TrackplanEnvironment {


        private static TranslationModel PHausen = new TranslationModel(4534097, 5627729);
        private static TranslationModel BBLU = new TranslationModel(-5415061, -5834664);
        private static TranslationModel Rueck = new TranslationModel(-5401239, -5716705);
        private static TranslationModel EBD = new TranslationModel(700,700);
        private static TrackplanEnvironment P_HausenEnv = new TrackplanEnvironment(PHausen, new ZoomModel(),
                "customised/test_pHausen_l1.ppxml");

        public static TrackplanEnvironment MartinsteinEnv2406 =
                new TrackplanEnvironment(EBD, new ZoomModel(),"customised/EBD_Martinstein_24_06V3.ppxml" );

        public static TrackplanEnvironment MartinsteinEnv210609 =
                new TrackplanEnvironment(EBD, new ZoomModel(),
                        "customised/ppj_martin_1806_cad_7-3_planPro_2021-06-09_15-59.ppxml" );

        public static TrackplanEnvironment MartinsteinWithoutBalisenEnv = new TrackplanEnvironment(EBD, new ZoomModel(),
                "customised/EBD_Martinstein_24_06V3_Ohne_Balisen.ppxml" );


        public static TrackplanEnvironment KaefWilhelmstalEnv =
                new TrackplanEnvironment(EBD, new ZoomModel(), "customised/GB_Szenario1.ppxml");


        private static TrackplanEnvironment EBDEnv = KaefWilhelmstalEnv;

        /**
         * Gerade benutztes Strecken-Setting
         */
        public static TrackplanEnvironment CurrentEnvironment = EBDEnv;



        private TranslationModel Translation;
        /**
         * Aktiver Zoom-Faktor als Model
         */
        public ZoomModel Zoom;
        /**
         * Ort der Plan-Pro-Datei in den Ressourcen des Java-Packages
         */
        public String resourceLocation;

        /**
         * Erstellt ein neues Setting mit Startpostion, Startzoom und Ort der Plan-Pro-Datei als Name in den
         * Java-Resourcen
         * @param translation {@link TranslationModel} - Startposition der Kartenansicht
         * @param zoom {@link ZoomModel} - Startzoom der Kartenansich
         * @param resourceLocation {@link String} - Name der Plan-Pro-Datei, als Resourcen-Name
         */
        public TrackplanEnvironment(TranslationModel translation, ZoomModel zoom, String resourceLocation) {
            Translation = translation;
            Zoom = zoom;
            this.resourceLocation = resourceLocation;
        }
    }
    

    private TranslationModel(double x , double y) {
        dMoveX = x;
        dMoveY = y;
    }

    /**
     * Gibt Aktuelle Karten-Positon als Model wider
     * @return TranslationModel - Kartenposition
     */
    public static TranslationModel getInstance() {
        return TrackplanEnvironment.CurrentEnvironment.Translation;
    }

    //private double dMoveX = -4534097;
    //private double dMoveY = -5627729;
    private double dMoveX = 0;
    private double dMoveY = 0;

    private String sInfo = "";

    /**
     * X-Position der betrachteten Kartenansicht
     * @return double - xpos
     */
    public double getdMoveX() {
        return dMoveX;
    }

    /**
     * Setzt neue X-Position des betrachteten Kartenausschnittes.
     * @param dMoveX double - neue x-Pos
     */
    public void setdMoveX(double dMoveX) {
        this.dMoveX = dMoveX;
    }
    /**
     * Y-Position der betrachteten Kartenansicht
     * @return double - ypos
     */
    public double getdMoveY() {
        return dMoveY;
    }
    /**
     * Setzt neue Y-Position des betrachteten Kartenausschnittes.
     * @param dMoveY double - neue y-Pos
     */
    public void setdMoveY(double dMoveY) {
        this.dMoveY = dMoveY;
    }

}
