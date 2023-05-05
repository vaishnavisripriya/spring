package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.Book;
import com.example.springdemo.service.BookService;



@RestController
public class BookController {
	@Autowired
	BookService c;
	@GetMapping(value="/api")
	public List<Book> getAll()
	{
		List<Book> d = c.getAll();
		return d;
	}
	@PostMapping(value="/saveBook")
	public Book saveBook(@RequestBody Book s)
	{
		return c.saveBook(s);
		
	}
	@PutMapping(value="/updateBook")
	public Book updateBook(@RequestBody Book s)
	{
		return c.updateBook(s);
	}
	@DeleteMapping(value="/delete")
    public void updateBook(@RequestParam Integer id)
    {
		c.deleteBook(id);
    }
	@GetMapping(value="/find/{id}")
	public Book findBook(@PathVariable("id") Integer id)
	{
		return c.getBook(id);
	}
	@GetMapping("/sort/{details}")
	public List<Book>sortAuthor(@PathVariable("details")String details)
	{
		return c.sortAsc(details);
	}
	@GetMapping("/pagination/{pnu}/{psize}")
	public List<Book>paginationDate(@PathVariable("pnu") int pnu, @PathVariable("psize") int psize)
{
	return c.paginationData(pnu, psize);
}
	@GetMapping("/paginationsorting/{pnu}/{psize}/{pname}")
	 public List<Book> paginationSorting(@PathVariable ("pnu") int pnu,@PathVariable("psize") int psize,@PathVariable("pname") String pname)
	{
		 return c.paginationAndSorting(pnu,psize,pname);
	 }
	
	@GetMapping("/fetchPrefix")
	public List<Book> fetchBookByAuthorPrefix(@RequestParam String prefix)
	{
		return c.fetchAuthorByTitlePrefix(prefix);
	}
	@GetMapping("/fetchSuffix")
	public List<Book> fetchBookByAuthorSuffix(@RequestParam String suffix)
	{
		return c.fetchAuthorByNameSuffix(suffix);
	}
	@GetMapping("/fetchByAuthor")
	public List<Book> fetchBookByAuthor(@RequestParam String author)
	{
		return c.fetchBookByAuthor(author);
	}
	@DeleteMapping("/deletePlayerByName/{name}")
    public String deleteBookByTitle(@PathVariable String title)
    {
 	   int result = c.deleteBookByTitle(title);
 	   if(result>0)
 		     return "Book record deleted";
 	   else
 		     return "Problem occured while deleting";
    }
    @PutMapping("/updateBookByAuhor/{author}/{title}")
    public String updatePlayerByName(@PathVariable String author,@PathVariable String title)
	{
    	int res=c.updatePlayerByName(author, title);
    	if(res>0)
    		return "Author record updated";
    	else
    		return "Problem occured";
		
	}
    
}
	

