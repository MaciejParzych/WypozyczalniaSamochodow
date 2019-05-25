package WypozyczalniaSamochodow.core;

import WypozyczalniaSamochodow.gui.MainWindow;

import javax.swing.*;
import java.awt.*;

public abstract class SettingsClass {
    public static void setIcon(MainWindow window) {
        Image icon = new ImageIcon("C:\\Users\\Maciej\\Desktop\\iJ\\todoswing-master\\car1.png").getImage();
        window.setIconImage(icon);

    }
}