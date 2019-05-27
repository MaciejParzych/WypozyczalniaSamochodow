package WypozyczalniaSamochodow.core;


public interface Settings {

    void moveUp(int i);
    void moveDown(int i);
    void add(String item);
    void removeAt(int i);
    int size();
    String elementAt(int i);

}
