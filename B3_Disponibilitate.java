import java.util.Scanner;

public class B3_Disponibilitate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produs[] produse = {
                new Produs("Zeamă de casă", 24.50, 30),
                new Produs("Piure cu pârjoală", 46.00, 25),
                new Produs("Salată de varză", 18.00, 40),
                new Produs("Compot", 12.00, 50)
        };

        System.out.print("Denumirea produsului: ");
        String cautat = sc.nextLine();

        Produs gasit = null;

        for (Produs p : produse) {
            if (p.getDenumire().equals(cautat)) {
                gasit = p;
                break;
            }
        }

        if (gasit == null) {
            System.out.println("Produs inexistent.");
            return;
        }

        System.out.print("Număr porții: ");
        int portii = sc.nextInt();

        if (gasit.esteDisponibil(portii)) {
            System.out.printf(
                    "Costul comenzii: %.2f lei%n",
                    gasit.costPentru(portii)
            );
        } else {
            System.out.println(
                    "Produsul nu este disponibil în cantitatea solicitată."
            );
        }
    }
}