package WypozyczalniaSamochodow;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import WypozyczalniaSamochodow.gui.MainWindow;

import java.awt.*;

public class TodoApp {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//        configureLookAndFeel();

        MainWindow window = new MainWindow();

        setIcon(window);


//        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    static void setIcon(MainWindow window){
        Image icon = new ImageIcon("C:\\Users\\Maciej\\Desktop\\iJ\\todoswing-master\\car1.png").getImage();
        window.setIconImage(icon);

    }

    private static void configureLookAndFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break; //preferred!
                }
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
        }
    }
}
