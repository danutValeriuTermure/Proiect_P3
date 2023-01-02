import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        GUIPaginaPrincipala gui = new GUIPaginaPrincipala(new File("clienti.txt"), new File("angajati.txt"));
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}