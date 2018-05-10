package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.Models.AccountEntity;
import com.test.Models.DreamersEntity;

import java.util.ArrayList;

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

    public static void addFriend(String userId, String dreamerId) {

    }

    public ArrayList<AccountEntity> getFriends(String userId) {
        return null;
    }

    public ArrayList<AccountEntity> getTopFriends(String userId) {
        ArrayList<DreamersEntity> dreamers = dao.getDreamers(Integer.parseInt(userId));
        ArrayList<Integer> dreamerIds = new ArrayList<Integer>();
        for(DreamersEntity dreamer : dreamers){
            dreamerIds.add(dreamer.getAcctId2());
            System.out.print(dreamer.getAcctId2());
        }
        return dao.getAccountsByIds(dreamerIds);
    }
}
