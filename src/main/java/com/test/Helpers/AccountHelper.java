package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.Models.AccountEntity;

/**
 * Created by Aaron on 2/11/2018.
 */
public class AccountHelper {
    private DreamLoudDao dao;

    public AccountHelper(DreamLoudDao dao) {
        this.dao = dao;
    }

    public void addUser(String firstName, String lastName, String userEmail, String userPic, String userPass, String userBio) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAcctBio(userBio);
        accountEntity.setAcctFname(firstName);
        accountEntity.setAcctEmail(userEmail);
        accountEntity.setAcctLname(lastName);
        accountEntity.setAcctPic(userPic);
        accountEntity.setAcctPw(userPass);
        dao.addAccount(accountEntity);
    }

    public void removeUser(String userEmail) {
        AccountEntity accountEntity = dao.getAccountByEmail(userEmail);
        if (accountEntity != null) {
            dao.deleteAccount(accountEntity);
        }
    }
}
