package no.iterate.konferanse2014.guava;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.List;

import no.iterate.konferanse2014.guava.beans.Dekningsnummer;
import no.iterate.konferanse2014.guava.beans.ForventetYtelse;
import no.iterate.konferanse2014.guava.beans.ForventetYtelseBuilder;
import no.iterate.konferanse2014.guava.beans.Medregningspensjon;
import no.iterate.konferanse2014.guava.func.Ytelser;

import org.junit.Test;

import com.google.common.collect.Lists;

public class YtelserTest {
	
	
	@Test
	public void justerYtelserHvisMedregningspensjonTest() {
		
		Ytelser ytelser = new Ytelser();
		
		List<Medregningspensjon> medregningsPensjoner = Lists.newArrayList(new Medregningspensjon(50));
		
		
		ForventetYtelse fy1 = new ForventetYtelseBuilder().withDekningsnummer(Dekningsnummer.EVENTUELL_LIVSVARIG_ALDERSPENSJON_2).withRedusertPensjon(100).build();
		//u¿nsket dekning
		ForventetYtelse fy2 = new ForventetYtelseBuilder().withDekningsnummer(Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_4_BARN_43).withRedusertPensjon(100).build();
		ForventetYtelse fy3 = new ForventetYtelseBuilder().withDekningsnummer(Dekningsnummer.EVENTUELL_LIVSVARIG_EKTEFELLEPENSJON_25).withRedusertPensjon(100).build();
		
		List<ForventetYtelse> ytelseliste = Lists.newArrayList(fy1, fy2,fy3);
		
		ytelser.justerYtelserHvisMedregningspensjon(ytelseliste , medregningsPensjoner );
	
		
		assertTrue(medregningsPensjoner.size() ==1);
		assertEquals(Integer.valueOf(fy1.getRedusertPensjon()), Integer.valueOf(50));
		assertEquals(Integer.valueOf(fy2.getRedusertPensjon()), Integer.valueOf(100));
		assertEquals(Integer.valueOf(fy3.getRedusertPensjon()), Integer.valueOf(70));
		
	}

}
