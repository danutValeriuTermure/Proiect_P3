import Produse.Produs;

import javax.swing.*;

public class Pereche {
    private JButton buttonImagine;
    private Produs informatiiProdus;

    public Pereche(JButton buttonImagine, Produs informatiiProdus){
        this.buttonImagine = buttonImagine;
        this.informatiiProdus = informatiiProdus;
    }

    public JButton getButonImagine() {
        return buttonImagine;
    }

    public Produs getInformatiiButon() {
        return informatiiProdus;
    }
}
