package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	@BeforeEach
	public void setUp() throws Exception {
		sb = new StanzaBloccata("StanzaBloccata", Direzione.ovest, "grimaldello");
		s = new Stanza("Stanzetta");
		a = new Attrezzo("grimaldello", 1);
		sb.impostaStanzaAdiacente(Direzione.ovest, s);
		
	}

	

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente(Direzione.ovest));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente(Direzione.ovest));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "Stanza bloccata nella direzione: ovest"+"\nPrendi il grimaldello e posalo nella stanza";
		assertEquals(e, sb.getDescrizione());
		
	}

	

}
