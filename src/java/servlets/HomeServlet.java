package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mfgperez
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        
        // if username is null 
        if (username == null) {

            response.sendRedirect("login"); // take them to the login url/ page
           
            return;
        } 
            // other wise forward them to the home page 
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response); // use / before WEB
            return;
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        
        // not needed 

    }
}
