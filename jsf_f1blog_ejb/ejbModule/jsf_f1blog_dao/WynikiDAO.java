package jsf_f1blog_dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jsf_f1blog_entities.Wyniki;

@Stateless
public class WynikiDAO {

	@PersistenceContext
	EntityManager em;
	
	public void create(Wyniki wyniki) {
		em.persist(wyniki);
	}

	public Wyniki merge(Wyniki wyniki) {
		return em.merge(wyniki);
	}

	public void remove(Wyniki wyniki) {
		em.remove(em.merge(wyniki));
	}

	public Wyniki find(Object id) {
		return em.find(Wyniki.class, id);
	}
}
