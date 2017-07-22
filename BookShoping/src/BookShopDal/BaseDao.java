package BookShopDal;

import java.io.IOException;
import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseDao {

	private static final String DRIVER;
	private static final String USERNAME;
	private static final String PASSWORD;
	private static final String CONNSTR;
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	static {
		Properties p = new Properties();

		try {
			p.load(BaseDao.class.getClassLoader().getResourceAsStream("jdb.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DRIVER = p.getProperty("driver");
		USERNAME = p.getProperty("userName");
		PASSWORD = p.getProperty("password");
		CONNSTR = p.getProperty("connStr");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(CONNSTR,USERNAME,PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;

	}

	public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
		if (ps == null) {
			if (conn == null) {
				conn = getConnection();
			}
			try {
				ps = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ps;
	}

	private static void doPreparedStatement(Object... objs) {
		
		
		for (int i = 0; i < objs.length; i++) {
			if (objs[i] instanceof Date) {
				try {
					ps.setObject(i + 1, new SimpleDateFormat("yyyy-MM-dd").format(objs[i]));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					ps.setObject(i + 1, objs[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean excuteUpdate(String sql, Object... objs) {
		
		try {
			getPreparedStatement(sql);
			doPreparedStatement(objs);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet excuteQuery(String sql, Object... objs) {
		
		if (ps == null) {
			try {
				ps = getPreparedStatement(sql);
				doPreparedStatement(objs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs == null ? null : rs;
	}

	public static void close() {
		if (rs != null) {
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
				ps=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
