package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Repas;

public class RepasDaoImp implements  RepasDao {
    private DaoFactory daoFactory;

    RepasDaoImp(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Repas repas) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO repas(id, titre, prix, description, image) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, repas.getId());
            preparedStatement.setString(2, repas.getTitre());
            preparedStatement.setString(3, repas.getPrix());
            preparedStatement.setString(4, repas.getDescription());
            preparedStatement.setString(5, repas.getUrl());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Repas> lister() {
        List<Repas> repass = new ArrayList<Repas>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, titre, prix, description, image FROM repas;");

            while (resultat.next()) {
                Integer id = resultat.getInt("id");
                String titre = resultat.getString("titre");
                String prix = resultat.getString("prix");
                String description = resultat.getString("description");
                String url = resultat.getString("image");

                Repas repas = new Repas();
                repas.setId(id);
                repas.setTitre(titre);
                repas.setDescriptipn(description);
                repas.setPrix(prix);
                repas.setUrl(url);

                repass.add(repas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repass;
    }
   
    public Repas selectRepas(int id) {
       
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, titre, prix, description, image FROM repas where id="+id);

            while (resultat.next()) {
                Integer id1 = resultat.getInt("id");
                String titre = resultat.getString("titre");
                String prix = resultat.getString("prix");
                String description = resultat.getString("description");
                String url = resultat.getString("image");

                Repas repas = new Repas();
                repas.setId(id1);
                repas.setTitre(titre);
                repas.setDescriptipn(description);
                repas.setPrix(prix);
                repas.setUrl(url);

                return repas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Repas repas = null;
		return repas;
    }
    @Override
    public void supp(Repas repas , String id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM repas where id ="+id);
           // preparedStatement.setInt(1, repas.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public void modifier(Repas repas ,String id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE repas SET titre=? , prix=? , description=? , image=? WHERE id ="+id);
            
            preparedStatement.setString(1, repas.getTitre());
            preparedStatement.setString(2, repas.getPrix());
            preparedStatement.setString(3, repas.getDescription());
            preparedStatement.setString(4, repas.getUrl());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public String countRepas() {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        String Countrow="";
        java.sql.Statement st;

        try {
            connexion = daoFactory.getConnection();
            st = connexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM repas ");;
            while(rs.next() ){
                Countrow = rs.getString(1);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  Countrow;

    }
    
	public RepasDaoImp() {
		super();
	}

	

}