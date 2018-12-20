package ua.nure.sherbakov.practice7.server.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ua.nure.sherbakov.log.Log;
import ua.nure.sherbakov.practice7.server.client.ServiceProvider;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	public static final Log log = Log.getInstance(Log.DEBUG,
			ua.nure.sherbakov.practice7.server.listener.ContextListener.class);

	/**
	 * Default constructor.
	 */
	public ContextListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		log.trace("Context initialized");
		String url = ctx.getInitParameter("wsdl");
		log.debug("Get Init Parameter: wsdl --> " + url);
		if ("".equals(url)) {
			ctx.setAttribute("FlowerService", ServiceProvider.getInstance(null));
		} else {
			ctx.setAttribute("FlowerService", ServiceProvider.getInstance(url));
		}
	}

}
