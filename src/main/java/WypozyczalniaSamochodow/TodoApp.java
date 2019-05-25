package WypozyczalniaSamochodow;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import WypozyczalniaSamochodow.core.SettingsClass;
import WypozyczalniaSamochodow.gui.MainWindow;


public class TodoApp extends SettingsClass {

    public static void main(String[] args)
//            throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//        configureLookAndFeel();
    {
        MainWindow window = new MainWindow();

        setIcon(window);


//        window.setLocationRelativeTo(null);
        window.setVisible(true);
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
