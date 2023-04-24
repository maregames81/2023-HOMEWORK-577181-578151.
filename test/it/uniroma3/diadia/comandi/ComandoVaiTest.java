package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	
	private Partita p;
	private Stanza s;
	private Stanza s2;
	private Comando c;
	private IO io= new IOConsole();
	
	@BeforeEach
	void setUp() {
		
		this.p= new Partita(io);
		s= new Stanza("1");
		s2= new Stanza("2");
		c= new ComandoVai();
		
	}

	@Test
	void testEsegui() {
		p.setStanzaCorrente(s);
		s.impostaStanzaAdiacente("sud", s2);
		c.setParametro("sud");
		c.esegui(p);
		
		assertEquals(s2,p.getStanzaCorrente());
	}

}
