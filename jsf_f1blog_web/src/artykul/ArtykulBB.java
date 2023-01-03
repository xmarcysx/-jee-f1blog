package artykul;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import jsf_f1blog_dao.UserDAO;
import jsf_f1blog_dao.WynikiDAO;
import jsf_f1blog_entities.Wyniki;

@Named("artykulBB")
@RequestScoped
public class ArtykulBB {	
	private static final String PAGE_ARTYKULY3 = "/pages/artykul3.xhtml?faces-redirect=true";

	private List<Wyniki> allWyniki2021;
	private List<Wyniki> allWyniki2022;
	private List<Wyniki> allWyniki2023;
	
	private Wyniki wyniki = new Wyniki();
	
	public Wyniki getWyniki() {
		wyniki.setSezon(2023);
		return wyniki;
	}
	public void setWyniki(Wyniki wyniki) {
		this.wyniki = wyniki;
	}

	@EJB
	UserDAO userDAO;
	
	@Inject
	WynikiDAO wynikiDAO;
	
	@PostConstruct
    public void init() {
        this.allWyniki2021 = userDAO.getAllWyniki2021();
        this.allWyniki2022 = userDAO.getAllWyniki2022();
        this.allWyniki2023 = userDAO.getAllWyniki2023();
    }
	
	public List<Wyniki> getAllWyniki2021(){
		return this.allWyniki2021;
	}
	
	public List<Wyniki> getAllWyniki2022(){
		return this.allWyniki2022;
	}
	
	public List<Wyniki> getAllWyniki2023(){
		return this.allWyniki2023;
	}
	
	public String doWyniki2023(){
		
		wynikiDAO.create(wyniki);
			
		return PAGE_ARTYKULY3;
	}
}
