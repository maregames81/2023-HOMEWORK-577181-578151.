package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	private String attrezzo;

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(attrezzo);
			partita.getPlayer().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			partita.getIO().mostraMessaggio("Oggetto aggiunto in borsa");
		} else partita.getIO().mostraMessaggio("Oggetto non presente nella stanza");

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;

	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

}
