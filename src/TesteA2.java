import java.util.Locale;

public class TesteA2 {

    static boolean pretProdusEgal(int o, double p) { return egal(Cantina.pretProdus(o), p); }

    static int ok = 0, fail = 0;

    static void verifica(String descriere, boolean conditie) {
        System.out.println((conditie ? "[OK]    " : "[EROARE] ") + descriere);
    }

    static boolean egal(double a, double b) {
        return Math.abs(a - b) < 0.005;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        verifica("pretProdus(1) = 24.50", pretProdusEgal(1, 24.50));
        verifica("pretProdus(2) = 46.00", pretProdusEgal(2, 46.00));
        verifica("pretProdus(3) = 18.00", pretProdusEgal(3, 18.00));
        verifica("pretProdus(4) = 12.00", pretProdusEgal(4, 12.00));
        verifica("pretProdus(9) = 0", Cantina.pretProdus(9) == 0);
        verifica("aplicaReducere(110.00) = 93.50", egal(Cantina.aplicaReducere(110.00), 93.50));
        verifica("aplicaReducere(100.00) = 100.00 (reducerea doar peste 100)", egal(Cantina.aplicaReducere(100.00), 100.00));
    }
}
