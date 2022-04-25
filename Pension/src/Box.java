
public class Box {
private int id;
private String gardiennage;
private String idPen;
private float taille;

public Box(int id,String gardiennage,String idPen,float taille) {
	this.id = id;
	this.gardiennage=gardiennage;
	this.idPen=idPen;	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getGardiennage() {
	return gardiennage;
}

public void setGardiennage(String gardiennage) {
	this.gardiennage = gardiennage;
}

public String getIdPen() {
	return idPen;
}

public void setIdPen(String idPen) {
	this.idPen = idPen;
}

public float getTaille() {
	return taille;
}

public void setTaille(float taille) {
	this.taille = taille;
}

/**
 * transforme les variables de l'objet en string code a co
 * @return objet transformer en String pour etre envoyer dans une requéte ou procedure sql
 * 
 */
public String getSQL() {
	return id + "," + gardiennage + "," + idPen + "," + taille;
}


}
