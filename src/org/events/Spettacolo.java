package org.events;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Spettacolo extends Evento {
	private BigDecimal prezzo;
	
	public Spettacolo(String titolo, LocalDate data, int postiTotali, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTotali);
		setPrezzo(prezzo);
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}	
}
