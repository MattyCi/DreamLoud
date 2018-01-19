package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.DaoFactory.DaoFactory;
import com.test.DaoFactory.DaoOptions;
import com.test.Models.AccountEntity;

public class LoginHelper {

    private static DreamLoudDao dao = DaoFactory.getInstance(DaoOptions.HIBERNATE_DAO);

    public static AccountEntity loginUsingEmailAndPassword(String email, String password) {
        AccountEntity acct = dao.getAccountByEmailAndPassword(email, password);
        return acct;
    }
}
