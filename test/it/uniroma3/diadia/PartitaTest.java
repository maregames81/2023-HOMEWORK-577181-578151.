package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	private Partita partita;
	private Stanza corrente;
	
	@BeforeEach
	public void setUp() {
		this.partita= new Partita();
		this.corrente= new Stanza("corrente");
	}

	@Test
	void testSetStanzaCorrente() {
		this.partita.setStanzaCorrente(corrente);
		assertTrue(this.corrente.equals(this.partita.getStanzaCorrente()));
	}


}
