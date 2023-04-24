package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	
	private Partita partita;
	private Attrezzo at;
	private Comando c;
	private IO io= new IOConsole();
	
	
	@BeforeEach
	void setUp() {
		this.partita = new Partita(io);
		this.at= new Attrezzo("astronave", 10);
		this.c= new ComandoPrendi();
	}

	@Test
	void testEsegui() {
		partita.getStanzaCorrente().addAttrezzo(at);
		c.setParametro("astronave");
		c.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("astronave"));
	}


}
