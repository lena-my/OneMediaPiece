package fr.bge.blog_bge.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the typeCompte database table.
 * 
 */
@Entity
@Table(name="typeCompte")
@NamedQuery(name="TypeCompte.findAll", query="SELECT t FROM TypeCompte t")
public class TypeCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idTypeCompte;

	@Lob
	@Column(nullable=false)
	private String label;

	public TypeCompte() {
	}

	public Long getIdTypeCompte() {
		return this.idTypeCompte;
	}

	public void setIdTypeCompte(Long idTypeCompte) {
		this.idTypeCompte = idTypeCompte;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}