package lab3;

import java.math.BigDecimal;

/**
 * Bonul refera o comanda creata in afara lui (agregare): comanda exista
 * independent de bon si ramane accesibila pentru raportul zilei.
 */
public class Bon {

    private static int contor = 0;

    private final int numar;
    private final Comanda comanda;

    public Bon(Comanda comanda) {
        if (comanda == null || comanda.esteGoala()) {
            throw new IllegalArgumentException("Nu se poate emite bon pentru o comanda goala");
        }
        this.numar = ++contor;
        this.comanda = comanda;
        comanda.inchide();
    }

    public int getNumar() { return numar; }

    public Comanda getComanda() { return comanda; }

    /** Fiecare al k-lea bon primeste cadou. */
    public boolean areCadou() {
        return numar % Parametri.K_CADOU == 0;
    }

    public BigDecimal getTotal() {
        return comanda.total();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("========== BON nr. %d ==========%n", numar));
        for (LinieComanda l : comanda.getLinii()) {
            sb.append(String.format("%-17s %2d x %6.2f = %8.2f lei%n",
                    l.getProdus().getDenumire(), l.getCantitate(),
                    l.getProdus().pretFinal(), l.subtotal()));
        }
        sb.append(String.format("%-31s %8.2f lei%n", "Subtotal:", comanda.subtotal()));
        BigDecimal duo = comanda.reducereDuoShaorma();
        if (duo.signum() > 0) {
            sb.append(String.format("%-31s %8.2f lei%n", "Reducere Duo-Shaorma (-50%):", duo.negate()));
        }
        sb.append(String.format("%-31s %8.2f lei%n", "TOTAL:", getTotal()));
        if (areCadou()) {
            sb.append("*** CADOU: ").append(Parametri.CADOU).append(" ***").append(System.lineSeparator());
        }
        return sb.toString();
    }
}
