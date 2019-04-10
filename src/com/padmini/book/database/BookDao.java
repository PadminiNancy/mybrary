package com.padmini.book.database;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.padmini.book.model.BookInfo;
import com.padmini.book.model.UserInfo;


public class BookDao {
	
	public BookInfo addBook(BookInfo book, String uname)
	{
		
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        BookInfo b = new BookInfo();
        UserInfo u = new UserInfo();
        u.setUname(uname);
        b.setBook_name(book.getBook_name());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setStatus(book.getStatus());
        b.setComment(book.getComment());
        b.setUser(u);
		session.save(b); 
        tx.commit();
        
        session.close();
        return book;
	}

	public BookInfo getBook(String book_name, String author, String uname)
	{
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
		Query q = session.createSQLQuery("Select * from bookInfo where book_name=:book_name and author=:athor and name=:uname");
		q.setParameter("book_name", book_name);
		q.setParameter("author", author);
		q.setParameter("uname", uname);
		List<?> list = q.list();		
		BookInfo book = (BookInfo)list.get(0);
      //  tx.commit();
        session.close();
		return book;		
	}
	
	public BookInfo upateBook(BookInfo book, String uname)
	{
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        BookInfo b = null;
		//Query q = session.createSQLQuery("Select * from bookInfo where name=:uname and book_name=:book_name");
        Query q = session.createQuery("from BookInfo where name=? and book_name=?");
        q.setString(0, uname);
        q.setString(1, book.getBook_name());
		/*q.setParameter("book_name", book.getBook_name());
		q.setParameter("uname", uname);*/
		List<BookInfo> list = q.list();	
		//System.out.println("Class returned from list is : "+list.get(0).getAuthor());
		b = list.get(0);
		b.setBook_id(b.getBook_id());
		UserInfo u = new UserInfo();
		u.setUname(uname);
		b.setUser(u);
		b.setAuthor(book.getAuthor());
		b.setPrice(book.getPrice());
		b.setStatus(book.getStatus());
		b.setComment(book.getComment());
		session.saveOrUpdate(b);
        tx.commit();
        session.close();
		return b;
		
	}
	
	
	public List<BookInfo> getAllBooks(String uname)
	{
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        
		Query q = session.createSQLQuery("Select * from bookInfo where name=:uname");
		q.setParameter("uname", uname);
		List<BookInfo> list = q.list();	
    //    tx.commit();
        session.close();		
		return list;		
	}
	
	public BookInfo deleteBook(BookInfo book, String uname)
	{
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
 
        BookInfo b = null;
		//Query q = session.createSQLQuery("Select * from bookInfo where name=:uname and book_name=:book_name");
        Query q = session.createQuery("from BookInfo where name=? and book_name=? and author=?");
        q.setString(0, uname);
        q.setString(1, book.getBook_name());
        q.setString(2, book.getAuthor());
		/*q.setParameter("book_name", book.getBook_name());
		q.setParameter("uname", uname);*/
		List<BookInfo> list = q.list();	
		//System.out.println("Class returned from list is : "+list.get(0).getAuthor());
		b = list.get(0);
        
		session.delete(b);
        tx.commit();
        session.close();
		return b;		
	}
	
}
