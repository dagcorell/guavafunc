package no.iterate.konferanse2014.guava.func;

import java.util.Collection;
import java.util.List;

import no.iterate.konferanse2014.guava.beans.Dekningsnummer;
import no.iterate.konferanse2014.guava.beans.ForventetYtelse;
import no.iterate.konferanse2014.guava.beans.Medregningspensjon;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Ytelser {

	/**
	 * Justerer ytelser på relevante dekninger hvis det finnes en
	 * medregnings-beregnetpensjon
	 * 
	 * @param ytelser
	 * @param medregningsPensjoner
	 */
	public void justerYtelserHvisMedregningspensjon(List<ForventetYtelse> ytelser, List<Medregningspensjon> medregningsPensjoner) {

		if (medregningsPensjoner != null && !medregningsPensjoner.isEmpty()) {
			// Finner totalbeløp for alle medregningspensjoner
			int spkRedPen = 0;
			for (Medregningspensjon medregningspensjon : medregningsPensjoner) {
				spkRedPen = spkRedPen + medregningspensjon.getSpkRedusertPensjon();
			}

			// Lager predikat
			Predicate<ForventetYtelse> ektefelleEllerBarnepensjon = Predicates.or(new Ektefellepensjon(), new Barnepensjon());
			// Filtrerer
			Collection<ForventetYtelse> forventetYtelser = Collections2.filter(ytelser, ektefelleEllerBarnepensjon);
			// Transformerer
			Collection<ForventetYtelse> ektefelleYtelser = Collections2.transform(forventetYtelser, new EktefelleBarnepensjonBeregning(spkRedPen));

			Collection<ForventetYtelse> andreYtelse = Collections2.transform(
					Collections2.filter(Collections2.filter(ytelser, Predicates.not(ektefelleEllerBarnepensjon)), Predicates.not(new Uonskete())),
					new NormalBeregning(spkRedPen));

			ytelser = Lists.newArrayList(Iterables.concat(ektefelleYtelser, andreYtelse));

		}
	}

	class Ektefellepensjon implements Predicate<ForventetYtelse> {

		@Override
		public boolean apply(ForventetYtelse ytelse) {

			return ytelse.getDekningsId().equals(Dekningsnummer.EVENTUELL_LIVSVARIG_EKTEFELLEPENSJON_25);
		}

	}

	class Barnepensjon implements Predicate<ForventetYtelse> {

		@Override
		public boolean apply(ForventetYtelse ytelse) {

			return ytelse.getDekningsId().equals(Dekningsnummer.EVENTUELL_OPPHORENDE_BARNEPENSJON_27);
		}

	}

	class EktefelleBarnepensjonBeregning implements Function<ForventetYtelse, ForventetYtelse> {

		private int spkRedPen;

		public EktefelleBarnepensjonBeregning(int spkRedPen) {
			super();
			this.spkRedPen = spkRedPen;
		}

		@Override
		public ForventetYtelse apply(ForventetYtelse ytelse) {
			int spkRedPen60 = 60 * spkRedPen / 100; // skal kun ha redusert 60%
													// av beløpet
			int nyPensjon = ytelse.getRedusertPensjon() - spkRedPen60;
			if (nyPensjon < 0) {
				nyPensjon = 0;
			}
			ytelse.setRedusertPensjon(nyPensjon);
			return ytelse;
		}

	}

	class Uonskete implements Predicate<ForventetYtelse> {

		@Override
		public boolean apply(ForventetYtelse ytelse) {

			return Dekningsnummer.UONSKEDE_DEKNINGSNUMMER.contains(ytelse.getDekningsId());
		}

	}

	class NormalBeregning implements Function<ForventetYtelse, ForventetYtelse> {

		private int spkRedPen;

		public NormalBeregning(int spkRedPen) {
			super();
			this.spkRedPen = spkRedPen;
		}

		@Override
		public ForventetYtelse apply(ForventetYtelse ytelse) {
			int nyPensjon = ytelse.getRedusertPensjon() - spkRedPen;
			if (nyPensjon < 0) {
				nyPensjon = 0;
			}
			ytelse.setRedusertPensjon(nyPensjon);
			return ytelse;
		}
	}

}
