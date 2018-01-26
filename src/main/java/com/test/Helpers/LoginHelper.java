package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.Models.AccountEntity;

public class LoginHelper {
    DreamLoudDao dao;

    public LoginHelper(DreamLoudDao dao) {
        this.dao = dao;
    }

    public  AccountEntity loginUsingEmailAndPassword(String email, String password) {
        return dao.getAccountByEmailAndPassword(email, password);
    }

    public AccountEntity getAcctUsingId(String userId){
        return dao.getAccountById(userId);
    }
}
