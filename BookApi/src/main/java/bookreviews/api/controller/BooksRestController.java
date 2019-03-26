package bookreviews.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookreviews.api.entity.Books;
import bookreviews.api.error.BookNotFoundException;
import bookreviews.api.service.BooksService;

@RestController
@RequestMapping("/api")
public class BooksRestController {

	@Autowired
	BooksService booksService;
	
	@GetMapping("/books")
	public List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}
	
	@GetMapping("/books/{theId}")
	public Books getBookById(@PathVariable int theId) {
		
		Books book = booksService.getBooksById(theId);
		
		if(book == null) {
			throw new BookNotFoundException("Book not found for id " + theId);
		}
		else
		return booksService.getBooksById(theId);
	}
	
	@PostMapping("/books")
	public Books saveBook(@RequestBody Books book) {
		
		book.setId(0);
		return booksService.saveOrUpdateBook(book);
		
	}
	
	@PutMapping("/books")
	public Books updateBook(@RequestBody Books book) {
		
		return booksService.saveOrUpdateBook(book);

	}
	
	@DeleteMapping("/books/{theId}")
	public String deleteCustomer(@PathVariable int theId) {
		
		
		if(booksService.getBooksById(theId) == null)			
			throw new BookNotFoundException("Book not found for id = " + theId);
		
		else {
			booksService.deleteBookById(theId);
			return "Deleted book id " + theId;
		}

		
	}

}
