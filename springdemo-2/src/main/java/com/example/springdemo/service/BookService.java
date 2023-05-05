package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springdemo.model.Book;
import com.example.springdemo.repository.BookRepository;

import jakarta.transaction.Transactional;


@Service
public class BookService {
	@Autowired
	BookRepository a ;
	public List<Book> getAll()
	{
		List<Book> b = a.findAll();
		return b;
	}
	public Book saveBook(Book s)
	{
		Book obj = a.save(s);
		return obj;
	}
	public Book updateBook(Book s)
	{
		Book obj = a.save(s);
		return obj;
	}
	public void deleteBook(int id)
	{
		a.deleteById(id);
	}
	public Book getBook(int id)
	{
		return  a.findById(id).get();
	}
	public List<Book> sortAsc(String details)
	{
		return a.findAll(Sort.by(details).ascending());
	}
	public List<Book> paginationData(int pageNu,int pageSize)
	{
		Page<Book> p = a.findAll(PageRequest.of(pageNu, pageSize));
		return p.getContent();
	}
	public List<Book> paginationAndSorting(int pageNu,int pageSize,String pname)
	{
		Page<Book> p = a.findAll(PageRequest.of(pageNu, pageSize, Sort.by(pname).ascending()));
		return p.getContent();
	}
	
	
	public List<Book> fetchAuthorByTitlePrefix(String prefix)
	{
		return a.findByTitleStartingWith(prefix);
	}
	public List<Book> fetchAuthorByNameSuffix(String suffix)
	{
		return a.findByTitleEndingWith(suffix);
	}
	public List<Book> fetchBookByAuthor(String Author)
	{
		return a.findByAuthor(Author);
	}
	public List<Book> getBookByAuthor(String Author,String title)
	  {
		  return a.getBooksByAuthor(Author, title);
	  }
	@Transactional 
	public int deleteBookByTitle(String title)
	{
   	return a.deleteBooksByTitle(title);
	}
	@Transactional
	public int updatePlayerByName(String author,String title)
	{
		return a.updateBooksByName(author, title);
	}

}
	

	


