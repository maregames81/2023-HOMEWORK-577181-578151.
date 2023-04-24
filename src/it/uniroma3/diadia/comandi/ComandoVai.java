package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;

	@Override
	public void esegui(Partita partita) {
		Stanza corrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			partita.getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}

		prossimaStanza= corrente.getStanzaAdiacente(this.direzione);
		
		if(prossimaStanza==null) {
			partita.getIO().mostraMessaggio("Direzione inestistente");
			return;
		}
		
		if(prossimaStanza.equals(corrente)) {
			partita.getIO().mostraMessaggio("Direzione bloccata");
			return;
		}
		

		partita.setStanzaCorrente(prossimaStanza);
		partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getPlayer().setCfu(partita.getPlayer().getCfu()-1);
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione= parametro;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}

}
