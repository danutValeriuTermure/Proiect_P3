import Produse.Produs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GUISearchAngajat extends JFrame{
    private List<Produs> listaProduse;
    private JTextField tf1;
    private JButton cauta, clear;
    private JTextArea textArea;
    private JScrollPane scrollArea;
    public GUISearchAngajat(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cauta produs");
        setSize(new Dimension(553, 263));
        getContentPane().setBackground(new Color(10, 38, 71));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        tf1 = new JTextField();
        tf1.setSize(new Dimension(252, 41));
        tf1.setBounds(20, 14, 252, 41);
        tf1.setFont(new Font("Monaco", Font.PLAIN,15));
        add(tf1);

        cauta = new JButton("Cauta");
        cauta.setSize(new Dimension(109, 41));
        cauta.setBounds(292, 14, 109, 41);
        cauta.setFont(new Font("Monaco", Font.PLAIN, 15));
        cauta.setForeground(Color.WHITE);
        cauta.setBackground(new Color(20, 66, 114));
        add(cauta);

        clear = new JButton("Clear");
        clear.setSize(new Dimension(109, 41));
        clear.setBounds(414, 14, 109, 41);
        clear.setFont(new Font("Monaco", Font.PLAIN, 15));
        clear.setForeground(Color.WHITE);
        clear.setBackground(new Color(20, 66, 114));
        add(clear);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monaco", Font.PLAIN, 15));
        textArea.setForeground(Color.WHITE);
        textArea.setSize(new Dimension(505, 148));
        textArea.setBounds(20, 70, 505, 148);
        textArea.setBackground(new Color(44, 116, 179));
        textArea.setOpaque(true);
        add(textArea);

        cauta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (print(connection, listaProduse, tf1.getText()).equals("NO")){
                    JOptionPane.showMessageDialog(null, "Nu a fost gasit produsul.");
                }
                else{
                    textArea.setText(print(connection, listaProduse, tf1.getText()));
                    scrollArea = new JScrollPane(textArea);
                    scrollArea.setSize(new Dimension(505, 148));
                    scrollArea.setBounds(20, 70, 505, 148);
                    scrollArea.setBackground(new Color(44, 116, 179));
                    scrollArea.setOpaque(true);
                    scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    add(scrollArea);
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                textArea.setText("");
            }
        });
    }

    public String print(Connection connection, List<Produs> listaProduse, String s){
        Statement stmt = null;
        int count;

        try {
            stmt = connection.createStatement();
            String query = "select count(*) from produse";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        Produs temp;
        listaProduse = new ArrayList<>();
        String toPrint = "";

        for (int i = 1; i <= count; i++){
            try{
                String categorie = "", marca = "", culoare = "", imagine = "";
                double pret = 0;
                int nrComenzi = 0;
                boolean discount = false;
                PreparedStatement prep = connection.prepareStatement("select categorie from produse where (idProduse)=(?)");
                prep.setInt(1, i);
                ResultSet rs = prep.executeQuery();
                if (rs.next()) {
                    categorie = rs.getString("categorie");
                }

                prep = connection.prepareStatement("select marca from produse where (idProduse)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    marca = rs.getString("marca");
                }

                prep = connection.prepareStatement("select culoare from produse where (idProduse)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    culoare = rs.getString("culoare");
                }

                prep = connection.prepareStatement("select imagine from produse where (idProduse)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    imagine = rs.getString("imagine");
                }

                prep = connection.prepareStatement("select pret from produse where (idProduse)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    pret = rs.getDouble("pret");
                }

                prep = connection.prepareStatement("select nrComenzi from produse where (idProduse)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    nrComenzi = rs.getInt("nrComenzi");
                }

                prep = connection.prepareStatement("select discount from produse where (idProduse)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    discount = rs.getBoolean("discount");
                }

                listaProduse.add(new Produs(i, categorie, nrComenzi, marca, pret, culoare, imagine));
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        String cs = s.toLowerCase(Locale.ROOT);
        boolean ok = false;
        for (Produs p : listaProduse){
            String p1 = p.getMarca().toLowerCase();
            String p2 = p.getCategorie().toLowerCase();
            if (p1.equals(cs) || p2.equals(cs)) {
                ok = true;
                toPrint = toPrint + p.toStringAdmin() + '\n';
            }
        }
        if (ok == true)
            return toPrint;
        else
            return "NO";
    }
}
