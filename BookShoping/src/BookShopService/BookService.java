package BookShopService;

import java.util.List;

import Models.BookModel;
import Models.PageModel;

public interface BookService {

	public List<BookModel> getList(PageModel page);

	public boolean update(BookModel m);

	public boolean delete(int id);

	public boolean add(BookModel m);
}
