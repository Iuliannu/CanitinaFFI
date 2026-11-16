package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Standul „Shaorma Express FFI”: tine catalogul de produse (agregare). */
public class Stand {

    private final String denumire;
    private final String concept;
    private final List<Produs> produse = new ArrayList<>();
    private final List<Meniu> meniuri = new ArrayList<>();

    public Stand(String denumire, String concept) {
        this.denumire = denumire;
        this.concept = concept;
    }

    public String getDenumire() { return denumire; }

    public String getConcept() { return concept; }

    public void adauga(Produs p) { produse.add(p); }

    public List<Produs> getProduse() { return Collections.unmodifiableList(produse); }

    public void adaugaMeniu(Meniu m) { meniuri.add(m); }

    public List<Meniu> getMeniuri() { return Collections.unmodifiableList(meniuri); }

    public Produs gaseste(String denumireCautata) {
        for (Produs p : produse) {
            if (p.getDenumire().equalsIgnoreCase(denumireCautata)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Produs inexistent: " + denumireCautata);
    }

    /** Construieste standul cu produsele din fisa de proiectare. */
    public static Stand shaormaExpress() {
        Stand s = new Stand("Shaorma Express FFI",
                "Shaorma la comanda, cu carne sau vegana, plus garnituri si bauturi.");
        s.adauga(new Shaorma("Shaorma Pui", 55.00, 10, Picanterie.MEDIE));
        s.adauga(new Shaorma("Shaorma Vita", 65.00, 8, Picanterie.PICANTA));
        s.adauga(new ShaormaVegana("Shaorma Falafel", 50.00, 4, Picanterie.FARA, true));
        s.adauga(new Garnitura("Cartofi prajiti", 25.00, 20, Portie.NORMALA));
        s.adauga(new Garnitura("Salata coleslaw", 20.00, 15, Portie.MICA));
        s.adauga(new Bautura("Ayran", 12.00, 20, 250));
        s.adauga(new Bautura("Cola", 12.00, 20, 330));
        s.adauga(new Bautura("Limonada", 9.00, 12, 500));
        s.adauga(new Bautura("Apa plata", 5.00, 20, 500));

        Produs pui = s.gaseste("Shaorma Pui");
        Produs falafel = s.gaseste("Shaorma Falafel");
        Produs cartofi = s.gaseste("Cartofi prajiti");
        Produs coleslaw = s.gaseste("Salata coleslaw");
        Produs cola = s.gaseste("Cola");
        Produs ayran = s.gaseste("Ayran");
        s.adauga(new MeniuCombo("Combo Clasic", pui, cartofi, cola));
        s.adauga(new MeniuCombo("Combo Vegan", falafel, coleslaw, ayran));

        Meniu dimineata = new Meniu("Meniul de dimineata");
        dimineata.adaugaProdus(pui);
        dimineata.adaugaProdus(ayran);
        Meniu zilei = new Meniu("Meniul zilei");
        zilei.adaugaProdus(pui);
        zilei.adaugaProdus(cartofi);
        zilei.adaugaProdus(cola);
        s.adaugaMeniu(dimineata);
        s.adaugaMeniu(zilei);
        return s;
    }
}
