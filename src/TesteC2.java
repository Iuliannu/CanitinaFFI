import java.util.Locale;

public class TesteC2 {

    static int ok = 0, fail = 0;

    static void verifica(String descriere, boolean conditie) {
        System.out.println((conditie ? "[OK]    " : "[EROARE] ") + descriere);
    }

    static boolean egal(double a, double b) {
        return Math.abs(a - b) < 0.005;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sapte = 0;
        for (int i = 0; i < 1000; i++) {
            int n = Cantina.genereazaNumar(1, 10);
            min = Math.min(min, n);
            max = Math.max(max, n);
            if (n == 7) sapte++;
        }
        System.out.println("minim = " + min + ", maxim = " + max + ", aparitii ale lui 7 = " + sapte);
        verifica("minimul este 1", min == 1);
        verifica("maximul este 10", max == 10);
        verifica("valoarea 7 apare de 70-130 de ori", sapte >= 70 && sapte <= 130);
        verifica("numar 7: 93.50 -> 81.50", egal(Cantina.aplicaZiuaNorocoasa(93.50, 7), 81.50));
        verifica("numar 3: 93.50 ramane 93.50", egal(Cantina.aplicaZiuaNorocoasa(93.50, 3), 93.50));
        verifica("numar 7: suma 5.00 nu devine negativa (0.00)", egal(Cantina.aplicaZiuaNorocoasa(5.00, 7), 0.0));
    }
}
