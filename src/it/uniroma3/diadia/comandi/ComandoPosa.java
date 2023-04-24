package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String attrezzo;
	@Override
	public void esegui(Partita partita) {
		Attrezzo a =partita.getPlayer().getBorsa().getAttrezzo(attrezzo);
		if(a!=null) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getPlayer().getBorsa().removeAttrezzo(attrezzo);
			partita.getIO().mostraMessaggio("Oggetto posato nella stanza");
		} else {
			partita.getIO().mostraMessaggio("Oggetto non presente in borsa");
		}

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
