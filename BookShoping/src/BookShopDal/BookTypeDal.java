package BookShopDal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.BookTypeModel;

public class BookTypeDal extends BaseDao {

	private static BookTypeDal instance = null;

	private BookTypeDal() {

	}

	public static BookTypeDal getInstance() {
		if (instance == null) {
			synchronized (BookTypeDal.class) {
				if (instance == null) {
					instance = new BookTypeDal();
				}
			}
		}
		return instance;
	}

	public static List<BookTypeModel> getList() {
		String sql = " select * from book_type ";
		ResultSet rs = excuteQuery(sql);

		List<BookTypeModel> list = convertoModels(rs);
		close();
		return list == null ? null : list;
	}

	private static List<BookTypeModel> convertoModels(ResultSet rs) {
		List<BookTypeModel> list = new ArrayList<>();
		try {
			while (rs.next()) {
				list.add(new BookTypeModel(rs.getString("name"), rs.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list == null ? null : list;

	}
}
