package lab3;

import java.util.Locale;

/** Verificarea etapei 3: afisarea produselor cu pretul de baza si cel final. */
public class Etapa3Demo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Stand stand = Stand.shaormaExpress();

        System.out.println("=== " + stand.getDenumire() + " ===");
        System.out.println(stand.getConcept());
        System.out.println();
        for (Produs p : stand.getProduse()) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println("Produse in stand: " + stand.getProduse().size()
                + " (minim cerut: " + Parametri.MIN_PRODUSE + ")");

        Produs vegana = stand.gaseste("Shaorma Falafel");
        System.out.println();
        System.out.println("Shaorma Falafel este si Shaorma? " + (vegana instanceof Shaorma));
        System.out.println("Shaorma Falafel este si Produs? " + (vegana instanceof Produs));
    }
}
