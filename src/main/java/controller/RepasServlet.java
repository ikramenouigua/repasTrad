package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.RepasDao;
import dao.RepasDaoImp;
import model.Repas;

/**
 * Servlet implementation class RepasServlet
 */
@WebServlet("/RepasServlet")
public class RepasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepasDao repasDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.repasDao = daoFactory.getRepasDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setAttribute("repass", repasDao.lister());
		  response.sendRedirect("/Repas_traditionnel/admin/add.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		Repas repas = new Repas();
		repas.setTitre(request.getParameter("titre"));
		repas.setDescriptipn(request.getParameter("description"));
		repas.setPrix(request.getParameter("prix"));
		repas.setUrl(request.getParameter("image"));
        
		repasDao.ajouter(repas);
        
        request.setAttribute("repass", repasDao.lister());
        
        response.sendRedirect("/Repas_traditionnel/admin/add.jsp");
    }

}
