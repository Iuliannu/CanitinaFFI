package lab3;

/** Shaorma vegana (nivelul 2 sub Produs): optional cu hummus, contra cost. */
public class ShaormaVegana extends Shaorma {

    private static final double SUPLIMENT_HUMMUS = 4.00;

    private final boolean cuHummus;

    public ShaormaVegana(String denumire, double pret, int stoc,
                         Picanterie picanterie, boolean cuHummus) {
        super(denumire, pret, stoc, picanterie);
        this.cuHummus = cuHummus;
    }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() + (cuHummus ? SUPLIMENT_HUMMUS : 0));
    }

    @Override
    public String toString() {
        return super.toString() + " [vegana" + (cuHummus ? ", cu hummus" : "") + "]";
    }
}
