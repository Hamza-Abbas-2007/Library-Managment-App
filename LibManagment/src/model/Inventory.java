package model;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Book> inv = new ArrayList<Book>();
	
	public Inventory(ArrayList<Book> inv) {
		this.setInv(inv);
	}

	public ArrayList<Book> getInv() {
		return inv;
	}

	public void setInv(ArrayList<Book> inv) {
		this.inv = inv;
	}
}
