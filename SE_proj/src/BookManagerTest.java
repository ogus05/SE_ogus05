import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookManagerTest {
	
	BookManager bookManager;
	Vector<Book> testCases;
	
	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
		testCases = new Vector<>(3);
		testCases.add(new Book(1, "자바 기초", "Jane", 2021));
		testCases.add(new Book(2, "소프트웨어 공학", "Tom", 2014));
		testCases.add(new Book(3, "분산 컴퓨팅", "Yoon", 2024));

	}

	@Test
	void testAddBooks() {
		Book testCase = testCases.get(0);
		try {
			Book retBook = bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate);
			assertEquals(testCase.id, retBook.id, "testCase, retBook ID is not equal");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}도서가 추가되었습니다.\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);		
			System.out.printf("검색결과:\n");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);			
			
			
			assertThrows(BookManagerException.class, () -> bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate));
			
		} catch(BookManagerException exc){
			assertAll();
		}
		
	}
	
	@Test
	void testSearchBooks() {
		Book testCase = testCases.get(0);
		try {
			bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate);
			Book retBook = bookManager.SearchBook(testCase.id);
			assertEquals(testCase.id, retBook.id, "testCase, retBook ID is not equal");
			System.out.printf("검색결과:\n");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);			
			
			assertThrows(BookManagerException.class, () -> bookManager.SearchBook(testCases.get(1).id));
			
		} catch(BookManagerException exc){
			assertAll();
		}
		
	}
	
	@Test
	void testRemoveBooks() {
		Book testCase = testCases.get(0);
		try {
			bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate);
			Book retBook = bookManager.RemoveBook(testCase.id);
			assertEquals(testCase.id, retBook.id, "testCase, retBook ID is not equal");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}도서가 삭제되었습니다.\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);		
			
			
			assertThrows(BookManagerException.class, () -> bookManager.RemoveBook(testCases.get(1).id));
			
		} catch(BookManagerException exc){
			assertAll();
		}
		
	}

}
