package bookreviews.api.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookreviews.api.entity.Books;

@Repository
public class BooksDaoImpl implements BooksDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Books> getAllBooks() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Books> query = currentSession.createQuery("from Books",Books.class);
		
		List<Books> books = query.list();
		
		return books;
	}

	@Override
	public Books getBooksById(int theId) {
	
		try {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Books> query = currentSession.createQuery("from Books where id=:theId",Books.class);
		
		query.setParameter("theId", theId);
		
		Books book = query.getSingleResult();
				
		return book;
		}
		
		catch(NoResultException e){
			return null;
		}
	
	}

	@Override
	public void deleteBookById(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from Books where id=:theId");
		
		query.setParameter("theId", theId);
		
		query.executeUpdate();

	}
	
	@Override
	public Books saveOrUpdateBook(Books books) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(books);
		
		return books;
	}

	
}
