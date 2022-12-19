package user;

import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;


import jsf_f1blog_dao.UserDAO;


@Named("userBB")
@RequestScoped
public class UserBB {
	private static final String PAGE_LOGIN = "/pages/login.xhtml?faces-redirect=true";
	private static final String PAGE_REGISTER = "/pages/register.xhtml?faces-redirect=true";

	
	@EJB
	UserDAO userDAO;
	

	public String goToLogin(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_LOGIN;
	}
	
	public String goToRegister(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_REGISTER;
	}
}
