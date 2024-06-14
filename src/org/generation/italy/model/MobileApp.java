package org.generation.italy.model;

import java.util.ArrayList;

public class MobileApp {

	// Dichiarazione variabili private per la classe
	private String nome;
	private String sistemaOperativo;
	private float prezzo;
	private ArrayList<Recensione> elencoRecensioni;
	private float ricavoTotale;
	
	// Dichiarazione costruttore e verifica validità
	public MobileApp(String nome, String sistemaOperativo, float prezzo) throws Exception {
		
		if (!nome.isBlank()) {
			this.nome = nome;
		} else {
			throw new Exception("Nome non valido");
		}
		
		if (!sistemaOperativo.isBlank()) {
			this.sistemaOperativo = sistemaOperativo;
		} else {
			throw new Exception("Sistema Operativo non valido");
		}
		
		if (prezzo > 0) {
			this.prezzo = prezzo;
		} else {
			throw new Exception("Prezzo non valido");
		}
		
		this.elencoRecensioni = new ArrayList<>();
		
	}

	// Getters e Setters
	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public float getRicavoTotale() {
		return ricavoTotale;
	}

	public void setRicavoTotale(float ricavoTotale) {
		this.ricavoTotale = ricavoTotale;
	}

	public String getNome() {
		return nome;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}
	
	// Metodi per l'aumento del ricavo totale
	public void download() {
		this.ricavoTotale += this.prezzo;
	}
	
	public void download(int numeroDownload) {
		this.ricavoTotale += this.prezzo * numeroDownload;
	}
	
	// Metodo per aggiunta recensione
	public void riceviRecensione(Recensione recensione) {
		this.elencoRecensioni.add(recensione);
	}
	
	// Metodo per la valutazione media delle recensioni
	public float valutazioneMedia() {
		
		if (elencoRecensioni.isEmpty()) {
			return 0;
		}
		
		float nrStelle = 0;
		for (Recensione recensione : elencoRecensioni) {
			nrStelle += recensione.getNumeroStelle();
		}
		
		return nrStelle / elencoRecensioni.size();
	}
	
}
