package shaun;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;

/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/13/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bootstrapper {
    public static void main(String[] args) throws Exception{
        Server server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/", true, false);

        server.setHandler(servletContextHandler);

        servletContextHandler.addServlet(new ServletHolder(new HelloServlet()),"/*");
        server.start();
        server.join();
    }
}
