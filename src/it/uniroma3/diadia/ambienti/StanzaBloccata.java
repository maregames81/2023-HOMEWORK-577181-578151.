package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private Direzione direzioneB;
	private String attrezzoS;

	public StanzaBloccata(String nome,Direzione direzione, String attrezzo) {
		super(nome);
		this.direzioneB=direzione;
		this.attrezzoS=attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(this.direzioneB.equals(direzione) && !(this.hasAttrezzo(attrezzoS))) {
			return this;
		} else
			return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {

		String bloccata= "Stanza bloccata nella direzione: "+ direzioneB + 
				"\rSe desideri proseguire in quella direzione prendi l'attrezzo: " + attrezzoS + " e posalo dentro la stanza\n";
		if(this.hasAttrezzo(attrezzoS))
			return super.getDescrizione();
		else return bloccata + super.getDescrizione();
	}





}
