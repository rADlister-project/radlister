//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
//import com.codeup.adlister.models.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet(name = "EditAdServlet")
//public class EditAdServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/WEB-INF/editad.jsp").forward(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String adTitle = request.getParameter("editAdTitle");
//        String adDescription = request.getParameter("editAdDescription");
//        Long adPrice = Long.parseLong(request.getParameter("editAdPrice"));
//        Long Id = Long.parseLong(request.getParameter("adId"));
//
//        if (adTitle != null && adDescription != null && adPrice != null) {
//            try {
//                Ad adToEdit = (Ad) request.getSession().getAttribute("Id");
//                adToEdit.setTitle(adTitle);
//                adToEdit.setDescription(adDescription);
////                adToEdit.setPrice(adPrice);
//                adToEdit.setId(Id);
//                DaoFactory.getAdsDao().editAd(adToEdit);
//                response.sendRedirect("/profile");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                response.sendRedirect("/edituser");
//            }
//
//        } else {
//            response.sendRedirect("/edituser");
//        }
//    }
//    }
//}
