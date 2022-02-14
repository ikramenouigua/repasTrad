package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.RepasDao;
import model.Repas;

/**
 * Servlet implementation class RepasDelete
 */

@WebServlet("/RepasDelete") 
public class RepasDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepasDao repasDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.repasDao = daoFactory.getRepasDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("repass", repasDao.lister());
		  response.sendRedirect("/RepasTrad/admin/Tab.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println("**************"+id);
		Repas repas = new Repas();
		repasDao.supp(repas,id);
		request.setAttribute("repass", repasDao.lister());
        
        response.sendRedirect("/RepasTrad/admin/Tab.jsp");
	}

}
