package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Commande;


public class DaoCommande {
	private String jdbcURL = "jdbc:mysql://localhost:3306/repas_trad";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_COMMANDES_SQL = "INSERT INTO COMMANDE" + "  (nom,prenom,ville,adresse,email,tel,idRepas,prix) VALUES "
			+ " (?, ?, ?, ?, ?,?,?,?);";
	

	

	public DaoCommande() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public void insertCommande(Commande com) throws SQLException {
		System.out.println(INSERT_COMMANDES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMANDES_SQL)) {
			preparedStatement.setString(1, com.getNom());
			preparedStatement.setString(2, com.getPrenom());
			preparedStatement.setString(3, com.getVille());
			preparedStatement.setString(4, com.getAddresse());
			preparedStatement.setString(5, com.getEmail());
			preparedStatement.setString(6, com.getTel());
			preparedStatement.setInt(7, com.getIdProd());
			preparedStatement.setFloat(8, com.getPrice());
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	
}
