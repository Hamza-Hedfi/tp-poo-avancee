package com.deuterium.tpfinal;

import com.deuterium.tpfinal.dao.AuteurDAO;
import com.deuterium.tpfinal.dao.LivreDAO;
import com.deuterium.tpfinal.model.Auteur;
import com.deuterium.tpfinal.model.Livre;
import com.deuterium.tpfinal.utils.AuteurNotFoundException;
import com.deuterium.tpfinal.utils.LivreNotFoundException;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, LivreNotFoundException, AuteurNotFoundException {

        AuteurDAO auteurDAO = new AuteurDAO();
        LivreDAO livreDAO = new LivreDAO();

        Auteur a = new Auteur("7898", "12345678", "dhgjhvjk", "gvhbkjn", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), null);
        // auteurDAO.insert(a);
        //
        Livre livre = new Livre("isbn1", "TITRE - 1", "MAISON EDIION", new Date(System.currentTimeMillis()), a);
        // livreDAO.insert(livre);

        System.out.println(auteurDAO.getById("ORCID-3"));
        System.out.println(auteurDAO.getAll());


        // livreDAO.delete(livre);

        // SwingUtilities.invokeLater(() -> {
        //     try {
        //         new MainFrame();
        //     } catch (SQLException throwables) {
        //         throwables.printStackTrace();
        //     } catch (AuteurNotFoundException e) {
        //         e.printStackTrace();
        //     }
        // });

    }
}
