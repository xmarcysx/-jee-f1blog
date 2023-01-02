package jsf_f1blog_dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jsf_f1blog_entities.Blog;

@Stateless
public class BlogDAO {

	@PersistenceContext
	EntityManager em;
	
	public void create(Blog blog) {
		em.persist(blog);
	}

	public Blog merge(Blog blog) {
		return em.merge(blog);
	}

	public void remove(Blog blog) {
		em.remove(em.merge(blog));
	}

	public Blog find(Object id) {
		return em.find(Blog.class, id);
	}
}
