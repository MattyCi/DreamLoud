package com.test.DAOs;

import com.test.Models.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * Created by Aaron on 11/28/2017.
 */
public class DreamLoudDaoImpl implements DreamLoudDao {
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

    public ArrayList<DreamersEntity> getDreamers(Integer userId) {
        ArrayList<DreamersEntity> dreamers = new ArrayList<DreamersEntity>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            dreamers = (ArrayList<DreamersEntity>) session.createQuery("FROM DreamersEntity where acctId=" + userId).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dreamers;
    }

    public void addAccount(AccountEntity accountEntity) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(accountEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void updateAccount(AccountEntity accountEntity) {

    }


    public void deleteAccount(AccountEntity acct) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(acct);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteDream(DreamsEntity dream) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(dream);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
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
        ArrayList<DreammemsEntity> dreamsUserFollows;
        ArrayList<Integer> dreamIds = new ArrayList<Integer>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            dreamsUserFollows = (ArrayList<DreammemsEntity>) session.createQuery("FROM DreammemsEntity where acctId = " + userId).list();
            for (DreammemsEntity dreamMems : dreamsUserFollows) {
                dreamIds.add(dreamMems.getDrmId());
            }
            Query query = session.createQuery("FROM DreamPostsEntity where dreamId in :ids");
            query.setParameterList("ids", dreamIds);
            posts = (ArrayList<DreamPostsEntity>) query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            posts = (ArrayList<DreamPostsEntity>) session.createQuery("FROM DreamPostsEntity").list();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return posts;
    }

    public ArrayList<PostCommentsEntity> getPostComments(int postId) {
        ArrayList<PostCommentsEntity> comments = new ArrayList<PostCommentsEntity>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            comments = (ArrayList<PostCommentsEntity>) session.createQuery("FROM PostCommentsEntity where postId=" + postId).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return comments;

    }

    public void postComment(PostCommentsEntity comment) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(comment);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public DreamsEntity getDreamById(Integer dreamId) {
        Session session = factory.openSession();
        DreamsEntity dream = (DreamsEntity) session.createQuery("from DreamsEntity where drmId =" + dreamId).setMaxResults(1).uniqueResult();
        session.close();
        return dream;
    }

    public void followDream(DreammemsEntity dreammemsEntity) throws Exception {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dreammemsEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public DreammemsEntity getDremMemByUserIdAndDrmId(int acctId, int drmId) {
        Session session = factory.openSession();
        DreammemsEntity dremMem = (DreammemsEntity) session.createQuery("from DreammemsEntity where acctId = " + acctId + " and drmId= " + drmId + "").setMaxResults(1).uniqueResult();
        session.close();
        return dremMem;
    }

    public void unfollowDream(DreammemsEntity dreammemsEntity) throws Exception {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(dreammemsEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public ArrayList<DreammemsEntity> getDremMemByDrmId(int drmId) {
        ArrayList<DreammemsEntity> dreammemsEntities = new ArrayList<DreammemsEntity>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            dreammemsEntities = (ArrayList<DreammemsEntity>) session.createQuery("FROM DreammemsEntity where drmId=" + drmId).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dreammemsEntities;
    }

    public ArrayList<DreamPostsEntity> getDreamPostsByDreamId(int drmId) {
        ArrayList<DreamPostsEntity> dreamPostsEntities = new ArrayList<DreamPostsEntity>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            dreamPostsEntities = (ArrayList<DreamPostsEntity>) session.createQuery("FROM DreamPostsEntity where dreamId=" + drmId).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dreamPostsEntities;
    }

    public void createPost(DreamPostsEntity dreamPostsEntity) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dreamPostsEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addDream(DreamsEntity dreamsEntity) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dreamsEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public AccountEntity getAccountByEmail(String userEmail) {
        Session session = factory.openSession();
        AccountEntity acct = (AccountEntity) session.createQuery("from AccountEntity where acctEmail = '" + userEmail + "'").setMaxResults(1).uniqueResult();
        session.close();
        return acct;
    }

    public DreamsEntity getDreamByName(String dreamName) {
        Session session = factory.openSession();
        DreamsEntity dream = (DreamsEntity) session.createQuery("from DreamsEntity where drmName = '" + dreamName + "'").setMaxResults(1).uniqueResult();
        session.close();
        return dream;
    }

    public ArrayList<AccountEntity> getAccountsByIds(ArrayList<Integer> dreamerIds) {
        ArrayList<AccountEntity> dreamerAccts = null;
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM AccountEntity where acctId in :ids");
            query.setParameterList("ids", dreamerIds);
            dreamerAccts = (ArrayList<AccountEntity>) query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        return dreamerAccts;
    }

    public void addDreamers(DreamersEntity dreamersEntity) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dreamersEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
