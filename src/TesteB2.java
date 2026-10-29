import java.util.Locale;

public class TesteB2 {

    static int ok = 0, fail = 0;

    static void verifica(String descriere, boolean conditie) {
        System.out.println((conditie ? "[OK]    " : "[EROARE] ") + descriere);
    }

    static boolean egal(double a, double b) {
        return Math.abs(a - b) < 0.005;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        verifica("calculeazaCost(46.00, 2) = 110.40", egal(Cantina.calculeazaCost(46.00, 2), 110.40));
        verifica("calculeazaCost(46.00, 2, true) = 93.84", egal(Cantina.calculeazaCost(46.00, 2, true), 93.84));
        verifica("calculeazaCost(46, 2) functioneaza (int -> double)", egal(Cantina.calculeazaCost(46, 2), 110.40));
        verifica("calculeazaCost(Produs, 2) = 110.40", egal(Cantina.calculeazaCost(new Produs("Piure cu parjoala", 46.00, 30), 2), 110.40));
        System.out.printf("Valori afisate: %.2f | %.2f%n", Cantina.calculeazaCost(46.00, 2), Cantina.calculeazaCost(46.00, 2, true));
    }
}
