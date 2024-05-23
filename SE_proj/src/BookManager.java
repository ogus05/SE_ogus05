import java.util.ArrayList;
import java.util.Iterator;



public class BookManager {
	ArrayList<Book> books;
	
	public BookManager() {
		books = new ArrayList<Book>();
	}
	
	
	private Book InnerSearch(int in_id) {
		Iterator<Book> iter = books.iterator();
		
		while(iter.hasNext()) {
			Book currentBook = iter.next();
			if(currentBook.id == in_id) {
				return currentBook;
			}
		}
		return null;
	}
	
	public Book AddBook(int in_id, String in_title, String in_author, int in_publicDate) throws BookManagerException {
		if(InnerSearch(in_id) != null) {
			throw new BookManagerException("해당 ID(%d)는 이미 존재합니다.\n");
		} else {
			Book book = new Book(in_id, in_title, in_author, in_publicDate);
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}도서가 추가되었습니다.\n", book.id, book.title, book.author, book.publicDate);		
			books.add(book);
			return book;
		}
	}
	
	
	public Book SearchBook(int in_id) throws BookManagerException{
		Book book = InnerSearch(in_id);
		if(book != null) {
			return book;
		} else {
			throw new BookManagerException("검색된 도서가 없습니다.\n");
		}

	}
	
	public Book RemoveBook(int in_id) throws BookManagerException{
		Book book = InnerSearch(in_id);
		if(book != null) {
			
			System.out.printf("{id: '%d', 제목: '%s', 저자 : '%s', 출판년도 : '%d'}도서가 삭제되었습니다.\n", book.id, book.title, book.author, book.publicDate);		
			books.remove(book);
			return book;
		} else {
			throw new BookManagerException("해당 ID(%d)의 도서를 찾을 수 없습니다.\n");
		}
		
		
	}
}
