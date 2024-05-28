import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

abstract public class BookManagerBase {
	List<Book> bookList;
	
	public BookManagerBase() {
		bookList = new LinkedList<Book>();
	}

	abstract protected Book InnerSearch(int in_id);

	public Book AddBook(int in_id, String in_title, String in_author, int in_publicDate) throws BookManagerException {
		if(InnerSearch(in_id) != null) {
			throw new BookManagerException("해당 ID(%d)는 이미 존재합니다.\n");
		} else {
			Book book = new Book(in_id, in_title, in_author, in_publicDate);
			bookList.add(book);
	        bookList.sort(Comparator.comparingInt(b -> b.id));
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
