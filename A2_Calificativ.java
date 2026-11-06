import java.util.Scanner;

public class A2_Calificativ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduceți nota: ");
        int nota = sc.nextInt();

        if (nota < 0 || nota > 10) {
            System.out.println("notă invalidă");
        } else if (nota < 5) {
            System.out.println("nesatisfăcător");
        } else if (nota <= 6) {
            System.out.println("satisfăcător");
        } else if (nota <= 8) {
            System.out.println("bine");
        } else {
            System.out.println("excelent");
        }
    }
}