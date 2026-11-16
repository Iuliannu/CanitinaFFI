package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** O linie a comenzii. Constructorul nu este public: liniile se creeaza doar in Comanda. */
public class LinieComanda {

    private final Produs produs;
    private int cantitate;

    LinieComanda(Produs produs, int cantitate) {
        this.produs = produs;
        this.cantitate = cantitate;
    }

    public Produs getProdus() { return produs; }

    public int getCantitate() { return cantitate; }

    void maresteCantitatea(int cantitateInPlus) {
        cantitate += cantitateInPlus;
    }

    public BigDecimal subtotal() {
        return BigDecimal.valueOf(produs.pretFinal())
                .multiply(BigDecimal.valueOf(cantitate))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
