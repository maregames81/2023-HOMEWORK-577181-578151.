package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.FormatoFileNonValidoException;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 * @throws FormatoFileNonValidoException 
	 * @throws FileNotFoundException 
	 */



	/* public void creaStanze() {


		 crea gli attrezzi 
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		/* crea stanze del labirinto 
		Stanza atrio = new StanzaBuia("Atrio","lanterna");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new StanzaMagica("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		 collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze 
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}
*/

	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}

	public Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c =
				new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}



	public void setStanzaVincente(Stanza s) {
		this.stanzaVincente= s;

	}

	public void setStanzaIniziale(Stanza i) {
		this.stanzaIniziale=i;		
	}


}
