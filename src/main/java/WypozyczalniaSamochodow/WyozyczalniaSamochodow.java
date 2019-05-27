package WypozyczalniaSamochodow;


import WypozyczalniaSamochodow.core.SettingsClass;
import WypozyczalniaSamochodow.gui.MainWindow;


public class WyozyczalniaSamochodow extends SettingsClass {

    public static void main(String[] args) {
        MainWindow window = new MainWindow();

        setIcon(window);


        window.setVisible(true);
    }
}
