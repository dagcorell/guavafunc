//package no.iterate.konferanse2014.guava;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//import java.util.Date;
//import java.util.List;
//
//import no.iterate.konferanse2014.guava.beans.Beregning;
//import no.iterate.konferanse2014.guava.beans.BeregningBuilder;
//import no.iterate.konferanse2014.guava.beans.BeregningManager;
//import no.iterate.konferanse2014.guava.PakkHendelse;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//
//import com.google.common.collect.Lists;
//
//public class PakkHendelseTest {
//	
//	@Mock
//	BeregningManager beregningManager;
//	
//	@Before
//	public void setup() {
//		initMocks(this);
//	}
//	
//	
//	final static Long HENDELSEID = 1l;
//	
//	@Test
//	public void testFiltrerBortBereninegr() {
//		
//		
//		PakkHendelse pakkHendelse = new PakkHendelse();
//		
//		pakkHendelse.setBeregningManager(beregningManager);
//		
//		Beregning b1 = BeregningBuilder.beregning().withSendtF2100Tidspunkt(new Date())
//										       .withNumBeregningsrekkefolge(1).build();
//		
//		Beregning b2 = BeregningBuilder.beregning().withSendtF2100Tidspunkt(new Date()).build();
//		
//		
//		Beregning b3 = BeregningBuilder.beregning().withNumBeregningsrekkefolge(1).build();
//				
//		List<Beregning> beregninger = Lists.newArrayList(b1,b2,b3);
//		when(beregningManager.hentBeregninger(HENDELSEID)).thenReturn(beregninger );
//		
//		
//		List<Beregning> filtrerteBeregninger  = pakkHendelse.hentBeregninger(HENDELSEID);
//		
//		assertTrue(!filtrerteBeregninger.contains(b1)); //b1 og b2 skal v¾re filtrert bort
//		assertTrue(!filtrerteBeregninger.contains(b2));
//		assertTrue(filtrerteBeregninger.contains(b3));
//		
//	}
//
//}
