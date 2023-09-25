package fr.bge.blog_bge.dao.jpa;

import fr.bge.blog_bge.dao.ArticleDao;
import fr.bge.blog_bge.model.Article;

public class ArticleDaoJpa extends AbstractDaoJpa<Article> implements ArticleDao {

	private final static ArticleDao INSTANCE = new ArticleDaoJpa();
	
	public ArticleDaoJpa() {
		
	}
	
	public static ArticleDao getInstance() {
		return INSTANCE;
	}

	@Override
	public Class<Article> getModelClass() {
		return Article.class;
	}

	@Override
	public String getTableName() {
		
		return "Article";
	}
}
