package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jobportal.model.User;

import util.HibernateUtil;

public class UserDao {
	public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }
}
