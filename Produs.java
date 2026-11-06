public class Produs {
    private String denumire;
    private double pret;
    private int stoc;

    public Produs(String denumire, double pret, int stoc) {
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
    }

    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public int getStoc() {
        return stoc;
    }

    public double costPentru(int portii) {
        return pret * portii;
    }

    public boolean esteDisponibil(int portii) {
        return portii > 0 && portii <= stoc;
    }

    public String codScurt() {
        return denumire.substring(0, 3).toUpperCase() + (int) pret;
    }

    @Override
    public String toString() {
        return String.format(
                "%s | preț: %.2f lei | stoc: %d",
                denumire, pret, stoc
        );
    }
}