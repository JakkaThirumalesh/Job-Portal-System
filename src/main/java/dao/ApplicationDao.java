package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jobportal.model.Application;

import util.HibernateUtil;

public class ApplicationDao {
	public void apply(Application application) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(application);
        tx.commit();
        session.close();
    }
}
