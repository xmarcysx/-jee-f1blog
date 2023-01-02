package blog;

import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;


import jsf_f1blog_dao.UserDAO;
import jsf_f1blog_entities.Blog;

@Named("blogBB")
@RequestScoped
public class BlogBB {	
	
	private List<Blog> allBlog;

	
	private static final String PAGE_ARTYKULY = "/pages/artykuly.xhtml?faces-redirect=true";
	private static final String PAGE_BLOG = "/pages/blog.xhtml?faces-redirect=true";
	private static final String PAGE_MARCYSIOX = "/pages/marcysiox.xhtml?faces-redirect=true";
	
	@EJB
	UserDAO userDAO;
	
	@PostConstruct
    public void init() {
        this.allBlog = userDAO.getAllBlog();
    }
	
	public List<Blog> getAllBlog(){
		return this.allBlog;
	}

	
	public String goToArtykuly(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_ARTYKULY;
	}
	
	public String goToBlog(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_BLOG;
	}
	
	public String goToMarcysiox(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_MARCYSIOX;
	}
}
