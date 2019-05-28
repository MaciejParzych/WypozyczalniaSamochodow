package WypozyczalniaSamochodow;


import WypozyczalniaSamochodow.core.KlasaUstawienia;
import WypozyczalniaSamochodow.gui.GlowneOkno;


public class WypozyczalniaSamochodow extends KlasaUstawienia {

    public static void main(String[] args)  {
        GlowneOkno window = new GlowneOkno();
        ustawIkone(window);
        window.setVisible(true);

    }

}
