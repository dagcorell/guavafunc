package no.iterate.konferanse2014.guava.beans;

import java.util.List;

public interface BeregningProsessMelding {

	public Beregning getBeregning();

	public Beregning getNesteBeregningSammePolise();

	public Beregning getNesteBeregningAnnenPolise();

	public Poliseversjon getPoliseversjon();

	public List<ForventetYtelse> getForventedeYtelser();

	public ForventetYtelse getFaktiskYtelse();

}
