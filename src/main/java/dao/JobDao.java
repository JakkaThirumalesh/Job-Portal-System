package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jobportal.model.Job;

import util.HibernateUtil;

public class JobDao {
	public void postJob(Job job) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(job);
        tx.commit();
        session.close();
    }
	public void approveJob(int jobId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Job job = session.get(Job.class, jobId);
        if (job != null) {
            job.setStatus("approved");
            session.update(job);
        }
        tx.commit();
        session.close();
    }
	
}
