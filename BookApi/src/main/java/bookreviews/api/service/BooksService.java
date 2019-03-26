package bookreviews.api.service;

import java.util.List;

import bookreviews.api.entity.Books;

public interface BooksService {

public List<Books> getAllBooks();
	
	public Books getBooksById(int id);
	
	public void deleteBookById(int id);
	
	public Books saveOrUpdateBook(Books book);
	
	
}
