package lab3;

/** Bautura: pretul de baza este pretul pentru 250 ml, cel final creste proportional cu volumul. */
public class Bautura extends Produs {

    private static final int VOLUM_BAZA_ML = 250;

    private final int volumMl;

    public Bautura(String denumire, double pret, int stoc, int volumMl) {
        super(denumire, pret, stoc);
        if (volumMl <= 0) {
            throw new IllegalArgumentException("Volumul trebuie sa fie pozitiv: " + volumMl);
        }
        this.volumMl = volumMl;
    }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() * volumMl / VOLUM_BAZA_ML);
    }

    @Override
    public String toString() {
        return super.toString() + " [bautura " + volumMl + " ml]";
    }
}
