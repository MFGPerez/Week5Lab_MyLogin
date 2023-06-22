<%-- 
    Document   : LogIn
    Created on : Jun 8, 2023, 11:58:25 AM
    Author     : mfgperez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login page</title>
    </head>
    <body>
        <h1>Login</h1>

        <form method="post" action="login" > <!-- we are going to post this data to the login servlets post method  -->


            <label><strong> Username:  </label><input type="text" name="username" ><br>  
            <br> 
            <label><strong> Password:  </label><input type="text" name="password"  ><br>  

            <input type="submit" value="Log in">  

        </form>

        <p> ${error}</p><br>
        <p>${logoutMessage}</p>

    </body>
</html>
