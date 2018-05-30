package it.polito.tdp.bar.model;

public class Tavolo implements Comparable<Tavolo>{
	
	private int numPosti;
	private boolean libero;
	
	public Tavolo(int numPosti, boolean libero) {
		this.numPosti = numPosti;
		this.libero = libero;
	}
	
	public int getNumPosti() {
		return numPosti;
	}
	
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	
	public boolean isLibero() {
		return libero;
	}
	
	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	@Override
	public int compareTo(Tavolo altro) {//ordine crescente
		return this.getNumPosti()-altro.getNumPosti();
	}

}
