package shaun;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/14/13
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class BootstrapperWar {

    public static void main(String[] args) throws Exception {
        Bootstrapper.handleArgs(args);
        runWar();
    }

    private static void runWar() throws Exception {
        Server server = new Server(8080);
        ProtectionDomain domain = BootstrapperWar.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
        webapp.setServer(server);
        webapp.setWar(location.toExternalForm());
        server.setHandler(webapp);
        server.start();
        server.join();
    }
}
