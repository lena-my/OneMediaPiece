package fr.bge.blog_bge.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@Table(name="article")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idArticle;

	@Lob
	@Column(nullable=false)
	private String contenu;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateModification;

	@Column(nullable=false)
	private boolean modere;

	@Column(name="public", nullable=false)
	private boolean public_;

	@Lob
	@Column(nullable=false)
	private String titre;

	//bi-directional many-to-one association to Compte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCompte", nullable=false)
	private Compte compte;

	public Article() {
	}

	public Long getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return this.dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public boolean getModere() {
		return this.modere;
	}

	public void setModere(boolean modere) {
		this.modere = modere;
	}

	public boolean getPublic_() {
		return this.public_;
	}

	public void setPublic_(boolean public_) {
		this.public_ = public_;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}