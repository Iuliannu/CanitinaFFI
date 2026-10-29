import java.util.Locale;
import java.util.Scanner;

public class Cantina {
    static final double PRAG_REDUCERE = 100.0;
    static final double REDUCERE = 0.15;

    static void afiseazaMeniu() {
        System.out.println("=== MENIUL ZILEI ===");
        System.out.println("1 - Zeama de casa      24.50 lei");
        System.out.println("2 - Piure cu parjoala  46.00 lei");
        System.out.println("3 - Salata de varza    18.00 lei");
        System.out.println("4 - Compot             12.00 lei");
        System.out.println("0 - Finalizare comanda");
    }

    static double pretProdus(int optiune) {
        return switch (optiune) {
            case 1 -> 24.50;
            case 2 -> 46.00;
            case 3 -> 18.00;
            case 4 -> 12.00;
            default -> 0;
        };
    }

    static double aplicaReducere(double total) {
        return total > PRAG_REDUCERE ? total * (1 - REDUCERE) : total;
    }

    static double citesteComanda(Scanner sc) {
        double total = 0;
        int optiune;
        do {
            System.out.print("Optiunea: ");
            optiune = sc.nextInt();
            switch (optiune) {
                case 0 -> { }
                case 1, 2, 3, 4 -> total += pretProdus(optiune);
                default -> System.out.println("Optiune inexistenta");
            }
        } while (optiune != 0);
        return total;
    }

    static void afiseazaRezumat(double total) {
        System.out.printf("Total: %.2f lei%n", total);
        System.out.printf("De plata: %.2f lei%n", aplicaReducere(total));
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        afiseazaMeniu();
        double total = citesteComanda(sc);
        afiseazaRezumat(total);
    }
}
