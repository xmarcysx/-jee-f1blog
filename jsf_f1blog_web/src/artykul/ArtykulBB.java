package artykul;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;


import jsf_f1blog_dao.UserDAO;
import jsf_f1blog_entities.Wyniki;

@Named("artykulBB")
@RequestScoped
public class ArtykulBB {	

	private List<Wyniki> allWyniki2021;
	private List<Wyniki> allWyniki2022;
	@EJB
	UserDAO userDAO;
	
	@PostConstruct
    public void init() {
        this.allWyniki2021 = userDAO.getAllWyniki2021();
        this.allWyniki2022 = userDAO.getAllWyniki2022();
    }
	
	public List<Wyniki> getAllWyniki2021(){
		return this.allWyniki2021;
	}
	
	public List<Wyniki> getAllWyniki2022(){
		return this.allWyniki2022;
	}
	
	
}
