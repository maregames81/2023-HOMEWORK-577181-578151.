package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {

	private StanzaMagica stanza;
	private Attrezzo attrezzo;

	@BeforeEach
	void setUp() {
		this.stanza=new StanzaMagica("stanza");
		this.attrezzo= new Attrezzo("arma",1);


	}

	@Test

	void testIsNotMagic() {
		assertTrue(this.stanza.addAttrezzo(attrezzo)); 
		assertSame(this.stanza.getAttrezzo("arma"),this.attrezzo);
	}

	void testAddAttrezzo() {
		for(int i=0;i<StanzaMagica.SOGLIA_MAGICA_DEFAULT;i++) {
			assertTrue(this.stanza.addAttrezzo(attrezzo));
		}	assertTrue(this.stanza.addAttrezzo(attrezzo));
	}



	void testIsMagic() {
		for(int i=0;i<StanzaMagica.SOGLIA_MAGICA_DEFAULT;i++) {
			Attrezzo attrezzoI = new Attrezzo("attrezzo"+i,1);
			assertTrue(this.stanza.addAttrezzo(attrezzoI));
		}
		Attrezzo magico= new Attrezzo("magico",1);
		this.stanza.addAttrezzo(magico);
		assertNull(this.stanza.getAttrezzo(magico.getNome()));
		Attrezzo ocigam = this.stanza.getAttrezzo("ocigam");
		assertNotNull(ocigam);
		assertEquals(new Attrezzo ("ocigam",2),ocigam);
	}
	void testTroppiAttrezzi() {
		for(int i=0;i<Stanza.NUMERO_MASSIMO_ATTREZZI;i++) {
			Attrezzo attrezzoI = new Attrezzo("attrezzo"+i,1);
			assertTrue(this.stanza.addAttrezzo(attrezzoI));
		}
		assertFalse(this.stanza.addAttrezzo(attrezzo));
	}

}
