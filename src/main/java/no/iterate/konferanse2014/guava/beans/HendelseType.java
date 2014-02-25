package no.iterate.konferanse2014.guava.beans;

import java.util.Arrays;
import java.util.List;



/**
 * @author Mads Aagaard, Capgemini
 */
public enum HendelseType  {

    // Generelle - skal håndteres separat
    /** REG */
    REGELENDRING("REG"),
    /** SYS * */
    SYSTEMENDRING("SYS"),
    /** OMR * */
    OMREGNING("OMR"),
    /** DOD * */
    DODSFALL("DOD"),
    /** KON * */
    KONVERTERING("KON"),
    /** ETO * */
    ETTEROPPGJOR("ETO"),
    /** SKF * */
    SKATTEFRITT_ENGANGSBELOP("SKF"),
    /** TER * */
    TERMINERING("TER"),
    /** HJE * */
    HJEMFALL("HJE"),
    /** FNR * */
    FOEDSELSNUMMERENDRING("FNR"),
    /** NYF * */
    NYTT_FOEDSELSNUMMER("NYF"),
    /** MAN * */
    MANUELT_OPPRETTET("MAN"),

    // Hendelser som kommer fra massehendelser - håndteres separat
    /** AVT * */
    AVTALENDRING("AVT"),
    /** RLO * */
    REGULERING_LONNSTABELL("RLO"),
    /** GRO * */
    G_REGULERING_OPPSATTE("GRO"),
    /** EDS * */
    ENDRING_DEKNINGSSETT("EDS"),

    // Historikk
    /** ANS * */
    START_I_STILLING("ANS"),
    /** HEN * */
    HISTORIKKENDRING("HEN"),
    /** SLU * */
    SLUTTET_I_STILLING("SLU"),
    /** SLE * */
    SLETTET_HISTORIKKLINJE("SLE"),
    /** PRO * */
    PROLONGERING("PRO"),
    /** MED * */
    MEDREGNINGENDRING("MED"),

    // Pensjon
    /** STA * */
    START_PENSJON("STA"),
    /** PEN * */
    PENSJONSENDRING("PEN"),
    /** STO * */
    STOPP_PENSJON("STO"),
    /** BAF * */
    BORTFALL_AFP("BAF"),
    /** UUT * */
    UTLOP_UTBETALINGSDEKNING("UUT"),
    /** FF * */
    FISJON_FUSJON("FF"),

    // Foreløpig ikke implementerte hendelsetyper i PRG
    /** EAL * */
    ENDRING_ALDERSGRENSE("EAL"),
    /** TAR * */
    TARIFFENDRING("TAR");

    public static final List<String> HISTORIKK_ALLE = Arrays.asList(START_I_STILLING.kode, HISTORIKKENDRING.kode, SLUTTET_I_STILLING.kode,
            SLETTET_HISTORIKKLINJE.kode, PROLONGERING.kode, FISJON_FUSJON.kode, BORTFALL_AFP.kode, MEDREGNINGENDRING.kode);

    public final static List<String> KJENTE_HENDELSESTYPER_I_PRG = Arrays.asList(KONVERTERING.kode, DODSFALL.kode, ETTEROPPGJOR.kode,
            SKATTEFRITT_ENGANGSBELOP.kode, AVTALENDRING.kode, SYSTEMENDRING.kode, REGELENDRING.kode, OMREGNING.kode,
            REGULERING_LONNSTABELL.kode, TERMINERING.kode, G_REGULERING_OPPSATTE.kode, HJEMFALL.kode, ENDRING_DEKNINGSSETT.kode,
            START_I_STILLING.kode, HISTORIKKENDRING.kode, SLUTTET_I_STILLING.kode, SLETTET_HISTORIKKLINJE.kode, PROLONGERING.kode,
            MEDREGNINGENDRING.kode, START_PENSJON.kode, PENSJONSENDRING.kode, STOPP_PENSJON.kode, BORTFALL_AFP.kode,
            UTLOP_UTBETALINGSDEKNING.kode, FISJON_FUSJON.kode, FOEDSELSNUMMERENDRING.kode, NYTT_FOEDSELSNUMMER.kode,
            MANUELT_OPPRETTET.kode);

    private String kode;

    private HendelseType(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    

}
