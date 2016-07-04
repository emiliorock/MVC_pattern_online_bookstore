package Data;

import java.io.*;
import java.util.*;

public class Item implements Serializable {
	
	public String title;
	public String author;
	public String type;
	public String date;
	public String price;
	public String seller;
	public String publisher;
	public String pause;
	
	public Item() {
		
	}
	
	public Item(String title, String author, String type, String date, String price, String seller, String publisher, String pause) {
		this.title = title;
		this.author = author;
		this.type = type;
		this.date = date;
		this.price = price;
		this.seller = seller;
		this.publisher = publisher;
		this.pause = pause;
	}
	
	/*** GET methods ***/
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getPause() {
		return pause;
	}
	
	/*** SET methods ***/
	public void setTitle (String title) {
		this.title = title;
	}
	
	public void setAuthor (String author) {
		this.author = author;
	}
	
	public void setPublisher (String publisher) {
		this.publisher = publisher;
	}
	
	public void setSeller (String seller) {
		this.seller = seller;
	}
	
	public void setPrice (String price) {
		this.price = price;
	}
	
	public void setDate (String date) {
		this.date = date;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	public void setPause (String pause) {
		this.pause = pause;
	}
}