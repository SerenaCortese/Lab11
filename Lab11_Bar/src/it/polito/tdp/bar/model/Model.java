package it.polito.tdp.bar.model;

public class Model {
	
	private Simulatore sim;
	

	public Statistiche doCalcola() {
		sim = new Simulatore();
		sim.init();
		sim.run();
		
		return sim.getStatistiche();
		
	}

}
