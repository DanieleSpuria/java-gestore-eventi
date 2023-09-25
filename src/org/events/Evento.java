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
			throw new Exception("\nIl numero dei posti non può essere negativo!\n");
		else this.postiTotali = postiTotali;
	}
	
	public void prenota(int n) throws Exception {
		if (postiTotali == postiPrenotati)
			throw new Exception("\nSold out!\n");
		if (data.isBefore(LocalDate.now()))
			throw new Exception("\nL'evento è già passato!\n");
		if (n < 0)
			throw new Exception("\nNon può essere un numero negativo!\n");
		if (n > postiTotali)
			throw new Exception("\nNon può essere un numero maggiore dei posti disponibili!\n");
		for (int i = 0; i < n; i++)
			postiPrenotati++;
	}
	
	public void disdici(int n) throws Exception {
		if (postiPrenotati == 0)
			throw new Exception("\nNon ci sono prenotazioni!\n");
		if (data.isBefore(LocalDate.now()))
			throw new Exception("\nL'evento è già passato!\n");
		if (n < 0)
			throw new Exception("\nNon può essere un numero negativo!\n");
		if (n > postiTotali)
			throw new Exception("\nNon può essere un numero maggiore dei posti disponibili!\n");
		if (n > postiPrenotati)
			throw new Exception("\nNon può essere un numero maggiore dei posti prenotati!\n");
		for (int i = 0; i < n; i++)
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
			throw new Exception("\nData non valida!\n");
		this.data = data;
	}
	public int getPostiTotali() {
		return postiTotali;
	}
	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public String getPosti() {
		return getPostiPrenotati() + "/" + getPostiTotali();
	}
	
	@Override
	public String toString() {
		return getData() + " - " + getTitolo();
	}
}
