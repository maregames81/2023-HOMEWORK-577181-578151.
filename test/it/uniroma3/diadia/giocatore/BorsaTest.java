package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

class BorsaTest {
	
	Borsa b;
	Borsa b1;
	Borsa b2;
	Attrezzo falce;
	Attrezzo pala;
	Attrezzo sega;
	Attrezzo martello;
	Attrezzo computer;
	Attrezzo laptop;
	Attrezzo racchetta;

	
	@BeforeEach
	public void setUp() {
		b = new Borsa();
		b1 = new Borsa();
		b2 = new Borsa();
		falce = new Attrezzo("falce", 2);
		pala = new Attrezzo("pala", 3);
		racchetta = new Attrezzo("racchetta", 3);
		martello = new Attrezzo("martello", 2);
		sega = new Attrezzo("sega", 16);
		computer = new Attrezzo("computer", 2);
		laptop = new Attrezzo("laptop", 4);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(falce));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(sega));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));

	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		b1.addAttrezzo(falce);
		b1.addAttrezzo(martello);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatorePerPeso());
		expected.add(falce);
		expected.add(martello);
		assertArrayEquals(expected.toArray(), b1.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		b2.addAttrezzo(martello);
		b2.addAttrezzo(falce);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(falce);
		ex.add(martello);
		assertTrue(this.controllaList(ex, b2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoPesiDiversi() {
		b2.addAttrezzo(computer);
		b2.addAttrezzo(laptop);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(computer);
		ex.add(laptop);
		//System.out.println(b2.getContenutoOrdinatoPerPeso());
		assertTrue(this.controllaList(ex, b2.getContenutoOrdinatoPerPeso()));
	}
	
	public boolean controllaList(List<?> c1, List<?> c2) {
		if(c1.size()!=c2.size())
			return false;
		for(int i = 0; i<c1.size(); i++ ) {
			if(!c1.get(i).equals(c2.get(i)) )
				return false;
		}
		return true;
	}
	
	


}
