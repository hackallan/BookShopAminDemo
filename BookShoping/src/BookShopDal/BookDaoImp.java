package BookShopDal;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import Models.BookModel;
import Models.PageModel;

@Repository("bookDao")
public class BookDaoImp implements BookDao {

	@Override
	public List<BookModel> getList(PageModel page) {
		SqlSessionFactory sf = null;
		try {
			sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		SqlSession ss = sf.openSession();
		List<BookModel> list = ss.selectList("bookDao.getList", page);
		ss.close();
		return list;
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
		// TODO Auto-generated method stub
		return false;
	}

}
