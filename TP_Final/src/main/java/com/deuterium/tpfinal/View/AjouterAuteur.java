package com.deuterium.tpfinal.View;

import com.deuterium.tpfinal.dao.AuteurDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterAuteur extends JFrame {

    JTextField orcidTF, nssTF, nomTF, prenomTF, dateDecTF, dateNaiTF;
    AuteurDAO auteurDAO = new AuteurDAO();

    public AjouterAuteur() {
        orcidTF = new JTextField("ORCID");
        nssTF = new JTextField("NSS");
        nomTF = new JTextField("NOM");
        prenomTF = new JTextField("PRENOM");
        dateDecTF = new JTextField("DateDEC");
        dateNaiTF = new JTextField("DateNAI");

        JPanel p = new JPanel(new GridLayout(6, 1));

        p.add(orcidTF);
        p.add(nssTF);
        p.add(nomTF);
        p.add(prenomTF);
        p.add(dateDecTF);
        p.add(dateNaiTF);

        setLayout(new BorderLayout());

        add(p, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        JButton save = new JButton("Ajouter");

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        p2.add(save);
        add(p2, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);
    }
}
