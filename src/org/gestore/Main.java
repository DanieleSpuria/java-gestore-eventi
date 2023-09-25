package org.gestore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.events.Concerto;
import org.events.Evento;

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
				
		int preno = -1;
		String resp = "";
		while(preno < 0 || preno > evento.getPostiTotali()) {
			try {
					System.out.print("Vuoi aggiungere delle prenotazioni? (s/n): ");
					resp = scan.nextLine();
					if (resp.equalsIgnoreCase("s")) {
						System.out.print("Quante prenotazioni vuoi aggiungere? ");
						preno = Integer.valueOf(scan.nextLine());
						evento.prenota(preno);
						System.out.println("");
					}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println(evento.getPosti() + "\n");
			
		}
		
		int disdo = -1;
		while(disdo < 0 || disdo > evento.getPostiTotali()) {

			try {
					System.out.print("Vuoi disdire dei posti? (s/n): ");
					resp = scan.nextLine();
					if (resp.equalsIgnoreCase("s")) {
						System.out.print("Quanti posti vuoi disdire? ");
						disdo = Integer.valueOf(scan.nextLine());
						evento.disdici(disdo);
						System.out.println("");
					}
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
	}
}