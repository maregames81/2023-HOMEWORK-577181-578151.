package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getPlayer().setCfu(partita.getPlayer().getCfu()-1);
		return "Ahia, il cane mi ha morso. Ho perso un CFU";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("bastone", 3));
		return this.agisci(partita)
				+ "Il cane ha preso l'attrezzo ma ne ha lasciato uno nuovo nella stanza...";
	}

}
