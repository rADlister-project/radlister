//package com.codeup.adlister.controllers;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/AddContact")
//public class AddContactServlet extends HttpServlet {
//
////    pulled from contacts manager to add a contact
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String telephone = request.getParameter("telephone");
//        Contact contact = new Contact(firstName, lastName, telephone);
//
//
//        Contacts allContacts = DaoFactory.getContactsDao();
//        allContacts.saveContact(contact);
//
////        List<Contact> contacts = allContacts.getContacts();
////        request.setAttribute("contacts", contacts);
////        request.getRequestDispatcher("ContactsManager/ContactsIndex.jsp").forward(request, response);
//        response.sendRedirect("/contacts");
//    }
//}
//
