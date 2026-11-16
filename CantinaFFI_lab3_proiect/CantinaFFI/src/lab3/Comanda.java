package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Comanda este proprietarul liniilor sale (compozitie). */
public class Comanda {

    /** Regula proprie „Duo-Shaorma”: reducerea la cea mai ieftina shaorma din comanda. */
    public static final int PRAG_DUO_SHAORMA = 2;
    public static final BigDecimal REDUCERE_DUO = new BigDecimal("0.50");

    private final List<LinieComanda> linii = new ArrayList<>();
    private boolean inchisa = false;

    /**
     * Adauga produsul in comanda. Daca stocul nu ajunge, produsul este refuzat
     * cu un mesaj si metoda intoarce false (fara exceptie).
     */
    public boolean adauga(Produs p, int cantitate) {
        if (p == null || cantitate <= 0) {
            throw new IllegalArgumentException("Produs sau cantitate invalide");
        }
        if (inchisa) {
            throw new IllegalStateException("Comanda este inchisa (bonul a fost emis)");
        }
        if (!p.areStoc(cantitate)) {
            System.out.println("  Refuzat: " + p.getDenumire() + " x" + cantitate
                    + " (stoc disponibil: " + p.getStoc() + ")");
            return false;
        }
        p.scadeStoc(cantitate);
        LinieComanda existenta = gasesteLinia(p);
        if (existenta != null) {
            existenta.maresteCantitatea(cantitate);
        } else {
            linii.add(new LinieComanda(p, cantitate));
        }
        System.out.println("  Adaugat: " + p.getDenumire() + " x" + cantitate);
        return true;
    }

    private LinieComanda gasesteLinia(Produs p) {
        for (LinieComanda l : linii) {
            if (l.getProdus().equals(p)) {
                return l;
            }
        }
        return null;
    }

    public List<LinieComanda> getLinii() {
        return Collections.unmodifiableList(linii);
    }

    public boolean esteGoala() { return linii.isEmpty(); }

    public BigDecimal subtotal() {
        BigDecimal suma = BigDecimal.ZERO;
        for (LinieComanda l : linii) {
            suma = suma.add(l.subtotal());
        }
        return suma.setScale(2, RoundingMode.HALF_UP);
    }

    /** Apelata de Bon la emitere: dupa aceasta comanda nu mai poate fi modificata. */
    void inchide() { inchisa = true; }

    /**
     * Regula proprie: daca in comanda sunt cel putin 2 portii de shaorma
     * (orice tip), cea mai ieftina portie primeste 50 % reducere.
     * Combo-urile nu se iau in calcul, fiindca au deja reducerea lor.
     */
    public BigDecimal reducereDuoShaorma() {
        int portii = 0;
        BigDecimal celMaiIeftin = null;
        for (LinieComanda l : linii) {
            if (l.getProdus() instanceof Shaorma) {
                portii += l.getCantitate();
                BigDecimal unitar = BigDecimal.valueOf(l.getProdus().pretFinal());
                if (celMaiIeftin == null || unitar.compareTo(celMaiIeftin) < 0) {
                    celMaiIeftin = unitar;
                }
            }
        }
        if (portii < PRAG_DUO_SHAORMA) {
            return BigDecimal.ZERO.setScale(2);
        }
        return celMaiIeftin.multiply(REDUCERE_DUO).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal total() {
        return subtotal().subtract(reducereDuoShaorma()).setScale(2, RoundingMode.HALF_UP);
    }
}
