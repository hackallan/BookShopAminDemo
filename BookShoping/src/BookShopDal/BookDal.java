package BookShopDal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.BookModel;

public class BookDal extends BaseDao {

	private static BookDal instance = null;

	private BookDal() {

	}

	public static BookDal getInstance() {
		if (instance == null) {
			synchronized (BookDal.class) {
				if (instance == null) {
					instance = new BookDal();
				}
			}
		}
		return instance;
	}

	public List<BookModel> getList(String pageSize, String pageIndex) {
		String sql = " select tb.name as book_type_name,b.id,b.author,b.book_type_id,b.`name`,b.pubDate from book  as b INNER JOIN book_type as tb on b.book_type_id = tb.id  limit ?,?";
		int page = (Integer.parseInt(pageIndex) - 1) * Integer.parseInt(pageSize);
		ResultSet rs = excuteQuery(sql, page, Integer.parseInt(pageSize));
		List<BookModel> list = convertoModels(rs);
		close();
		return list;
	}
	
	public boolean update(BookModel m)
	{
		String sql = " update book set name=?,book_type_id=?,book_type_name=?,author=? where id=?";
		boolean resultIs=excuteUpdate(sql, m.getName(),m.getTypeId(),m.getTypeName(),m.getAuthor(),m.getId());
		close();
		return resultIs;
	}
	
	public boolean delete(int id)
	{
		String sql = " delete from  book  where id=?";
		boolean resultIs=excuteUpdate(sql,id);
		close();
		return resultIs;
	}

	public boolean add(BookModel m) {
		String sql = " insert into book (name,book_type_id,book_type_name,author,pubDate) values(?,?,?,?,now());";
		boolean resultIs = false;
		resultIs = excuteUpdate(sql, m.getName(), m.getTypeId(), m.getTypeName(), m.getAuthor());
		close();
		return resultIs;
	}

	private List<BookModel> convertoModels(ResultSet rs) {
		List<BookModel> list = new ArrayList<>();
		try {
			while (rs.next()) {
				list.add(new BookModel(rs.getInt("id"), rs.getString("name"), rs.getInt("book_type_id"),
						rs.getString("book_type_name"), rs.getString("author"), rs.getDate("pubDate")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
