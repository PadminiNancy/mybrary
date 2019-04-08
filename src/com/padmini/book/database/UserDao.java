package com.padmini.book.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.padmini.book.model.UserInfo;
import com.padmini.book.database.SessionUtil;

public class UserDao {

	public UserInfo addUser(UserInfo user)
	{
		
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        UserInfo u = new UserInfo();
        u.setUname(user.getUname());
        u.setPassword(user.getPassword());
		session.save(u); 
        tx.commit();
        session.close();
        return user;
	}
	
	public UserInfo getUser(String uname)
	{
		
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        System.out.println("before fetch : "+uname);
        UserInfo u = (UserInfo)session.get(UserInfo.class,uname); 
        
        System.out.println("After fetch : "+u.getUname());
        tx.commit();
        session.close();
        return u;
	}
	
	public UserInfo getAllUsers()
	{		
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();       
        Query q = session.createQuery("from UserInfo ");
		//q.setParameter("status", status);		
		List<UserInfo> list = q.list();		
		UserInfo users = (UserInfo)list.get(0);
        session.close();
        return users;
	}
	
}
