package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Meniul combo este un Produs (se vinde si apare pe bon) si, totodata,
 * are produse (componentele). Nu are stoc propriu: stocul sau este cel al
 * componentei cu stocul cel mai mic.
 */
public class MeniuCombo extends Produs {

    private final List<Produs> componente;

    public MeniuCombo(String denumire, Produs... componente) {
        super(denumire, sumaBaza(componente), 0);
        this.componente = new ArrayList<>(List.of(componente));
        for (int i = 0; i < componente.length; i++) {
            for (int j = i + 1; j < componente.length; j++) {
                if (componente[i].equals(componente[j])) {
                    throw new IllegalArgumentException("Componenta repetata: "
                            + componente[i].getDenumire());
                }
            }
        }
    }

    private static double sumaBaza(Produs[] componente) {
        if (componente == null || componente.length < 2) {
            throw new IllegalArgumentException("Un combo are cel putin doua componente");
        }
        double suma = 0;
        for (Produs c : componente) {
            suma += c.getPret();
        }
        return suma;
    }

    public List<Produs> getComponente() { return Collections.unmodifiableList(componente); }

    /** Suma preturilor finale ale componentelor minus reducerea personala. */
    @Override
    public double pretFinal() {
        double suma = 0;
        for (Produs c : componente) {
            suma += c.pretFinal();
        }
        return rotunjeste(suma * (100 - Parametri.REDUCERE_COMBO) / 100.0);
    }

    /** Se pot vinde cate combo-uri permite componenta cea mai putin aprovizionata. */
    @Override
    public int getStoc() {
        int minim = Integer.MAX_VALUE;
        for (Produs c : componente) {
            minim = Math.min(minim, c.getStoc());
        }
        return minim;
    }

    @Override
    public void scadeStoc(int cantitate) {
        if (!areStoc(cantitate)) {
            throw new IllegalStateException("Stoc insuficient pentru " + getDenumire());
        }
        for (Produs c : componente) {
            c.scadeStoc(cantitate);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" [combo -").append(Parametri.REDUCERE_COMBO).append("%:");
        for (Produs c : componente) {
            sb.append(' ').append(c.getDenumire()).append(';');
        }
        sb.setLength(sb.length() - 1);
        return sb.append(']').toString();
    }
}
