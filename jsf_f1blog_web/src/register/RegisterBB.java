package register;

import java.util.List;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import jsf_f1blog_dao.UserDAO;
import jsf_f1blog_dao.RoleDAO;
import jsf_f1blog_entities.User;
import jsf_f1blog_entities.Role;


@Named("registerBB")
@RequestScoped
public class RegisterBB {
	private static final String PAGE_LOGIN = "/pages/login.xhtml?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private String roleOption = "user"; //user
	
	private User user = new User();

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Inject
	RoleDAO roleDAO;
	
	@Inject
	UserDAO userDAO;
	
	public void setUserRole() {
		//Set Role ID
		Role role = roleDAO.getRoleByName(this.roleOption);
		this.user.setRole(role);;
	}

	public boolean validateUser(User user) {
		List<User> duplicates = userDAO.searchForDuplicate(user.getUsername(), user.getEmail());
		if(duplicates.isEmpty() || duplicates == null) return true;
		else return false;
	}
	
	public String doRegister(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		if(validateUser(user)) {
			setUserRole();
			userDAO.create(user);
			
			return PAGE_LOGIN;
		}
		else {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nie udało się utworzyć uzytkownika: login lub email występują w systemie", null));
			return PAGE_STAY_AT_THE_SAME;
		}
	}
}
