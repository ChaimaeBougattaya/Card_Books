package tp.model.bo;

import java.util.Set;
import java.util.TreeSet;

public class Library {

	Set<Book> books;
	
	public Library() {
		books = new TreeSet<Book>();
	}
	public Set<Book> getBooks() {
		return books;
	}
	public Book getBook(String SBN)
	{
		for(Book b : books)
		{
			if(b.getSBN().equals(SBN))
				return b;
		}
		return null;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public void addBook(Book b)
	{
		this.books.add(b);
	}
	public void removebook(String sbn)
	{
		this.books.remove(this.getBook(sbn));
	}
}
