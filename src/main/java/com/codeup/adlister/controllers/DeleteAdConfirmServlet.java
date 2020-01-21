package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteAdConfirm")
public class DeleteAdConfirmServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long Id = Long.parseLong(request.getParameter("adId"));
        request.getSession().setAttribute("adId", Id);
        //Working on creating ad persistency
        //Ad ad = (DaoFactory.getAdsDao().getAdById(Id));
        //request.getSession().setAttribute("ad", ad);
        System.out.println(Id);
        request.getRequestDispatcher("/WEB-INF/deletead.jsp").forward(request, response);
        System.out.println("post test");
    }
}
