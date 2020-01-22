package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
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

    //method used for search the database
    public List<Ad> search(String userInput) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String query = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            String queryWildCard = userInput + "%";


            stmt = connection.prepareStatement(query);
            stmt.setString(1, queryWildCard);
            stmt.setString(2, queryWildCard);

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
}