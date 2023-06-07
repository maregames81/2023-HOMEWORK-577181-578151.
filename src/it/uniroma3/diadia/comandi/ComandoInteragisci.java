package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {

	private static final String MESSAGGIO_CON_CHI = 
			"Con chi dovrei interagire?...";

	private IO io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.setParametro(personaggio.agisci(partita)) ;
			io.mostraMessaggio(this.getParametro());
		} else io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}


}
