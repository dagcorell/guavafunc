//package no.iterate.konferanse2014.guava;
//
//import java.util.Date;
//import java.util.List;
//
//import no.iterate.konferanse2014.guava.beans.Beregning;
//import no.iterate.konferanse2014.guava.beans.BeregningProsessMelding;
//import no.iterate.konferanse2014.guava.beans.F2100Hendelseskode;
//import no.iterate.konferanse2014.guava.beans.ForventetYtelse;
//import no.iterate.konferanse2014.guava.beans.HendelseType;
//import no.iterate.konferanse2014.guava.beans.Poliseversjon;
//
//
///**
// * Forenklet versjon av prosesseringsteget KontrollerYtelser
// * 
// *
// */
//public class KontrollerYtelser {
//
//	 public boolean handleMessage(BeregningProsessMelding msg) {
//
//	        Beregning beregning = msg.getBeregning();
//	        Beregning nesteBeregningSammePolise = msg.getNesteBeregningSammePolise();
//	        Beregning nesteBeregningAnnenPolise = msg.getNesteBeregningAnnenPolise();
//	        Beregning nyBeregning = new Beregning();
//	        Poliseversjon poliseversjon = msg.getPoliseversjon();
//	        List<ForventetYtelse> ytelser = msg.getForventedeYtelser();
//	        ForventetYtelse faktiskYtelse = msg.getFaktiskYtelse();
//	        
//	        
//
//	        for (ForventetYtelse forventetYtelse : ytelser) {
//	            kontrollerDekninger(forventetYtelse, poliseversjon, beregning, nyBeregning, nesteBeregningSammePolise);
//	        }
//	 }
//	
//	
//	 protected void kontrollerDekninger(ForventetYtelse ytelse, Poliseversjon poliseversjon, Beregning beregning, Beregning nyBeregning, Beregning nesteBeregningSammePolise) {
//	        switch (ytelse.getDekningsId()) {
//	        case EVENTUELL_LIVSVARIG_ALDERSPENSJON_2:
//	        case EVENTUELL_OPPHORENDE_ALDERSPENSJON_3:
//	            if (poliseversjon.getStatusKode().isAktiv() || poliseversjon.getStatusKode().isOppsatt() || poliseversjon.getStatusKode().isUforeberegning()) {
//	                if (DatoUtils.datoDiff(ytelse.getPremieopphorDato(), ytelse.getPensjonFraDato()) < 0 &&
//	                        DatoUtils.datoDiff(ytelse.getPremieopphorDato(), beregning.getAksjonsDato()) > 0) {
//	                    F2100Hendelseskode hendelseskode = poliseversjon.getStatusKode().isUforeberegning() ? F2100Hendelseskode.PENSJONSENDRING : F2100Hendelseskode.STILLINGSENDRING;
//	                    finnEventuellBeregningOgEllerHendelse(HendelseType.ENDRING_DEKNINGSSETT, hendelseskode, ytelse.getPremieopphorDato(), poliseversjon, beregning, nyBeregning, nesteBeregningSammePolise);
//	                } else {
//	                    finnEventuellBeregningOgEllerHendelse(HendelseType.PROLONGERING, F2100Hendelseskode.PROLONGERING, ytelse.getPensjonFraDato(), poliseversjon, beregning, nyBeregning, nesteBeregningSammePolise);
//	                }
//
//	            }
//	            break;
//	        case EVENTUELL_OPPHORENDE_UFOREPENSJON_22:
//	            if (poliseversjon.getStatusKode().isUforeberegning()) {
//	                Date hendelsesDato = finnNesteBeregningEllerHendelsesDato(ytelse.getUtlopsDato(), ytelse.getPremieopphorDato(), beregning.getAksjonsDato());
//	                finnEventuellBeregningOgEllerHendelse(HendelseType.ENDRING_DEKNINGSSETT, F2100Hendelseskode.PENSJONSENDRING, hendelsesDato, poliseversjon, beregning, nyBeregning, nesteBeregningSammePolise);
//	                break;
//	            }
//	            // Det er korrekt at break ligger innenfor if'en i case ovenfor. Dekning 22 kan finnes både for uføre og aktive poliser, men vi ønsker break dersom polisen
//	            // vi nå behandler er uføre. Dersom det ikke er uførepolise, men en aktiv polise ønsker vi at dekning 22 behandles av if nedenfor. Dette er i henhold til jira
//	            // http://jira/jira/browse/SFXPRG-1155
//	        case EVENTUELL_OPPHORENDE_BARNETILLEGG_24:
//	            if (poliseversjon.getStatusKode().isAktiv() || poliseversjon.getStatusKode().isOppsatt()) {
//	                Date hendelsesDato = finnNesteBeregningEllerHendelsesDato(ytelse.getUtlopsDato(), ytelse.getPremieopphorDato(), beregning.getAksjonsDato());
//	                finnEventuellBeregningOgEllerHendelse(HendelseType.ENDRING_DEKNINGSSETT, F2100Hendelseskode.STILLINGSENDRING, hendelsesDato, poliseversjon, beregning, nyBeregning, nesteBeregningSammePolise);
//	            }
//	            break;
//	        case UTBETALT_OPPHORENDE_ALDERSPENJSON_8:
//	        case UTBETALT_OPPHORENDE_EKTEFELLEPENSJON_55:
//	            finnEventuellBeregningOgEllerHendelse(HendelseType.UTLOP_UTBETALINGSDEKNING, F2100Hendelseskode.UTLOP_AV_UTBETALINGSDEKNING, ytelse.getUtlopsDato(), poliseversjon, beregning, nyBeregning, nesteBeregningSammePolise);
//	            break;
//	        case EVENTUELL_OPPHORENDE_AFP_10:
//	            Date hendelsesDato = finnNesteBeregningEllerHendelsesDato(ytelse.getPensjonFraDato(), ytelse.getPremieopphorDato(), beregning.getAksjonsDato());
//	            int alder = poliseversjon.getPolise().getFoedselsnummer().alder(hendelsesDato) + 1;
//	            F2100Hendelseskode hendelsekode;
//	            HendelseType hendelse;
//	            if (alder < ytelse.getUtlopsAlder().intValue()) {
//	                hendelsekode = F2100Hendelseskode.STILLINGSENDRING;
//	                hendelse = HendelseType.ENDRING_DEKNINGSSETT;
//	            } else {
//	                hendelsekode = F2100Hendelseskode.BORTFALL_AV_AFP;
//	                hendelse = HendelseType.BORTFALL_AFP;
//	            }
//	            finnEventuellBeregningOgEllerHendelse(hendelse, hendelsekode, hendelsesDato, poliseversjon, beregning, nyBeregning, nesteBeregningSammePolise);
//	            break;
//	        default:
//	            break;
//	        }
//	    }
//
//
//	private void finnEventuellBeregningOgEllerHendelse(
//			HendelseType prolongering, F2100Hendelseskode prolongering2,
//			Object pensjonFraDato, Poliseversjon poliseversjon,
//			Beregning beregning, Beregning nyBeregning,
//			Beregning nesteBeregningSammePolise) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
//	
//}
