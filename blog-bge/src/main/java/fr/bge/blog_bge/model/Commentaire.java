package fr.bge.blog_bge.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the commentaire database table.
 * 
 */
@Entity
@Table(name="commentaire")
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idCommentaire;

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

	//bi-directional many-to-one association to Article
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkArticle", nullable=false)
	private Article article;

	//bi-directional many-to-one association to Compte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCompte", nullable=false)
	private Compte compte;

	public Commentaire() {
	}

	public Long getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
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

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}