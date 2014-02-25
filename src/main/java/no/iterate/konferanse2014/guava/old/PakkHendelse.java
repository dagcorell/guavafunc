package no.iterate.konferanse2014.guava.old;

import java.util.ArrayList;
import java.util.List;

import no.iterate.konferanse2014.guava.beans.Beregning;
import no.iterate.konferanse2014.guava.beans.BeregningManager;
import no.iterate.konferanse2014.guava.beans.PakkHendelseMelding;

public class PakkHendelse {

	private BeregningManager beregningManager;

	

	public boolean handleMessage(PakkHendelseMelding pakkHendelseMelding) {

		List<Beregning> beregninger = hentBeregninger(pakkHendelseMelding
				.getHendelseId());

		sendPakkeTilF2100(pakkHendelseMelding, beregninger);

		return true;
	}

	public List<Beregning> hentBeregninger(Long hendelseId) {

		List<Beregning> beregninger = new ArrayList<Beregning>();

		for (Beregning beregning : beregningManager.hentBeregninger(hendelseId)) {
			if (skalSendesF2100(beregning)) {
				beregninger.add(beregning);
			}
		}

		return beregninger;
	}

	private boolean skalSendesF2100(Beregning beregning) {

		if (beregning.getSendtF2100Tidspunkt() != null) {

			return false;
		}

		if (beregning.getNumBeregningsrekkefolge() == null) {

			return false;
		}

		return true;
	}

	private void sendPakkeTilF2100(PakkHendelseMelding pakkHendelseMelding,
			List<Beregning> beregninger) {
		// gj¿r ingen ting

	}
	
	public BeregningManager getBeregningManager() {
		return beregningManager;
	}

	public void setBeregningManager(BeregningManager beregningManager) {
		this.beregningManager = beregningManager;
	}
}
