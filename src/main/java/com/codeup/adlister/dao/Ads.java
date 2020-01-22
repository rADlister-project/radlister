package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // search ads by user input

    List<Ad>search(String userInput);
    //    get a list of ads from a particular user
    List<Ad> allFromUser(Long userID);

    //    gets 3 random ads
    public List<Ad> getRandomAds();

    Long deleteAd(Long Id);
    public Ad getAdById(long id);
    public Ad extractAd(ResultSet rs) throws SQLException;

    // editAd

    public Ad editAd(Ad adToUpdate);

    Ad singleAd(Long Id);
}

