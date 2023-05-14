package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	private Labirinto mappa;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	
	@BeforeEach
	public void setUp() {
		this.mappa= new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Atrio")
				.getLabirinto();
		this.stanzaIniziale= this.mappa.getStanzaIniziale();
		this.stanzaVincente= this.mappa.getStanzaVincente();
	}
	@Test
	void testGetStanzaVincente() {
		assertTrue(this.stanzaVincente.equals(mappa.getStanzaVincente()));
	}


}
