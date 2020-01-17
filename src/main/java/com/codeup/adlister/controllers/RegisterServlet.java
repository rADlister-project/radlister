package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        // TODO: show the registration form
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // TODO: ensure the submitted information is valid
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String passwordConfirmation = request.getParameter("confirm_password");
//

//        if (DaoFactory.getUsersDao().findByUsername(username) == null) {

//            if (username == null || password == null || email == null || !email.contains("@")) {
//                response.sendRedirect("/register");
//            } else {
//                User newUser = new User(username, email, hash);
//                DaoFactory.getUsersDao().insert(newUser);
//                request.getSession().setAttribute("user", newUser);
//                request.getSession().setAttribute("isLoggedIn", true);
//                response.sendRedirect("/profile");
//            }
//        } else {
//            response.sendRedirect("/register");
//        }
//        // TODO: create a new user based off of the submitted information
//        // TODO: if a user was successfully created, send them to their profile
//    }
//}

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String passwordConfirmation = request.getParameter("confirm_password");
//        // validate input
//        boolean inputHasErrors = username.isEmpty()
//                || email.isEmpty()
//                || password.isEmpty()
//                || (! password.equals(passwordConfirmation));
//
//        if (inputHasErrors) {
//            response.sendRedirect("/register");
//            return;
//        }
//
//        // create and save a new user
//        User user = new User(username, email, password);
//        DaoFactory.getUsersDao().insert(user);
//        response.sendRedirect("/login");
//    }
//}