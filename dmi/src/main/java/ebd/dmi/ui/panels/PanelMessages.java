///**
// *
// */
//package ebd.dmi.ui.panels;
//
//import ebd.dmi.ui.Message;
//import ebd.dmi.ui.templates.MyPanel;
//import ebd.dmi.ui.utility.DMIUtility;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author <i>Aron</i><br>
// *
// */
//public class PanelMessages extends MyPanel {
//
//	private static final long serialVersionUID = 1L;
//
//	private final List<Message> messages = new ArrayList();
//
//	private int base = 0;
//
//
//	/**
//	 *
//	 */
//	public PanelMessages() {
//		super(54, 0, 234, 100);
//		setBorder(DMIUtility.instance().getMyLabelBorder());
//	}
//
//
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		g.setColor(Color.white);
//		// soll nur 5 zeilen darstellen
//		int zweier = 0;
//		int abstand = 5;
//		int size = this.messages.size();
//		for (int i = 0; i < 5 - zweier; i++) {
//			int off = i + this.base;
//			if (size - off >= 0 && size - off < size) {
//				Message msg = this.messages.get(size - off);
//
//				if (msg.isOneLiner()) {
//					g.drawString(msg.toString(), abstand, 15 + 15 * (i + zweier));
//				} else {
//					String[] msgs = msg.getMessages();
//					g.drawString(msgs[0], abstand, 15 + 15 * (i + zweier));
//					zweier++;
//					if (i < 5 - zweier) {
//						g.drawString(msgs[1], abstand, 15 + 15 * (i + zweier));
//					}
//				}
//			}
//		}
//	}
//
//
//	public void addMessage(String msg) {
//		this.messages.add(new Message(new Date(), msg));
//	}
//
//
//	public int getMessageCount() {
//		return this.messages.size();
//	}
//
//
//	public int getBase() {
//		return this.base;
//	}
//
//
//	public void setBase(int base) {
//		int oldBase = this.base;
//
//		base = Math.max(0, Math.min(base, getMessageCount() - 1));
//		this.base = base;
//		if (oldBase != base) {
//			repaint();
//		}
//	}
//
//
//	public void increaseBase() {
//		setBase(getBase() + 1);
//	}
//
//
//	public void decreaseBase() {
//		setBase(getBase() - 1);
//	}
//}
