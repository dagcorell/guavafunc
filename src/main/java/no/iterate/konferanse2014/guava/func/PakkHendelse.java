package no.iterate.konferanse2014.guava.func;

import java.util.ArrayList;
import java.util.List;

import no.iterate.konferanse2014.guava.beans.Beregning;
import no.iterate.konferanse2014.guava.beans.BeregningManager;
import no.iterate.konferanse2014.guava.beans.PakkHendelseMelding;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

public class PakkHendelse {

	private BeregningManager beregningManager;

	

	public boolean handleMessage(PakkHendelseMelding pakkHendelseMelding) {

		List<Beregning> beregninger = hentBeregninger(pakkHendelseMelding
				.getHendelseId());

		sendPakkeTilF2100(pakkHendelseMelding, beregninger);

		return true;
	}

	public List<Beregning> hentBeregninger(Long hendelseId) {
		
		Predicate<Beregning> kombinertPredikat = Predicates.and(Predicates.not(new ErSendtF2100()), new HarBeregningsrekkefolge());
    
		return new ArrayList<Beregning>(Collections2.filter(beregningManager.hentBeregninger(hendelseId), kombinertPredikat));
	}

	

	private void sendPakkeTilF2100(PakkHendelseMelding pakkHendelseMelding,
			List<Beregning> beregninger) {
		// todo: sende til f2100

	}
	
	
	
	class ErSendtF2100 implements Predicate<Beregning> {

		@Override
		public boolean apply(Beregning beregning) {
		
			return beregning.getSendtF2100Tidspunkt() != null;
		}
		
	}
	
	class HarBeregningsrekkefolge implements Predicate<Beregning> {

		@Override
		public boolean apply(Beregning beregning) {
	
			return beregning.getNumBeregningsrekkefolge() != null;
		}
		
	}
	
	
	
	
	public BeregningManager getBeregningManager() {
		return beregningManager;
	}

	public void setBeregningManager(BeregningManager beregningManager) {
		this.beregningManager = beregningManager;
	}
}
