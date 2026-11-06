import java.util.Locale;
import java.util.Scanner;

public class A1_Cantina {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double zeama = 24.50;
        double piure = 46.00;
        double salata = 18.00;
        double compot = 12.00;

        System.out.printf("%-22s %8s%n", "Produs", "Preț");
        System.out.printf("%-22s %8.2f%n", "Zeamă de casă", zeama);
        System.out.printf("%-22s %8.2f%n", "Piure cu pârjoală", piure);
        System.out.printf("%-22s %8.2f%n", "Salată de varză", salata);
        System.out.printf("%-22s %8.2f%n", "Compot", compot);

        System.out.print("Număr porții de zeamă: ");
        int portii = sc.nextInt();

        double total = portii * zeama;

        System.out.printf("Cost total: %.1f lei%n", total);
    }
}
