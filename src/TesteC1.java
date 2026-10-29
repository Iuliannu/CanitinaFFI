import java.util.Locale;

public class TesteC1 {

    static int ok = 0, fail = 0;

    static void verifica(String descriere, boolean conditie) {
        System.out.println((conditie ? "[OK]    " : "[EROARE] ") + descriere);
    }

    static boolean egal(double a, double b) {
        return Math.abs(a - b) < 0.005;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Cantina.pretProdus(1); // incarca clasa Cantina => se creeaza cele 4 produse
        verifica("Produs.getNumarProduse() = 4", Produs.getNumarProduse() == 4);
        System.out.println("getNumarProduse() = " + Produs.getNumarProduse());
    }
}
