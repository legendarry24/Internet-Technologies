package ua.nure.sherbakov.practice7.server.client.web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.sherbakov.log.Log;
import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.entity.GrovingTips;
import ua.nure.sherbakov.practice7.entity.VisualParameters;
import ua.nure.sherbakov.practice7.server.service.FlowerService;
import ua.nure.sherbakov.practice7.server.service.DAOException_Exception;

/**
 * Servlet implementation class AddFlower
 */
public class AddFlower extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = Log.getInstance(Log.DEBUG, AddFlower.class);

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
		Flower flower = new Flower();
		VisualParameters vp = new VisualParameters();
		GrovingTips gt = new GrovingTips();
		HttpSession session = request.getSession();
		log.debug("Requst encoding --> " + request.getCharacterEncoding());
		try {
			flower.setName(request.getParameter("name"));
			flower.setOrigin(request.getParameter("origin"));
			flower.setSoil(request.getParameter("soil"));
			
/*			vp.setStalkColor(request.getParameter("stalkColor"));
			flower.setVisualParameters(vp);
			vp.setColorOfLeaves(request.getParameter("colorOfLeaves"));
			flower.setVisualParameters(vp);
			vp.setAveragePlantSize(Integer.parseInt(request.getParameter("averagePlantSize")));
			flower.setVisualParameters(vp);
			gt.setTemperature(Integer.parseInt(request.getParameter("temperature")));
			flower.setGrovingTips(gt);
			gt.setWatering(Integer.parseInt(request.getParameter("watering")));
			flower.setGrovingTips(gt);
			gt.setLighting(Boolean.parseBoolean(request.getParameter("lighting")));
			flower.setGrovingTips(gt);
			*/
			flower.setMultipling(request.getParameter("multipling"));
			flower.setPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))));
			log.debug("Get flower from request --> " + flower);

			// ----------------------------
			// TODO Validate flower
			// ----------------------------

			// send request to web-service
			int id = service.addFlower(flower);
			log.debug("Flower added with id --> " + id);

			// if ok set flower into session attribute
			session.setAttribute("flower", flower);
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
