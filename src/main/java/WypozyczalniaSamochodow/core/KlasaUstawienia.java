package WypozyczalniaSamochodow.core;

import WypozyczalniaSamochodow.gui.GlowneOkno;

import javax.swing.*;
import java.awt.*;

public abstract class KlasaUstawienia {
    public static void ustawIkone(GlowneOkno window) {
        Image ikona = new ImageIcon("car1.png").getImage();
        window.setIconImage(ikona);




    }

}