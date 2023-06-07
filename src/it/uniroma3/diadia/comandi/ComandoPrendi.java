package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().hasAttrezzo(this.getParametro())) {
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
			partita.getPlayer().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			partita.getIO().mostraMessaggio("Oggetto aggiunto in borsa");
		} else partita.getIO().mostraMessaggio("Oggetto non presente nella stanza");

	}



}
