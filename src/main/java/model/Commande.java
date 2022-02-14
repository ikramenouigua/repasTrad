package model;

public class Commande {
	private Integer id;
	private String nom;
	private String prenom;
	private String ville;
	private String addresse;
	private String email;
	private String tel;
	private int idProd;
	private float price;
	
	public Commande(Integer id, String nom, String prenom, String ville, String addresse, String email, String tel,
			int idProd, float price) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.addresse = addresse;
		this.email = email;
		this.tel = tel;
		this.idProd = idProd;
		this.price = price;
	}
	
	public Commande(String nom, String prenom, String ville, String addresse, String email, String tel, int idProd,
			float price) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.addresse = addresse;
		this.email = email;
		this.tel = tel;
		this.idProd = idProd;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
