package ua.nure.sherbakov.practice7.server.client.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.sherbakov.log.Log;
import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.server.service.FlowerService;

/**
 * Servlet implementation class FindFlowerByOrigin
 */
public class FindFlowerByOrigin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = Log.getInstance(Log.DEBUG, FindFlowerByOrigin.class);

	private FlowerService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (FlowerService) ctx.getAttribute("FlowerService");
		log.trace("Get attribute FlowerService --> " + service);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pattern = request.getParameter("pattern");
		log.debug("Get find pattern from request --> " + pattern);

		List<Flower> flowers = service.findByOrigin(pattern);
		log.debug("Get flowers from FlowerService --> " + flowers);
		request.setAttribute("flowers", flowers);
		log.trace("Set flowers to the session --> " + flowers);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		log.trace("Redirect to list.jsp");
	}

}
