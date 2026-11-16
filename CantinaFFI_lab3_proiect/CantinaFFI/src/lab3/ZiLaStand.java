package lab3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Simularea unei zile de lucru. Fara argumente ruleaza scenariul fix;
 * cu argumentul "interactiv" comenzile se introduc de la tastatura.
 */
public class ZiLaStand {

    private final Stand stand;
    private final List<Bon> bonuri = new ArrayList<>();

    public ZiLaStand(Stand stand) {
        this.stand = stand;
    }

    /** Emite bonul pentru comanda; o comanda complet refuzata nu primeste bon. */
    private void incheie(Comanda comanda) {
        if (comanda.esteGoala()) {
            System.out.println("  Comanda goala: nu se emite bon.\n");
            return;
        }
        Bon bon = new Bon(comanda);
        bonuri.add(bon);
        System.out.println(bon);
    }

    private Produs p(String denumire) {
        return stand.gaseste(denumire);
    }

    public void ruleazaScenariu() {
        System.out.println("##### " + stand.getDenumire() + ": scenariul zilei #####\n");

        System.out.println("--- Comanda 1: fara regula ---");
        Comanda c = new Comanda();
        c.adauga(p("Shaorma Pui"), 1);
        c.adauga(p("Cola"), 1);
        incheie(c);

        System.out.println("--- Comanda 2: meniu combo ---");
        c = new Comanda();
        c.adauga(p("Combo Clasic"), 1);
        incheie(c);

        System.out.println("--- Comanda 3: regula Duo-Shaorma activa ---");
        c = new Comanda();
        c.adauga(p("Shaorma Pui"), 2);
        c.adauga(p("Ayran"), 1);
        incheie(c);

        System.out.println("--- Comanda 4 ---");
        c = new Comanda();
        c.adauga(p("Shaorma Falafel"), 3);
        c.adauga(p("Cartofi prajiti"), 1);
        incheie(c);

        System.out.println("--- Comanda 5: refuzata partial (stoc) ---");
        c = new Comanda();
        c.adauga(p("Shaorma Falafel"), 2);
        c.adauga(p("Limonada"), 1);
        c.adauga(p("Shaorma Vita"), 1);
        incheie(c);

        System.out.println("--- Comanda 6 ---");
        c = new Comanda();
        c.adauga(p("Combo Clasic"), 1);
        c.adauga(p("Apa plata"), 1);
        incheie(c);

        System.out.println("--- Comanda 7: epuizeaza Falafel ---");
        c = new Comanda();
        c.adauga(p("Shaorma Falafel"), 1);
        c.adauga(p("Salata coleslaw"), 1);
        incheie(c);

        System.out.println("--- Comanda 8: combo cu componenta epuizata ---");
        c = new Comanda();
        c.adauga(p("Combo Vegan"), 1);
        c.adauga(p("Apa plata"), 2);
        incheie(c);

        raportulZilei();
    }

    public void ruleazaInteractiv(Scanner sc) {
        List<Produs> produse = stand.getProduse();
        String raspuns;
        do {
            Comanda c = new Comanda();
            int optiune;
            do {
                System.out.println("--- Meniu ---");
                for (int i = 0; i < produse.size(); i++) {
                    System.out.printf("%d - %s (%.2f lei)%n", i + 1,
                            produse.get(i).getDenumire(), produse.get(i).pretFinal());
                }
                System.out.println("0 - Finalizare comanda");
                System.out.print("Optiunea: ");
                optiune = sc.nextInt();
                if (optiune >= 1 && optiune <= produse.size()) {
                    System.out.print("Cantitate: ");
                    int q = sc.nextInt();
                    if (q > 0) {
                        c.adauga(produse.get(optiune - 1), q);
                    }
                } else if (optiune != 0) {
                    System.out.println("Optiune inexistenta");
                }
            } while (optiune != 0);
            incheie(c);
            System.out.print("Inca o comanda? (da/nu): ");
            raspuns = sc.next();
        } while (raspuns.equalsIgnoreCase("da"));
        raportulZilei();
    }

    /** Raportul de inchidere: se reconstituie din bonurile emise. */
    private void raportulZilei() {
        BigDecimal incasari = BigDecimal.ZERO;
        List<Produs> vandute = new ArrayList<>();
        List<Integer> cantitati = new ArrayList<>();
        for (Bon b : bonuri) {
            incasari = incasari.add(b.getTotal());
            for (LinieComanda l : b.getComanda().getLinii()) {
                int idx = vandute.indexOf(l.getProdus());
                if (idx < 0) {
                    vandute.add(l.getProdus());
                    cantitati.add(l.getCantitate());
                } else {
                    cantitati.set(idx, cantitati.get(idx) + l.getCantitate());
                }
            }
        }
        int maxIdx = -1;
        for (int i = 0; i < vandute.size(); i++) {
            if (maxIdx < 0 || cantitati.get(i) > cantitati.get(maxIdx)) {
                maxIdx = i;
            }
        }

        System.out.println("################ RAPORTUL ZILEI ################");
        System.out.println("Numar de bonuri: " + bonuri.size());
        System.out.printf("Incasari totale: %.2f lei%n", incasari);
        if (maxIdx >= 0) {
            System.out.println("Produsul cel mai vandut: " + vandute.get(maxIdx).getDenumire()
                    + " (" + cantitati.get(maxIdx) + " buc.)");
        }
        System.out.println("Stoc ramas:");
        for (Produs prod : stand.getProduse()) {
            String nota = prod instanceof MeniuCombo ? "  (derivat din componente)" : "";
            System.out.printf("  %-16s %3d%s%n", prod.getDenumire(), prod.getStoc(), nota);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ZiLaStand zi = new ZiLaStand(Stand.shaormaExpress());
        if (args.length > 0 && args[0].equals("interactiv")) {
            zi.ruleazaInteractiv(new Scanner(System.in));
        } else {
            zi.ruleazaScenariu();
        }
    }
}
