package lab3;

/**
 * Parametrii personali ai lucrarii, calculati din numarul de ordine N
 * din catalogul grupei TI 241.
 */
public final class Parametri {

    /** Numarul de ordine in catalogul grupei. */
    public static final int N = 7;

    /** Numarul minim de produse distincte in stand: 6 + N % 3. */
    public static final int MIN_PRODUSE = 6 + N % 3;

    /** Reducerea meniului combo, in procente: 10 + N % 6. */
    public static final int REDUCERE_COMBO = 10 + N % 6;

    /** Fiecare al k-lea bon primeste un cadou: k = 3 + N % 4. */
    public static final int K_CADOU = 3 + N % 4;

    /** Cadoul standului, afisat pe fiecare al k-lea bon. */
    public static final String CADOU = "Sos de usturoi + autocolant FFI";

    private Parametri() { }
}
