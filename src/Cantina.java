import java.util.Locale;
import java.util.Scanner;

public class Cantina {
    static final double PRAG_REDUCERE = 100.0;
    static final double REDUCERE = 0.15;
    static final double TVA = 0.20;

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

    static void afiseazaTabelCosturi(double pret) {
        System.out.println("Portii | Cost");
        for (int portii = 1; portii <= 5; portii++) {
            System.out.printf("%6d | %.2f lei%n", portii, pret * portii);
        }
    }

    static boolean esteDeschis(int ziua, int ora) {
        return (ziua >= 1 && ziua <= 5 && ora >= 8 && ora < 16)
                || (ziua == 6 && ora >= 9 && ora < 13);
    }

    static double calculeazaCost(double pret, int portii) {
        return pret * portii * (1 + TVA);
    }

    static double calculeazaCost(double pret, int portii, boolean bursier) {
        double baza = pret * portii;
        if (bursier) {
            baza = baza * (1 - REDUCERE);
        }
        return baza * (1 + TVA);
    }

    static double calculeazaCost(Produs p, int portii) {
        return calculeazaCost(p.getPret(), portii);
    }

    static void demonstreazaCosturi() {
        Produs piure = new Produs("Piure cu parjoala", 46.00, 30);
        System.out.printf("2 x piure, cu TVA:               %.2f lei%n", calculeazaCost(46.00, 2));
        System.out.printf("2 x piure, bursier, cu TVA:      %.2f lei%n", calculeazaCost(46.00, 2, true));
        System.out.printf("2 x piure (obiect Produs):       %.2f lei%n", calculeazaCost(piure, 2));
        System.out.printf("calculeazaCost(46, 2) cu int:    %.2f lei%n", calculeazaCost(46, 2));
    }

    static void comandaCompleta(Scanner sc) {
        System.out.print("Ziua (1 - luni ... 7 - duminica): ");
        int ziua = sc.nextInt();
        System.out.print("Ora (0-23): ");
        int ora = sc.nextInt();
        if (!esteDeschis(ziua, ora)) {
            System.out.println("Cantina este inchisa. Comenzile nu se accepta.");
            return;
        }
        afiseazaMeniu();
        double total = citesteComanda(sc);
        afiseazaRezumat(total);
    }

    static void comandaMaxim5(Scanner sc) {
        afiseazaMeniu();
        double total = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Pozitia " + i + " din 5: ");
            int optiune = sc.nextInt();
            if (optiune == 0) {
                break;
            }
            if (optiune < 1 || optiune > 4) {
                System.out.println("Optiune inexistenta");
                continue;
            }
            total += pretProdus(optiune);
        }
        System.out.printf("Total fara reducere: %.2f lei%n", total);
    }

    static void afiseazaMeniuPrincipal() {
        System.out.println();
        System.out.println("=== CANTINA FFI ===");
        System.out.println("1 - Comanda completa (orar, do-while, bon)");
        System.out.println("2 - Comanda de maximum 5 pozitii");
        System.out.println("3 - Tabelul costurilor (zeama)");
        System.out.println("4 - Calcul cost cu TVA");
        System.out.println("0 - Iesire");
        System.out.print("Alegerea: ");
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int alegere;
        do {
            afiseazaMeniuPrincipal();
            alegere = sc.nextInt();
            switch (alegere) {
                case 1 -> comandaCompleta(sc);
                case 2 -> comandaMaxim5(sc);
                case 3 -> afiseazaTabelCosturi(pretProdus(1));
                case 4 -> demonstreazaCosturi();
                case 0 -> System.out.println("La revedere!");
                default -> System.out.println("Optiune inexistenta");
            }
        } while (alegere != 0);
    }
}
