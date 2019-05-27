package WypozyczalniaSamochodow.gui;

import javax.swing.AbstractListModel;

import WypozyczalniaSamochodow.core.ListaSchemat;

public class WypozyczalniaModel extends AbstractListModel<String> {
	private static final long serialVersionUID = 1L;

	protected ListaSchemat list;
	
	protected WypozyczalniaModel(ListaSchemat list) {
		this.list = list;
	}
	
	public void wGore(int i) {
		this.list.wGore(i);
		this.fireContentsChanged(this, i - 1, i);
	}
	
	public void wDol(int i) {
		this.list.wDol(i);
		this.fireContentsChanged(this, i, i + 1);
	}

	
	
	public void usun(int i) {
		this.list.usun(i);
		this.fireContentsChanged(this, i, i);
	}
	
	public void dodaj(String task) {
		this.list.dodaj(task);
		this.fireContentsChanged(this, 
				this.list.rozmiar() - 1, this.list.rozmiar() - 1);
	}

	
	@Override
	public int getSize() {
		return this.list.rozmiar();
	}
	@Override
	public String getElementAt(int index) {
		return this.list.elementAt(index);
	}
}
