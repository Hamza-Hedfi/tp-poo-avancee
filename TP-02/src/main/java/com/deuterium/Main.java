package com.deuterium;

import com.deuterium.entity.Article;
import com.deuterium.entity.Categorie;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Article article1 = new Article();
        Article article2 = new Article();
        Article article3 = new Article();

        Categorie cat1 = new Categorie();
        cat1.setLabel("Cat-1");
        cat1.setDescription("Categorie 1");

        Categorie cat2 = new Categorie();
        cat2.setLabel("Cat-2");
        cat2.setDescription("Categorie 2");

        article1.setCategories(List.of(cat1, cat2));
        article2.setCategories(List.of(cat2));

        cat1.setArticles(List.of(article1, article2));


//        article.setId(UUID.randomUUID());
        System.out.println(article1);
        System.out.println(article2);
        System.out.println(article3);

        System.out.println("-----------------------------------");

        System.out.println(cat1);

    }
}
