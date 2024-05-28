public class BookManagerBS extends BookManagerBase {
	
	public BookManagerBS() {
		super();
	}
	
	@Override
	protected Book InnerSearch(int in_id) {
		int leftIdx = 0, rightIdx = bookList.size() - 1; 
	       
        while (leftIdx <= rightIdx)
        { 
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2; 
            
            Book bookInCurrentLoop = bookList.get(midIdx);
            
            if (bookInCurrentLoop.id == in_id) {
            	return bookInCurrentLoop;             	
            }
   
            if (bookInCurrentLoop.id < in_id) {
            	leftIdx = midIdx + 1;             	
            }
   
            else {
            	rightIdx = midIdx - 1;             	
            }
        } 
   
        return null; 
	}
}
