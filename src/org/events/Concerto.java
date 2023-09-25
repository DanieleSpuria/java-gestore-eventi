package org.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	private LocalTime ora;
	private BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTotali);
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getOraFormat() {
        DateTimeFormatter oraForma = DateTimeFormatter.ofPattern("hh:mm");
        return ora.format(oraForma);
	}
	
	public String getPrezzoFormat() {
		return String.format("%.2f €", prezzo);
	}
	
	@Override
	public String toString() {
		return "Data: " + getData() +
			   "\nOra: " + getOraFormat() +
			   "\nTitolo: " + getTitolo() +
			   "\nPrezzo: " + getPrezzoFormat() +
			   "\nPosti prenotati: " + getPosti();
	}
}
