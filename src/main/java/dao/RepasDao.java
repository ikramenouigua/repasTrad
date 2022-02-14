package dao;

import java.util.List;

import model.Repas;

public interface RepasDao {
	void ajouter( Repas repas );
	void supp(Repas repas , String id);
	void modifier(Repas repas , String id);
    List<Repas> lister();
	String countRepas();
	Repas selectRepas(int id);
}
