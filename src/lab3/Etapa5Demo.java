package lab3;

import java.util.Locale;

/** Verificarea etapei 5: bonul, cadoul la fiecare al k-lea bon, regula Duo-Shaorma. */
public class Etapa5Demo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Stand stand = Stand.shaormaExpress();
        Produs pui = stand.gaseste("Shaorma Pui");
        Produs vita = stand.gaseste("Shaorma Vita");
        Produs cola = stand.gaseste("Cola");

        System.out.println("=== Scenariul 1: regula NU se activeaza (o singura shaorma) ===");
        Comanda a = new Comanda();
        a.adauga(pui, 1);
        a.adauga(cola, 1);
        System.out.println(new Bon(a));

        System.out.println("=== Scenariul 2: regula se activeaza (doua shaorma) ===");
        Comanda b = new Comanda();
        b.adauga(pui, 1);
        b.adauga(vita, 1);
        System.out.println(new Bon(b));

        System.out.println("=== Cadoul la fiecare al " + Parametri.K_CADOU + "-lea bon ===");
        for (int i = 3; i <= Parametri.K_CADOU; i++) {
            Comanda c = new Comanda();
            c.adauga(cola, 1);
            Bon bon = new Bon(c);
            System.out.println("Bon " + bon.getNumar() + ": cadou = " + bon.areCadou());
            if (bon.areCadou()) {
                System.out.println(bon);
            }
        }
    }
}
