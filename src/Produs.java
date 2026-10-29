public class Produs {
    private static int numarProduse = 0;
    private String denumire;
    private double pret;
    private int stoc;

    public Produs(String denumire, double pret, int stoc) {
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
        numarProduse++;
    }

    public String getDenumire() { return denumire; }
    public double getPret() { return pret; }
    public int getStoc() { return stoc; }

    public static int getNumarProduse() {
        return numarProduse;
    }

    public void setPret(double pret) {
        if (pret > 0) {
            this.pret = pret;
        } else {
            System.out.println("Pret invalid: se accepta doar valori pozitive");
        }
    }

    public double costPentru(int portii) {
        return pret * portii;
    }

    public boolean esteDisponibil(int portii) {
        return portii > 0 && portii <= stoc;
    }

    public String codScurt() {
        String prefix = denumire.substring(0, 3).toUpperCase();
        int valoare = (int) pret;
        return prefix + valoare;
    }

    @Override
    public String toString() {
        return denumire + " | " + pret + " lei | stoc: " + stoc;
    }
}
