package com.deuterium.tpfinal.dao;

import com.deuterium.tpfinal.model.Auteur;
import com.deuterium.tpfinal.model.Livre;
import com.deuterium.tpfinal.utils.AuteurNotFoundException;
import com.deuterium.tpfinal.utils.LivreNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.deuterium.tpfinal.utils.ConnectionPool.getConnection;

public class LivreDAO implements CRUDOperations<Livre, String> {
    @Override
    public void insert(Livre newLivre) throws SQLException {
        try (Connection connection = getConnection()) {

            String sqlInsert = "INSERT INTO livre VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sqlInsert);

            statement.setString(1, newLivre.getIsbn());
            statement.setString(2, newLivre.getTitre());
            statement.setString(3, newLivre.getMaisonEdi());
            statement.setDate(4, newLivre.getDatePub());
            statement.setString(5, newLivre.getAuteur().getOrcid());

            statement.executeUpdate();
        }
    }

    @Override
    public Livre getById(String isbn) throws SQLException, AuteurNotFoundException, LivreNotFoundException {
        try (Connection connection = getConnection()) {
            String sqlSelect = "SELECT * FROM livre WHERE isbn = ?";

            PreparedStatement statement = connection.prepareStatement(sqlSelect);

            statement.setString(1, isbn);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next())
                    throw new LivreNotFoundException("Livre avec l'ISBN(" + isbn + ") n'existe pas!");
                else {
                    Livre livre = new Livre();

                    livre.setIsbn(resultSet.getString("isbn"));
                    livre.setTitre(resultSet.getString("titre"));
                    livre.setMaisonEdi(resultSet.getString("maisonEdi"));
                    livre.setDatePub(resultSet.getDate("datePub"));
                    livre.setAuteur(new AuteurDAO().getById(resultSet.getString("auteur")));

                    return livre;
                }
            }
        }
    }

    @Override
    public List<Livre> getAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Livre livreToUpdate) throws SQLException {
        try (Connection connection = getConnection()) {
            String sqlUpdate = "UPDATE livre SET titre = ?, maisonEdi = ?, datePub = ?, auteur = ? WHERE isbn = ?";

            PreparedStatement statement = connection.prepareStatement(sqlUpdate);


            statement.setString(1, livreToUpdate.getTitre());
            statement.setString(2, livreToUpdate.getMaisonEdi());
            statement.setDate(3, livreToUpdate.getDatePub());
            statement.setString(4, livreToUpdate.getAuteur().getOrcid());
            statement.setString(5, livreToUpdate.getIsbn());

            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Livre livreToDelete) throws SQLException, LivreNotFoundException {
        try (Connection connection = getConnection()) {

            String isbn = livreToDelete.getIsbn();

            String sqlInsert = "DELETE FROM livre WHERE isbn = ?";
            PreparedStatement statement = connection.prepareStatement(sqlInsert);

            statement.setString(1, isbn);

            if (statement.executeUpdate() == 0) {
                throw new LivreNotFoundException("Livre avec l'ISBN(" + isbn + ") n'existe pas!");
            }
        }
    }

    public List<Livre> getAllForAuteur(String orcid) throws SQLException, AuteurNotFoundException {
        List<Livre> livreList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sqlSelectAllLivre = "SELECT * FROM livre WHERE auteur = ?";
            PreparedStatement stmtGetAllAuteur = connection.prepareStatement(sqlSelectAllLivre);
            stmtGetAllAuteur.setString(1, orcid);
            try (ResultSet allLivreRS = stmtGetAllAuteur.executeQuery()) {
                Auteur a = new Auteur();
                while (allLivreRS.next()) {
                    String isbn = allLivreRS.getString("isbn");
                    String titre = allLivreRS.getString("titre");
                    String maisonEdi = allLivreRS.getString("maisonEdi");
                    String auteur = allLivreRS.getString("auteur");
                    Date datePub = allLivreRS.getDate("datePub");

                    livreList.add(new Livre(isbn, titre, maisonEdi, datePub, new AuteurDAO().getById(auteur)));
                }
            }
        }

        return livreList;
    }
}
