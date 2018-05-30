package it.polito.tdp.bar.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class Simulatore {
	
		// Parametri
		private int TOT_TAVOLI = 15; // numero totale di tavoli
		private int TOT_EVENTI = 2000;
		

		// Modello del mondo
		private List<Tavolo> tavoli;
		private int capienza;
		
		
		// Valori in output
		private Statistiche statistiche;
		
		// Coda degli eventi
		private PriorityQueue<Event> queue = new PriorityQueue<Event>();
		
		public void init() {
			tavoli = new ArrayList<Tavolo>();
			
			for(int i = 0; i<2;i++) {
				Tavolo t = new Tavolo(10, true);
				tavoli.add(t);
			}
			
			for(int i = 0; i<4;i++) {
				Tavolo t = new Tavolo(8, true);
				tavoli.add(t);
			}
			
			for(int i = 0; i<4;i++) {
				Tavolo t = new Tavolo(6, true);
				tavoli.add(t);
			}
			
			for(int i = 0; i<5;i++) {
				Tavolo t = new Tavolo(4, true);
				tavoli.add(t);
			}
			
			Collections.sort(tavoli);
			
			
			statistiche = new Statistiche(0, 0, 0);

			queue.clear();
			int time = 0 ;
			int numEventi = 0;
			while (numEventi<TOT_EVENTI) {
				int oraInizio = time+(int)Math.random()*10;
				int persone =  (int)(Math.random()*9+1);
				int permanenzaMinuti = (int) (1 + Math.random()*60+60);
				float tolleranza = (float) Math.random();
				
				Event e = new Event(oraInizio, EventType.ARRIVA,persone, permanenzaMinuti, tolleranza);
				queue.add(e) ;
				numEventi++;
				time = (int) Math.random()*10 ;//l'intervallo tra due eventi è compreso tra 1 e 10 minuti
			}
			
		}

		public void run() {
			Event e;
			while ((e = queue.poll()) != null) {//itero finché ho eventi nella coda
				processEvent(e);
			}
		}

		private void processEvent(Event e) {
			switch(e.getTipo()) {
			
			case ARRIVA:
				
				statistiche.setNumero_totale_clienti(statistiche.getNumero_totale_clienti()+e.getNum_persone());
				System.out.println(e.getNum_persone());
				boolean trovato = false;
				for(Tavolo t: tavoli) {
					if(t.isLibero() && e.getNum_persone() >= t.getNumPosti()/2) {
						t.setLibero(false);
						capienza = t.getNumPosti();
						statistiche.setClienti_soddisfatti(statistiche.getClienti_soddisfatti()+e.getNum_persone());
						Event e1 = new Event(e.getOra()+e.getPermanenzaMinuti(), EventType.USCITA, e.getNum_persone(), e.getPermanenzaMinuti(), e.getTolleranza());
						queue.add(e1);
						trovato=true;
						break;
					}
				}
				if(!trovato) {
					if(Math.random()<e.getTolleranza()) {
						//rimane-->BANCONE
						statistiche.setClienti_soddisfatti(statistiche.getClienti_soddisfatti()+e.getNum_persone());
					}else {
						//incremento insoddisfatti
						statistiche.setClienti_insoddisfatti(statistiche.getClienti_insoddisfatti()+e.getNum_persone());
					}
				}
				
				break;
					
			case USCITA://cliente soddisfatto, tempo scaduto
				
				for(Tavolo t : tavoli) {
					if(!t.isLibero() && t.getNumPosti() == capienza) {
						t.setLibero(true);
						break;
					}
				}
				break;
				
			}
			
		}

		public Statistiche getStatistiche() {
			return statistiche;
		}
		
		

}
