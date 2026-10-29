import java.util.Locale;
import java.util.Scanner;

public class Cantina {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== MENIUL ZILEI ===");
        System.out.println("1 - Zeama de casa      24.50 lei");
        System.out.println("2 - Piure cu parjoala  46.00 lei");
        System.out.println("3 - Salata de varza    18.00 lei");
        System.out.println("4 - Compot             12.00 lei");
        System.out.println("0 - Finalizare comanda");

        double total = 0;
        int optiune;
        do {
            System.out.print("Optiunea: ");
            optiune = sc.nextInt();
            switch (optiune) {
                case 1 -> total += 24.50;
                case 2 -> total += 46.00;
                case 3 -> total += 18.00;
                case 4 -> total += 12.00;
                case 0 -> { }
                default -> System.out.println("Optiune inexistenta");
            }
        } while (optiune != 0);

        double dePlata = total > 100 ? total * 0.85 : total;
        System.out.printf("Total: %.2f lei%n", total);
        System.out.printf("De plata: %.2f lei%n", dePlata);
    }
}
