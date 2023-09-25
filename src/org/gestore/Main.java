package org.gestore;

import java.time.LocalDate;

import org.events.Evento;

public class Main {
	public static void main(String[] args) {
		try {
			Evento evento = new Evento("Bellissimo", 
					LocalDate.of(2023, 9, 30), 
					2);			
			System.out.println(evento);
			
			evento.prenota();
			System.out.println(evento);
			
			evento.prenota();
			System.out.println(evento);
			
			evento.disdici();
			System.out.println(evento);
			
			evento.disdici();
			System.out.println(evento);
			
			evento.disdici();
			System.out.println(evento);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}