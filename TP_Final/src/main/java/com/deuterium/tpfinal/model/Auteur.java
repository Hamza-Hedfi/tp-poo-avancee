package com.deuterium.tpfinal.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Auteur {
    private String orcid;
    private String nss;
    private String nom;
    private String prenom;
    private Date dateDec;
    private Date dateNai;
    private List<Livre> livreList;

    public Auteur() {
        livreList = new ArrayList<>();
    }

    public Auteur(String orcid, String nss, String nom, String prenom, Date dateDec, Date dateNai, List<Livre> livreList) {
        this.orcid = orcid;
        this.nss = nss;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDec = dateDec;
        this.dateNai = dateNai;
        this.livreList = livreList;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDec() {
        return dateDec;
    }

    public void setDateDec(Date dateDec) {
        this.dateDec = dateDec;
    }

    public Date getDateNai() {
        return dateNai;
    }

    public void setDateNai(Date dateNai) {
        this.dateNai = dateNai;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "orcid='" + orcid + '\'' +
                ", nss='" + nss + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateDec=" + dateDec +
                ", dateNai=" + dateNai +
                ", Livres=" + livreList +
                '}' + '\n';
    }

    public List<Livre> getLivreList() {
        return livreList;
    }

    public void setLivreList(List<Livre> livreList) {
        this.livreList = livreList;
    }
}
