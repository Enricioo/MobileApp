package org.generation.italy.model;

import java.time.LocalDate;

public class Recensione {

	// Dichiarazione variabili private per la classe
	private LocalDate data;
	private String nomeUtente;
	private float numeroStelle;
	private String testo;

	// Dichiarazione costruttore e verifica validità
	public Recensione(LocalDate data, String nomeUtente, float numeroStelle, String testo) throws Exception {
		
		if (data == null) {
			throw new Exception("Data non valida");
		} else {
			this.data = data;
		}
		
		if (!nomeUtente.isEmpty()) {
			this.nomeUtente = nomeUtente;
		} else {
			throw new Exception("Nome utente non valido.");
		}
		
		if (numeroStelle >= 1 && numeroStelle <= 5) {
			this.numeroStelle = numeroStelle;
		} else {
			throw new Exception("Numero non valido");
		}
		
		if (!testo.isEmpty()) {
			this.testo = testo;
		} else {
			throw new Exception("Il testo non è valido");
		}
		
	}

	// Getters e Setters
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public float getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
}
