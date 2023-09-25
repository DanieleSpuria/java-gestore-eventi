package org.gestore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.events.Concerto;
import org.events.Evento;
import org.events.ProgrammaEventi;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Evento evento = null;
		
		try {
			System.out.println("°°Nuovo evento°°\n");
			System.out.print("Inserire titolo: ");
			String titolo = scan.nextLine();
			System.out.print("Inserire data (yyyy-mm-dd): ");
			LocalDate data = LocalDate.parse(scan.nextLine());
			System.out.print("Inserire numero posti totali: ");
			int postiTotali = Integer.valueOf(scan.nextLine());
			
			evento = new Evento(titolo, data, postiTotali);			
			System.out.println("\n[ "+ evento + " ]\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		boolean c = true;
		String resp = "";
		while(c) {
			try {
					System.out.print("Vuoi aggiungere delle prenotazioni? (s/n): ");
					resp = scan.nextLine();
					if (resp.equalsIgnoreCase("s")) {
						System.out.print("Quante prenotazioni vuoi aggiungere? ");
						int preno = Integer.valueOf(scan.nextLine());
						evento.prenota(preno);
					}
					c = false;
					System.out.println("");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println(evento.getPosti() + "\n");
			
		}
		
		c = true;
		while(c) {
			try {
					System.out.print("Vuoi disdire dei posti? (s/n): ");
					resp = scan.nextLine();
					if (resp.equalsIgnoreCase("s")) {
						System.out.print("Quanti posti vuoi disdire? ");
						int disdo = Integer.valueOf(scan.nextLine());
						evento.disdici(disdo);
					}
						c = false;
					System.out.println("");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println(evento.getPosti() + "\n");
		}	
		
		scan.close();
		
		System.out.println("------------\n");
		System.out.println("[ concerto ]");
		
		try {
			BigDecimal n = BigDecimal.valueOf(32.504);
			Concerto con = new Concerto("bello", LocalDate.of(2023, 12, 12), 100, LocalTime.of(22, 30), n);
			System.out.println(con);		
		} catch (Exception e) {
			e.getMessage();
		}
		
		System.out.println("-------------\n");
		System.out.println("[ programma eventi ]\n");
		
		ProgrammaEventi pro = new ProgrammaEventi("bellissimi");
		
		try {
			Evento ev = new Evento("bello", LocalDate.of(2023, 12, 12), 100);
			Evento al = new Evento("poppo", LocalDate.of(2023, 10, 12), 100);
			Evento oi = new Evento("occhio", LocalDate.of(2023, 11, 10), 100);
			
			LocalDate loc = LocalDate.of(2023, 12, 12);
			
			pro.addEvento(ev);
			pro.addEvento(oi);
			pro.addEvento(al);
		
			System.out.println(pro);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}