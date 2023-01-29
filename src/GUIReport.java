import Produse.Produs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUIReport extends JFrame {
    private JLabel lab;
    private JComboBox optiuni;
    private JButton raporteaza;
    public GUIReport (Connection connection, Produs p){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Raport modificare produse");
        setSize(new Dimension(500, 188));
        getContentPane().setBackground(new Color(10, 38, 71));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        lab = new JLabel("Selecteaza modificarea ce trebuie facuta: ");
        lab.setSize(new Dimension(274, 42));
        lab.setBounds(19, 24, 274, 42);
        lab.setFont(new Font("Monaco", Font.BOLD, 12));
        lab.setBackground(new Color(10, 38, 71));
        lab.setForeground(Color.WHITE);
        add(lab);

        String[] opt = {"------------","Categorie", "Marca", "Culoare", "Pret"};
        optiuni = new JComboBox<>(opt);
        optiuni.setFont(new Font("Monaco", Font.PLAIN, 13));
        optiuni.setSize(new Dimension(100, 42));
        optiuni.setBounds(322, 27, 100, 42);
        add(optiuni);

        raporteaza = new JButton("Raporteaza");
        raporteaza.setSize(new Dimension(215, 46));
        raporteaza.setBounds(81, 81, 215, 46);
        raporteaza.setFont(new Font("Monaco", Font.BOLD, 15));
        raporteaza.setBackground(new Color(44, 116, 179));
        raporteaza.setForeground(Color.WHITE);
        add(raporteaza);

        raporteaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optiuni.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Selecteaza o optiune valida");
                }else {
                    String deSchimbat = opt[optiuni.getSelectedIndex()];
                    Statement stmt = null;
                    int count;

                    try {
                        stmt = connection.createStatement();
                        String query = "select count(*) from raporturi";
                        ResultSet rs = stmt.executeQuery(query);
                        rs.next();
                        count = rs.getInt(1);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    String sql = "insert into raporturi (id, idProdus, DeModificat)" + " values(?, ?, ?)";
                    try {
                        PreparedStatement addStmt = connection.prepareStatement(sql);

                        addStmt.setInt(1, count + 1);
                        addStmt.setInt(2, p.getId());
                        addStmt.setString(3, deSchimbat);

                        addStmt.execute();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        JOptionPane.showMessageDialog(null, "Raportarea a fost inregistrata cu succes!");
                        dispose();
                        setVisible(false);
                    }
                }
            }
        });
    }
}
