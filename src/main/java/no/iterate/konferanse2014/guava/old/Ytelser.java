package no.iterate.konferanse2014.guava.old;

import java.util.List;

import no.iterate.konferanse2014.guava.beans.Dekningsnummer;
import no.iterate.konferanse2014.guava.beans.ForventetYtelse;
import no.iterate.konferanse2014.guava.beans.Medregningspensjon;

public class Ytelser {

    public void justerYtelserHvisMedregningspensjon(List<ForventetYtelse> ytelser, List<Medregningspensjon> medregningsPensjoner) {

        if (medregningsPensjoner != null && !medregningsPensjoner.isEmpty()) {
            //Finner totalbeløp for alle medregningspensjoner
            int spkRedPen = 0;
            for (Medregningspensjon medregningspensjon : medregningsPensjoner) {
                spkRedPen = spkRedPen + medregningspensjon.getSpkRedusertPensjon();
            }

            //Reduserer alle relevante dekninger med totalbeløpet
            for (ForventetYtelse ytelse : ytelser) {
                int nyPensjon;
                if (ytelse.getDekningsId().equals(Dekningsnummer.EVENTUELL_LIVSVARIG_EKTEFELLEPENSJON_25) || ytelse.getDekningsId().equals(Dekningsnummer.EVENTUELL_OPPHORENDE_BARNEPENSJON_27)) {
                    int spkRedPen60 = 60 * spkRedPen / 100; //skal kun ha redusert 60% av beløpet
                    nyPensjon = ytelse.getRedusertPensjon() - spkRedPen60;
                    if (nyPensjon < 0) {
                        nyPensjon = 0;
                    }
                    ytelse.setRedusertPensjon(nyPensjon);
                } else if (!Dekningsnummer.UONSKEDE_DEKNINGSNUMMER.contains(ytelse.getDekningsId())) {
                    nyPensjon = ytelse.getRedusertPensjon() - spkRedPen;
                    if (nyPensjon < 0) {
                        nyPensjon = 0;
                    }
                    ytelse.setRedusertPensjon(nyPensjon);
                }
            }
        }
    }
	
}
