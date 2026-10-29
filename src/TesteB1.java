import java.util.Locale;

public class TesteB1 {

    static int ok = 0, fail = 0;

    static void verifica(String descriere, boolean conditie) {
        System.out.println((conditie ? "[OK]    " : "[EROARE] ") + descriere);
    }

    static boolean egal(double a, double b) {
        return Math.abs(a - b) < 0.005;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        verifica("esteDeschis(3, 8)  -> true",  Cantina.esteDeschis(3, 8));
        verifica("esteDeschis(6, 12) -> true",  Cantina.esteDeschis(6, 12));
        verifica("esteDeschis(3, 16) -> false", !Cantina.esteDeschis(3, 16));
        verifica("esteDeschis(6, 13) -> false", !Cantina.esteDeschis(6, 13));
        verifica("esteDeschis(7, 10) -> false", !Cantina.esteDeschis(7, 10));
    }
}
