package it.polito.tdp.bar.model;

public class Event implements Comparable<Event> {
	private int ora ; //LocalTime perché ho orari espliciti
	private EventType tipo ;
	
	private int num_persone;
	private int permanenzaMinuti;//tra 60 e 120
	private float tolleranza;
	
	public Event(int ora, EventType tipo, int num_persone, int permanenzaMinuti, float tolleranza) {
		super();
		this.ora = ora;
		this.tipo = tipo;
		this.num_persone = num_persone;
		this.permanenzaMinuti = permanenzaMinuti;
		this.tolleranza = tolleranza;
	}

	public int getOra() {
		return ora;
	}

	public EventType getTipo() {
		return tipo;
	}

	public int getNum_persone() {
		return num_persone;
	}

	public int getPermanenzaMinuti() {
		return permanenzaMinuti;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	@Override
	public int compareTo(Event o) {
		return this.ora-o.ora;
	} 
	
	
	

}
