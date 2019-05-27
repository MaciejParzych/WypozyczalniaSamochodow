package WypozyczalniaSamochodow.core;

import java.util.*;

public class ListaSchemat implements  Ustawienia {

    private List<String> list = new LinkedList<>();

    public void wGore(int i) {
        if (i > 0) {
            String zamien = this.list.get(i - 1);
            this.list.set(i - 1, this.list.get(i));
            this.list.set(i, zamien);
        }
    }

    public void wDol(int i) {
        if (i < this.list.size() - 1) {
            String zamien = this.list.get(i + 1);
            this.list.set(i + 1, this.list.get(i));
            this.list.set(i, zamien);
        }
    }

    public void dodaj(String przedmiot) {
        this.list.add(przedmiot);
    }


    public void usun(int i) {
        if (i >= 0 && i < this.list.size()) {
            this.list.remove(i);
        }
    }

    public int rozmiar() {
        return list.size();
    }

    public String elementAt(int i) {
        return list.get(i);
    }

}
