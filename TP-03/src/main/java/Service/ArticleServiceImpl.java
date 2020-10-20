package Service;

import DAO.ArticleDAO;
import DAO.ArticleDAOArrayList;
import Entity.Article;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Hamza Hadfi
 * @since 2020
 */

public class ArticleServiceImpl implements ArticleService {

    private ArticleDAO articleDAO;

    public ArticleServiceImpl(ArticleDAOArrayList articleDAOArrayList) {
        this.articleDAO = articleDAOArrayList;
    }

    @Override
    public void save(Article article) {
        articleDAO.save(article);
    }

    @Override
    public Optional<Article> getById(UUID id) {
        return articleDAO.getById(id);
    }

    @Override
    public void update(Article article) {
        articleDAO.update(article);
    }

    @Override
    public void delete(Article article) {
        articleDAO.delete(article);
    }

    @Override
    public List<Article> getAll() {
        return articleDAO.getAll();
    }
}
