package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletead")
public class DeleteAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String password = request.getParameter("editPassword");
//        String confirmPassword = request.getParameter("confirmPassword");
//        Long userId = Long.parseLong(request.getParameter("userId"));

//        Long adId = (Long) request.getAttribute("adId");
//        request.getAttribute("ad");
//        Ad ad = (Ad) request.getAttribute("ad");
        Long Id = (Long) request.getSession().getAttribute("adId");
        System.out.println("from second delete servlet" + Id);
//        Long Id =  request.setAttribute("adId", adId);
//       Long.parseLong("adId");
//        Long Id = ad.getId();
//        System.out.println(Id);
//        System.out.println(Id + "from deleteAdServlet");
//        Ad adToDelete = (User) request.getSession().getAttribute("user");
//        request.getSession().invalidate();
        try {
            DaoFactory.getAdsDao().deleteAd(Id);
            request.getSession().removeAttribute("adId");
            response.sendRedirect("/profile"); //goodbye page

        } catch (IOException e) {
            e.printStackTrace();
//            error page if unable to delete
            response.sendRedirect("/home");

        }


    }
}
