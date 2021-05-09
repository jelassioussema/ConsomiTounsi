package tn.ConsomiTounsi.Entities;




import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publicity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nom;
	@Enumerated(EnumType.STRING)
	private Canal canal;
	@Enumerated(EnumType.STRING)
	private GenderCible genderCible;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private int nbrInitialVueCible;
	private int nbrFinalVue;
	private float cout;
	private String video;
	private String image;
	private String emailProprietaire;
	private String numeroProprietaire;
	private boolean status;


	public Publicity() {
	}
	

	public Publicity(String nom,Canal canal,
			GenderCible genderCible, Date dateDebut, Date dateFin,
			int nbrInitialVueCible, int nbrFinalVue, float cout, String video,
			String image) {
		super();
		this.nom = nom;
		this.canal = canal;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrInitialVueCible = nbrInitialVueCible;
		this.nbrFinalVue = nbrFinalVue;
		this.cout = cout;
		this.video = video;
		this.image = image;
	
	}



	

	public Publicity(String nom, Canal canal, GenderCible genderCible, Date dateDebut, Date dateFin) {
		super();
		this.nom = nom;
		this.canal = canal;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;

	}
	
	
	
	


	public Publicity(String nom, Canal canal, GenderCible genderCible, Date dateDebut, Date dateFin, String emailProprietaire, String numeroProprietaire) {
		super();
		this.nom = nom;
		this.canal = canal;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.emailProprietaire = emailProprietaire;
		this.numeroProprietaire = numeroProprietaire;
	}


	public Publicity(Long id, String nom, Canal canal, GenderCible genderCible, Date dateDebut, Date dateFin) {
		super();
		Id = id;
		this.nom = nom;
		this.canal = canal;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;

	}
	


	public Publicity(Long id, String nom, Canal canal, GenderCible genderCible, Date dateDebut, Date dateFin,
			int nbrFinalVue, String emailProprietaire, String numeroProprietaire,boolean status) {
		super();
		Id = id;
		this.nom = nom;
		this.canal = canal;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrFinalVue = nbrFinalVue;
		this.emailProprietaire = emailProprietaire;
		this.numeroProprietaire = numeroProprietaire;
		this.status=status;
	}


	public Publicity(Long id, String nom, Canal canal, GenderCible genderCible, Date dateDebut, Date dateFin,
			 String video, String image) {
		super();
		Id = id;
		this.nom = nom;
		this.canal = canal;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.video = video;
		this.image = image;
	}


	public Publicity(Long id, String nom, Canal canal, GenderCible genderCible, Date dateDebut, Date dateFin,int nbrFinalVue,
			 String video, String image, String emailProprietaire,
			String numeroProprietaire,boolean status) {
		super();
		Id = id;
		this.nom = nom;
		this.canal = canal;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrFinalVue=nbrFinalVue;
		this.video = video;
		this.image = image;
		this.emailProprietaire = emailProprietaire;
		this.numeroProprietaire = numeroProprietaire;
		this.status=status;
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNbrInitialVueCible() {
		return nbrInitialVueCible;
	}

	public void setNbrInitialVueCible(int nbrInitialVueCible) {
		this.nbrInitialVueCible = nbrInitialVueCible;
	}

	public int getNbrFinalVue() {
		return nbrFinalVue;
	}

	public void setNbrFinalVue(int nbrFinalVue) {
		this.nbrFinalVue = nbrFinalVue;
	}

	public float getCout() {
		return cout;
	}

	public void setCout(float cout) {
		this.cout = cout;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public GenderCible getGenderCible() {
		return genderCible;
	}

	public void setGenderCible(GenderCible genderCible) {
		this.genderCible = genderCible;
	}



	public String getEmailProprietaire() {
		return emailProprietaire;
	}


	public void setEmailProprietaire(String emailProprietaire) {
		this.emailProprietaire = emailProprietaire;
	}


	public String getNumeroProprietaire() {
		return numeroProprietaire;
	}


	public void setNumeroProprietaire(String numeroProprietaire) {
		this.numeroProprietaire = numeroProprietaire;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}

}
