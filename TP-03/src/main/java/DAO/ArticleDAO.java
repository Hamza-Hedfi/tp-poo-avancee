package DAO;

import Entity.Article;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Hamza Hadfi
 * @since 2020
 */

public interface ArticleDAO {
    void save(Article article);

    Optional<Article> getById(UUID id);

    void update(Article article);

    void delete(Article article);

    List<Article> getAll();
}
