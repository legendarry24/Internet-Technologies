package ua.nure.sherbakov.practice7.server.client.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.sherbakov.log.Log;
import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.server.service.DAOException_Exception;
import ua.nure.sherbakov.practice7.server.service.FlowerService;

/**
 * Servlet implementation class DeleteFlower
 */
public class DeleteFlower extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = Log.getInstance(Log.DEBUG, DeleteFlower.class);

	private FlowerService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (FlowerService) ctx.getAttribute("FlowerService");
		log.trace("Get attribute FlowerService --> " + service);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			log.debug("Get id from request --> " + id);
			Flower flower = service.deleteFlower(id);
			session.setAttribute("flower", flower);
			log.debug("Set deleted flower to the session --> " + flower);
		} catch (DAOException_Exception e) {
			// Internal exception in web-service
			session.setAttribute("errorMsg", "Error: Can not add flower into database");
			log.debug("Set errorMsg to the session", e.getMessage());
		} catch (NumberFormatException e) {
			// Can not parse price or count
			session.setAttribute("errorMsg", "Error: uncorrect price or count");
			log.debug("Set errorMsg to the session", e.getMessage());
		} catch (Exception e) {
			// Any other exceptions
			session.setAttribute("errorMsg", "Error: Can not comminicate with flower service");
			log.debug("Set errorMsg to the session", e.getMessage());
		}

		// PRG pattern
		response.sendRedirect("viewflower.jsp");
		log.debug("Redirect to viewflower.jsp");
	}

}
