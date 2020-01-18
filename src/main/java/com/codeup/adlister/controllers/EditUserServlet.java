package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("EditUser")
public class EditUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id",id);
        Users userDao = DaoFactory.getUsersDao();
        User updateUser = userDao.getUserById(id);
        request.setAttribute("EditUser",editUser);
        request.getRequestDispatcher("EditUser.jsp").forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Users usersDao = DaoFactory.getUsersDao();
        long id = Long.parseLong(request.getParameter("id"));
        String userName = request.getParameter("editUserName");
        String userEmail = request.getParameter("editEmail");
        String password = request.getParameter("editUserName");
        User user = new User(id, userName,userEmail,password); //?
        usersDao.insert(user); //?
        response.sendRedirect("/users"); //? check path


    }


}






//getUserDao

//users interface getUserById
//password hash