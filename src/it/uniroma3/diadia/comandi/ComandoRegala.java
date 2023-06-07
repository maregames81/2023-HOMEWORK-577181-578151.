package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null)
		personaggio.riceviRegalo(partita.getStanzaCorrente().getAttrezzo(getParametro()), partita);
		else partita.getIO().mostraMessaggio("Non c'è nessuno in questa stanza");
	}

}
