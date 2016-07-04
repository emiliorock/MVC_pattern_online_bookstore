package Data;

import java.io.*;
import java.util.*;

public class User {

	private String username;
	private String password;
	private String nickname;
	private String firstname;
	private String lastname;
	private String email;
	private String birthday;
	private String address;
	private String cardnumber;
	private String ban;
	
	public User() {

	}

	public User(String username, String password, String nickname,
			String firstname, String lastname, String email, String birthday,
			String address, String cardnumber, String ban) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthday = birthday;	
		this.address = address;
		this.cardnumber = cardnumber;
		this.ban = ban;
	}

	/*** set method ***/
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	public void setBan(String ban) {
		this.ban = ban;
	}

	/*** get method ***/
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getCardnumber() {
		return cardnumber;
	}
	
	public String getBan() {
		return ban;
	}

}
