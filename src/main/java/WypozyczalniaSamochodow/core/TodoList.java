package WypozyczalniaSamochodow.core;

import java.util.*;

public class TodoList implements  Ustawienia {

    private List<String> list = new LinkedList<>();

    public void wGore(int i) {
        if (i > 0) {
            String swap = this.list.get(i - 1);
            this.list.set(i - 1, this.list.get(i));
            this.list.set(i, swap);
        }
    }

    public void wDol(int i) {
        if (i < this.list.size() - 1) {
            String swap = this.list.get(i + 1);
            this.list.set(i + 1, this.list.get(i));
            this.list.set(i, swap);
        }
    }

    public void dodaj(String item) {
        this.list.add(item);
    }



//    public void editAt(int i, String newValue) {
//        if (i >= 0 && i < this.list.size()) {
//            this.list.set(i, newValue);
//        }
//    }

    public void usun(int i) {
        if (i >= 0 && i < this.list.size()) {
            this.list.remove(i);
        }
    }

    public int size() {
        return list.size();
    }

    public String elementAt(int i) {
        return list.get(i);
    }

//    @Override
//    public Iterator<String> iterator() {
//        return list.iterator();
//    }
}
