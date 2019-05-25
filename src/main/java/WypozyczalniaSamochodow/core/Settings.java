package WypozyczalniaSamochodow.core;

import java.util.Iterator;

public interface Settings {

    void moveUp(int i);
    void moveDown(int i);
    void add(String item);
    void editAt(int i, String newValue);
    void removeAt(int i);
    int size();
    String elementAt(int i);
    Iterator<String> iterator();

}
