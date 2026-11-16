package lab3;

/** Shaorma: pretul final = pretul de baza + suplimentul de picanterie. */
public class Shaorma extends Produs {

    private final Picanterie picanterie;

    public Shaorma(String denumire, double pret, int stoc, Picanterie picanterie) {
        super(denumire, pret, stoc);
        this.picanterie = picanterie;
    }

    public Picanterie getPicanterie() { return picanterie; }

    @Override
    public double pretFinal() {
        return rotunjeste(super.pretFinal() + picanterie.getSupliment());
    }

    @Override
    public String toString() {
        return super.toString() + " [shaorma, picanterie " + picanterie.getEticheta() + "]";
    }
}
