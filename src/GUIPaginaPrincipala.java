import Produse.Produs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIPaginaPrincipala extends JFrame {

    private JButton login, register, favorite, cosulMeu;
    private JButton meniuL, meniuTT, meniuP, meniuCM, meniuTAV, meniuG;
    private JMenuBar meniu;
    private JScrollPane mainContent;
    private JPanel produse;
    private JLabel paginaPrincipala;
    private List<Pereche> butoane;
    private List<JPanel> panels;

    public GUIPaginaPrincipala(Connection connection){
        setTitle("Pagina principala");
        setSize(new Dimension(980, 800));
        getContentPane().setBackground(new Color(10, 38, 71));
        setResizable(false);
        setLayout(null);

        JPanel susStanga = new JPanel(new FlowLayout(FlowLayout.CENTER));
        susStanga.setSize(new Dimension(260, 70));
        susStanga.setBounds(350, 10, 250, 60);
        susStanga.setBackground(new Color(10, 38, 71));
        susStanga.setOpaque(true);
        paginaPrincipala = new JLabel("MAGAZIN ELECTRONICE");
        paginaPrincipala.setForeground(Color.WHITE);
        paginaPrincipala.setFont(new Font("Monaco", Font.BOLD, 20));
        paginaPrincipala.setPreferredSize(new Dimension(250, 50));
        paginaPrincipala.setBackground(new Color(10, 38, 71));
        paginaPrincipala.setOpaque(true);
        susStanga.add(paginaPrincipala);
        add(susStanga);

        JPanel susDreapta = new JPanel(new FlowLayout(FlowLayout.CENTER));
        susDreapta.setSize(new Dimension(420, 70));
        susDreapta.setBounds(530, 10, 420, 70);
        susDreapta.setBackground(new Color(10, 38, 71));
        susDreapta.setOpaque(true);
        login = new JButton("Login");
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Monaco", Font.BOLD, 15));
        login.setPreferredSize(new Dimension(100, 30));
        login.setBackground(new Color(20, 66, 114));
        login.setOpaque(true);

        register = new JButton("Register");
        register.setForeground(Color.WHITE);
        register.setFont(new Font("Monaco", Font.BOLD, 15));
        register.setPreferredSize(new Dimension(100, 30));
        register.setBackground(new Color(20, 66, 114));
        register.setOpaque(true);

        susDreapta.add(login);
        susDreapta.add(register);
        add(susDreapta);

        JPanel mijlocSus = new JPanel();
        mijlocSus.setSize(new Dimension(960, 50));
        mijlocSus.setBounds(10, 100, 960, 50);
        mijlocSus.setBackground(new Color(10, 38, 71));
        mijlocSus.setOpaque(true);

        meniuL = new JButton("Laptopuri");
        meniuL.setForeground(Color.WHITE);
        meniuL.setFont(new Font("Monaco", Font.BOLD, 12));
        meniuL.setPreferredSize(new Dimension(110, 40));
        meniuL.setBackground(new Color(20, 66, 114));
        meniuL.setOpaque(true);

        meniuTT = new JButton("Telefoane/Tablete");
        meniuTT.setForeground(Color.WHITE);
        meniuTT.setFont(new Font("Monaco", Font.BOLD, 12));
        meniuTT.setPreferredSize(new Dimension(160, 40));
        meniuTT.setBackground(new Color(20, 66, 114));
        meniuTT.setOpaque(true);

        meniuP = new JButton("Periferice");
        meniuP.setForeground(Color.WHITE);
        meniuP.setFont(new Font("Monaco", Font.BOLD, 12));
        meniuP.setPreferredSize(new Dimension(110, 40));
        meniuP.setBackground(new Color(20, 66, 114));
        meniuP.setOpaque(true);

        meniuCM = new JButton("Calculatoare/Monitoare");
        meniuCM.setForeground(Color.WHITE);
        meniuCM.setFont(new Font("Monaco", Font.BOLD, 12));
        meniuCM.setPreferredSize(new Dimension(190, 40));
        meniuCM.setBackground(new Color(20, 66, 114));
        meniuCM.setOpaque(true);

        meniuTAV = new JButton("Televizoare/Audio/Video");
        meniuTAV.setForeground(Color.WHITE);
        meniuTAV.setFont(new Font("Monaco", Font.BOLD, 12));
        meniuTAV.setPreferredSize(new Dimension(190, 40));
        meniuTAV.setBackground(new Color(20, 66, 114));
        meniuTAV.setOpaque(true);

        meniuG = new JButton("Gaming");
        meniuG.setForeground(Color.WHITE);
        meniuG.setFont(new Font("Monaco", Font.BOLD, 12));
        meniuG.setPreferredSize(new Dimension(110, 40));
        meniuG.setBackground(new Color(20, 66, 114));
        meniuG.setOpaque(true);

        mijlocSus.add(meniuL);
        mijlocSus.add(meniuTT);
        mijlocSus.add(meniuP);
        mijlocSus.add(meniuCM);
        mijlocSus.add(meniuTAV);
        mijlocSus.add(meniuG);
        add(mijlocSus);

        int count = getNrIntrari(connection);

        produse = new JPanel();
        produse.setLayout(new GridLayout(count / 2, 2));
        produse.setSize(new Dimension(960, 560));
        produse.setBounds(10, 150, 960, 560);
        produse.setBackground(new Color(44, 116, 179));
        produse.setOpaque(true);

        mainContent = new JScrollPane(produse);
        mainContent.setSize(new Dimension(960, 560));
        mainContent.setBounds(10, 150, 960, 560);
        mainContent.setBackground(new Color(44, 116, 179));
        mainContent.setOpaque(true);
        mainContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(mainContent);

        addToPanel(connection);

        meniu = new JMenuBar();
        meniu.setBackground(new Color(10, 38, 71));
        meniu.setOpaque(true);
        JMenu file = new JMenu("Extra");
        file.setForeground(Color.WHITE);
        meniu.add(file);
        setJMenuBar(meniu);
        JMenuItem info = new JMenuItem(new AbstractAction("Admin") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                GUILoginAdmin admin = new GUILoginAdmin(connection);
            }
        });

        JMenuItem logAngajat = new JMenuItem(new AbstractAction("Login Angajat") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                GUILoginAngajat log = new GUILoginAngajat(connection);
            }
        });


        file.add(info);
        file.add(logAngajat);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                GUILogin loginEvent = new GUILogin(connection);
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIRegister registerEvent = new GUIRegister(connection);
            }
        });

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public int getNrIntrari(Connection connection){
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
        return count;
    }

    public void addToPanel(Connection connection){
        butoane = new ArrayList<>();
        JButton aux;
        Produs temp;

        int count = getNrIntrari(connection);

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

                ImageIcon imgButton = new ImageIcon(imagine);
                Image imagineButton = imgButton.getImage();
                Image imagineButtonFinal = imagineButton.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                imgButton = new ImageIcon(imagineButtonFinal);

                temp = new Produs(i, categorie, nrComenzi, marca, pret, culoare, imagine);
                aux = new JButton(imgButton);
                aux.setSize(new Dimension(300, 300));

                butoane.add(new Pereche(aux, temp));
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        for (Pereche p : butoane){
            produse.add(p.getButonImagine());
            p.getButonImagine().setToolTipText(p.getInformatiiButon().toString());
        }
    }
}
