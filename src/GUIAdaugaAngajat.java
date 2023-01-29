import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUIAdaugaAngajat extends JFrame {
    private JLabel nume, prenume, email, parola, nrLogin;
    private JTextField tfNume, tfPrenume, tfEmail, tfParola, tfNrLogin;
    private JButton adauga, clear, done, genereaza;

    public GUIAdaugaAngajat(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adauga angajat");
        setSize(new Dimension(534, 290));
        getContentPane().setBackground(new Color(10, 38, 71));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        nume = new JLabel("Nume:");
        nume.setBackground(new Color(10, 38, 71));
        nume.setOpaque(true);
        nume.setForeground(Color.WHITE);
        nume.setFont(new Font("Monaco", Font.PLAIN, 15));
        nume.setSize(new Dimension(98, 38));
        nume.setBounds(14, 14, 98, 38);
        add(nume);

        prenume = new JLabel("Prenume:");
        prenume.setBackground(new Color(10, 38, 71));
        prenume.setOpaque(true);
        prenume.setForeground(Color.WHITE);
        prenume.setFont(new Font("Monaco", Font.PLAIN, 15));
        prenume.setSize(new Dimension(98, 38));
        prenume.setBounds(14, 61, 98, 38);
        add(prenume);

        email = new JLabel("Email:");
        email.setBackground(new Color(10, 38, 71));
        email.setOpaque(true);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Monaco", Font.PLAIN, 15));
        email.setSize(new Dimension(98, 38));
        email.setBounds(14, 108, 98, 38);
        add(email);

        parola = new JLabel("Parola:");
        parola.setBackground(new Color(10, 38, 71));
        parola.setOpaque(true);
        parola.setForeground(Color.WHITE);
        parola.setFont(new Font("Monaco", Font.PLAIN, 15));
        parola.setSize(new Dimension(98, 38));
        parola.setBounds(14, 155, 98, 38);
        add(parola);

        nrLogin = new JLabel("Nr Login:");
        nrLogin.setBackground(new Color(10, 38, 71));
        nrLogin.setOpaque(true);
        nrLogin.setForeground(Color.WHITE);
        nrLogin.setFont(new Font("Monaco", Font.PLAIN, 15));
        nrLogin.setSize(new Dimension(98, 38));
        nrLogin.setBounds(14, 203, 98, 38);
        add(nrLogin);

        tfNume = new JTextField();
        tfNume.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfNume.setSize(new Dimension(170, 38));
        tfNume.setBounds(129, 14, 170, 38);
        add(tfNume);

        tfPrenume = new JTextField();
        tfPrenume.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfPrenume.setSize(new Dimension(170, 38));
        tfPrenume.setBounds(129, 61, 170, 38);
        add(tfPrenume);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfEmail.setSize(new Dimension(170, 38));
        tfEmail.setBounds(129, 108, 170, 38);
        add(tfEmail);

        tfParola = new JTextField();
        tfParola.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfParola.setSize(new Dimension(170, 38));
        tfParola.setBounds(129, 155, 170, 38);
        add(tfParola);

        tfNrLogin = new JTextField();
        tfNrLogin.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfNrLogin.setSize(new Dimension(78, 38));
        tfNrLogin.setBounds(129, 203, 78, 38);
        add(tfNrLogin);

        genereaza = new JButton("GEN");
        genereaza.setBackground(new Color(20, 66, 114));
        genereaza.setFont(new Font("Monaco", Font.PLAIN, 15));
        genereaza.setOpaque(true);
        genereaza.setForeground(Color.WHITE);
        genereaza.setSize(new Dimension(82, 38));
        genereaza.setBounds(216, 203, 82, 38);
        add(genereaza);

        genereaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int upperbound = 10000;
                int int_random = rand.nextInt(upperbound);
                tfNrLogin.setText(Integer.toString(int_random));
            }
        });

        adauga = new JButton("Adauga");
        adauga.setBackground(new Color(20, 66, 114));
        adauga.setFont(new Font("Monaco", Font.PLAIN, 15));
        adauga.setOpaque(true);
        adauga.setForeground(Color.WHITE);
        adauga.setSize(new Dimension(122, 38));
        adauga.setBounds(380, 14, 122, 38);
        add(adauga);

        clear = new JButton("Clear");
        clear.setBackground(new Color(20, 66, 114));
        clear.setFont(new Font("Monaco", Font.PLAIN, 15));
        clear.setOpaque(true);
        clear.setForeground(Color.WHITE);
        clear.setSize(new Dimension(122, 38));
        clear.setBounds(380, 82, 122, 38);
        add(clear);

        done = new JButton("Done");
        done.setBackground(new Color(20, 66, 114));
        done.setFont(new Font("Monaco", Font.PLAIN, 15));
        done.setOpaque(true);
        done.setForeground(Color.WHITE);
        done.setSize(new Dimension(122, 38));
        done.setBounds(380, 149, 122, 38);
        add(done);

        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNume.getText().equals("") || tfPrenume.getText().equals("") || tfEmail.getText().equals("") || tfParola.getText().equals("") || tfNrLogin.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Completeaza toate campurile!");
                }else{

                    Statement stmt = null;
                    int count;

                    try {
                        stmt = connection.createStatement();
                        String query = "select count(*) from angajati";
                        ResultSet rs = stmt.executeQuery(query);
                        rs.next();
                        count = rs.getInt(1);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    String strNume = tfNume.getText();
                    String strPrenume = tfPrenume.getText();
                    String strEmail = tfEmail.getText();
                    String strParola = tfParola.getText();
                    int varNrID = Integer.parseInt(tfNrLogin.getText());

                    if (verificareEmailValid(strEmail) == false){
                        JOptionPane.showMessageDialog(null, "Email invalid!");
                    }else if (strParola.length() < 10){
                        JOptionPane.showMessageDialog(null, "Parola trebuie sa fie de cel putin 10 caractere!");
                    }else {
                        String sql = "insert into angajati (idAngajati, nume, prenume, email, parola, nrLogin)" + " values(?, ?, ?, ?, ?, ?)";
                        try {
                            PreparedStatement addStmt = connection.prepareStatement(sql);

                            addStmt.setInt(1, count + 1);
                            addStmt.setString(2, strNume);
                            addStmt.setString(3, strPrenume);
                            addStmt.setString(4, strEmail);
                            addStmt.setString(5, strParola);
                            addStmt.setInt(6, varNrID);

                            addStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } finally {
                            JOptionPane.showMessageDialog(null, "ADAUGAT");
                        }
                    }
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNume.setText("");
                tfPrenume.setText("");
                tfEmail.setText("");
                tfParola.setText("");
                tfNrLogin.setText("");
            }
        });

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                GUIAdmin guiadm = new GUIAdmin(connection);
            }
        });
    }

    public boolean verificareEmailValid(String s){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

}
