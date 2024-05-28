import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookManagerTest {
	final int NUMB_OF_TEST_CASE = 100000;
	
	BookManager bookManager;
	BookManagerBS bookManagerBS;
	Vector<Book> testCases;
	
	public BookManagerTest(){
		System.out.printf("테스트 시작.\n 저장된 케이스의 개수는 %d개, publicDate는 id에 2024가 더해집니다.\n", NUMB_OF_TEST_CASE);
		
		for(int bookID = 0; bookID < NUMB_OF_TEST_CASE; bookID++) {
			String bookTitle = Integer.toString(bookID) + "번째 책";
			String bookAuthor = Integer.toString(bookID) + "번째 책 저자";
			int bookPublicDate = bookID + 2024;
			testCases.add(new Book(bookID, bookTitle, bookAuthor, bookPublicDate));
		}
	}
	
	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
		testCases = new Vector<>(NUMB_OF_TEST_CASE);
	}

	@Test
	void testAddBooks() {
		Book testCase = testCases.get(0);
		try {
			Book retBook = bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate);
			assertEquals(testCase.id, retBook.id, "testCase, retBook ID is not equal");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}도서가 추가되었습니다.\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);		
			
			BookManagerException ex = assertThrows(BookManagerException.class, () -> bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate));
			System.out.println(ex.getMessage());
		} catch(BookManagerException exc){
		}
	}
	
	@Test
	void testAddBooksBS() {
		Book testCase = testCases.get(0);
		try {
			Book retBook = bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate);
			assertEquals(testCase.id, retBook.id, "testCase, retBook ID is not equal");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}도서가 추가되었습니다.\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);		
			
			BookManagerException ex = assertThrows(BookManagerException.class, () -> bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate));
			System.out.println(ex.getMessage());
		} catch(BookManagerException exc){
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
			
			BookManagerException ex = assertThrows(BookManagerException.class, () -> bookManager.SearchBook(testCases.get(1).id));
			System.out.println(ex.getMessage());

		} catch(BookManagerException exc){
		}
		
	}
	
	@Test
	void testSearchBooksBS() {
		Book testCase = testCases.get(0);
		try {
			bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate);
			Book retBook = bookManager.SearchBook(testCase.id);
			assertEquals(testCase.id, retBook.id, "testCase, retBook ID is not equal");
			System.out.printf("검색결과:\n");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);			
			
			BookManagerException ex = assertThrows(BookManagerException.class, () -> bookManager.SearchBook(testCases.get(1).id));
			System.out.println(ex.getMessage());

		} catch(BookManagerException exc){
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
			
			
			BookManagerException ex = assertThrows(BookManagerException.class, () -> bookManager.RemoveBook(testCases.get(1).id));
			System.out.println(ex.getMessage());

		} catch(BookManagerException exc){
		}
		
	}
	
	@Test
	void testRemoveBooksBS() {
		Book testCase = testCases.get(0);
		try {
			bookManager.AddBook(testCase.id, testCase.title, testCase.author, testCase.publicDate);
			Book retBook = bookManager.RemoveBook(testCase.id);
			assertEquals(testCase.id, retBook.id, "testCase, retBook ID is not equal");
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}도서가 삭제되었습니다.\n", retBook.id, retBook.title, retBook.author, retBook.publicDate);		
			
			
			BookManagerException ex = assertThrows(BookManagerException.class, () -> bookManager.RemoveBook(testCases.get(1).id));
			System.out.println(ex.getMessage());

		} catch(BookManagerException exc){
		}
		
	}

}
