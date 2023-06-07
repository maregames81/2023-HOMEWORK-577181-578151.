package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_SALUTATA = "Dato che mi hai salutato, ti farò un favore mandandoti in posto pieno di attrezzi!";
	private static final String MESSAGGIO_NON_SALUTATA = "Potevi almeno salutarmi prima, vai a cercare attrezzi da un'altra parte sempre se ne troverai eheh!";

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		List<Stanza> stanzeAdiacenti = (List<Stanza>) partita.getStanzaCorrente().getMapStanzeAdiacenti().values();
		Stanza b= stanzeAdiacenti.get(0);
		if(this.haSalutato()) {
			for(Stanza a: partita.getStanzaCorrente().getMapStanzeAdiacenti().values()) {
				if(b.getNumeroAttrezzi()<a.getNumeroAttrezzi())
					b=a;
			}
			partita.setStanzaCorrente(b);
			return MESSAGGIO_SALUTATA;
		}
		else {
			for(Stanza a: partita.getStanzaCorrente().getMapStanzeAdiacenti().values()) {
				if(b.getNumeroAttrezzi()>a.getNumeroAttrezzi())
					b=a;
			}
			partita.setStanzaCorrente(b);
			return MESSAGGIO_NON_SALUTATA;
		}
		
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "Ahahah grazie per il regalo, lo custodirò gelosamente";
	}

}
