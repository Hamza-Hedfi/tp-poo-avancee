package com.deuterium.tpfinal.View;

import com.deuterium.tpfinal.dao.AuteurDAO;
import com.deuterium.tpfinal.dao.LivreDAO;
import com.deuterium.tpfinal.model.Auteur;
import com.deuterium.tpfinal.model.Livre;
import com.deuterium.tpfinal.utils.AuteurNotFoundException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MainFrame extends JFrame {

    JTable jTableAuteur;
    JTable jTableLivre;
    AuteurDAO auteurDAO = new AuteurDAO();
    LivreDAO livreDAO = new LivreDAO();
    DefaultTableModel modelAuteur;
    DefaultTableModel modelLivre;

    public MainFrame() throws SQLException, AuteurNotFoundException {
        jTableAuteur = new JTable() {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }

            ;
        };

        jTableLivre = new JTable() {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }

            ;
        };


        setLayout(new BorderLayout());

        nathemLoumourAuteur();

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());

        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(), BorderFactory.createTitledBorder("Auteurs")));
        p2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(), BorderFactory.createTitledBorder("Ses lives")));

        JScrollPane comp = new JScrollPane(jTableAuteur);
        JScrollPane comp2 = new JScrollPane(jTableLivre);
        p1.add(comp, BorderLayout.NORTH);
        p2.add(comp2, BorderLayout.CENTER);

        MenuBar mb = new MenuBar();
        Menu auteurMenu = new Menu("Auteur");

        MenuItem supprimerAuteur = new MenuItem("Supprimer");
        MenuItem ajouterAuteur = new MenuItem("Ajouter");

        supprimerAuteur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableAuteur.getSelectedRow();
                String ocid = (String) jTableAuteur.getValueAt(selectedRow, 0);
                try {
                    auteurDAO.delete(auteurDAO.getById(ocid));

                    nathemLoumourAuteur();
                } catch (SQLException | AuteurNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
        ajouterAuteur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AjouterAuteur ajouterAuteur1 = new AjouterAuteur();
                ajouterAuteur1.setVisible(true);
            }
        });

        jTableAuteur.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = jTableAuteur.getSelectedRow();
                String orcid = (String) jTableAuteur.getValueAt(selectedRow, 0);
                try {
                    nathemLoumourLivre(orcid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (AuteurNotFoundException auteurNotFoundException) {
                    auteurNotFoundException.printStackTrace();
                }
            }
        });

        auteurMenu.add(supprimerAuteur);
        auteurMenu.add(ajouterAuteur);
        mb.add(auteurMenu);
        setMenuBar(mb);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void nathemLoumourAuteur() throws SQLException, AuteurNotFoundException {
        modelAuteur = null;
        modelAuteur = new DefaultTableModel();
        String[] tableHeader = {"ORCID", "NSS", "NOM", "PRENOM", "Date naissance", "Date decé"};
        List<Auteur> auteurs = auteurDAO.getAll();

        for (String col :
                tableHeader) {
            modelAuteur.addColumn(col);
        }

        Object rowData[] = new Object[6];

        for (int i = 0; i < auteurs.size(); i++) {
            rowData[0] = auteurs.get(i).getOrcid();
            rowData[1] = auteurs.get(i).getNss();
            rowData[2] = auteurs.get(i).getNom();
            rowData[3] = auteurs.get(i).getPrenom();
            rowData[4] = auteurs.get(i).getDateNai();
            rowData[5] = auteurs.get(i).getDateDec();
            modelAuteur.addRow(rowData);
        }


        jTableAuteur.setModel(modelAuteur);
    }

    private void nathemLoumourLivre(String orcid) throws SQLException, AuteurNotFoundException {
        modelLivre = null;
        modelLivre = new DefaultTableModel();
        String[] tableHeader = {"ISBN", "TITRE", "MAISON EDITION", "DATE PUB"};
        List<Livre> livres = livreDAO.getAllForAuteur(orcid);

        for (String col :
                tableHeader) {
            modelLivre.addColumn(col);
        }

        Object rowData[] = new Object[6];

        for (int i = 0; i < livres.size(); i++) {
            rowData[0] = livres.get(i).getIsbn();
            rowData[1] = livres.get(i).getTitre();
            rowData[2] = livres.get(i).getMaisonEdi();
            rowData[3] = livres.get(i).getDatePub();

            modelLivre.addRow(rowData);
        }


        jTableLivre.setModel(modelLivre);
    }
}
