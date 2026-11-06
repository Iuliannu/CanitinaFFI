import java.util.Locale;
import java.util.Scanner;

public class C2_BonDetaliat {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String[] produse = {
                "Zeamă de casă",
                "Piure cu pârjoală",
                "Salată de varză",
                "Compot"
        };

        double[] preturi = {
                24.50,
                46.00,
                18.00,
                12.00
        };

        int[] cantitati = new int[4];

        while (true) {
            System.out.println();
            System.out.println("1. Zeamă de casă");
            System.out.println("2. Piure cu pârjoală");
            System.out.println("3. Salată de varză");
            System.out.println("4. Compot");
            System.out.println("0. Finalizare");

            System.out.print("Produs: ");
            int optiune = sc.nextInt();

            if (optiune == 0) {
                break;
            }

            if (optiune < 1 || optiune > 4) {
                System.out.println("Opțiune invalidă.");
                continue;
            }

            System.out.print("Porții: ");
            int portii = sc.nextInt();

            if (portii > 0) {
                cantitati[optiune - 1] += portii;
            }
        }

        double subtotal = 0;

        System.out.println();
        System.out.println("----- BON DETALIAT -----");

        for (int i = 0; i < produse.length; i++) {
            if (cantitati[i] > 0) {
                double pozitie = cantitati[i] * preturi[i];
                subtotal += pozitie;

                System.out.printf(
                        "%s × %d = %.2f lei%n",
                        produse[i],
                        cantitati[i],
                        pozitie
                );
            }
        }

        double reducere;

        if (subtotal > 100) {
            reducere = subtotal * 0.15;
        } else {
            reducere = 0;
        }

        double total = subtotal - reducere;

        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("Total: %.2f lei%n", total);
    }
}