package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata stanza;
	private Attrezzo lanterna;
	private Stanza s;
	
	@BeforeEach
	public void setUp() {
		this.stanza = new StanzaBloccata("StanzaBuia", "sud","lanterna");
		this.s= new Stanza("s");
		this.lanterna = new Attrezzo("lanterna", 1);
		this.stanza.impostaStanzaAdiacente("sud", s);
	}

	@Test
	void testGetStanzaAdiacenteBloccata() {
		assertEquals(stanza,stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	void testGetStanzaAdiacente() {
		stanza.addAttrezzo(lanterna);
		assertEquals(s,stanza.getStanzaAdiacente("sud"));
	}

	@Test
	void testGetDescrizione() {
		stanza.addAttrezzo(lanterna);
		assertEquals(stanza.toString(),stanza.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneBloccata() {
		stanza.addAttrezzo(lanterna);
		String bloccata= stanza.getDescrizione();
		stanza.removeAttrezzo(lanterna);
		assertFalse(bloccata.equals(stanza.getDescrizione()));
	}

}
