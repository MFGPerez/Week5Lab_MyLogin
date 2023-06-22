/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 * Description handles all authentication and creation/ destruction of sessions
 *
 * @author mfgperez
 */
public class LoginServlet extends HttpServlet {

    @Override // displays login form , responsible for loging out the user 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  // on start up

        /* FIELDS  */
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");

        //  String username = (String) session.getAttribute("username");

        /* LOGOUT*/
        if (logout != null) {

            request.setAttribute("logoutMessage", "You have been logged out");
            session.invalidate();
            session = request.getSession();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // use / before WEB
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* FIELDS  */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService acount = new AccountService();
        User newUser;
        HttpSession session = request.getSession();
        //String user; 

        // if username or password is not null 
        if (username != null && password != null) {

            newUser = acount.login(username, password);

            // if username is abe or barb send them to the home page , the nset attribute user name to username 
            if (newUser != null) {

                session.setAttribute("username", newUser.getUserName());
            
                response.sendRedirect("home"); // send user to the home page 
                return; // good practice 
            }

        }

        request.setAttribute("error", "invalid username or passsword");

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;

    }
}
