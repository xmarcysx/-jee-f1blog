package jsf_f1blog_entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the blog database table.
 * 
 */
@Entity
@NamedQuery(name="Blog.findAll", query="SELECT b FROM Blog b")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBlog;

	@Lob
	private String tekst;

	public Blog() {
	}

	public int getIdBlog() {
		return this.idBlog;
	}

	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

}