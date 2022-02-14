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
 * Servlet implementation class RepasUpdate
 */
@WebServlet("/RepasUpdate")
public class RepasUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepasDao repasDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.repasDao = daoFactory.getRepasDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("repass", repasDao.lister());
		  response.sendRedirect("/RepasTrad/admin/Tab.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Repas repas = new Repas();
		String id=request.getParameter("id");
		repas.setTitre(request.getParameter("titre"));
		repas.setDescriptipn(request.getParameter("description"));
		repas.setPrix(request.getParameter("prix"));
		repas.setUrl(request.getParameter("image"));
        
		repasDao.modifier(repas ,id);
        
        request.setAttribute("repass", repasDao.lister());
        
        response.sendRedirect("/RepasTrad/admin/Tab.jsp");
	}

}
