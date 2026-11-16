package lab3;

import java.util.Locale;

/** Verificarea etapei 2: validare, contor static de id-uri, equals. */
public class Etapa2Demo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("=== Etapa 2: superclasa Produs ===");
        Produs p1 = new Produs("Shaorma Pui", 55.00, 10);
        Produs p2 = new Produs("Cartofi prajiti", 25.00);   // constructorul scurt, stoc 0

        incearca("new Produs(\"\", 10, 5)", () -> new Produs("", 10, 5));
        incearca("new Produs(\"Cola\", -5, 3)", () -> new Produs("Cola", -5, 3));
        incearca("new Produs(\"Cola\", 12, -1)", () -> new Produs("Cola", 12, -1));

        Produs p3 = new Produs("Cola", 12.00, 20);

        System.out.println();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("id-ul celui de-al treilea produs creat: " + p3.getId());

        System.out.println();
        Produs duplicat = new Produs("  shaorma pui ", 60.00, 1);
        System.out.println("p1.equals(\"  shaorma pui \"): " + p1.equals(duplicat));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
    }

    private static void incearca(String descriere, Runnable creare) {
        try {
            creare.run();
            System.out.println(descriere + " -> creat (NEASTEPTAT)");
        } catch (IllegalArgumentException e) {
            System.out.println(descriere + " -> IllegalArgumentException: " + e.getMessage());
        }
    }
}
