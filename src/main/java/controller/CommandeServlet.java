package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoCommande;
import dao.DaoFactory;

import dao.RepasDao;
import model.Commande;
import model.Repas;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet("/CommandeServlet")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    String action = request.getServletPath();
		    System.out.println("dddjj");
			String id = request.getParameter("id");
			int id1=Integer.parseUnsignedInt(id);
			System.out.println(id1);
			RepasDao repasDao;
            DaoFactory daoFactory = DaoFactory.getInstance();
            repasDao = daoFactory.getRepasDao();
   		    Repas repas =  repasDao.selectRepas(id1);
   		     HttpSession ses =request.getSession();
	    	ses.setAttribute("id", repas.getId());
	    	ses.setAttribute("price", repas.getPrix());
   		 RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
 		request.setAttribute("repas", repas);
 		
 		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String ville = request.getParameter("ville");
		String add = request.getParameter("add");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		 HttpSession ses =request.getSession(true);
	    int idRepas=(int) ses.getAttribute("id");
	    DaoFactory daoFactory = DaoFactory.getInstance();
	    RepasDao repasDao;
        repasDao = daoFactory.getRepasDao();
		    Repas repas =  repasDao.selectRepas(idRepas);
	    float prix= Float.valueOf(repas.getPrix()).floatValue();
	    Commande com= new Commande(nom,prenom,ville,add,email,tel,idRepas,prix);
	    DaoCommande ComDAO2 = new DaoCommande();
		
			try {
				ComDAO2.insertCommande(com);
				ses.removeAttribute("id");
				ses.removeAttribute("price");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("index.jsp");
	}
	    

}
