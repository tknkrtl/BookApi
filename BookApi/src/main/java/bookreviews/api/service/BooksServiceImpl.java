package bookreviews.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookreviews.api.dao.BooksDao;
import bookreviews.api.dao.BooksDaoImpl;
import bookreviews.api.entity.Books;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	BooksDao BooksDaoImpl;

	@Transactional
	@Override
	public List<Books> getAllBooks() {
		
		return BooksDaoImpl.getAllBooks();
	}

	@Transactional
	@Override
	public Books getBooksById(int id) {

		return BooksDaoImpl.getBooksById(id);
	}

	@Transactional
	@Override
	public void deleteBookById(int id) {

		BooksDaoImpl.deleteBookById(id);
		
	}

	@Transactional
	@Override
	public Books saveOrUpdateBook(Books book) {
		return BooksDaoImpl.saveOrUpdateBook(book);
	}

	
	
}
