package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";



	private Partita partita;


	public DiaDia(Labirinto labirinto,IO IO) {
		this.partita = new Partita(labirinto,IO);
	}

	public void gioca() {
		String istruzione; 
		this.getPartita().getIO().mostraMessaggio(MESSAGGIO_BENVENUTO);

		do		
			istruzione = this.getPartita().getIO().leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	public Partita getPartita() {
		return partita;
	}

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}


	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto mappa = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addAttrezzo("secchio", 3)
				.addStanzaVincente("Biblioteca")
				.addStanza("Aula N11")
				.addAttrezzo("lanterna", 3)
				.addStanzaBloccata("Aula N10", "martello", "sud")
				.addAttrezzo("lanterna", 2)
				.addStanzaBuia("Laboratorio", "lanterna")
				.addAttrezzo("martello", 5)
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Atrio", "Aula N11", "est")
				.addAdiacenza("Atrio", "Laboratorio", "ovest")
				.addAdiacenza("Atrio", "Aula N10", "sud")
				.addAdiacenza("Aula N11", "Atrio", "ovest")
				.addAdiacenza("Aula N11", "Laboratorio", "est")
				.addAdiacenza("Aula N10", "Laboratorio", "ovest")
				.addAdiacenza("Aula N10", "Aula N11", "est")
				.addAdiacenza("Aula N10", "Atrio", "nord")
				.addAdiacenza("Laboratorio", "Atrio", "est")
				.addAdiacenza("Laboratorio", "Aula N11", "ovest")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto(); 
		DiaDia gioco = new DiaDia(mappa,io);
		gioco.gioca();

	}
}