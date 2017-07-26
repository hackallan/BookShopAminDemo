package BookShopService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookShopDal.BookDao;
import Mapper.BookServiceMapper;
import Models.BookModel;
import Models.PageModel;

@Service("bookService")
public class BookServiceImp implements BookService {

	@Autowired
	private BookServiceMapper mapper;

	@Override
	public List<BookModel> getList(PageModel page) {
		return mapper.getList(page);
	}

	@Override
	public boolean update(BookModel m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(BookModel m) {
		return mapper.add(m);
	}

}
