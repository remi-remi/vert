package model;

public class Box {
private int id;
private float superficie;
private String libelle;
private int idPension;
private float tarif;


public Box(int id, float superficie, String libelle, int idPension, float tarif) { /// constructeur pour la recuperation dans la bdd
	this.id = id;
	this.superficie = superficie;
	this.libelle = libelle;
	this.idPension= idPension;
	this.tarif=tarif;
}

public Box(int id, float superficie, String libelle, float tarif) { /// constructeur pour l'ajout
	this.id = id;
	this.superficie = superficie;
	this.libelle = libelle;
	this.tarif=tarif;
}

public Box(String libelle, int idPension, float superficie) { /// faut voir si il faut le retirer
	this.id = 0;
	this.superficie = superficie;
	this.libelle = libelle;
	this.idPension= idPension;
}


public float getTarif() {
	return tarif;
}

public void setTarif(float tarif) {
	this.tarif = tarif;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public float getSuperficie() {
	return superficie;
}

public void setSuperficie(float superficie) {
	this.superficie = superficie;
}

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}

public int getIdPension() {
	return idPension;
}

public void setIdPension(int idPension) {
	this.idPension = idPension;
}

/**
 * transforme les variables de l'objet en string code a co
 * @return objet transformer en String pour etre envoyer dans une requéte ou procedure sql
 * 
 */
public String getSQL() {
	return id + "," + libelle + "," + idPension + "," + superficie;
	
}

public boolean equals(Box box) {
	if(box.getLibelle() == libelle && box.getSuperficie() == superficie)
		return true;
	else
		return false;
}






}
