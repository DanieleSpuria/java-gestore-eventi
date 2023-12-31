package org.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammaEventi {
	private String titolo;
	private List<Evento> eventi;
	private List<Evento> eventiOrdinati;
	
	public ProgrammaEventi(String titolo) {
		setTitolo(titolo);
		setEventi();
	}
	
	public void addEvento(Evento evento) {
		eventi.add(evento);
	}
	
	public void resEventi() {
		for (Evento evento : eventi) {
			System.out.println("[ " + evento.getTitolo() + " ]");
			System.out.println(evento + "\n");
		}
	}
	
	public void resEventiData(LocalDate data) {
		for (Evento evento : eventi)
			if (evento.getData().isEqual(data))
				System.out.println(evento.getData() + " / " + evento.getTitolo());
	}
	
	public int numeroEventi() {
		int count = 0;
		for (Evento evento : eventi)
			count ++;
		return count;
	}
	
	public void svuotaLista() {
		eventi.clear();
		System.out.println("\n" + titolo + " è stato svuotato con successo!");
	}
	
	public String dataLista() {
		String eventiOrd = "";
		eventiOrdinati = eventi.stream()
                .sorted(Comparator.comparing(Evento::getData))
                .collect(Collectors.toList());
		for (Evento evento : eventiOrdinati)
			eventiOrd += evento.getData() + " / " + evento.getTitolo() + "\n";
		return eventiOrd;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public List<Evento> getEventi() {
		return eventi;
	}
	public void setEventi() {
		eventi = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		
		return "\n[ " + getTitolo() + " ]\n" + "\n" 
				+ dataLista();
	}
}
