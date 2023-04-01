package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
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

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","borsa"};

	private Partita partita;
	private IOConsole IO;

	public DiaDia() {
		this.partita = new Partita();
		this.IO= new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		this.IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = this.IO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando daEseguire = new Comando(istruzione);
		String nome = daEseguire.getNome();
		if(nome!=null) {

			if ("fine".equals(nome)) {
				this.fine(); 
				return true;
			} else if ("vai".equals(nome))
				this.vai(daEseguire.getParametro());
			else if ("aiuto".equals(nome))
				this.aiuto();
			else if ("prendi".equals(nome))
				this.prendi(daEseguire.getParametro());
			else if ("posa".equals(nome))
				this.posa(daEseguire.getParametro());
			else if ("borsa".equals(nome))
				this.borsa();
			else
				this.IO.mostraMessaggio("Comando sconosciuto");
			if (this.partita.vinta()) {
				this.IO.mostraMessaggio("Hai vinto!");
				return true;
			} else
				return false;
		} else return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		this.IO.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.IO.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();
			this.partita.getPlayer().setCfu(cfu);
		}
		this.IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	/**
	 * Comando "Prendi".
	 */
	private void prendi(String attrezzo) {
		if(this.partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(attrezzo);
			this.partita.getPlayer().getBorsa().addAttrezzo(a);
			this.IO.mostraMessaggio("Oggetto aggiunto in borsa");
		} else this.IO.mostraMessaggio("Oggetto non presente nella stanza");
	}



	/**
	 * Comando "Posa".
	 */

	private void posa(String attrezzo) {
		Attrezzo a =this.partita.getPlayer().getBorsa().getAttrezzo(attrezzo);
		if(a!=null) {
			this.partita.getStanzaCorrente().addAttrezzo(a);
			this.partita.getPlayer().getBorsa().removeAttrezzo(attrezzo);
			this.IO.mostraMessaggio("Oggetto posato nella stanza");
		} else {
			this.IO.mostraMessaggio("Oggetto non presente in borsa");
		}
	}

	/**
	 * Comando "Borsa".
	 */

	private void borsa() {
		this.IO.mostraMessaggio(this.partita.getPlayer().getBorsa().toString());
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
		
	}
}