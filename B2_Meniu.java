import java.util.Locale;
import java.util.Scanner;

public class B2_Meniu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double[] preturi = {
                24.50,
                46.00,
                18.00,
                12.00
        };

        String[] produse = {
                "Zeamă de casă",
                "Piure cu pârjoală",
                "Salată de varză",
                "Compot"
        };

        double total = 0;

        while (true) {
            System.out.println();
            System.out.println("1. Zeamă de casă - 24.50 lei");
            System.out.println("2. Piure cu pârjoală - 46.00 lei");
            System.out.println("3. Salată de varză - 18.00 lei");
            System.out.println("4. Compot - 12.00 lei");
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

            System.out.print("Număr porții: ");
            int portii = sc.nextInt();

            if (portii <= 0) {
                System.out.println("Număr invalid de porții.");
                continue;
            }

            double valoare = preturi[optiune - 1] * portii;
            total += valoare;

            System.out.printf(
                    "Adăugat: %s × %d = %.2f lei%n",
                    produse[optiune - 1],
                    portii,
                    valoare
            );
        }

        double reducere;

        if (total > 100) {
            reducere = total * 0.15;
        } else {
            reducere = 0;
        }

        double dePlata = total - reducere;

        System.out.printf("%nTotal acumulat: %.2f lei%n", total);
        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("Suma de plată: %.2f lei%n", dePlata);
    }
}