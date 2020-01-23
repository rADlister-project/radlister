package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public Long insert(Ad ad) {
        // make sure we have ads
        if (ads == null) {
            ads = generateAds();
        }
        // we'll assign an "id" here based on the size of the ads list
        // really the dao would handle this
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    @Override
    public List<Ad> search(String userInput) {
        return null;
    }

    @Override
    public List<Ad> allFromUser(Long userID) {
        return null;
    }

    @Override
    public List<Ad> getRandomAds() {
        return null;
    }

    @Override
    public Long deleteAd(Long id) {
        return null;
    }

    @Override
    public Ad getAdById(long id) {
        return null;
    }

    @Override
    public Ad extractAd(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public Ad editAd(Ad ad) {
        return null;
    }

//    @Override
//    public Ad editAd(Ad adToUpdate) {
//        return null;
//    }

    @Override
    public Ad singleAd(Long Id) {
        return null;
    }

    @Override
    public Long insertCategory(Category category) throws SQLException {
        return null;
    }

    @Override
    public List<Long> findCategoriesByID(long ad_id) throws SQLException {
        return null;
    }

    @Override
    public void deleteCategories(long ad_id) {

    }

    @Override
    public List<Ad> findAdsByCategories(List<Long> categories) throws SQLException {
        return null;
    }

    @Override
    public List<Ad> findAdsByCategory(long category) throws SQLException {
        return null;
    }


    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
//        ads.add(new Ad(
//            1,
//            1,
//            "playstation for sale",
//            "This is a slightly used playstation"
//        ));
//        ads.add(new Ad(
//            2,
//            1,
//            "Super Nintendo",
//            "Get your game on with this old-school classic!"
//        ));
//        ads.add(new Ad(
//            3,
//            2,
//            "Junior Java Developer Position",
//            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
//        ));
//        ads.add(new Ad(
//            4,
//            2,
//            "JavaScript Developer needed",
//            "Must have strong Java skills"
//        ));
        return ads;
    }

}
