package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EditAd")
public class EditAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String adTitle = request.getParameter("editAdTitle");
        int adPrice = Integer.parseInt(request.getParameter("editAdPrice"));
        String adDescription = request.getParameter("editAdDescription");
        long Id = Long.parseLong(request.getParameter("adId"));
        User user = (User) request.getSession().getAttribute("user");
        long userID = user.getId();
        Ad adToEdit = new Ad(0, 0, "", 0, "");
        System.out.println("post success");
        adToEdit.setTitle(adTitle);
        adToEdit.setPrice(adPrice);
        adToEdit.setDescription(adDescription);
        adToEdit.setId(Id);
        adToEdit.setUserId(userID);
        DaoFactory.getAdsDao().editAd(adToEdit);
        response.sendRedirect("/profile");


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String adTitle = request.getParameter("editAdTitle");
//        int adPrice = Integer.parseInt((String) request.getAttribute("editAdPrice"));
//        String adDescription = request.getParameter("editAdDescription");
        Long Id = Long.parseLong(request.getParameter("adId"));
//
//        request.setAttribute("adTitle", adTitle);
//        request.setAttribute("adPrice", adPrice);
//        request.setAttribute("adDescription", adDescription);
        request.setAttribute("adId", Id);


        request.getRequestDispatcher("/WEB-INF/editad.jsp").forward(request, response);

    }
}