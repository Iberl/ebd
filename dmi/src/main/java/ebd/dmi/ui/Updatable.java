package ebd.dmi.ui;

public interface Updatable {

	public void update(String updateValue);


	public void addToChangers();


	public String getIdentifier();


	public abstract void setIdentifier(String identifier);

}
