import java.util.*;



public class BookManager extends BookManagerBase {
	
	public BookManager() {
		super();
	}
	@Override
	protected Book InnerSearch(int in_id) {
		Iterator<Book> itr_book = bookList.iterator();
		
		while(itr_book.hasNext()) {
			Book bookInCurrentLoop = itr_book.next();
			if(bookInCurrentLoop.id == in_id) {
				return bookInCurrentLoop;
			}
		}
		return null;
	}

}
