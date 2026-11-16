package lab3;

/**
 * Superclasa ierarhiei de produse ale standului.
 * Campurile sunt private; subclasele folosesc getterii si pretFinal().
 */
public class Produs {

    /** Contorul comun tuturor produselor; primul produs are id 1. */
    private static int contor = 0;

    private final int id;
    private final String denumire;
    private double pret;
    private int stoc;

    /** Produs fara stoc initial (stoc 0); delegheaza constructorului complet. */
    public Produs(String denumire, double pret) {
        this(denumire, pret, 0);
    }

    /** Constructorul complet: singurul loc in care se valideaza datele. */
    public Produs(String denumire, double pret, int stoc) {
        if (denumire == null || denumire.isBlank()) {
            throw new IllegalArgumentException("Denumirea produsului nu poate fi goala");
        }
        valideazaPret(pret);
        if (stoc < 0) {
            throw new IllegalArgumentException("Stocul nu poate fi negativ: " + stoc);
        }
        // id-ul se atribuie dupa validare: un produs invalid nu consuma id.
        this.id = ++contor;
        this.denumire = denumire.trim();
        this.pret = pret;
        this.stoc = stoc;
    }

    private static void valideazaPret(double pret) {
        if (Double.isNaN(pret) || pret < 0) {
            throw new IllegalArgumentException("Pretul nu poate fi negativ: " + pret);
        }
    }

    /** Rotunjeste la doua zecimale; folosita de subclase la calculul pretului final. */
    protected static double rotunjeste(double valoare) {
        return Math.round(valoare * 100) / 100.0;
    }

    public int getId() { return id; }

    public String getDenumire() { return denumire; }

    public double getPret() { return pret; }

    public void setPret(double pret) {
        valideazaPret(pret);
        this.pret = pret;
    }

    public int getStoc() { return stoc; }

    /** Pretul de baza; subclasele il suprascriu in functie de campurile proprii. */
    public double pretFinal() {
        return pret;
    }

    public boolean areStoc(int cantitate) {
        return getStoc() >= cantitate;
    }

    /** Scade stocul; apelantul verifica in prealabil disponibilitatea. */
    public void scadeStoc(int cantitate) {
        if (cantitate <= 0) {
            throw new IllegalArgumentException("Cantitatea trebuie sa fie pozitiva: " + cantitate);
        }
        if (!areStoc(cantitate)) {
            throw new IllegalStateException("Stoc insuficient pentru " + denumire);
        }
        stoc -= cantitate;
    }

    /** Doua produse sunt egale daca au aceeasi denumire (fara diferenta de litere). */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produs)) return false;
        return denumire.equalsIgnoreCase(((Produs) o).denumire);
    }

    @Override
    public int hashCode() {
        return denumire.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return String.format("#%d %s | baza %.2f lei | final %.2f lei | stoc %d",
                id, denumire, pret, pretFinal(), getStoc());
    }
}
