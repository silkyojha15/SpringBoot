package com.sks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//import com.sks.MockitoJunitSpringBootApplication;
import com.sks.entity.Book;
import com.sks.repository.BookRepository;
import com.sks.service.BookService;

@SpringBootTest(classes=MockitoJunitSpringBootApplication.class)


public class MockitoJunitSpringBootApplicationTests {
	
	@Mock 
	BookRepository bookRepo;
	
	@InjectMocks
	BookService bookService = new BookService();
	
	@Test
	public void testGetAllBooks() {
		
		List<Book> books = new ArrayList<>();
		Book b = new Book(1, "Learn Java", "Abc", 100, "borrowed");
		books.add(b);
		Book b1 = new Book(2, "Learn Java1", "Abc1", 101, "borrowed");
		books.add(b1);

		
		when(bookRepo.findAll()).thenReturn(books);
		List<Book> result = bookService.getAllBooks();
		
		Assertions.assertNotEquals(null, result);
		Assertions.assertTrue(result.get(0).getName().endsWith("-b"));
		Assertions.assertEquals("Learn Java-b", result.get(0).getName());
		
		Assertions.assertNotEquals(null, result);
		Assertions.assertTrue(result.get(1).getAuthor().endsWith("-b"));
		Assertions.assertEquals("Abc1-b", result.get(1).getAuthor());
	}

	@Test
	void contextLoads() {
	}

}
