package utils;

import java.io.Serializable;

public class LibraryItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private int qty;
	
	public LibraryItem(Book book,int qty){
		this.book = book;
		this.qty = qty;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public int hashCode(){
		return book.hashCode();
	}
	@Override
	public boolean equals(Object obj){
		if(obj != null && obj.getClass().equals(this.getClass())){
			LibraryItem item = (LibraryItem) obj;
			if(this.book.equals(item.getBook())){
				return true;
			}else{
				return false; 
			}
		}
		
		return false;
	}
}
