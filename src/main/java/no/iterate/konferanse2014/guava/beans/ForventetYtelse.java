package no.iterate.konferanse2014.guava.beans;

import java.util.Date;

public class ForventetYtelse {
	Dekningsnummer dekningsnummer = null;
	Date pensjonFradato;
	Date utlopsDato;
	int redusertPensjon;
	

	public Dekningsnummer getDekningsId() {
		// TODO Auto-generated method stub
		return dekningsnummer;
	}

	public Dekningsnummer getDekningsnummer() {
		return dekningsnummer;
	}

	public void setDekningsnummer(Dekningsnummer dekningsnummer) {
		this.dekningsnummer = dekningsnummer;
	}

	public Date getPensjonFradato() {
		return pensjonFradato;
	}

	public void setPensjonFradato(Date pensjonFradato) {
		this.pensjonFradato = pensjonFradato;
	}

	public Date getUtlopsDato() {
		return utlopsDato;
	}

	public void setUtlopsDato(Date utlopsDato) {
		this.utlopsDato = utlopsDato;
	}

	public int getRedusertPensjon() {
		return redusertPensjon;
	}

	public void setRedusertPensjon(int redusertPensjon) {
		this.redusertPensjon = redusertPensjon;
	}

	

}
