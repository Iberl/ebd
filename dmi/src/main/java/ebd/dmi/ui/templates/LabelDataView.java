/**
 * 
 */
package ebd.dmi.ui.templates;

//import ebd.dmi.ui.MainFrame;
import ebd.dmi.ui.Updatable;

/**
 * @author aron
 * 
 */
public class LabelDataView extends MyLabel implements Updatable {

	private static final long serialVersionUID = -5543699229281834546L;

	public MyLabel data;
	int x;
	int y;
	int breite;
	int hoehe;
	private String identifier;


	/**
	 * @param x
	 * @param y
	 * @param breite
	 * @param hoehe
	 * @param str
	 */
	public LabelDataView(int x, int y, int breite, int hoehe, String str, boolean changeable) {
		super(204 - breite, y, breite, hoehe, str);
		this.x = 204 + 15;
		this.y = y;
		this.breite = 300 - 210;
		this.hoehe = hoehe;
		setBorder(null);
		setHorizontalAlignment(RIGHT);
		createDataField();
		if (changeable) {
			addToChangers();
		}
	}


	/**
	 * @param x
	 * @param y
	 * @param breite
	 * @param hoehe
	 * @param str
	 */
	public LabelDataView(int x, int y, int breite, int hoehe, String str) {
		super(204 - breite, y, breite, hoehe, str);
		this.x = 204 + 15;
		this.y = y;
		this.breite = 300 - 210;
		this.hoehe = hoehe;
		setBorder(null);
		setHorizontalAlignment(RIGHT);
		createDataField();
	}

	private void createDataField() {
		String str = "";
		MyLabel dataField = new MyLabel(this.x, this.y, this.breite, this.hoehe, str);
		dataField.setHorizontalAlignment(LEFT);
		dataField.setBorder(null);
		this.data = dataField;

	}

	public void update(String s) {
		if (this.data != null) {
			this.data.setText(s);
		}
	}

	public void addToChangers() {
		//TODO: Abhängigkeiten von MainFrame entfernen
		//MainFrame.getHauptFrame().addToChangeYourValue(this);
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setDataField(String s) {
		this.data.setText(s);
	}
}
