package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ca.sheridancollege.beans.User;

public class DAO {
	SessionFactory sessionFactory=new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml").buildSessionFactory();
	public void insertUser(User user1) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//modify, create, 
		session.save(user1);
		
		session.getTransaction().commit();
		session.close();
	}
	//GET ALL USERS
	public List<User> getUserList() {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	//modify, create, 
	//List<User> userList=	(List<User>) session.createQuery("from User").getResultList();
	CriteriaBuilder cb=session.getCriteriaBuilder();
	CriteriaQuery<User> criteria=cb.createQuery(User.class);
	Root<User> root= criteria.from(User.class);
	List<User> userList=session.createQuery(criteria).getResultList();
	
	session.getTransaction().commit();
	session.close();
	
	return userList;
	} //end of getting all users
	
	//GET ALL USER BY NAME
	public List<User> getUsersByName(String fName, String lName) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	//modify, create, 
	//Query query=session.getNamedQuery("User.byUserFirstLastName");
	//query.setParameter("fname", fName);
	//query.setParameter("lname", lName);
	//List<User> userList=query.getResultList();

	CriteriaBuilder cb=session.getCriteriaBuilder();
	CriteriaQuery<User> criteria=cb.createQuery(User.class);
	Root<User> root= criteria.from(User.class);
	
	criteria.where(
			cb.or(
					cb.equal(root.get("firstName"), fName),
					cb.equal(root.get("lastName"), lName)));
	List<User> userList=session.createQuery(criteria).getResultList();
	
	session.getTransaction().commit();
	session.close();
	
	return userList;
	}

	
}
