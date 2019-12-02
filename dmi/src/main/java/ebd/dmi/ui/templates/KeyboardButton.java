/**
 * 
 */
package ebd.dmi.ui.templates;

import java.awt.event.ActionEvent;


/**
 * @author <i>Aron</i><br>
 * 
 */
public class KeyboardButton extends MyButton {

	private static final long serialVersionUID = -4265485567631115708L;

	MyTextField label = null;


	/**
	 * @param x
	 * @param y
	 * @param str
	 */
	public KeyboardButton(int x, int y, String str, MyTextField txtNumber) {
		super(x, y, 102, 50, str);
		this.label = txtNumber;
	}


	/*
	 * (non-Javadoc)
	 * @see ui.MeinButton#clickAction(java.awt.event.ActionEvent)
	 */
	@Override
	public void clickAction(ActionEvent e) {
		String str = "";
		if (this.label == null) {
			System.out.println("Kein zugewiesenes Label!");
			return;
		} else if (toString().equals("Del")) {
			str = this.label.getText();
			str = str.substring(0, str.length() - 1);
			this.label.setText(str);
		} else if (toString().equals("C")) {
			this.label.setText("");
		} else {
			this.label.setText(this.label.getText() + toString());
		}
	}
}
