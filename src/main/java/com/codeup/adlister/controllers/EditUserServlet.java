package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "controllers.EditUserServlet", urlPatterns = "/edituser")
public class EditUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        User user = (User) request.getSession().getAttribute("user");

//
//        long id = request.getParameter(user.getId());
//        request.setAttribute("id",id);
//        Users userDao = DaoFactory.getUsersDao();
//        User editUser = userDao.getUserById(id);
//        request.setAttribute("EditUser",editUser);
        request.getRequestDispatcher("/WEB-INF/EditUser.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("editUserName");
        String userEmail = request.getParameter("editEmail");
        String password = request.getParameter("editPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        Long userId = Long.parseLong(request.getParameter("userId"));

        if (password.equalsIgnoreCase(confirmPassword)) {
            try {
//        Users usersDao = DaoFactory.getUsersDao();

//        long id = Long.parseLong(request.getParameter("id"));


                User userToUpdate = (User) request.getSession().getAttribute("user");
//        long id = userToUpdate.getId();
                System.out.println(userToUpdate.getId());
                System.out.println(userToUpdate.getUsername());


                userToUpdate.setUsername(userName);
                userToUpdate.setEmail(userEmail);
                userToUpdate.setPassword(password);
                userToUpdate.setId(userId);

                System.out.println(userToUpdate.getId());
                System.out.println(userToUpdate.getUsername());

                DaoFactory.getUsersDao().updateUser(userToUpdate);
                response.sendRedirect("/profile");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("/edituser");
            }

        } else {
            response.sendRedirect("/edituser");
        }
    }
}
//        userToUpdate.setUsername();
//    DaoFactory.getUsersDao().editUser();

//        User user = new User(id, userName,userEmail,password);
//        usersDao.insert(user);
//getUserDao

//users interface getUserById
//password hash