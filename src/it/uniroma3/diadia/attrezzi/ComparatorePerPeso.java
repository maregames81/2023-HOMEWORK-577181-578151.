package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorePerPeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		int pes= o1.getPeso()-o2.getPeso();
		if(pes==0) {
			return o1.getNome().compareTo(o2.getNome());
		}
		return pes;
		
		
	}

}
