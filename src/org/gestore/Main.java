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
		
		ProgrammaEventi eventi = null;
		Evento evento = null;
		String resp = "";
		int scelta = 0;
		boolean newEventoFlag = true;
		
		// CREAZIONE PROGRAMMA EVENTI
		System.out.print("Inserire nome programma eventi: ");
		String nomeProgramma = scan.nextLine();		
		eventi = new ProgrammaEventi(nomeProgramma);
		
		
		// STAMPA PROGRAMMA EVENTI
		boolean exit = false;
		while(!exit) {
			String fin = "°°°°";
			for (int i = 0; i < eventi.getTitolo().length(); i++) 
				fin += "°";
			
			System.out.println("\n" + fin + "\n");
			System.out.println(eventi);
			System.out.println(fin + "\n");
			
			System.out.println("Cosa desideri fare adesso? \n");
			System.out.println("1) aggiungere un evento");
			System.out.println("2) contare eventi");
			System.out.println("3) filtrare per data");
			System.out.println("4) ordinare per data");
			System.out.println("5) svuotare il programma");
			System.out.println("6) esci");
			
			scelta = Integer.valueOf(scan.nextLine());
			
			switch (scelta) {
				case 1: {
					while (newEventoFlag) {
							
							// EVENTO
							try {
								System.out.println("\n°°Nuovo evento°°\n");
								System.out.print("Inserire titolo: ");
								String titolo = scan.nextLine();
								System.out.print("Inserire data (yyyy-mm-dd): ");
								LocalDate data = LocalDate.parse(scan.nextLine());
								System.out.print("Inserire numero posti totali: ");
								int postiTotali = Integer.valueOf(scan.nextLine());
								
								evento = new Evento(titolo, data, postiTotali);			
								eventi.addEvento(evento);
								System.out.println("\n[ "+ evento + " ]\n");
							} catch (Exception e) {
								System.err.println(e.getMessage());
							}
							
							// AGGIUNGERE PRENOTAZIONI
							boolean c = true;				
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
							
							// DISDIRE PRENOTAZIONI
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
							break;
					}
					break;
				}
				case 2: {
					System.out.println("\nNumero eventi: " + eventi.numeroEventi());
					break;
				}
				case 3: {
					System.out.print("\nInserire data (yyyy-mm-dd): ");
					LocalDate data = LocalDate.parse(scan.nextLine());
					System.out.print("\nEventi con la data inserita:\n");
					eventi.resEventiData(data);
					break;
				}
				case 4: {
					System.out.print("\nElenco eventi ordinati per data:\n" + eventi);
					break;
				}
				case 5: {
					eventi.svuotaLista();
					break;
				}
				case 6: {
					exit = true;
					System.out.println("\nSei uscito dal programma!\n");
					break;
				}
			}
		}
						
//		System.out.println("------------\n");
//		System.out.println("[ concerto ]");
//		
//		try {
//			BigDecimal n = BigDecimal.valueOf(32.504);
//			Concerto con = new Concerto("bello", LocalDate.of(2023, 12, 12), 100, LocalTime.of(22, 30), n);
//			System.out.println(con);		
//		} catch (Exception e) {
//			e.getMessage();
//		}
	}
}