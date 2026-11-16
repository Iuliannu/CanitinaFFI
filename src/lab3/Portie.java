package lab3;

/** Marimea portiei de garnitura: coeficient de pret si gramaj. */
public enum Portie {
    MICA(0.7, 120),
    NORMALA(1.0, 180),
    DUBLA(1.8, 360);

    private final double coeficient;
    private final int grame;

    Portie(double coeficient, int grame) {
        this.coeficient = coeficient;
        this.grame = grame;
    }

    public double getCoeficient() { return coeficient; }

    public int getGrame() { return grame; }
}
