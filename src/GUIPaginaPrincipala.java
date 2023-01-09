import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * meniuL = meniu laptopuri
 * meniuTT = meniu tablete, telefoane
 * meniuP = meniu periferice
 * meniuCM = meniu calculatoare monitoare
 * meniuTAV = meniu tv, audio, video
 * meniuG = meniu gaming
 */
public class GUIPaginaPrincipala extends JFrame {

    private JButton paginaPrincipala, login, register, favorite, cosulMeu;
    private JButton meniuL, meniuTT, meniuP, meniuCM, meniuTAV, meniuG;
    private JTextField search;

    public GUIPaginaPrincipala(File clienti, File angajati){
        setTitle("Pagina principala");
        Container c = getContentPane();
        c.setBackground(Color.magenta);
        setSize(new Dimension(980, 800));
        setResizable(false);
        setLayout(null);

        JPanel susStanga = new JPanel(new FlowLayout(FlowLayout.CENTER));
        susStanga.setSize(new Dimension(260, 70));
        susStanga.setBounds(10, 10, 250, 60);
        paginaPrincipala = new JButton("Pagina Principala");
        paginaPrincipala.setFont(new Font("Monaco", Font.BOLD, 20));
        paginaPrincipala.setPreferredSize(new Dimension(250, 50));
        susStanga.add(paginaPrincipala);
        add(susStanga);

        JPanel susMijloc = new JPanel(new FlowLayout(FlowLayout.CENTER));
        susMijloc.setSize(new Dimension(260, 70));
        susMijloc.setBounds(270, 10, 250, 60);
        search = new JTextField("Cauta in stoc");
        search.setFont(new Font("Monaco", Font.BOLD, 20));
        search.setPreferredSize(new Dimension(250, 50));
        susMijloc.add(search);
        add(susMijloc);

        JPanel susDreapta = new JPanel(new FlowLayout(FlowLayout.CENTER));
        susDreapta.setSize(new Dimension(420, 70));
        susDreapta.setBounds(530, 10, 420, 70);
        login = new JButton("LoginRelated.Login");
        login.setFont(new Font("Monaco", Font.BOLD, 15));
        login.setPreferredSize(new Dimension(100, 30));
        register = new JButton("Register");
        register.setFont(new Font("Monaco", Font.BOLD, 15));
        register.setPreferredSize(new Dimension(100, 30));
        favorite = new JButton("Favorite");
        favorite.setFont(new Font("Monaco", Font.BOLD, 15));
        favorite.setPreferredSize(new Dimension(100, 30));
        cosulMeu = new JButton("Cosul meu");
        cosulMeu.setFont(new Font("Monaco", Font.BOLD, 15));
        cosulMeu.setPreferredSize(new Dimension(120, 30));
        susDreapta.add(login);
        susDreapta.add(register);
        susDreapta.add(favorite);
        susDreapta.add(cosulMeu);
        add(susDreapta);

        JPanel mijlocSus = new JPanel();
        mijlocSus.setSize(new Dimension(960, 200));
        mijlocSus.setBounds(10, 100, 960, 200);
        meniuL = new JButton("Laptopuri");
        meniuL.setFont(new Font("Monaco", Font.BOLD, 10));
        meniuL.setPreferredSize(new Dimension(100, 30));
        meniuTT = new JButton("Telefoane/Tablete");
        meniuTT.setFont(new Font("Monaco", Font.BOLD, 10));
        meniuTT.setPreferredSize(new Dimension(150, 30));
        meniuP = new JButton("Periferice");
        meniuP.setFont(new Font("Monaco", Font.BOLD, 10));
        meniuP.setPreferredSize(new Dimension(100, 30));
        meniuCM = new JButton("Calculatoare/Monitoare");
        meniuCM.setFont(new Font("Monaco", Font.BOLD, 10));
        meniuCM.setPreferredSize(new Dimension(180, 30));
        meniuTAV = new JButton("Televizoare/Produse.Audio/Produse.Video");
        meniuTAV.setFont(new Font("Monaco", Font.BOLD, 10));
        meniuTAV.setPreferredSize(new Dimension(180, 30));
        meniuG = new JButton("Produse.Gaming");
        meniuG.setFont(new Font("Monaco", Font.BOLD, 10));
        meniuG.setPreferredSize(new Dimension(100, 30));
        mijlocSus.add(meniuL);
        mijlocSus.add(meniuTT);
        mijlocSus.add(meniuP);
        mijlocSus.add(meniuCM);
        mijlocSus.add(meniuTAV);
        mijlocSus.add(meniuG);
        add(mijlocSus);

        JPanel principal = new JPanel();
        principal.setSize(new Dimension(600, 700));
        principal.setBounds(10, 140, 600, 700);

        JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
        vbar.setBounds(800, 150, 15, 400);
        principal.add(vbar);
        add(principal);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUILogin loginEvent = new GUILogin(clienti, angajati);
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIRegister registerEvent = new GUIRegister(clienti, angajati);
            }
        });

    }
}
