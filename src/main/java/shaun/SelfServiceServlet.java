package shaun;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/14/13
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class SelfServiceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/");
        }else{
            String form = "<pre><form method=\"post\">\n" +
                    "        New password: <input type=\"password\" name=\"newPassword\"><br>\n" +
                    "Confirm new Password: <input type=\"password\" name=\"confirmedNewPassword\">" +
                    "<input type=\"submit\" value=\"Change\">\n" +
                    "</form></pre>";

            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            User user = (User)request.getSession().getAttribute("user");
            response.getWriter().println("Welcome! "+user.getUsername());
            response.getWriter().println(form);
            response.getWriter().println("session=" + request.getSession(true).getId());
        }
    }
}
