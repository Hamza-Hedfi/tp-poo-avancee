package com.deuterium.tpfinal.model;

import java.sql.Date;

public class Livre {
    private String isbn;
    private String titre;
    private String maisonEdi;
    private Date datePub;
    private Auteur auteur;

    public Livre() {
    }

    public Livre(String isbn, String titre, String maisonEdi, Date datePub, Auteur auteur) {
        this.isbn = isbn;
        this.titre = titre;
        this.maisonEdi = maisonEdi;
        this.datePub = datePub;
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMaisonEdi() {
        return maisonEdi;
    }

    public void setMaisonEdi(String maisonEdi) {
        this.maisonEdi = maisonEdi;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "\nLivre{" +
                "isbn='" + isbn + '\'' +
                ", titre='" + titre + '\'' +
                ", maisonEdi='" + maisonEdi + '\'' +
                ", datePub=" + datePub +
                ", auteur_orcid=" + auteur.getOrcid() +
                "}";
    }
}
