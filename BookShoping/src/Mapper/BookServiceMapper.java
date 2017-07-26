package Mapper;

import java.util.List;

import Models.BookModel;
import Models.PageModel;

public interface BookServiceMapper {

	public List<BookModel> getList(PageModel page);
	
	public List<BookModel> getBookList();
	
	/**
	 *添加
	 * */
	public boolean add(BookModel m);
}
