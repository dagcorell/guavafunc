package no.iterate.konferanse2014.guava.beans;

import java.util.Arrays;
import java.util.List;


/**
 * @author Mads Aagaard, Capgemini
 *         <p/>
 *         Gjenspeiler TORT152
 */
public enum Dekningsnummer {

    /** 1 */
    AKTUELLT_PREMIEFRITAK_1(1),
    /** 2 */
    EVENTUELL_LIVSVARIG_ALDERSPENSJON_2(2),
    /** 3 */
    EVENTUELL_OPPHORENDE_ALDERSPENSJON_3(3),
    /** 4 */
    EVENTUELL_OPPHORENDE_ALDERSPENSJON_4(4),
    /** 5 */
    EVENTUELL_OPPHORENDE_ALDERSPENSJON_5(5),
    /** 6 */
    EVENTUELL_OPPHORENDE_ALDERSPENSJON_6(6),
    /** 7 */
    EVENTUELL_OPPHORENDE_ALDERSPENSJON_7(7),
    /** 8 */
    UTBETALT_OPPHORENDE_ALDERSPENJSON_8(8),
    /** 9 */
    UTBETALT_LIVSVARIG_ALDERSPENSJON_9(9),
    /** 10 */
    EVENTUELL_OPPHORENDE_AFP_10(10),
    /** 11 */
    EVENTUELL_OPPHORENDE_AFP_11(11),
    /** 12 */
    UTBETALT_OPPHORENDE_AFP_12(12),
    /** 13 */
    UTBETALT_OPPHORENDE_AFP_13(13),
    /** 14 */
    EVENTUELL_OPPHORENDE_AFP_14(14),
    /** 15 */
    EVENTUELL_OPPHORENDE_AFP_15(15),
    /** 16 */
    EVENTUELL_OPPHORENDE_AFP_16(16),
    /** 17 */
    UTBETALT_OPPHORENDE_FTP_17(17),
    /** 18 */
    EVENTUELL_OPPHORENDE_FTP_18(18),
    /** 19 */
    EVENTUELL_OPPHORENDE_FTP_19(19),
    /** 20 */
    EVENTUELL_OPPHORENDE_FTP_20(20),
    /** 21 */
    EVENTUELL_OPPHORENDE_FTP_21(21),
    /** 22 */
    EVENTUELL_OPPHORENDE_UFOREPENSJON_22(22),
    /** 23 */
    UTBETALT_OPPHORENDE_UFOREPENSJON_23(23),
    /** 24 */
    EVENTUELL_OPPHORENDE_BARNETILLEGG_24(24),
    /** 25 */
    EVENTUELL_LIVSVARIG_EKTEFELLEPENSJON_25(25),
    /** 26 */
    UTBETALT_LIVSVARIG_EKTEFELLEPENSJON_26(26),
    /** 27 */
    EVENTUELL_OPPHORENDE_BARNEPENSJON_27(27),
    /** 28 */
    UTBETALT_OPPHORENDE_BARNEPENSJON_28(28),
    /** 29 */
    EVENTUELL_PREMIEFRITAK_29(29),
    /** 30 */
    REFUSJON_OPPHORENDE_AFP_30(30),
    /** 31 */
    REFUSJON_OPPHORENDE_FTP_31(31),
    /** 32 */
    EVENTUELL_OPPHORENDE_UFOREPENSJON_32(32),
    /** 33 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_1_BARN_33(33),
    /** 34 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_2_BARN_34(34),
    /** 35 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_3_BARN_35(35),
    /** 36 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_4_BARN_36(36),
    /** 37 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_5_BARN_37(37),
    /** 38 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_6_BARN_38(38),
    /** 39 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_7_BARN_39(39),
    /** 40 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_1_BARN_40(40),
    /** 41 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_2_BARN_41(41),
    /** 42 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_3_BARN_42(42),
    /** 43 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_4_BARN_43(43),
    /** 44 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_5_BARN_44(44),
    /** 45 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_6_BARN_45(45),
    /** 46 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_7_BARN_46(46),
    /** 47 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_1_BARN_47(47),
    /** 48 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_2_BARN_48(48),
    /** 49 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_3_BARN_49(49),
    /** 50 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_4_BARN_50(50),
    /** 51 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_5_BARN_51(51),
    /** 52 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_6_BARN_52(52),
    /** 53 */
    UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_7_BARN_53(53),
    /** 54 */
    EVENTUELL_LIVSVARIG_EKTEFELLEPENSJON_ETTERLATT_54(54),
    /** Dekning 55 er spesiell. Den kan både være utbetalt og eventuell, men skal p.t ikke beregnes. Tall kopieres fra dekning 54. */
    UTBETALT_OPPHORENDE_EKTEFELLEPENSJON_55(55),
    // Utils.listUnntatteDekninger() må korrigeres hvis dekning 56 og/eller 57 legges til.
    /** Dekning 58 er spesiell. Den kan både være etteroppgjør etter dødsfall eller en engangsbelop som betales til ektefelle. */
    UTBETALT_ETTEROPPGJOR_SKATTEFRITT_ENGANGSBELOP_58(58);

   

    private final int kode;

    private Dekningsnummer(int kode) {
        this.kode = kode;
    }

    public int getKode() {
        return this.kode;
    }

    public static Dekningsnummer finnKode(Integer integerKode) {
        for (Dekningsnummer tk : values()) {
            if (tk.getKode() == integerKode) {
                return tk;
            }
        }
       
        return null;
    }
    
    public static final List<Dekningsnummer> UONSKEDE_DEKNINGSNUMMER = Arrays.asList(
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_1_BARN_33, Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_2_BARN_34,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_3_BARN_35, Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_4_BARN_36,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_5_BARN_37, Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_6_BARN_38,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_UFOR_7_BARN_39,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_1_BARN_40,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_2_BARN_41,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_3_BARN_42,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_4_BARN_43,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_5_BARN_44,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_6_BARN_45,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_ALDER_7_BARN_46, Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_1_BARN_47,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_2_BARN_48, Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_3_BARN_49,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_4_BARN_50, Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_5_BARN_51,
            Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_6_BARN_52, Dekningsnummer.UTBETALT_OPPHORENDE_BARNETILLEGG_AFP_7_BARN_53,
            Dekningsnummer.UTBETALT_OPPHORENDE_UFOREPENSJON_23);


}
