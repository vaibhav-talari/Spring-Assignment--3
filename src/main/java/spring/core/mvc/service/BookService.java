package spring.core.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.mvc.model.Book;
import spring.core.mvc.dao.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo dao;
	
	@Transactional
	public boolean addBook(Book book)
	{
		return dao.addBook(book);
	}
	
	@Transactional
	public Book getBook(long refid)
	{
		return dao.getBook(refid);
	}
	
	@Transactional
	public boolean deleteBook(long refid)
	{
		return dao.deleteBook(refid);
	}

	@Transactional
	public List<Book> getAllBooks()
	{
		return dao.getAllBooks();
	}

}
