package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a =partita.getPlayer().getBorsa().getAttrezzo(this.getParametro());
		if(a!=null) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getPlayer().getBorsa().removeAttrezzo(this.getParametro());
			partita.getIO().mostraMessaggio("Oggetto posato nella stanza");
		} else {
			partita.getIO().mostraMessaggio("Oggetto non presente in borsa");
		}

	}

	

}
