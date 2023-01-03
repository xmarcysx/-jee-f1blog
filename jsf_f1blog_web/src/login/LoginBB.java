package login;

import java.util.List;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.simplesecurity.RemoteClient;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.faces.simplesecurity.PasswordHash;


import jsf_f1blog_dao.UserDAO;
import jsf_f1blog_entities.User;


@Named("loginBB")
@RequestScoped
public class LoginBB {
	private static final String PAGE_LOGIN = "/pages/login.xhtml?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private static final String PAGE_BLOG = "/pages/blog.xhtml?faces-redirect=true";
	private static final String PAGE_ADMIN_BLOG = "/pages/adminBlog.xhtml?faces-redirect=true";
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Inject
	UserDAO userDAO;
	

	public String doLogin(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		//0. hash prompted password
		password = new PasswordHash().hashPassword(password);

		// 1. verify login and password - get User from "database"
		User user = userDAO.getUserFromDatabase(username, password);

		// 2. if bad login or password - stay with error info
		if (user == null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Niepoprawny login lub hasło", null));
			return PAGE_STAY_AT_THE_SAME;
		}

		// 3. if logged in: get User roles, save in RemoteClient and store it in session
		RemoteClient<User> client = new RemoteClient<User>(); //create new RemoteClient
		client.setDetails(user);
		client.getRoles().add(user.getRole().getName());

			
		//store RemoteClient with request info in session (needed for SecurityFilter)
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		client.store(request);
		
		// and enter the system (now SecurityFilter will pass the request)
		return PAGE_BLOG;
	}
	
	public String doLogout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_LOGIN;
	}
}
