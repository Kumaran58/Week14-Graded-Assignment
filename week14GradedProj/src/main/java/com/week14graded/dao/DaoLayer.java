package com.week14graded.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.week14graded.model.EmployeeModel;

public class DaoLayer implements DaoInterface {

	@Override
	public void insertEmployee(EmployeeModel e) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.save(e);

			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
	}

	@Override
	public void updateEmployee(EmployeeModel employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.update(employee);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}

	@Override
	public void deleteEmployee(EmployeeModel e) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.delete(e);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> empList = new ArrayList<EmployeeModel>();
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		try {
			Transaction tx = ses.beginTransaction();
			Query q1 = ses.createQuery("from EmployeeModel",EmployeeModel.class);
			empList=q1.getResultList();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return empList;
	}

	@Override
	public EmployeeModel getEmployeeById(int id) {
		EmployeeModel emp = null;
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		try {
			Transaction tx = ses.beginTransaction();
			emp = ses.get(EmployeeModel.class,id);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return emp;
	}

}
