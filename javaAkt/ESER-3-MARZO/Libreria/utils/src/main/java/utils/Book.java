package utils;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String author;
	
	public Book(int id, String title, String author){
		this.id = id;
		this.title = title;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override 
	public boolean equals(Object obj){
		if(obj != null && obj.getClass().equals(this.getClass())){
			Book tmp = (Book)obj;
			if(tmp.getId() == this.getId()){
				return true;
			}
			return false;
		}
		
		return false;
	}
	@Override
	public int hashCode(){
		return id;
	}
}
