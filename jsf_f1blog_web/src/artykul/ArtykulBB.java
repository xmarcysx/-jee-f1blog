package artykul;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

import java.util.List;

import javax.ejb.EJB;


import jsf_f1blog_dao.UserDAO;
import jsf_f1blog_entities.Blog;

@Named("artykulBB")
@RequestScoped
public class ArtykulBB {	


	
	@EJB
	UserDAO userDAO;
}
