import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUIAdaugaProdus extends JFrame {
    private JLabel categorie, marca, pret, culoare, imagine;
    private JTextField tfCategorie, tfMarca, tfPret, tfImagine;
    private JButton adauga, clear, done;
    private JComboBox culori;

    public GUIAdaugaProdus(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adauga produs");
        setSize(new Dimension(650, 320));
        getContentPane().setBackground(new Color(10, 38, 71));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        categorie = new JLabel("Categorie:");
        categorie.setBackground(new Color(10, 38, 71));
        categorie.setOpaque(true);
        categorie.setForeground(Color.WHITE);
        categorie.setFont(new Font("Monaco", Font.PLAIN, 15));
        categorie.setSize(new Dimension(122, 38));
        categorie.setBounds(23, 26, 122, 38);
        add(categorie);

        marca = new JLabel("Marca:");
        marca.setBackground(new Color(10, 38, 71));
        marca.setOpaque(true);
        marca.setForeground(Color.WHITE);
        marca.setFont(new Font("Monaco", Font.PLAIN, 15));
        marca.setSize(new Dimension(122, 38));
        marca.setBounds(23, 74, 122, 38);
        add(marca);

        pret = new JLabel("Pret:");
        pret.setBackground(new Color(10, 38, 71));
        pret.setOpaque(true);
        pret.setForeground(Color.WHITE);
        pret.setFont(new Font("Monaco", Font.PLAIN, 15));
        pret.setSize(new Dimension(122, 38));
        pret.setBounds(23, 122, 122, 38);
        add(pret);

        culoare = new JLabel("Culoare:");
        culoare.setBackground(new Color(10, 38, 71));
        culoare.setOpaque(true);
        culoare.setForeground(Color.WHITE);
        culoare.setFont(new Font("Monaco", Font.PLAIN, 15));
        culoare.setSize(new Dimension(122, 38));
        culoare.setBounds(23, 169, 122, 38);
        add(culoare);

        imagine = new JLabel("Imagine:");
        imagine.setBackground(new Color(10, 38, 71));
        imagine.setOpaque(true);
        imagine.setForeground(Color.WHITE);
        imagine.setFont(new Font("Monaco", Font.PLAIN, 15));
        imagine.setSize(new Dimension(122, 38));
        imagine.setBounds(23, 220, 122, 38);
        add(imagine);

        tfCategorie = new JTextField();
        tfCategorie.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfCategorie.setSize(new Dimension(202, 38));
        tfCategorie.setBounds(169, 26, 202, 38);
        add(tfCategorie);

        tfMarca = new JTextField();
        tfMarca.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfMarca.setSize(new Dimension(202, 38));
        tfMarca.setBounds(169, 74, 202, 38);
        add(tfMarca);

        tfPret = new JTextField();
        tfPret.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfPret.setSize(new Dimension(202, 38));
        tfPret.setBounds(169, 122, 202, 38);
        add(tfPret);

        String[] col = {"--------","Negru", "Alb", "Gri", "Verde", "Rosu", "Albastru"};
        culori = new JComboBox(col);
        culori.setFont(new Font("Monaco", Font.PLAIN, 13));
        culori.setSize(new Dimension(115, 38));
        culori.setBounds(169, 169, 115, 38);
        add(culori);

        tfImagine = new JTextField();
        tfImagine.setFont(new Font("Monaco", Font.PLAIN, 13));
        tfImagine.setSize(new Dimension(202, 38));
        tfImagine.setBounds(169, 220, 202, 38);
        add(tfImagine);

        adauga = new JButton("Adauga");
        adauga.setBackground(new Color(20, 66, 114));
        adauga.setFont(new Font("Monaco", Font.PLAIN, 15));
        adauga.setOpaque(true);
        adauga.setForeground(Color.WHITE);
        adauga.setSize(new Dimension(122, 38));
        adauga.setBounds(491, 26, 122, 38);
        add(adauga);

        clear = new JButton("Clear");
        clear.setBackground(new Color(20, 66, 114));
        clear.setFont(new Font("Monaco", Font.PLAIN, 15));
        clear.setOpaque(true);
        clear.setForeground(Color.WHITE);
        clear.setSize(new Dimension(122, 38));
        clear.setBounds(491, 74, 122, 38);
        add(clear);

        done = new JButton("Done");
        done.setBackground(new Color(20, 66, 114));
        done.setFont(new Font("Monaco", Font.PLAIN, 15));
        done.setOpaque(true);
        done.setForeground(Color.WHITE);
        done.setSize(new Dimension(122, 38));
        done.setBounds(491, 122, 122, 38);
        add(done);

        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfCategorie.getText().equals("") || tfMarca.getText().equals("") || tfPret.getText().equals("") || tfImagine.getText().equals("") || culori.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null,"Completeaza toate campurile sau selecteaza optiuni valide!");
                }else{

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

                    String strCategorie = tfCategorie.getText();
                    String strMarca = tfMarca.getText();
                    double varPret = Double.parseDouble(tfPret.getText());
                    String strCuloare = col[culori.getSelectedIndex()];
                    String strImagine = tfImagine.getText();

                    String sql = "insert into produse (idProduse, categorie, marca, culoare, pret, imagine)" + " values(?, ?, ?, ?, ?, ?)";
                    try{
                        PreparedStatement addStmt = connection.prepareStatement(sql);

                        addStmt.setInt(1, count + 1);
                        addStmt.setString(2, strCategorie);
                        addStmt.setString(3, strMarca);
                        addStmt.setString(4, strCuloare);
                        addStmt.setDouble(5, varPret);
                        addStmt.setString(6, strImagine);

                        addStmt.execute();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }finally {
                        JOptionPane.showMessageDialog(null, "ADAUGAT");
                    }
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCategorie.setText("");
                tfMarca.setText("");
                tfPret.setText("");
                tfImagine.setText("");
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
}
