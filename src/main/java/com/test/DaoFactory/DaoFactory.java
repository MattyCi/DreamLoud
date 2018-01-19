package com.test.DaoFactory;

import org.hibernate.cfg.Configuration;
import com.test.DAOs.*;

/**
 * Created by Aaron on 11/28/2017.
 */
public class DaoFactory {
    public static DreamLoudDao getInstance(int choice){
        switch (choice){
            case DaoOptions.HIBERNATE_DAO:
                return new DreamLoudDaoImpl(new Configuration().configure("hibernate.cfg.xml").buildSessionFactory());
            default:
                return null;
        }
    }
}
