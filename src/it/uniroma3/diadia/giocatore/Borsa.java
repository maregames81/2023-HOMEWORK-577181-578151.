package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;


	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); 
		this.numeroAttrezzi = 0;
		this.pesoAttuale = 0;

	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		this.pesoAttuale += attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public static int getDefaultPesoMaxBorsa() {
		return DEFAULT_PESO_MAX_BORSA;
	}

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		return this.pesoAttuale;
	}

	public Collection<Attrezzo> getAttrezzi() {
		return attrezzi.values();
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a= this.attrezzi.remove(nomeAttrezzo);
		if(a==null)
			return false;
		else {
			this.pesoAttuale = this.pesoAttuale- a.getPeso();
			this.numeroAttrezzi--;
			return true;
		}

	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getAttrezzi().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatorePerPeso cpp= new ComparatorePerPeso();
		List<Attrezzo> list= new ArrayList<>();
		list.addAll(this.attrezzi.values());
		Collections.sort(list, cpp);
		return list;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatorePerNome cpp= new ComparatorePerNome();
		SortedSet<Attrezzo> set= new TreeSet<Attrezzo>(cpp);
		set.addAll(this.attrezzi.values());
		return set;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePerPeso cpp= new ComparatorePerPeso();
		SortedSet<Attrezzo> set= new TreeSet<Attrezzo>(cpp);
		set.addAll(this.attrezzi.values());
		return set;
	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> p2a = new HashMap<>();
		for(Attrezzo a: this.attrezzi.values()) {
			if(p2a.containsKey(a.getPeso())) {
				//attrezzo di peso gia visto
				Set<Attrezzo> stessoPeso= p2a.get(a.getPeso());
				stessoPeso.add(a);
				p2a.put(a.getPeso(), stessoPeso);
			}
			else {
				//attrezzo di peso mai visto prima
				Set<Attrezzo> stessoPeso= new HashSet<>();
				stessoPeso.add(a);
				p2a.put(a.getPeso(), stessoPeso);
			}

		}
		return p2a;
	}
}
