package org.gestore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import org.events.Concerto;
import org.events.Evento;
import org.events.ProgrammaEventi;
import org.events.Spettacolo;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ProgrammaEventi eventi = null;
		Evento evento = null;
		String resp = "";
		int scelta = 0;
		boolean newEventoFlag = true;
		String prezzoStr = "";
		
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
			System.out.println("2) info eventi");
			System.out.println("3) contare eventi");
			System.out.println("4) filtrare per data");
			System.out.println("5) ordinare per data");
			System.out.println("6) svuotare il programma");
			System.out.println("7) esci");
			
			scelta = Integer.valueOf(scan.nextLine());
			
			switch (scelta) {
				case 1: {
					while (newEventoFlag) {	
						// EVENTO
						System.out.println("\nScegli il tipo di evento:");
						System.out.println("1) concerto");
						System.out.println("2) spettacolo");
						
						scelta = Integer.valueOf(scan.nextLine());
	
						try {
							System.out.println("\n°°Nuovo evento°°\n");
							System.out.print("Inserire titolo: ");
							String titolo = scan.nextLine();
							System.out.print("Inserire data (yyyy-mm-dd): ");
							LocalDate data = LocalDate.parse(scan.nextLine());
							System.out.print("Inserire numero posti totali: ");
							int postiTotali = Integer.valueOf(scan.nextLine());
							
							if (scelta == 1) {
								System.out.print("Inserisci orario (hh:mm): ");
								LocalTime orario = LocalTime.parse(scan.nextLine());
								System.out.print("Inserisci prezzo (00.00...): ");
								prezzoStr = scan.nextLine();
								BigDecimal prezzo = new BigDecimal(prezzoStr);
								
								evento = new Concerto(titolo, data, postiTotali, orario, prezzo);	
							}
							
							if (scelta == 2) {
								System.out.print("Inserisci prezzo (00.00...): ");
								prezzoStr = scan.nextLine();
								BigDecimal prezzo = new BigDecimal(prezzoStr);
								
								evento = new Spettacolo(titolo, data, postiTotali, prezzo);	
							}
									
							eventi.addEvento(evento);
							System.out.println("\n"+ evento + "\n");
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
						
						// PRENOTAZIONI
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
							System.out.println(evento + "\n");
						}
						
						// DISDIRE 
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
							System.out.println(evento + "\n");
						}
						break;
					}
					break;
				}
				case 2: {
					System.out.println("\nInfo eventi: \n");
					eventi.resEventi();
				}
				case 3: {
					System.out.println("\nNumero eventi: " + eventi.numeroEventi());
					break;
				}
				case 4: {
					System.out.print("\nInserire data (yyyy-mm-dd): ");
					LocalDate data = LocalDate.parse(scan.nextLine());
					System.out.print("\nEventi con la data inserita:\n");
					eventi.resEventiData(data);
					break;
				}
				case 5: {
					System.out.print("\nElenco eventi ordinati per data:\n" + eventi);
					break;
				}
				case 6: {
					eventi.svuotaLista();
					break;
				}
				case 7: {
					exit = true;
					System.out.println("\nSei uscito dal programma!\n");
					break;
				}
			}
		}
		scan.close();
	}
}