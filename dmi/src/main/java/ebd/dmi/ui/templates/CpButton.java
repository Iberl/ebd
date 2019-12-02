///**
// *
// */
//package ebd.dmi.ui.templates;
//
//import ebd.dmi.ui.utility.DMIPictures;
//
//import java.awt.event.ActionEvent;
//
///**
// * @author <i>Aron</i><br>
// *
// */
//public class CpButton extends MyButton {
//
//	private static final long serialVersionUID = -4673427978982659028L;
//
//
//	/**
//	 * @param x
//	 * @param y
//	 * @param breite
//	 * @param hoehe
//	 * @param str
//	 */
//	public CpButton(int x, int y, int breite, int hoehe, String str) {
//		super(x, y, breite, hoehe, str);
//	}
//
//
//	/**
//	 * @param x
//	 * @param y
//	 * @param breite
//	 * @param hoehe
//	 * @param str
//	 */
//	public CpButton(int x, int y, int breite, int hoehe, String str, DMIPictures pic) {
//		super(x, y, breite, hoehe, str, pic);
//	}
//
//
//	/*
//	 * (non-Javadoc)
//	 * @see ui.MeinButton#clickAction(java.awt.event.ActionEvent)
//	 */
//	@Override
//	public void clickAction(ActionEvent e) {
//		this.parent.switchCenter(e.getSource().toString());
//	}
//}
