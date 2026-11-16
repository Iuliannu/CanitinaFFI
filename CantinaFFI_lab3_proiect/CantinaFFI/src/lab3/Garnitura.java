package lab3;

/** Garnitura: pretul final = pretul de baza * coeficientul portiei. */
public class Garnitura extends Produs {

    private final Portie portie;

    public Garnitura(String denumire, double pret, int stoc, Portie portie) {
        super(denumire, pret, stoc);
        this.portie = portie;
    }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() * portie.getCoeficient());
    }

    @Override
    public String toString() {
        return super.toString() + " [garnitura " + portie + ", " + portie.getGrame() + " g]";
    }
}
