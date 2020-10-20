import Controller.ArticleController;
import DAO.ArticleDAOArrayList;
import Entity.Article;
import Service.ArticleServiceImpl;
import org.apache.commons.lang3.SerializationUtils;

import java.util.UUID;

/**
 * @author Hamza Hadfi
 * @since 2020
 */

public class MAIN {
    public static void main(String[] args) {
        ArticleController articleController = new ArticleController(
                new ArticleServiceImpl(
                        new ArticleDAOArrayList()
                ));

        Article article1 = new Article("PC", "DELL 15-7577");
        Article article2 = new Article("Montre", "Description Montre bla bla ");
        Article article3 = new Article("Article 3", "Description Article 3 bla bla ");

        articleController.articleService.save(article1);
        articleController.articleService.save(article2);
        articleController.articleService.save(article3);

        System.out.println("------------- GET ALL Articles -------------");
        System.out.println(articleController.articleService.getAll());

        System.out.println(System.lineSeparator());
        System.out.println("------------- GET By ID -------------");
        System.out.println(articleController.articleService.getById(article1.getId()));

        System.out.println(System.lineSeparator());
        System.out.println("------------- GET By ID (None existing Article)-------------");
        System.out.println(articleController.articleService.getById(UUID.randomUUID()));

        System.out.println(System.lineSeparator());
        System.out.println("------------- Update Article(name) PC to Ordinateur Portable-------------");
        Article updatedArticle = SerializationUtils.clone(article1);
        System.out.println(updatedArticle);
        updatedArticle.setDesignation("Ordinateur Portable");
        articleController.articleService.update(updatedArticle);
        System.out.println("------------- GET ALL Articles -------------");
        System.out.println(articleController.articleService.getAll());

        System.out.println("------------- Delete Article (article 3)-------------");
        articleController.articleService.delete(article3);
        System.out.println("------------- GET ALL Articles -------------");
        System.out.println(articleController.articleService.getAll());
    }
}
