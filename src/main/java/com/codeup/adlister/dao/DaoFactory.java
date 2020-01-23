package com.codeup.adlister.dao;

import com.codeup.adlister.models.Categories;
import com.codeup.adlister.models.MySQLCategoriesDao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config = new Config();
    private static Categories categoriesDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Categories getCategoriesDao(){
        if (categoriesDao == null){
            categoriesDao = new MySQLCategoriesDao(config);
        }
        return categoriesDao;
    }
}
