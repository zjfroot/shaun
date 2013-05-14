package shaun;

import shaun.util.HtpasswdParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/13/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {
    private String greeting="Subversion user self service";
    public LoginServlet(){}
    public LoginServlet(String greeting)
    {
        this.greeting=greeting;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getSession().getAttribute("user") == null){
            String form = "<pre><form method=\"post\">\n" +
                    "User name: <input type=\"text\" name=\"username\"><br>\n" +
                    " Password: <input type=\"password\" name=\"password\">" +
                    // "<input type=\"hidden\" name=\"from\" value=\""+ request.getRequestURI() +"\">"+
                    "<input type=\"submit\" value=\"Login\">\n" +
                    "</form></pre>";

            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>" + greeting + "</h1>");
            response.getWriter().println(form);
            response.getWriter().println("session=" + request.getSession(true).getId());
        }else{
            response.sendRedirect("/shaun");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HtpasswdParser parser = new HtpasswdParser();
        String hash = parser.parse().get(username);

        if(PasswordVerifier.verify(hash,password)){
            req.getSession().setAttribute("user", new User(username, hash));
            resp.sendRedirect("/shaun");
        } else {
            System.err.println("Authentication failed.");
            resp.sendRedirect("/");
        }
    }
}
