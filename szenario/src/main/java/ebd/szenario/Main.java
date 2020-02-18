package ebd.szenario;

import ebd.globalUtils.configHandler.ConfigHandler;

public class Main {

    public static void main(String[] args) {
        if (ConfigHandler.getInstance() == null){
            System.out.println("Config Handler could not be opened");
            System.exit(0);
        }
        Szenario szenario = new Szenario();
    }
}
