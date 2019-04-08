package com.padmini.book.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Immutable;


/*@Entity
@Table(name = "user")*/
public class UserInfo {
	
	/*@Id
	
	@Column(name = "name")*/
	private String uname;
	
//	@Column(name = "password")
	private String password;
	
//	@OneToMany(fetch = FetchType.EAGER,mappedBy = "username", cascade = CascadeType.ALL)
    private Set books = new HashSet(0);

	public UserInfo() {
		super();
	}

	public UserInfo(String uname) {
		super();
		this.uname = uname;
	}
	
	public UserInfo(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getBooks() {
		return books;
	}

	public void setBooks(Set userBooks) {
		this.books = userBooks;
	}
	
	

}
