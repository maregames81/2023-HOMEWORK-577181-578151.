package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	private Giocatore player;
	private Labirinto mappa;
	private Stanza stanzaCorrente;
	private boolean finita;
	private IO IO;


	public Partita(Labirinto labirinto,IO IO){
		this.mappa= labirinto;
		//mappa.creaStanze();
		this.player= new Giocatore();
		this.stanzaCorrente=mappa.getStanzaIniziale();
		this.finita = false;
		this.IO= IO;

	}


	public IO getIO() {
		return IO;
	}


	public Giocatore getPlayer() {
		return player;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== mappa.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (player.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public boolean giocatoreIsVivo() {
		if(this.player.getCfu()!=0)
			return true;
		else return false;
	}


}
