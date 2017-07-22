package BookShopBll;

import java.util.List;

import Models.BookModel;
import Models.PageModel;

public interface BookServiceMapper {

	public List<BookModel> getList(PageModel page);
	
	public List<BookModel> getBookList();
}
