package shaun.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jifzh
 * Date: 5/14/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginFilter implements javax.servlet.Filter{
    protected ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
/*
            HttpServletRequest req = (HttpServletRequest)servletRequest;
            HttpServletResponse resp = (HttpServletResponse)servletResponse;

            if (!isAuth(req)) {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return; //break filter chain, requested JSP/servlet will not be executed
            }
*/

            //propagate to next element in the filter chain, ultimately JSP/ servlet gets executed
            filterChain.doFilter(servletRequest, servletResponse);
    }

/*    *//**
     * logic to accept or reject access to the page, check log in status
     * @return true when authentication is deemed valid
     * @param req
     *//*
    protected boolean isAuth(HttpServletRequest req){
        String password = req.getParameter("password");
        System.out.println(password);
        return false;
    }*/

    @Override
    public void destroy() {

    }
}
