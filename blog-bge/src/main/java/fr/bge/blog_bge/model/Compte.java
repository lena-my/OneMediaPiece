package fr.bge.blog_bge.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@Table(name="compte")
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idCompte;

	@Column(nullable=false)
	private boolean bani;

	@Lob
	@Column(nullable=false)
	private String email;

	@Lob
	@Column(nullable=false)
	private String motDePasse;

	@Lob
	@Column(nullable=false)
	private String pseudonime;

	@Column(nullable=false)
	private boolean signale;

	@Column(nullable=false)
	private boolean supprime;

	@Column(nullable=false)
	private boolean supressionDonnee;

	@Column(nullable=false)
	private boolean valide;

	//bi-directional many-to-one association to TypeCompte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkTypeCompte", nullable=false)
	private TypeCompte typeCompte;

	public Compte() {
	}

	public Long getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public boolean getBani() {
		return this.bani;
	}

	public void setBani(boolean bani) {
		this.bani = bani;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPseudonime() {
		return this.pseudonime;
	}

	public void setPseudonime(String pseudonime) {
		this.pseudonime = pseudonime;
	}

	public boolean getSignale() {
		return this.signale;
	}

	public void setSignale(boolean signale) {
		this.signale = signale;
	}

	public boolean getSupprime() {
		return this.supprime;
	}

	public void setSupprime(boolean supprime) {
		this.supprime = supprime;
	}

	public boolean getSupressionDonnee() {
		return this.supressionDonnee;
	}

	public void setSupressionDonnee(boolean supressionDonnee) {
		this.supressionDonnee = supressionDonnee;
	}

	public boolean getValide() {
		return this.valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public TypeCompte getTypeCompte() {
		return this.typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

}