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

@WebServlet("/singleAd")
public class singleAdServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("adId");
        Long id = Long.parseLong(idString);
        Ad ads = DaoFactory.getAdsDao().singleAd(id);
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/ads/singleAd.jsp").forward(request, response);
    }



}
