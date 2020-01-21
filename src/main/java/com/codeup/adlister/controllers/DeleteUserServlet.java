package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.DeleteUserServlet", urlPatterns = "/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        String password = request.getParameter("editPassword");
        String confirmPassword = request.getParameter("confirmPassword");
//        Long userId = Long.parseLong(request.getParameter("userId"));
        User userToDelete = (User) request.getSession().getAttribute("user");
        if (Password.check(confirmPassword, userToDelete.getPassword())) {
            //                User userToDelete = (User) request.getSession().getAttribute("user");
//                System.out.println(userToDelete.getId());
            DaoFactory.getUsersDao().deleteUser(userToDelete);
            request.getSession().invalidate();
            response.sendRedirect("/home"); //goodbuy page

        } else {
            response.sendRedirect("/edituser");
        }
    }
}



