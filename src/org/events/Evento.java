package org.events;

import java.time.LocalDate;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;
	
	public Evento (String titolo, LocalDate data, int postiTotali) throws Exception {
		setTitolo(titolo);
		setData(data);
		if (postiTotali < 0) 
			throw new Exception("Il numero dei posti non può essere negativo!");
		else this.postiTotali = postiTotali;
	}
	
	public void prenota() throws Exception {
		if (postiTotali == postiPrenotati)
			throw new Exception("Sold out!");
		if (data.isBefore(LocalDate.now()))
			throw new Exception("L'evento è già passato!");
		postiPrenotati++;
	}
	
	public void disdici() throws Exception {
		if (postiPrenotati == 0)
			throw new Exception("Non ci sono prenotazioni!");
		if (data.isBefore(LocalDate.now()))
			throw new Exception("L'evento è già passato!");
		postiPrenotati--;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) throws Exception {
		if (data.isBefore(LocalDate.now())) 
			throw new Exception("Questa data è già passata!");
		this.data = data;
	}
	public int getPostiTotali() {
		return postiTotali;
	}
	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	@Override
	public String toString() {
		return getData() + " - " + getTitolo();
	}
}
