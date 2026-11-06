import java.util.Scanner;

public class C1_Rest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Suma de plată: ");
        int plata = sc.nextInt();

        System.out.print("Suma achitată: ");
        int achitata = sc.nextInt();

        int rest = achitata - plata;

        int n500 = rest / 500;
        rest %= 500;

        int n200 = rest / 200;
        rest %= 200;

        int n100 = rest / 100;
        rest %= 100;

        int n50 = rest / 50;
        rest %= 50;

        int n20 = rest / 20;
        rest %= 20;

        int n10 = rest / 10;
        rest %= 10;

        int n5 = rest / 5;
        rest %= 5;

        int n1 = rest;

        System.out.println(n500 + " bancnote de 500");
        System.out.println(n200 + " bancnote de 200");
        System.out.println(n100 + " bancnote de 100");
        System.out.println(n50 + " bancnote de 50");
        System.out.println(n20 + " bancnote de 20");
        System.out.println(n10 + " bancnote de 10");
        System.out.println(n5 + " bancnote de 5");
        System.out.println(n1 + " bancnote de 1");
    }
}