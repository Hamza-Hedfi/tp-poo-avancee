package DAO;

import Entity.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Hamza Hadfi
 * @since 2020
 */

public class ArticleDAOArrayList implements ArticleDAO {

    private List<Article> articleList;

    {
        articleList = new ArrayList<>();
    }

    @Override
    public void save(Article article) {
        articleList.add(article);
    }

    @Override
    public Optional<Article> getById(UUID id) {
        for (Article article :
                articleList) {
            if (article.getId().equals(id)) {
                return Optional.of(article);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Article article) {
        articleList.set(articleList.indexOf(article), article);
    }

    @Override
    public void delete(Article article) {
        articleList.remove(article);
    }

    @Override
    public List<Article> getAll() {
        return articleList;
    }
}
