package org.generation.italy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.generation.italy.model.MobileApp;
import org.generation.italy.model.Recensione;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Dichiarazione Scanner e variabili
		Scanner sc = new Scanner(System.in);
		String nome, sistemaOperativo, nomeUtente, testo;
		float prezzo, numeroStelle;
		int scelta, nrDownload;
		
		// Stampa messaggio per inserimento dati dell'app
		System.out.println("Inserisci i dati della tua App: ");
		System.out.print("Nome: ");
		nome = sc.nextLine();
		System.out.print("Sistema operativo: ");
		sistemaOperativo = sc.nextLine();
		System.out.print("Prezzo: ");
		prezzo = sc.nextFloat();
		
		// Creazione dell'app dai dati inseriti in precedenza
		MobileApp app = new MobileApp(nome, sistemaOperativo, prezzo);
		
		// Inizio ciclo app
		do {
			
			// Stampa menù per visualizzare le scelte
			System.out.println("Menù: ");
			System.out.println("1. Download singolo \n2. Download multiplo \n3. Ricevi recensione \n4. Visualizza recensioni \n5. Esci");
			System.out.println("Seleziona un'opzione: ");
			scelta = sc.nextInt();
			sc.nextLine();
			
			// Creazione switch per le scelte selezionate
			switch (scelta) {
			
			case 1:
				app.download();
				System.out.println("Download singolo effettuato!");
				break;
			case 2:
				System.out.println("Inserisci il numero di download da eseguire: ");
				nrDownload = sc.nextInt();
				sc.nextLine();
				app.download(nrDownload);
				System.out.println("Download multiplo effettuato.");
				break;
			case 3:
				System.out.println("Inserisci il nome utente: ");
				nomeUtente = sc.nextLine();
				System.out.println("Inserisci il numero di stelle (da 1 a 5)");
				numeroStelle = sc.nextFloat();
				sc.nextLine();
				System.out.println("Inserisci il testo della tua recensione: ");
				testo = sc.nextLine();
				Recensione recensione = new Recensione(LocalDate.now(), nomeUtente, numeroStelle, testo);
				app.riceviRecensione(recensione);
				System.out.println("Recensione inviata!");
				break;
			case 4:
				System.out.println("Lista recensioni: ");
				for (Recensione r : app.getElencoRecensioni()) {
					System.out.println("Data: " + r.getData() + " | Utente: " + r.getNomeUtente() + " | Stelle: " + r.getNumeroStelle() + " | Testo: " + r.getTesto());
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Scelta non valida, riprova: ");
			}
			// Visualizzazione dati dell'app
			System.out.println("Dati dell'app: ");
			System.out.println("Nome: " + app.getNome() + "\nSistema Operativo: " + app.getSistemaOperativo() + "\nPrezzo: " + app.getPrezzo() + "\nRicavo totale: " + app.getRicavoTotale() + "\nValutazione media: " + String.format("%.2f", app.valutazioneMedia()));
		} while (scelta != 5);
		
		
	}

}
