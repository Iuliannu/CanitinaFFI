package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Meniul refera produse create in afara lui (agregare): daca meniul dispare,
 * produsele continua sa existe.
 */
public class Meniu {

    private final String denumire;
    private final List<Produs> produse = new ArrayList<>();

    public Meniu(String denumire) {
        if (denumire == null || denumire.isBlank()) {
            throw new IllegalArgumentException("Denumirea meniului nu poate fi goala");
        }
        this.denumire = denumire;
    }

    public String getDenumire() { return denumire; }

    public void adaugaProdus(Produs p) {
        if (p == null) {
            throw new IllegalArgumentException("Produs null");
        }
        produse.add(p);
    }

    public List<Produs> getProduse() { return Collections.unmodifiableList(produse); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Meniu \"" + denumire + "\":");
        for (Produs p : produse) {
            sb.append(String.format("%n   - %s: %.2f lei", p.getDenumire(), p.pretFinal()));
        }
        return sb.toString();
    }
}
