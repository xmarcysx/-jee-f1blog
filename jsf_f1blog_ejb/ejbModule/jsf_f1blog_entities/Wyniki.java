package jsf_f1blog_entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wyniki database table.
 * 
 */
@Entity
@NamedQuery(name="Wyniki.findAll", query="SELECT w FROM Wyniki w")
public class Wyniki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idWyscigu;

	private String grandPrix;

	private int sezon;

	private String team;

	private String zwyciezca;

	public Wyniki() {
	}

	public int getIdWyscigu() {
		return this.idWyscigu;
	}

	public void setIdWyscigu(int idWyscigu) {
		this.idWyscigu = idWyscigu;
	}

	public String getGrandPrix() {
		return this.grandPrix;
	}

	public void setGrandPrix(String grandPrix) {
		this.grandPrix = grandPrix;
	}

	public int getSezon() {
		return this.sezon;
	}

	public void setSezon(int sezon) {
		this.sezon = sezon;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getZwyciezca() {
		return this.zwyciezca;
	}

	public void setZwyciezca(String zwyciezca) {
		this.zwyciezca = zwyciezca;
	}

}