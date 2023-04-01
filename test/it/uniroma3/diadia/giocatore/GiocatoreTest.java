package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class GiocatoreTest {
	private Giocatore giocatore;
	private Borsa borsa;
	
	
	@BeforeEach
	public void setUp() {
		this.giocatore= new Giocatore();
		this.borsa= this.giocatore.getBorsa();
		
	}

	@Test
	void testGetCfu() {
		assertTrue(20==this.giocatore.getCfu());
	}

	@Test
	void testGetBorsa() {
		assertTrue(this.borsa.equals(this.giocatore.getBorsa()));
	}

}
