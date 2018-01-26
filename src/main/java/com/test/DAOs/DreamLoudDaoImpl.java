package com.test.DAOs;

import com.test.Models.AccountEntity;
import com.test.Models.DreamPostsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

/**
 * Created by Aaron on 11/28/2017.
 */
public class DreamLoudDaoImpl implements DreamLoudDao{
    private static SessionFactory factory;

    public DreamLoudDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public AccountEntity getAccount() {
        return null;
    }

    public AccountEntity getAccountById(String acctId) {
        AccountEntity user;
        Session sessions = factory.openSession();
        user = (AccountEntity) sessions.createQuery("from AccountEntity where acctId = " + acctId + "").setMaxResults(1).uniqueResult();
        sessions.close();
        return user;
    }

    public ArrayList<AccountEntity> getAccountsInDream(String dreamId) {
        return null;
    }

    public void addAccount(AccountEntity accountEntity) {

    }


    public void updateAccount(AccountEntity accountEntity) {

    }



    public void deleteAccount(String acctId) {

    }

    public void deleteDream(String dreamId) {

    }

    public void deleteDreamChat(String dreamChatId) {

    }

    public void deleteDreamer(String acctId) {

    }

    public AccountEntity getAccountByEmailAndPassword(String email, String password) {
        Session session = factory.openSession();
        AccountEntity acct = (AccountEntity) session.createQuery("from AccountEntity where acctEmail = '" + email + "' and acctPw= '" + password + "'").setMaxResults(1).uniqueResult();
        session.close();
        return acct;
    }

    public ArrayList<DreamPostsEntity> getDreamPosts(String userId) {
        ArrayList<DreamPostsEntity> posts = new ArrayList<DreamPostsEntity>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            posts = (ArrayList<DreamPostsEntity>) session.createQuery("FROM DreamPostsEntity").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return posts;
    }
}
