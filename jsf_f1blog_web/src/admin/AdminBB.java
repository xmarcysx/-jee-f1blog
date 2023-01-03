package admin;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import jsf_f1blog_dao.BlogDAO;
import jsf_f1blog_entities.Blog;


@Named("adminBB")
@RequestScoped
public class AdminBB {
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/adminBlog.xhtml?faces-redirect=true";
	private Blog blog = new Blog();
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	@Inject
	BlogDAO blogDAO;
	
	
	public String dodajWpis(){
		blogDAO.create(blog);
		return PAGE_STAY_AT_THE_SAME;
		
	}
}
