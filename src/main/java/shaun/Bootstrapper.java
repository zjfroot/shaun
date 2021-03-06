package shaun;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import shaun.servlet.LoginServlet;
import shaun.util.HtpasswdFileHolder;

/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/13/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bootstrapper {
    public static void main(String[] args) throws Exception{
        handleArgs(args);
        startJettyServerWebAppExploded();
    }

    public static void handleArgs(String[] args) {
        if (args.length != 1){
            System.err.println("Needed a path to .htpasswd file");
            System.exit(0);
        }else{
            String path = args [0];
            System.out.println("Setting .htpasswd path to: " + path);
            HtpasswdFileHolder.setFile(path);
        }
    }

    private static void startJettyServerWithHelloServlet() throws Exception {
        Server server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/", true, false);
        server.setHandler(servletContextHandler);
        servletContextHandler.addServlet(new ServletHolder(new LoginServlet()),"/*");
        server.start();
        server.join();
    }

    private static void startJettyServerWebAppExploded () throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setDescriptor("/WEB-INF/web.xml");
        context.setResourceBase("../shaun/src/main/webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();
    }
}
