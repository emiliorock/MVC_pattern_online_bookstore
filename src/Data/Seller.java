package Data;

import java.io.*;
import java.util.*;

public class Seller implements Serializable {
	
	public String username;
	public String password;
	public String publisher;
	public String email;
	public String address;
	public String ban;
	
	public Seller() {
		
	}
	
	public Seller(String username, String password, String publisher, String email, String address, String ban) {
		this.username = username;
		this.password = password;
		this.publisher = publisher;
		this.email = email;
		this.address = address;
		this.ban = ban;
	}
	
	/*** GET methods ***/
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getBan() {
		return ban;
	}
	
	/*** SET methods ***/
	public void setUsername (String username) {
		this.username = username;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public void setAddress (String address) {
		this.address = address;
	}
	
	public void setBan (String ban) {
		this.ban = ban;
	}
	
}