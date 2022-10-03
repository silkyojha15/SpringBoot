package com.sks.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.sks.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public List<Book> findByName(String name);
	//public List<Book> findByAuthor(String author);

}
