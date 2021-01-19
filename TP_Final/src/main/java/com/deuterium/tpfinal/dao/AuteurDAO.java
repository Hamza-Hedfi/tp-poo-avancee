package com.deuterium.tpfinal.dao;

import com.deuterium.tpfinal.model.Auteur;
import com.deuterium.tpfinal.model.Livre;
import com.deuterium.tpfinal.utils.AuteurNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.deuterium.tpfinal.utils.DatabaseConnection.getInstance;


public class AuteurDAO implements CRUDOperations<Auteur, String> {

    @Override
    public void insert(Auteur newAuteur) throws SQLException {
        try (Connection connection = getInstance().getConnection()) {
            String sqlInsert = "INSERT INTO auteur VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, newAuteur.getOrcid());
            statement.setString(2, newAuteur.getNss());
            statement.setString(3, newAuteur.getNom());
            statement.setString(4, newAuteur.getPrenom());
            statement.setDate(5, newAuteur.getDateDec());
            statement.setDate(6, newAuteur.getDateNai());


            statement.executeUpdate();
        }
    }

    @Override
    public Auteur getById(String orcid) throws SQLException, AuteurNotFoundException {
        Auteur auteur = null;
        try (Connection connection = getInstance().getConnection()) {
            String sqlSelect = "SELECT * FROM auteur WHERE orcid = ?";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            statement.setString(1, orcid);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next())
                    throw new AuteurNotFoundException("Auteur avec l'ORCID(" + orcid + ") n'existe pas!");

                auteur = new Auteur();

                auteur.setOrcid(resultSet.getString("orcid"));
                auteur.setNss(resultSet.getString("nss"));
                auteur.setNom(resultSet.getString("nom"));
                auteur.setPrenom(resultSet.getString("prenom"));
                auteur.setDateDec(resultSet.getDate("dateDec"));
                auteur.setDateNai(resultSet.getDate("dateNai"));

                List<Livre> livreList = new ArrayList<>();
                String sqlSelectLivre = "SELECT * FROM livre WHERE auteur = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectLivre);
                preparedStatement.setString(1, orcid);
                try (ResultSet livreRS = preparedStatement.executeQuery()) {

                    while (livreRS.next()) {
                        String isbn = livreRS.getString("isbn");
                        String titre = livreRS.getString("titre");
                        String maisonEdi = livreRS.getString("maisonEdi");
                        Date datePub = livreRS.getDate("datePub");

                        livreList.add(new Livre(isbn, titre, maisonEdi, datePub, auteur));
                    }
                    auteur.setLivreList(livreList);
                    return auteur;
                }


            }
        }
    }

    @Override
    public List<Auteur> getAll() throws SQLException, AuteurNotFoundException {
        List<Auteur> auteurList = new ArrayList<>();

        try (Connection connection = getInstance().getConnection()) {
            String sqlSelectAllAuteur = "SELECT * FROM auteur";
            PreparedStatement stmtGetAllAuteur = connection.prepareStatement(sqlSelectAllAuteur);
            try (ResultSet allAuteurRS = stmtGetAllAuteur.executeQuery()) {
                Auteur a = new Auteur();
                while (allAuteurRS.next()) {
                    String orcid = allAuteurRS.getString("orcid");
                    String nss = allAuteurRS.getString("nss");
                    String nom = allAuteurRS.getString("nom");
                    String prenom = allAuteurRS.getString("prenom");
                    Date dateDec = allAuteurRS.getDate("dateDec");
                    Date dateNai = allAuteurRS.getDate("dateNai");

                    auteurList.add(new Auteur(orcid, nss, nom, prenom, dateDec, dateNai, null));
                }
            }
        }

        return auteurList;
    }

    @Override
    public void update(Auteur auteurToUpdate) throws SQLException {
        try (Connection connection = getInstance().getConnection()) {
            String sqlUpdate = "UPDATE auteur SET nss = ?, nom = ?, prenom = ?, dateDec = ?, dateNai = ? WHERE orcid = ?";

            PreparedStatement statement = connection.prepareStatement(sqlUpdate);

            statement.setString(1, auteurToUpdate.getNss());
            statement.setString(2, auteurToUpdate.getNom());
            statement.setString(3, auteurToUpdate.getPrenom());
            statement.setDate(4, auteurToUpdate.getDateDec());
            statement.setDate(5, auteurToUpdate.getDateNai());
            statement.setString(6, auteurToUpdate.getOrcid());

            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Auteur auteurToDelete) throws SQLException, AuteurNotFoundException {
        try (Connection connection = getInstance().getConnection()) {

            String oricd = auteurToDelete.getOrcid();

            String sqlInsert = "DELETE FROM auteur WHERE orcid = ?";
            PreparedStatement statement = connection.prepareStatement(sqlInsert);

            statement.setString(1, oricd);

            if (statement.executeUpdate() == 0) {
                throw new AuteurNotFoundException("Auteur avec l'ORCID(" + oricd + ") n'existe pas!");
            }
        }
    }
}
