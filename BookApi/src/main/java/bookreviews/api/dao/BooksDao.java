package bookreviews.api.dao;

import java.util.List;

import bookreviews.api.entity.Books;

public interface BooksDao {

	public List<Books> getAllBooks();
	
	public Books getBooksById(int id);
	
	public void deleteBookById(int id);
	
	public Books saveOrUpdateBook(Books book);
	
	
}
