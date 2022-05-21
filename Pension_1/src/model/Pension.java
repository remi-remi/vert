package model;

public class Pension {
	String pensionVille = null;
	String pensionAdresse = null;
	String pensionTelephone = null;
	String pensionResponsable = null;

	String pensionNom = null;
	String pensionAdresseSiegeSocial = null;
	String pensionNomDirigeant = null;
	String pensionAdresseLogo = null;
	Float pensionPrixVaccin = null;
	Float pensionPrixVermifuge = null;
	
	public Pension(String pensionVille, String pensionAdresse, String pensionTelephone, String pensionResponsable,
					String pensionNom, String pensionAdresseSiegeSocial, String pensionNomDirigeant, String pensionAdresseLogo,
					Float pensionPrixVaccin, Float pensionPrixVermifuge){		
		super();
		this.pensionVille = pensionVille;
		this.pensionAdresse = pensionAdresse;
		this.pensionTelephone = pensionTelephone;
		this.pensionResponsable = pensionResponsable;
		this.pensionNom = pensionNom;
		this.pensionAdresseSiegeSocial = pensionAdresseSiegeSocial;
		this.pensionNomDirigeant = pensionNomDirigeant;
		this.pensionAdresseLogo = pensionAdresseLogo;
		this.pensionPrixVaccin = pensionPrixVaccin;
		this.pensionPrixVermifuge = pensionPrixVermifuge;
	}
	
	public String getPensionVille() {
		return pensionVille;
	}
	public void setPensionVille(String pensionVille) {
		this.pensionVille = pensionVille;
	}
	public String getPensionAdresse() {
		return pensionAdresse;
	}
	public void setPensionAdresse(String pensionAdresse) {
		this.pensionAdresse = pensionAdresse;
	}
	public String getPensionTelephone() {
		return pensionTelephone;
	}
	public void setPensionTelephone(String pensionTelephone) {
		this.pensionTelephone = pensionTelephone;
	}
	public String getPensionResponsable() {
		return pensionResponsable;
	}
	public void setPensionResponsable(String pensionResponsable) {
		this.pensionResponsable = pensionResponsable;
	}
	public String getPensionNom() {
		return pensionNom;
	}
	public void setPensionNom(String pensionNom) {
		this.pensionNom = pensionNom;
	}
	public String getPensionAdresseSiegeSocial() {
		return pensionAdresseSiegeSocial;
	}
	public void setPensionAdresseSiegeSocial(String pensionAdresseSiegeSocial) {
		this.pensionAdresseSiegeSocial = pensionAdresseSiegeSocial;
	}
	public String getPensionNomDirigeant() {
		return pensionNomDirigeant;
	}
	public void setPensionNomDirigeant(String pensionNomDirigeant) {
		this.pensionNomDirigeant = pensionNomDirigeant;
	}
	public String getPensionAdresseLogo() {
		return pensionAdresseLogo;
	}
	public void setPensionAdresseLogo(String pensionAdresseLogo) {
		this.pensionAdresseLogo = pensionAdresseLogo;
	}
	public float getPensionPrixVaccin() {
		return pensionPrixVaccin;
	}
	public void setPensionPrixVaccin(float pensionPrixVaccin) {
		this.pensionPrixVaccin = pensionPrixVaccin;
	}
	public float getPensionPrixVermifuge() {
		return pensionPrixVermifuge;
	}
	public void setPensionPrixVermifuge(float pensionPrixVermifuge) {
		this.pensionPrixVermifuge = pensionPrixVermifuge;
	}

	
	
}
