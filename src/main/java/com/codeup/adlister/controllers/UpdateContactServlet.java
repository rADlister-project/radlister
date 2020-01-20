//package com.codeup.adlister.controllers;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/UpdateContact")
//public class UpdateContactServlet extends HttpServlet {
//
////   pulled from contacts manager, gives ability to update a contact
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        long id = Long.parseLong(request.getParameter("id"));
//        request.setAttribute("id", id);
//        Contacts contactDao = DaoFactory.getContactsDao();
//        Contact updateContact = contactDao.getContactById(id);
//        request.setAttribute("updateContact", updateContact);
//        request.getRequestDispatcher("ContactsManager/UpdateContacts.jsp").forward(request, response);
//
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Contacts contactsDao = DaoFactory.getContactsDao();
//        long id = Long.parseLong(request.getParameter("id"));
//        String firstName = request.getParameter("updateFirstName");
//        String lastName = request.getParameter("updateLastName");
//        String telephone = request.getParameter("updateTelephone");
//        Contact contact = new Contact(id, firstName, lastName, telephone);
//        contactsDao.saveContact(contact);
//        response.sendRedirect("/contacts");
//
//
//    }
//}
//
//
////        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
////
////
////        String firstName = request.getParameter("firstName");
////        String lastName = request.getParameter("lastName");
////        String telephone = request.getParameter("telephone");
////        Contact contact = new Contact(firstName, lastName, telephone);
////
////
////        Contacts allContacts = DaoFactory.getContactsDao();
////        allContacts.saveContact(contact);
////
//////        List<Contact> contacts = allContacts.getContacts();
//////        request.setAttribute("contacts", contacts);
//////        request.getRequestDispatcher("ContactsManager/ContactsIndex.jsp").forward(request, response);
////        response.sendRedirect("/contacts");
////    }
//
//
//
