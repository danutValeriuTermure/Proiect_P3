import LoginRelated.Angajat;
import LoginRelated.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUILogin extends JFrame implements Serializable {

    private JLabel titlu, email, parola;
    private JTextField tfEmail;
    private JPasswordField tfParola;
    private JButton login;
    private JCheckBox arataParola;
    private List<Client> listaClienti;
    private List<Angajat> listaAngajati;

    private JCheckBox bAngajat, bClient;

    public GUILogin(File clienti, File angajati){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container col = getContentPane();
        col.setBackground(Color.magenta);
        setTitle("LoginRelated.Login");
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
        email.setBounds(20, 120, 90, 30);

        parola = new JLabel("Parola : ");
        parola.setSize(new Dimension(80, 20));
        parola.setFont(new Font("Monaco", Font.BOLD, 12));
        parola.setBounds(20, 170, 90, 30);

        tfEmail = new JTextField();
        tfEmail.setPreferredSize(new Dimension(200, 20));
        tfEmail.setFont(new Font("Monaco", Font.BOLD, 12));
        tfEmail.setBounds(115, 120, 200, 20);

        tfParola = new JPasswordField();
        tfParola.setEchoChar('*');
        tfParola.setPreferredSize(new Dimension(200, 20));
        tfParola.setFont(new Font("Monaco", Font.BOLD, 12));
        tfParola.setBounds(115, 170, 200, 20);

        login = new JButton("LOGIN");
        login.setSize(new Dimension(80, 20));
        login.setFont(new Font("Monaco", Font.BOLD, 12));
        login.setBounds(70, 250, 80, 20);

        arataParola = new JCheckBox("Arata parola");
        arataParola.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            tfParola.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
        });
        arataParola.setBounds(70, 190, 100, 50);

        bClient = new JCheckBox("Register LoginRelated.Client");
        bAngajat = new JCheckBox("Register LoginRelated.Angajat");

        bClient.setSize(new Dimension(180, 20));
        bClient.setFont(new Font("Monaco", Font.BOLD, 12));
        bClient.setBounds(40, 50, 180, 20);

        bAngajat.setSize(new Dimension(180, 20));
        bAngajat.setFont(new Font("Monaco", Font.BOLD, 12));
        bAngajat.setBounds(40, 80, 180, 20);

        add(bClient);
        add(bAngajat);

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
                if (bClient.isSelected() && bAngajat.isSelected()){
                    JOptionPane.showMessageDialog(null, "Selecteaza doar o varianta");
                }
                String email = tfEmail.getText();
                String parola = tfParola.getText();

                if (bClient.isSelected() && !bAngajat.isSelected()) {
                    String regex = "^(.+)@(.+)$";
                    Pattern pattern = Pattern.compile(regex);

                    boolean ok = false;
                    Matcher matcher = pattern.matcher(email);
                    if (matcher.matches() == false) {
                        JOptionPane.showMessageDialog(null, "Email incorect");
                    }else {
                        ok = true;
                    }
                    if (ok == true) {
                        try {
                            boolean gasit = false;
                            String copieEmail = "", copieParola = "";
                            Scanner myReaderClienti = new Scanner(clienti);
                            while (myReaderClienti.hasNextLine()) {
                                String data = myReaderClienti.nextLine();
                                String[] splited = data.split(" ");
                                if (splited[0].equals(email)) {
                                    copieParola = splited[1];
                                    copieEmail = splited[0];
                                    gasit = true;
                                }
                            }

                            if (gasit == true) {
                                if (copieParola.equals(parola)) {
                                    JOptionPane.showMessageDialog(null, "Logat");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Parola gresita");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "User gresit");
                            }

                            myReaderClienti.close();
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

                if (bAngajat.isSelected()&& !bClient.isSelected()) {
                    String regex = "^(.+)@(.+)$";
                    Pattern pattern = Pattern.compile(regex);

                    boolean ok = false;
                    Matcher matcher = pattern.matcher(email);
                    if (matcher.matches() == false) {
                        JOptionPane.showMessageDialog(null, "Email incorect");
                    }else {
                        ok = true;
                    }
                    if (ok == true) {
                        try {
                            boolean gasit = false;
                            String copieEmail = "", copieParola = "";
                            Scanner myReaderAngajati = new Scanner(angajati);
                            while (myReaderAngajati.hasNextLine()) {
                                String data = myReaderAngajati.nextLine();
                                String[] splited = data.split(" ");
                                if (splited[0].equals(email)) {
                                    copieParola = splited[1];
                                    copieEmail = splited[0];
                                    gasit = true;
                                }
                            }

                            if (gasit == true) {
                                if (copieParola.equals(parola)) {
                                    JOptionPane.showMessageDialog(null, "Logat");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Parola gresita");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "User gresit");
                            }

                            myReaderAngajati.close();
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
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
                for (LoginRelated.Angajat a : listaAngajati){
                    if (a.getEmail() == email){
                        if (a.getParola() == parola) {
                            JOptionPane.showMessageDialog(null, "Logat");
                        }
                    }
                }

                for (LoginRelated.Client c : listaClienti){
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
    /**
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
            listaClienti.add((LoginRelated.Client) o);
        }
    }

    public void DeserializareAngajati(File f) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        java.util.List<Object> temp = (List<Object>) ois.readObject();
        ois.close();
        fis.close();
        for (Object o : temp){
            listaAngajati.add((LoginRelated.Angajat) o);
        }
    }*/
}
