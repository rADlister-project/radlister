package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //post request to display the info
        String userSearch = request.getParameter("search");
        if(userSearch != null && !userSearch.equals("")){
            List<Ad> ads = null;
            try {
                ads = DaoFactory.getAdsDao().search(userSearch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(!ads.isEmpty()){
                request.setAttribute("ads", ads);
                request.setAttribute("userInput", request.getParameter("search"));
                request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
                return;
            }else {
                request.setAttribute("errorMessage", "No ads were found, try searching for something else");
            }
        }
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}

