package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia sb;
	private Attrezzo torcia;
	private Stanza s;
	
	@BeforeEach
	void setUp() {
		this.sb=new StanzaBuia("atrio","torcia");
		this.torcia= new Attrezzo("torcia", 1);
		this.s= new Stanza("atrio");
	}

	@Test
	void testGetDescrizione() {
		assertFalse(s.getDescrizione().equals(sb.getDescrizione()));
	}
	
	@Test
	void testGetDescrizioneCon() {
		s.addAttrezzo(torcia);
		sb.addAttrezzo(torcia);
		assertEquals(s.getDescrizione(),sb.getDescrizione());
	}

}
