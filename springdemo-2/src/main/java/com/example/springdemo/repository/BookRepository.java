package com.example.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByTitleStartingWith(String prefix);
	List<Book> findByTitleEndingWith(String suffix);
    List<Book> findByAuthor(String country);
  //positional parameter,order should match
  		@Query("select f from Book f where f.author=?1 and f.title=?2")
  	     public List<Book> getBooksByAuthor(String author,String title);
  		
          //named parameter
          @Query("select f from Book f where f.author=:author")
  	    public List<Book> getBooksByAuthor(String author);
          
  		//DML
  		@Modifying
  		@Query("delete from Book f where f.title=?1")
  		public int deleteBooksByTitle(String title);
  		
          @Modifying
          @Query("update Book f set f.author=?1 where f.title=?2")
          public int updateBooksByName(String author,String title);
          
          @Query(value="select * from Book f where f.volume=?",nativeQuery=true)
          public List<Book> fetchBooksByVolume(String volume);

}
