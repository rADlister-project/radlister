package com.codeup.adlister.controllers;//add contact as response to user action

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class AddUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //grab contact info from AddContact.jsp form
        String addUserName = request.getParameter("userName");
        String addEmail = request.getParameter("lastName");
        String addPassword = request.getParameter("phoneNumber");

        //create new contact
        User contact = new User(addUserName, addEmail, addPassword);



        Users allContacts = DaoFactory.getUsersDao(); //
        allContacts.insert(contact);
        response.sendRedirect("/users");
    }


}