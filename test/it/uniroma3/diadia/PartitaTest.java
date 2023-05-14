package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	private Partita partita;
	private Stanza corrente;
	private IO IO;
	private Labirinto mappa;
	
	@BeforeEach
	public void setUp() {
		this.mappa= new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.getLabirinto();
		this.partita= new Partita(mappa, IO);
		this.corrente= new Stanza("corrente");
	}

	@Test
	void testSetStanzaCorrente() {
		this.partita.setStanzaCorrente(corrente);
		assertTrue(this.corrente.equals(this.partita.getStanzaCorrente()));
	}


}
