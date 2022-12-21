package jsf_f1blog_dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jsf_f1blog_entities.User;


@Stateless
public class UserDAO {

	@PersistenceContext
	EntityManager em;
	
	public void create(User user) {
		em.persist(user);
	}

	public User merge(User user) {
		return em.merge(user);
	}

	public void remove(User user) {
		em.remove(em.merge(user));
	}

	public User find(Object id) {
		return em.find(User.class, id);
	}
	
	public List<User> searchForDuplicate(String username, String email) {
		Query query =  em.createQuery("SELECT u FROM User u WHERE u.username LIKE :username OR u.email LIKE :email");
		query.setParameter("username", username);
		query.setParameter("email", email);
		return query.getResultList();
	}
	
	public User getUserFromDatabase(String username, String password) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username like :login AND u.password LIKE :pass");
		query.setParameter("login", username);
		query.setParameter("pass", password);
		
		try {
			return (User) query.getResultList().get(0);
		} catch (Exception e) {	}
		
		return null;
	}

}
