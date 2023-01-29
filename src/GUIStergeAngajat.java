import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import LoginRelated.Angajat;
import Produse.*;

import java.util.ArrayList;
import java.util.List;

public class GUIStergeAngajat extends JFrame {
    private JLabel label;
    private JTextField tfID;
    private JButton sterge, done;
    private JTextArea tArea;
    private JScrollPane scrollArea;
    private List<Angajat> listaAngajati;
    public GUIStergeAngajat(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sterge angajat");
        setSize(new Dimension(450, 550));
        getContentPane().setBackground(new Color(10, 38, 71));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        String toPrint = print(connection, listaAngajati);
        show(toPrint);

        label = new JLabel("ID de sters:");
        label.setBackground(new Color(10, 38, 71));
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Monaco", Font.PLAIN, 15));
        label.setSize(new Dimension(115, 34));
        label.setBounds(55, 12, 115, 34);
        add(label);

        tfID = new JTextField();
        tfID.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfID.setSize(new Dimension(62, 34));
        tfID.setBounds(176, 12, 62, 34);
        add(tfID);

        sterge = new JButton("Sterge");
        sterge.setBackground(new Color(20, 66, 114));
        sterge.setFont(new Font("Monaco", Font.PLAIN, 15));
        sterge.setOpaque(true);
        sterge.setForeground(Color.WHITE);
        sterge.setSize(new Dimension(115, 34));
        sterge.setBounds(55, 57, 115, 34);
        add(sterge);

        done = new JButton("Done");
        done.setBackground(new Color(20, 66, 114));
        done.setFont(new Font("Monaco", Font.PLAIN, 15));
        done.setOpaque(true);
        done.setForeground(Color.WHITE);
        done.setSize(new Dimension(115, 34));
        done.setBounds(176, 57, 115, 34);
        add(done);

        sterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tfID.getText());

                String stmt = "delete from angajati where (idAngajati)=(?)";
                try {
                    PreparedStatement prepStmt = connection.prepareStatement(stmt);
                    prepStmt.setInt(1, id);
                    prepStmt.execute();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    JOptionPane.showMessageDialog(null, "Angajat sters");
                }

                remove(tArea);
                remove(scrollArea);
                String toShow = print(connection, listaAngajati);
                show(toShow);
            }
        });

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                GUIAdmin newAdmin = new GUIAdmin(connection);
            }
        });
    }

    public void show(String s){
        tArea = new JTextArea(s);
        tArea.setFont(new Font("Monaco", Font.PLAIN, 15));
        tArea.setForeground(Color.WHITE);
        tArea.setSize(new Dimension(410, 403));
        tArea.setBounds(14, 113, 410, 403);
        tArea.setBackground(new Color(44, 116, 179));
        tArea.setOpaque(true);

        scrollArea = new JScrollPane(tArea);
        scrollArea.setSize(new Dimension(410, 403));
        scrollArea.setBounds(14, 113, 410, 403);
        scrollArea.setBackground(new Color(44, 116, 179));
        scrollArea.setOpaque(true);
        scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollArea);
    }

    public String print(Connection connection, List<Angajat> listaAngajati){
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

        Produs temp;
        listaAngajati = new ArrayList<>();
        String toPrint = "";

        for (int i = 1; i <= count; i++){
            try{
                String nume = "", prenume = "", email = "", parola = "";
                int nrLogin = 0;
                PreparedStatement prep = connection.prepareStatement("select nume from angajati where (idAngajati)=(?)");
                prep.setInt(1, i);
                ResultSet rs = prep.executeQuery();
                if (rs.next()) {
                    nume = rs.getString("nume");
                }

                prep = connection.prepareStatement("select prenume from angajati where (idAngajati)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    prenume = rs.getString("prenume");
                }

                prep = connection.prepareStatement("select email from angajati where (idAngajati)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    email = rs.getString("email");
                }

                prep = connection.prepareStatement("select parola from angajati where (idAngajati)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    parola = rs.getString("parola");
                }

                prep = connection.prepareStatement("select nrLogin from angajati where (idAngajati)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    nrLogin = rs.getInt("nrLogin");
                }

                listaAngajati.add(new Angajat(i, nume, prenume, email, parola, nrLogin));
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        for (Angajat a : listaAngajati){
            toPrint = toPrint + a.toStringAdmin() + '\n';
        }
        return toPrint;
    }
}
