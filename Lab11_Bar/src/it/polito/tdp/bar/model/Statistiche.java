package it.polito.tdp.bar.model;

public class Statistiche {
	
	private int numero_totale_clienti;
	private int clienti_soddisfatti;
	private int clienti_insoddisfatti;
	
	public Statistiche(int numero_totale_clienti, int clienti_soddisfatti, int clienti_insoddisfatti) {
		super();
		this.numero_totale_clienti = numero_totale_clienti;
		this.clienti_soddisfatti = clienti_soddisfatti;
		this.clienti_insoddisfatti = clienti_insoddisfatti;
	}
	public int getNumero_totale_clienti() {
		return numero_totale_clienti;
	}
	public void setNumero_totale_clienti(int numero_totale_clienti) {
		this.numero_totale_clienti = numero_totale_clienti;
	}
	public int getClienti_soddisfatti() {
		return clienti_soddisfatti;
	}
	public void setClienti_soddisfatti(int clienti_soddisfatti) {
		this.clienti_soddisfatti = clienti_soddisfatti;
	}
	public int getClienti_insoddisfatti() {
		return clienti_insoddisfatti;
	}
	public void setClienti_insoddisfatti(int clienti_insoddisfatti) {
		this.clienti_insoddisfatti = clienti_insoddisfatti;
	}
	@Override
	public String toString() {
		return "Numero_totale_clienti=" + numero_totale_clienti + "\nClienti_soddisfatti="
				+ clienti_soddisfatti + "\nClienti_insoddisfatti=" + clienti_insoddisfatti+"\n";
	}
	

	

}
