package lab3;

import java.math.BigDecimal;
import java.util.Locale;

/** Verificarea etapei 4: comanda (compozitie), stoc, BigDecimal si experimentul. */
public class Etapa4Demo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Stand stand = Stand.shaormaExpress();
        Produs falafel = stand.gaseste("Shaorma Falafel");   // stoc 4
        Produs cola = stand.gaseste("Cola");

        System.out.println("=== Etapa 4: comanda ===");
        Comanda c = new Comanda();
        c.adauga(cola, 1);
        c.adauga(cola, 2);                       // acelasi produs: aceeasi linie
        System.out.println("Linii in comanda: " + c.getLinii().size()
                + ", cantitate Cola: " + c.getLinii().get(0).getCantitate());
        System.out.println("Stoc Cola dupa 3 buc.: " + cola.getStoc());

        System.out.println();
        System.out.println("Stoc Falafel inainte: " + falafel.getStoc());
        boolean ok = c.adauga(falafel, 5);        // peste stoc
        System.out.println("Adaugare acceptata? " + ok);
        System.out.println("Stoc Falafel dupa refuz: " + falafel.getStoc());

        System.out.println();
        System.out.println("Total comanda (BigDecimal): " + c.total() + " lei");

        System.out.println();
        System.out.println("=== Experiment double vs BigDecimal ===");
        double s = 0;
        for (int i = 0; i < 10; i++) s += 0.10;
        System.out.println("double:     " + s);
        BigDecimal b = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) b = b.add(new BigDecimal("0.10"));
        System.out.println("BigDecimal: " + b);
        System.out.println("new BigDecimal(0.10)   = " + new BigDecimal(0.10));
        System.out.println("new BigDecimal(\"0.10\") = " + new BigDecimal("0.10"));
    }
}
