package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                Integer.parseInt(request.getParameter("price")),
                request.getParameter("description")

        );
        String checkbox1 = request.getParameter("checkbox1");
        String checkbox2 = request.getParameter("checkbox2");
        String checkbox3 = request.getParameter("checkbox3");
        String checkbox4 = request.getParameter("checkbox4");
        String checkbox5 = request.getParameter("checkbox5");
        String checkbox6 = request.getParameter("checkbox6");
        String checkbox7 = request.getParameter("checkbox7");
        long adIndex = DaoFactory.getAdsDao().insert(ad);
        try {
            //See comment below for CategoryInsertHelper, the returned long is the index of the inserted row (if an insert occurred)
            long result1 = CategoryInsertHelper(adIndex, checkbox1, 1);
            long result2 = CategoryInsertHelper(adIndex, checkbox2, 2);
            long result3 = CategoryInsertHelper(adIndex, checkbox3, 3);
            long result4 = CategoryInsertHelper(adIndex, checkbox4, 4);
            long result5 = CategoryInsertHelper(adIndex, checkbox5, 5);
            long result6 = CategoryInsertHelper(adIndex, checkbox6, 6);
            long result7 = CategoryInsertHelper(adIndex, checkbox7, 7);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            response.sendRedirect("/ads");
    }
    private long CategoryInsertHelper(long index, String category, long num) throws SQLException {
        long result;
        if (category != null) {
            long insertCat = num;
            Category cat = new Category(
                    index,
                    insertCat
            );
            result = DaoFactory.getAdsDao().insertCategory(cat);
        } else result = 0;
        return result;
    }
}
