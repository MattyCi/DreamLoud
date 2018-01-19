package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.DaoFactory.DaoFactory;
import com.test.DaoFactory.DaoOptions;
import com.test.Models.AccountEntity;

public class LoginHelper {

    private DreamLoudDao dao = DaoFactory.getInstance(DaoOptions.HIBERNATE_DAO);

    public  AccountEntity loginUsingEmailAndPassword(String email, String password) {
        return dao.getAccountByEmailAndPassword(email, password);
    }

    public AccountEntity getAcctUsingId(String userId){
        return dao.getAccountById(userId);
    }
}
