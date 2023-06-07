package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {


	@Override
	public void esegui(Partita partita) {
		Stanza corrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.getParametro()==null) {
			partita.getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}

		prossimaStanza= corrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
		
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



}
