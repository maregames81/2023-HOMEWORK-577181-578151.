package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getIO().mostraMessaggio("\nPlayer:");
		partita.getIO().mostraMessaggio("Cfu=" +partita.getPlayer().getCfu());
		partita.getIO().mostraMessaggio(partita.getPlayer().getBorsa().toString());

	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getParametro() {
		return null;
	}

}
