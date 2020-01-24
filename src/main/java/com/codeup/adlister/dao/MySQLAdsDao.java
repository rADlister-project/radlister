package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> getRandomAds() {
        List<Ad> randomAds = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * from ads order by RAND() LIMIT 3";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                randomAds.add(
                        new Ad(rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getInt("price"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return randomAds;
    }


    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, price, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setInt(3, ad.getPrice());
            stmt.setString(4, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    public Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getInt("price"),
                rs.getString("description")
        );
    }

    @Override
    public Ad editAd(Ad ad) {

        try {
            System.out.println("try");
            String query = "UPDATE ads SET title = ?, price = ?, description = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ad.getTitle());
            stmt.setInt(2, ad.getPrice());
            stmt.setString(3, ad.getDescription());
            stmt.setLong(4, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }

        return null;
    }


    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> allFromUser(Long userID) {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "select id, user_id, title, price, description from ads where user_id = " + userID;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                ads.add(
                        new Ad(rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getInt("price"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long deleteAd(Long Id) {
        try {
            String query = "DELETE FROM ads where id  = ?";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, Id);
            System.out.println("test delete");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exception delete");
        }

        return null;
    }


    @Override
    public Ad getAdById(long id) {
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return extractAd(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad by id", e);
        }

    }

    public List<Ad> search(String userInput) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String query = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ? OR price = ?";
            String searchInput = "%" + userInput + "%";
            String searchPrice = userInput;
            stmt = connection.prepareStatement(query);
            stmt.setString(1, searchInput);
            stmt.setString(2, searchInput);
            stmt.setString(3, searchPrice);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving the ads", e);
        }
    }


    @Override
    public Ad singleAd(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            List<Ad> ads = createAdsFromResults(rs);
            return ads.get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving this ad.", e);
        }

    }

    public Long insertCategory(Category category) throws SQLException {
        String insertQuery = "INSERT INTO ad_category (ad_id, cat_id) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, category.getAd_id());
        ps.setLong(2, category.getCategory());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
    }

    public List<Long> findCategoriesByID(long ad_id) throws SQLException {
        List<Long> categories = new ArrayList<>();
        String searchQuery = "SELECT * FROM ad_category where ad_id = ?";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setLong(1, ad_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            long hold = rs.getLong("ad_category");
            categories.add(hold);
        }
        return categories;
    }

    public List<Ad> findAdsByCategories (List<Long> categories) throws SQLException {
        String search = categories.toString();
        search = search.replaceAll("\\[", "(").replaceAll("\\]",")");
        System.out.println(search);
        String searchQuery = "SELECT ads.id, ads.user_id, ads.title, ads.description FROM ads JOIN ad_category ON ads.id = ad_category.ad_id WHERE ad_category.cat_id in "+search+" GROUP BY ad_category.ad_id";
        Statement stmt = connection.prepareStatement(searchQuery);
        System.out.println(stmt);
        ResultSet rs = ((PreparedStatement) stmt).executeQuery();
        return createAdsFromResults(rs);
    }
    public List<Ad> findAdsByCategory (long category) throws SQLException {
        String searchQuery = "SELECT ads.id, ads.user_id, ads.title, ads.description FROM ads JOIN ad_category ON ads.id = ad_category.ad_id WHERE ad_category.cat_id = ? GROUP BY ad_category.ad_id";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setLong(1,category);
        System.out.println(stmt);
        ResultSet rs = stmt.executeQuery();
        return createAdsFromResults(rs);
    }

    public void deleteCategories(long ad_id) {
        try {
            System.out.println("deleteCategories");
            String deleteQuery = "DELETE FROM ad_category WHERE ad_id = ?";
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, ad_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

