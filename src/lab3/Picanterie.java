package lab3;

/** Gradul de picanterie al unei shaorma; fiecare grad are un supliment de pret. */
public enum Picanterie {
    FARA(0.00, "fara"),
    MEDIE(0.00, "medie"),
    PICANTA(3.00, "picanta"),
    FOARTE_PICANTA(5.00, "foarte picanta");

    private final double supliment;
    private final String eticheta;

    Picanterie(double supliment, String eticheta) {
        this.supliment = supliment;
        this.eticheta = eticheta;
    }

    public double getSupliment() { return supliment; }

    public String getEticheta() { return eticheta; }
}
