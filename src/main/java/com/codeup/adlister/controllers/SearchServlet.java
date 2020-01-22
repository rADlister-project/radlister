//package com.codeup.adlister.controllers;
//
//
//import com.codeup.adlister.dao.DaoFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "SearchServlet", urlPatterns = "/search")
//public class SearchServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//
//
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response){
//        request.setAttribute("user", DaoFactory.getUsersDao().findByUsername());
//        try {
//            request.getRequestDispatcher("/WEB-INF/users/index.jsp").forward(request,response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//}