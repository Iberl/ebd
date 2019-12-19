package ebd.dmi.ui.templates;

//import ebd.dmi.ui.MainFrame;
import ebd.dmi.ui.Updatable;
import ebd.dmi.ui.utility.DMIPictures;
import ebd.dmi.ui.utility.DMIUtility;

public class MyChangeableLabel extends MyLabel implements Updatable {

	private static final long serialVersionUID = 1L;

	private String identifier;
	private DMIPictures icon;
	private DMIPictures secondIcon = null;


	public MyChangeableLabel(int x, int y, int width, int height, DMIPictures pic) {
		super(x, y, width, height, pic);
		setDisabledIcon(null);
		this.icon = pic;
		addToChangers();
	}

	public void update(String updateValue) {
		boolean b = Boolean.parseBoolean(updateValue);
		if (b) {
			setIcon(DMIUtility.instance().getIcon(this.icon));
		} else {
			if (this.secondIcon == null) {
				setIcon(null);
			} else {
				setIcon(DMIUtility.instance().getIcon(this.secondIcon));
			}
		}
	}

	public void addToChangers() {
		//TODO: Abhängigkeiten von MainFrame entfernen
		//MainFrame.getHauptFrame().addToChangeYourValue(this);
	}

	public void setSecondIcon(DMIPictures icon) {
		this.secondIcon = icon;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public DMIPictures getSecondIcon() {
		return this.secondIcon;
	}
}