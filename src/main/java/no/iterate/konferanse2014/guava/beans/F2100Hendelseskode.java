package no.iterate.konferanse2014.guava.beans;


/**
 * Enumerator som representerer hendelseskodene til F2100 (ref. "Vedlegg til kap 8 Mapping av hendelser SPK - F2100.xls")
 * <p/>
 * Dette er PRG interne verider som ikke er definert i en egen TOCT tabell
 *
 * @author Håvard Balke
 */
public enum F2100Hendelseskode {

    /** AVTALEENDRING: 1 */
    AVTALEENDRING(1),
    /** START_I_STILLING_NY_POLISE: 2 */
    START_I_STILLING_NY_POLISE(2),
    /** GJENINNTREDEN: 3 */
    GJENINNTREDEN(3),
    /** STILLINGSENDRING: 4 */
    STILLINGSENDRING(4),
    /** AVSLUTTET_STILLINGSFORHOLD: 6 */
    AVSLUTTET_STILLINGSFORHOLD(6),
    /** PENSJONSENDRING: 7 */
    PENSJONSENDRING(7),
    /** PENSJONERING_NY_BARNEPOLISE: 8 */
    PENSJONERING_NY_BARNEPOLISE(8),
    /** OPPHOR_AV_BARNEPOLISE: 9 */
    OPPHOR_AV_BARNEPOLISE(9),
    /** DOD: 10 */
    DOD(10),
    /** G_OMREGNING: 11 */
    G_OMREGNING(11),
    /** REGELENDRING: 12 */
    REGELENDRING(12),
    /** SYSTEMENDRING: 13 */
    SYSTEMENDRING(13),
    /** TERMINERING: 14 */
    TERMINERING(14),
    /** INN_I_PERMISJON: 16 */
    INN_I_PERMISJON(16),
    /** UT_AV_PERMISJON: 17 */
    UT_AV_PERMISJON(17),
    /** INN_I_PREMIEFRITAK: 18 */
    INN_I_PREMIEFRITAK(18),
    /** UFOREPENSJONERING: 19 */
    UFOREPENSJONERING(19),
    /** REAKTIVERING: 20 */
    REAKTIVERING(20),
    /** INN_I_PENSJON: 21 */
    INN_I_PENSJON(21),
    /** PENSJONERING_NY_EKTEFELLEPOLISE: 22 */
    PENSJONERING_NY_EKTEFELLEPOLISE(22),
    /** TILBAKEFORSEL_AV_VERDI: 23 */
    TILBAKEFORSEL_AV_VERDI(23),
    /** OPPHOR_AV_EKTEFELLEPOLISE: 24 */
    OPPHOR_AV_EKTEFELLEPOLISE(24),
    /** BORTFALL_AV_AFP: 27 */
    BORTFALL_AV_AFP(27),
    /** UTLOP_AV_UTBETALINGSDEKNING: 28 */
    UTLOP_AV_UTBETALINGSDEKNING(28),
    /** PROLONGERING: 29 */
    PROLONGERING(29),
    /** HJEMFALL: 30 */
    HJEMFALL(30),
    /** ETTEROPPGJOR_SOM_UTBETALES_TIL_BOET: 31 */
    ETTEROPPGJOR_SOM_UTBETALES_TIL_BOET(31),
    /** AVTALEBYTTE: 32 */
    AVTALEBYTTE(32),
    /** REAKTIVERING_ALDERSPENSJON: 33 */
    REAKTIVERING_ALDERSPENSJON(33),
    /** GRUNNLAGSSKIFTE: 34 */
    GRUNNLAGSSKIFTE(34),
    /** KONVERTERING_AV_POLISE_I_PERMISJON: 98 */
    KONVERTERING_AV_POLISE_I_PERMISJON(98),
    /** KONVERTERING: 99 */
    KONVERTERING(99);


    private int kode;

    private F2100Hendelseskode(int kode) {
        this.kode = kode;
    }

    /**
     * Returnerer den numeriske verdi av Enum-en
     *
     * @return numerisk verdi av Enum-en
     */
    public int getKode() {
        return this.kode;
    }

    /**
     * Mapper int til enum
     *
     * @param intKode
     * @return enum som representerer tallverdien
     */
    public static F2100Hendelseskode finnKode(int intKode) {
        for (F2100Hendelseskode f2100Kode : values()) {
            if (f2100Kode.getKode() == intKode) {
                return f2100Kode;
            }
        }

        return null;
    }

    /**
     * Sjekker om hendelseskoden skal ha dekningssett oversendt F2100.
     * Omfatter hendelseskodene:</br>
     * OPPHOR_AV_BARNEPOLISE</br>
     * DOD</br>
     * TERMINERING</br>
     * TILBAKEFORSEL_AV_VERDI</br>
     * OPPHOR_AV_EKTEFELLEPOLISE</br>
     * HJEMFALL
     *
     * @param hendelseskode
     * @return true hvis hendelseskode skal ha tilhørende dekningssett til F2100, ellers false
     */
    public static boolean skalHaDekningssettIPolisehendelse(F2100Hendelseskode hendelseskode) {

        switch (hendelseskode) {
        case OPPHOR_AV_BARNEPOLISE:
        case DOD:
        case TERMINERING:
        case TILBAKEFORSEL_AV_VERDI:
        case OPPHOR_AV_EKTEFELLEPOLISE:
        case HJEMFALL:
            return false;
        default:
            return true;
        }
    }

    /**
     * Hvis hendelseskode er AVSLUTTET_STILLINGSFORHOLD, GJENINNTREDEN eller AVTALEENDRING betyr det at det er en
     * avtaleendring/bytte.
     *
     * @param kode
     * @return true hvis hendelseskode inngår i et avtalebytte, ellers false
     */
    public static boolean inngaarIAvtaleBytte(int kode) {
        F2100Hendelseskode f2100Kode = finnKode(kode);

        switch (f2100Kode) {
        case AVSLUTTET_STILLINGSFORHOLD:
        case GJENINNTREDEN:
        case AVTALEBYTTE:
            return true;
        default:
            return false;
        }
    }

}
