package Controller;

import Service.ArticleService;
import Service.ArticleServiceImpl;

/**
 * @author Hamza Hadfi
 * @since 2020
 */

public class ArticleController {

    public ArticleService articleService;

    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        articleService = articleServiceImpl;
    }
}
