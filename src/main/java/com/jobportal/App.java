package com.jobportal;

import com.jobportal.model.Application;
import com.jobportal.model.Job;
import com.jobportal.model.User;

import dao.ApplicationDao;
import dao.JobDao;
import dao.UserDao;

public class App 
{
    public static void main( String[] args )
    {
    	UserDao userDao = new UserDao();
    	JobDao jobDao = new JobDao();
    	ApplicationDao appDao = new ApplicationDao();
    	
    	//Employer can post Jobs//
    	User employer = new User();
    	employer.setUsername("employer1");
    	employer.setRole("employer");
    	userDao.save(employer);
    	System.out.println("User role is Employer");
    	
    	//Employer posted Job//
    	Job job = new Job();
    	job.setTitle("Java Developer");
    	job.setDescription("Full-time developer role.");
    	job.setCompany("Tech Anudip");
    	job.setStatus("pending");
    	job.setEmployer(employer);
    	jobDao.postJob(job);
    	System.out.println("Employer posted a job");
    	
    	//Admin can aprove a Jobs//
    	User admin = new User();
        admin.setUsername("admin1");
        admin.setRole("admin");
        userDao.save(admin);
        System.out.println("User role is Admin");
        jobDao.approveJob(job.getId());
        System.out.println("Admin aproved the Job");
    	
    	//Jobseeker can apply for Jobs//
        User seeker = new User();
        seeker.setUsername("seeker1");
    	seeker.setRole("jobseeker");
    	userDao.save(seeker);
    	System.out.println("User role is Job Seeker");
    	
    	Application application = new Application();
    	application.setJob(job);
    	application.setSeeker(seeker);
    	application.setResume("I have 1 years of experience...");
    	appDao.apply(application);
    	System.out.println("Job Seeker Applied for Job");
    	
    	
    }
}
