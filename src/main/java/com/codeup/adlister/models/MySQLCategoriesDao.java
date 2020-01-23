package com.codeup.adlister.models;
import java.sql.*;
import com.codeup.adlister.dao.Config;
import com.mysql.cj.jdbc.Driver;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    @Override
    public List<Category> some() {
        return null;
    }

    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM category");
            ResultSet rs = stmt.executeQuery();
            return createCategories(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error with categories joining subcategories.", e);
        }
    }



    public Category extractCategory(ResultSet rs) {
        try {
            return new Category(
                    rs.getLong("id"),
                    rs.getString("category").toUpperCase()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error extracting all Categories.", e);
        }
    }


    private List<Category> createCategories(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }

}
