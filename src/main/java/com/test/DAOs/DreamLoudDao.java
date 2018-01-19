package com.test.DAOs;

import com.test.Models.AccountEntity;

import java.util.ArrayList;

/**
 * Created by Aaron on 11/28/2017.
 */
public interface DreamLoudDao {

    AccountEntity getAccountById(String acctId);

    ArrayList<AccountEntity> getAccountsInDream(String dreamId);


    void addAccount(AccountEntity accountEntity);


    void updateAccount(AccountEntity accountEntity);


    void deleteAccount(String acctId);

    void deleteDream(String dreamId);

    void deleteDreamChat(String dreamChatId);

    void deleteDreamer(String acctId);

    AccountEntity getAccountByEmailAndPassword(String email, String password);
}
