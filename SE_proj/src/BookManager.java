import java.util.ArrayList;
import java.util.Iterator;



public class BookManager {
	ArrayList<Book> bookList;
	
	public BookManager() {
		bookList = new ArrayList<Book>();
	}
	
	
	private Book InnerSearch(int in_id) {
		Iterator<Book> itr_book = bookList.iterator();
		
		while(itr_book.hasNext()) {
			Book bookInCurrentLoop = itr_book.next();
			if(bookInCurrentLoop.id == in_id) {
				return bookInCurrentLoop;
			}
		}
		return null;
	}
	
	public Book AddBook(int in_id, String in_title, String in_author, int in_publicDate) throws BookManagerException {
		if(InnerSearch(in_id) != null) {
			throw new BookManagerException("해당 ID(%d)는 이미 존재합니다.\n");
		} else {
			Book book = new Book(in_id, in_title, in_author, in_publicDate);
			bookList.add(book);
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
			bookList.remove(book);
			return book;
		} else {
			throw new BookManagerException("해당 ID(%d)의 도서를 찾을 수 없습니다.\n");
		}
		
		
	}
}
