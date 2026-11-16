package lab3;

import java.util.Locale;

/** Verificarea etapei 6: agregarea (6.1) si meniul combo (6.2). */
public class Etapa6Demo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("=== 6.1 Agregarea ===");
        // produsele se creeaza in afara meniurilor
        Produs pui = new Shaorma("Shaorma Pui", 55.00, 10, Picanterie.MEDIE);
        Produs cola = new Bautura("Cola", 12.00, 20, 330);

        Meniu meniuDimineata = new Meniu("Meniul de dimineata");
        Meniu meniuZilei = new Meniu("Meniul zilei");
        meniuDimineata.adaugaProdus(pui);
        meniuDimineata.adaugaProdus(cola);
        meniuZilei.adaugaProdus(pui);

        System.out.println("(1) Acelasi obiect in doua meniuri:");
        System.out.println(meniuDimineata);
        System.out.println(meniuZilei);
        System.out.println("   meniuDimineata.get(0) == meniuZilei.get(0): "
                + (meniuDimineata.getProduse().get(0) == meniuZilei.getProduse().get(0)));

        System.out.println("(2) pui.setPret(60.00):");
        pui.setPret(60.00);
        System.out.println(meniuDimineata);
        System.out.println(meniuZilei);

        System.out.println("(3) meniuDimineata = null:");
        meniuDimineata = null;
        System.out.println("   produsul exista: " + pui);
        System.out.println("   Meniul zilei inca il contine: " + meniuZilei.getProduse().contains(pui));
        Comanda c = new Comanda();
        c.adauga(pui, 1);
        System.out.println("   comanda: " + c.total() + " lei");

        System.out.println();
        System.out.println("=== 6.2 Meniul combo ===");
        Stand stand = Stand.shaormaExpress();
        Produs combo = stand.gaseste("Combo Clasic");
        System.out.println(combo);
        double suma = 0;
        for (Produs p : ((MeniuCombo) combo).getComponente()) {
            System.out.printf("   componenta %-16s final %.2f%n", p.getDenumire(), p.pretFinal());
            suma += p.pretFinal();
        }
        System.out.printf("   suma = %.2f, reducere %d%% => combo %.2f%n",
                suma, Parametri.REDUCERE_COMBO, combo.pretFinal());

        System.out.println();
        Comanda c2 = new Comanda();
        Produs falafel = stand.gaseste("Shaorma Falafel");
        Produs comboVegan = stand.gaseste("Combo Vegan");
        System.out.println("Stoc combo vegan (cea mai mica componenta): " + comboVegan.getStoc());
        c2.adauga(falafel, 4);                     // epuizam componenta Falafel
        System.out.println("Stoc Falafel: " + falafel.getStoc() + ", stoc combo: " + comboVegan.getStoc());
        boolean ok = c2.adauga(comboVegan, 1);
        System.out.println("Combo vegan acceptat? " + ok);
    }
}
