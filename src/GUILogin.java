import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUILogin extends JFrame implements Serializable {

    private JLabel titlu, email, parola;
    private JTextField tfEmail;
    private JPasswordField tfParola;
    private JButton login;
    private JCheckBox arataParola;
    private List<Client> listaClienti;
    private List<Angajat> listaAngajati;

    public GUILogin(File clienti, File angajati){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setSize(new Dimension(500, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        titlu = new JLabel("LOGIN");
        titlu.setSize(new Dimension(100, 50));
        titlu.setFont(new Font("Monaco", Font.BOLD, 20));

        JPanel susStanga = new JPanel(new FlowLayout(FlowLayout.CENTER));
        susStanga.setSize(new Dimension(120, 70));
        susStanga.setBounds(10, 10, 130, 80);
        susStanga.add(titlu);
        add(susStanga);

        email = new JLabel("Email : ");
        email.setSize(new Dimension(80, 20));
        email.setFont(new Font("Monaco", Font.BOLD, 12));
        email.setBounds(20, 100, 90, 30);

        parola = new JLabel("Parola : ");
        parola.setSize(new Dimension(80, 20));
        parola.setFont(new Font("Monaco", Font.BOLD, 12));
        parola.setBounds(20, 150, 90, 30);

        tfEmail = new JTextField();
        tfEmail.setPreferredSize(new Dimension(200, 20));
        tfEmail.setFont(new Font("Monaco", Font.BOLD, 12));
        tfEmail.setBounds(115, 100, 200, 20);

        tfParola = new JPasswordField();
        tfParola.setEchoChar('*');
        tfParola.setPreferredSize(new Dimension(200, 20));
        tfParola.setFont(new Font("Monaco", Font.BOLD, 12));
        tfParola.setBounds(115, 150, 200, 20);

        login = new JButton("LOGIN");
        login.setSize(new Dimension(80, 20));
        login.setFont(new Font("Monaco", Font.BOLD, 12));
        login.setBounds(70, 230, 80, 20);

        arataParola = new JCheckBox("Arata parola");
        arataParola.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            tfParola.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
        });
        arataParola.setBounds(70, 180, 100, 50);

        add(email);
        add(tfEmail);
        add(parola);
        add(tfParola);
        add(arataParola);
        add(login);

        listaClienti = new ArrayList<>();
        listaAngajati = new ArrayList<>();
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String parola = tfParola.getText();
                try {
                    boolean gasit = false;
                    String copieEmail = "", copieParola = "";
                    Scanner myReaderClienti = new Scanner(clienti);
                    while (myReaderClienti.hasNextLine()) {
                        String data = myReaderClienti.nextLine();
                        String[] splited = data.split(" ");
                        if (splited[0].equals(email)){
                            copieParola = splited[1];
                            copieEmail = splited[0];
                            gasit = true;
                        }
                    }

                    if (gasit == true){
                        if (copieParola.equals(parola)){
                            JOptionPane.showMessageDialog(null, "Logat");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Parola gresita");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "User gresit");
                    }

                    myReaderClienti.close();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    boolean gasit = false;
                    String copieEmail = "", copieParola = "";
                    Scanner myReaderAngajati = new Scanner(angajati);
                    while (myReaderAngajati.hasNextLine()) {
                        String data = myReaderAngajati.nextLine();
                        String[] splited = data.split(" ");
                        if (splited[0].equals(email)){
                            copieParola = splited[1];
                            copieEmail = splited[0];
                            gasit = true;
                        }
                    }

                    if (gasit == true){
                        if (copieParola.equals(parola)){
                            JOptionPane.showMessageDialog(null, "Logat");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Parola gresita");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "User gresit");
                    }

                    myReaderAngajati.close();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                /**
                try {
                    if (clienti.exists())
                        DeserializareClienti(clienti);
                    if (angajati.exists())
                        DeserializareAngajati(angajati);
                }
                catch(IOException|ClassNotFoundException|ClassCastException ex){
                    ex.printStackTrace();
                }


                String email = tfEmail.getText();
                String parola = tfParola.getText();

                boolean okParola = true, okUser = true;
                for (Angajat a : listaAngajati){
                    if (a.getEmail() == email){
                        if (a.getParola() == parola) {
                            JOptionPane.showMessageDialog(null, "Logat");
                        }
                    }
                }

                for (Client c : listaClienti){
                    if (c.getEmail() == email){
                        if (c.getParola() == parola) {
                            JOptionPane.showMessageDialog(null, "Logat");
                        }
                    }
                }
                 */
            }
        });
    }

    public boolean verificareEsteClient(){
        return false;
    }

    public boolean verificareEsteAngajat(){
        return false;
    }


    public void DeserializareClienti(File f) throws IOException, ClassNotFoundException{
        System.out.println("1");
        FileInputStream fis = new FileInputStream(f);
        System.out.println("2");
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println("3");
        List<Object> temp = (List<Object>) ois.readObject();
        System.out.println("4");
        ois.close();
        fis.close();
        for (Object o : temp){
            listaClienti.add((Client) o);
        }
    }

    public void DeserializareAngajati(File f) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        java.util.List<Object> temp = (List<Object>) ois.readObject();
        ois.close();
        fis.close();
        for (Object o : temp){
            listaAngajati.add((Angajat) o);
        }
    }
}
