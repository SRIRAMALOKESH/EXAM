package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;

public class StudentManager {

	public String inserData(Student s1) {
		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session se = sf.openSession();
		se.getTransaction().begin();
		se.persist(s1);
		se.getTransaction().commit();
		sf.close();
		se.close();
		return "insertion done Successfully";
	}
	
	public String updateData(Student s1) throws Exception {
		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session se = sf.openSession();
		se.getTransaction().begin();
		Student s2 = se.find(Student.class, s1.sid);
		s2.setSname(s1.getSname());
		se.merge(s2);
		se.getTransaction().commit();
		sf.close();
		se.close();
		return "Updation done successfully";
		
	}
	
	public String deletaData(Student s1) throws Exception{
		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session se = sf.openSession();
		se.getTransaction().begin();
		Student s2 = se.find(Student.class, s1.getSid());
		if(s2 != null) {
			se.remove(s2);
		}
		se.getTransaction().commit();
		sf.close();
		se.close();
		return "Deletion done successfully";
	}
	
	
	public List<Student> retrieveData() throws Exception{
		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session se = sf.openSession();
		se.getTransaction().begin();
		List<Student> list = new ArrayList<Student>();
		TypedQuery<Student> qry =  se.createQuery("Select s from Student s",Student.class);
		list = qry.getResultList();
		se.getTransaction().commit();
		sf.close();
		se.close();
		
		return list;
		
		
	}
}
