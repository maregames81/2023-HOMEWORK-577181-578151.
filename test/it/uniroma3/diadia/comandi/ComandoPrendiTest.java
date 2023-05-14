package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	
	private Partita partita;
	private Attrezzo at;
	private Comando c;
	private IO io= new IOConsole();
	private Labirinto mappa;
	
	
	@BeforeEach
	void setUp() {
		this.mappa= new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.getLabirinto();
		this.partita = new Partita(mappa, io);
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
