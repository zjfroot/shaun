package shaun.servlet;

import shaun.model.User;
import shaun.util.HtpasswdUpdater;

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

    private String form = "<pre><form method=\"post\">\n" +
            "        New password: <input type=\"password\" name=\"newPassword\"><br>\n" +
            "Confirm new Password: <input type=\"password\" name=\"confirmedNewPassword\">" +
            "<input type=\"submit\" value=\"Change\">\n" +
            "</form></pre>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(req.getSession().getAttribute("user") == null){
            resp.sendRedirect("/");
        }else{
            resp.setContentType("text/html");
            resp.setStatus(HttpServletResponse.SC_OK);
            User user = (User)req.getSession().getAttribute("user");
            resp.getWriter().println("<pre>Welcome! "+user.getUsername() +"    <a href=\"/logout\">Logout</a></pre>");
            resp.getWriter().println(form);
            resp.getWriter().println("session=" + req.getSession(true).getId());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("newPassword");
        String confirmedNewPassword = req.getParameter("confirmedNewPassword");
        User user = (User)req.getSession().getAttribute("user");

        String message;
        if(newPassword.equals(confirmedNewPassword)){
            if(newPassword.length() < 5)
                message = "Password too short, at least 5 letters";
            else {
                HtpasswdUpdater.updatePassword(user.getUsername(),newPassword);
                message = "Password changed";
            }
        }else{
            message = "Password does not match";
        }

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<pre>Welcome! "+user.getUsername() +"    <a href=\"/logout\">Logout</a></pre>");
        resp.getWriter().println("<pre>"+message+"</pre>");
        resp.getWriter().println(form);
        resp.getWriter().println("session=" + req.getSession(true).getId());
    }
}
