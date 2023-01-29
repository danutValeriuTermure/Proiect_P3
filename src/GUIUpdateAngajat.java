import LoginRelated.*;
import Produse.Produs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIUpdateAngajat extends JFrame {
    private JLabel labelID, labelCol, labelNou;
    private JComboBox coloane;
    private JTextField tfID, tfNou;
    private JButton update, done;
    private JTextArea tArea;
    private JScrollPane scrollArea;
    private List<Angajat> listaAngajati;
    public GUIUpdateAngajat(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update angajat");
        setSize(new Dimension(581, 549));
        getContentPane().setBackground(new Color(10, 38, 71));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        String toPrint = print(connection, listaAngajati);
        show(toPrint);

        labelID = new JLabel("ID angajat de modificat: ");
        labelID.setBackground(new Color(10, 38, 71));
        labelID.setOpaque(true);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Monaco", Font.PLAIN, 15));
        labelID.setSize(new Dimension(184, 29));
        labelID.setBounds(14, 14, 184, 29);
        add(labelID);

        labelCol = new JLabel("Coloana angajat de modificat: ");
        labelCol.setBackground(new Color(10, 38, 71));
        labelCol.setOpaque(true);
        labelCol.setForeground(Color.WHITE);
        labelCol.setFont(new Font("Monaco", Font.PLAIN, 12));
        labelCol.setSize(new Dimension(200, 29));
        labelCol.setBounds(14, 52, 200, 29);
        add(labelCol);

        labelNou = new JLabel("Nou: ");
        labelNou.setBackground(new Color(10, 38, 71));
        labelNou.setOpaque(true);
        labelNou.setForeground(Color.WHITE);
        labelNou.setFont(new Font("Monaco", Font.PLAIN, 15));
        labelNou.setSize(new Dimension(184, 29));
        labelNou.setBounds(14, 92, 184, 29);
        add(labelNou);

        tfID = new JTextField();
        tfID.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfID.setSize(new Dimension(52, 29));
        tfID.setBounds(207, 12, 52, 29);
        add(tfID);

        String[] strColoane = {"-------", "Nume", "Prenume", "Email", "Parola", "NrLogin"};

        coloane = new JComboBox<>(strColoane);
        coloane.setFont(new Font("Monaco", Font.PLAIN, 13));
        coloane.setSize(new Dimension(100, 29));
        coloane.setBounds(207, 52, 100, 29);
        add(coloane);

        tfNou = new JTextField();
        tfNou.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfNou.setSize(new Dimension(131, 29));
        tfNou.setBounds(207, 92, 131, 29);
        add(tfNou);

        update = new JButton("Update");
        update.setBackground(new Color(20, 66, 114));
        update.setFont(new Font("Monaco", Font.PLAIN, 15));
        update.setOpaque(true);
        update.setForeground(Color.WHITE);
        update.setSize(new Dimension(110, 54));
        update.setBounds(338, 16, 110, 54);
        add(update);

        done = new JButton("Done");
        done.setBackground(new Color(20, 66, 114));
        done.setFont(new Font("Monaco", Font.PLAIN, 15));
        done.setOpaque(true);
        done.setForeground(Color.WHITE);
        done.setSize(new Dimension(110, 54));
        done.setBounds(453, 16, 110, 54);
        add(done);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Statement stmtC = null;
                int count;

                try {
                    stmtC = connection.createStatement();
                    String query = "select count(*) from angajati";
                    ResultSet rs = stmtC.executeQuery(query);
                    rs.next();
                    count = rs.getInt(1);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                int id = Integer.parseInt(tfID.getText());
                if (id < 1 || id > count) {
                    JOptionPane.showMessageDialog(null, "ID invalid");
                } else {
                    int deModificat = coloane.getSelectedIndex();
                    String inlocuitor = tfNou.getText();
                    if (deModificat == 0 || inlocuitor.equals("")) {
                        JOptionPane.showMessageDialog(null, "Completeaza campurile");
                    } else {
                        String stmt;
                        switch (deModificat) {
                            case 1:
                                stmt = "update angajati set nume=? where idAngajati=?";
                                try {
                                    PreparedStatement prepStmt = connection.prepareStatement(stmt);
                                    prepStmt.setString(1, inlocuitor);
                                    prepStmt.setInt(2, id);
                                    prepStmt.execute();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } finally {
                                    JOptionPane.showMessageDialog(null, "Angajat modificat");
                                }
                                break;
                            case 2:
                                stmt = "update angajati set prenume=? where idAngajati=?";
                                try {
                                    PreparedStatement prepStmt = connection.prepareStatement(stmt);
                                    prepStmt.setString(1, inlocuitor);
                                    prepStmt.setInt(2, id);
                                    prepStmt.execute();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } finally {
                                    JOptionPane.showMessageDialog(null, "Angajat modificat");
                                }
                                break;
                            case 3:
                                stmt = "update angajati set email=? where idAngajati=?";
                                try {
                                    PreparedStatement prepStmt = connection.prepareStatement(stmt);
                                    prepStmt.setString(1, inlocuitor);
                                    prepStmt.setInt(2, id);
                                    prepStmt.execute();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } finally {
                                    JOptionPane.showMessageDialog(null, "Angajat modificat");
                                }
                                break;
                            case 4:
                                stmt = "update angajati set parola=? where idAngajati=?";
                                try {
                                    PreparedStatement prepStmt = connection.prepareStatement(stmt);
                                    prepStmt.setString(1, inlocuitor);
                                    prepStmt.setInt(2, id);
                                    prepStmt.execute();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } finally {
                                    JOptionPane.showMessageDialog(null, "Angajat modificat");
                                }
                                break;
                            case 5:
                                stmt = "update angajati set nrLogin=? where idAngajati=?";
                                int aux = Integer.parseInt(inlocuitor);
                                try {
                                    PreparedStatement prepStmt = connection.prepareStatement(stmt);
                                    prepStmt.setInt(1, aux);
                                    prepStmt.setInt(2, id);
                                    prepStmt.execute();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } finally {
                                    JOptionPane.showMessageDialog(null, "Angajat modificat");
                                }
                                break;
                        }
                        remove(tArea);
                        remove(scrollArea);
                        String toShow = print(connection, listaAngajati);
                        show(toShow);
                    }
                }
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
        tArea.setSize(new Dimension(550, 370));
        tArea.setBounds(15, 133, 550, 370);
        tArea.setBackground(new Color(44, 116, 179));
        tArea.setOpaque(true);

        scrollArea = new JScrollPane(tArea);
        scrollArea.setSize(new Dimension(550, 370));
        scrollArea.setBounds(15, 133, 550, 370);
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
