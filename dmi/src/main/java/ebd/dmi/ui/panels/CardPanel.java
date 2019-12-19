//package ebd.dmi.ui.panels;
//
//import ebd.dmi.ui.MainFrame;
//import ebd.dmi.ui.Scalable;
//import ebd.dmi.ui.subwindows.*;
//import ebd.dmi.ui.templates.MyPanel;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author <i>Aron</i><br>
// *         CardPanel erbt von JPanel und setzt Specs automatisch um.
// */
//public class CardPanel extends MyPanel {
//
//	/**
//	 * Generated ID der Klasse.
//	 */
//	private static final long serialVersionUID = 5304063459271383933L;
//	final static int x = 334;
//	final static int y = 15;
//	final static int breite = 366;
//	final static int hoehe = 450;
//	private static CardPanel cp;
//	CardLayout cl = new CardLayout();
//	MainFrame frame;
//	public PanelG panelG;
//	public static PanelH panelH;
//	public PanelD panelD;
//
//
//	/**
//	 * Speichert alle Kinder, welche vom Interface Skalierbar erben.
//	 */
//	private List<Scalable> skalierbareKinder = new ArrayList<Scalable>();
//
//
//	/**
//	 * Konstruktor für das CardPanel.
//	 */
//	public CardPanel() {
//		super(x, y, breite, hoehe);
//		setLayout(this.cl);
//		CardPanel.cp = this;
//
//		// default panel
//		MyPanel panelStandard = new MyPanel(0, 0, breite, hoehe);
//
//		this.panelD = new PanelD();
//		panelStandard.add(this.panelD);
//
//		PanelF panelF = new PanelF();
//		panelStandard.add(panelF);
//
//		this.panelG = new PanelG();
//		panelStandard.add(this.panelG);
//
//		panelH = new PanelH();
//		panelStandard.add(panelH);
//
//		this.skalierbareKinder.add(panelStandard);
//
//		this.add(panelStandard, "Standard");
//		// fertig default panel
//
//		// Subwindows
//		PanelMenuWindow panelMf = new PanelMenuWindow();
//		this.add(panelMf, "Fenster");
//		// panelMf.setVisible(false);
//		this.skalierbareKinder.add(panelMf);
//
//		// Main Window
//		PanelMain panelM = new PanelMain();
//		this.add(panelM, "Main");
//
//		// Main Window
//		PanelTrainNumber panelTrainNumber = new PanelTrainNumber();
//		this.add(panelTrainNumber, "Train Running Number");
//
//		// Override Window
//		PanelOverride panelO = new PanelOverride();
//		this.add(panelO, "Override");
//
//		// Dataview 1 Window
//		PanelDataView panelData = new PanelDataView();
//		this.add(panelData, "DataView");
//
//		// Dataview 2 Window
//		PanelDataView2 panelData2 = new PanelDataView2();
//		this.add(panelData2, "DataView2");
//
//		// Special Window
//		PanelSpecial panelS = new PanelSpecial();
//		this.add(panelS, "Special");
//
//		// Adhesion Window
//		PanelAdhesion panelAdhesion = new PanelAdhesion();
//		this.add(panelAdhesion, "Adhesion");
//
//		// Special Window
//		PanelSettings panelSet = new PanelSettings();
//		this.add(panelSet, "Settings");
//
//		PanelTrainData panelTrainData = new PanelTrainData();
//		this.add(panelTrainData, "Train Data");
//
//		// fertig Subwindows
//
//	}
//
//
//	/**
//	 * Wechselt die Panels im CardLayout.
//	 *
//	 * @param btnName Name des Buttons, der switchCenter auslöste
//	 */
//	public final void switchCenter(final String btnName) {
//		if (btnName.equals("Main")) {
//			this.cl.show(this, "Main");
//		} else if (btnName.equals("Spec")) {
//			this.cl.show(this, "Special");
//		} else if (btnName.equals("Adhesion")) {
//			this.cl.show(this, "Adhesion");
//		} else if (btnName.equals("Train Running Number")) {
//			this.cl.show(this, "Train Running Number");
//		} else if (btnName.equals("Dataview")) {
//			this.cl.show(this, "DataView");
//		} else if (btnName.equals("Dataview2")) {
//			this.cl.show(this, "DataView2");
//		} else if (btnName.equals("Override")) {
//			this.cl.show(this, "Override");
//		} else if (btnName.equals("Settings")) {
//			this.cl.show(this, "Settings");
//		} else if (btnName.equals("Exit")) {
//			this.cl.show(this, "Standard");
//		} else if (btnName.equals("Train Data")) {
//			this.cl.show(this, "Train Data");
//		} else {
//			System.out.println("Kein assoziertes Panel für Button " + btnName);
//			System.out.println("Es wird zum TestPanel gegangen");
//			this.cl.show(this, "Fenster");
//		}
//
//		this.frame.resize();
//	}
//
//
//	/**
//	 * @return the CardPanel
//	 */
//	public final static CardPanel getCp() {
//		return cp;
//	}
//
//
//	@Override
//	public final void addChildren(final MainFrame f) {
//		this.frame = f;
//		super.addChildren(f);
//		for (Scalable s : this.skalierbareKinder) {
//			f.addScaleable(s);
//			if (s instanceof MyPanel) {
//				((MyPanel) s).addChildren(f);
//			}
//		}
//	}
//
//}
