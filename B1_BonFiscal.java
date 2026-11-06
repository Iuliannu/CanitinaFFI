import java.util.Locale;
import java.util.Scanner;

public class B1_BonFiscal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double pretPiure = 46.00;
        int portii = 2;

        System.out.print("Student bursier? (1/0): ");
        int bursier = sc.nextInt();

        double subtotal = portii * pretPiure;

        double reducere;

        if (bursier == 1) {
            reducere = subtotal * 0.15;
        } else {
            reducere = 0;
        }

        double bazaTVA = subtotal - reducere;
        double tva = bazaTVA * 0.20;
        double total = bazaTVA + tva;

        System.out.printf("Subtotal: %.2f lei%n", subtotal);
        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("TVA: %.2f lei%n", tva);
        System.out.printf("Total: %.2f lei%n", total);
    }
}