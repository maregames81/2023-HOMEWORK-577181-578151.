package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa vuota;
	private Borsa nonVuota;
	private Attrezzo osso;
	
	@BeforeEach
	public void setUp() {
		this.vuota= new Borsa();
		this.nonVuota= new Borsa();
		this.osso= new Attrezzo("osso", 1);
		this.nonVuota.addAttrezzo(osso);
	}

	@Test
	void testAddAttrezzo() {
		this.vuota.addAttrezzo(osso);
		assertFalse(this.vuota.isEmpty());
		
	}

	@Test
	void testIsEmpty() {
		assertFalse(this.nonVuota.isEmpty());
		assertTrue(this.vuota.isEmpty());
	}

	@Test
	void testRemoveAttrezzo() {
		this.nonVuota.removeAttrezzo("osso");
		assertTrue(this.nonVuota.isEmpty());
	}

}
