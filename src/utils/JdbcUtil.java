package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;



/**
 * @author WXZ JDBC的驱动加载，与连接 通用的增删改查
 */

public class JdbcUtil {
	private static String user; // 用户名
	private static String password; // 密码
	private static String driver; // 驱动
	private static String url; // 连接字符串

	static {
		try {
			// 0.加载配置文件
			InputStream stream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pro = new Properties();
			pro.load(stream);
			JdbcUtil.user = pro.getProperty("user");
			JdbcUtil.password = pro.getProperty("password");
			JdbcUtil.driver = pro.getProperty("driver");
			JdbcUtil.url = pro.getProperty("url");
			// 1.加载驱动
			Class.forName(driver);
			// System.out.println("Oracle驱动加载完成。。。。。");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	// 2.连接数据库
	
	public static Connection getConn() {

		Connection conn = null;
		try {
			// 获取到数据库连接
			conn = DriverManager.getConnection(url, user, password);
			 System.out.println("已连接到"+conn+"...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 3.关闭数据库的连接
	public static void close(Connection conn, ResultSet res, Statement ps) {
		try {
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
						// System.out.println("关闭数据库连接");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 模板通用查询
	 * @param sql        传入的查询语句
	 * @param parameter  查询语句当中的参数
	 * @param handler    返回的结果集
	 * @return 
	 */	
	
	public static void query(String sql, PreparedStatementParameter parameter,
			ResultSetHandler handler) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 通过数据库连接，执行sql语句
			ps = getConn().prepareStatement(sql);
			// 是否有参数，如果有，则执行
			if (parameter != null) {
				parameter.setValues(ps);
			}
			// 执行数据库查询语句
			rs  = ps.executeQuery();
			// 处理结果集
			if (handler != null) {
				handler.handlerRS(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		} finally {
			close(null, rs, ps);
		}
	}

	/**
	 * 模板通用添删改
	 * @param sql       传入的查询语句
	 * @param parameter 查询语句当中的参数
	 * @return
	 */
	public static int updateAll(String sql, PreparedStatementParameter parameter) {
		int row = 0;
		PreparedStatement ps = null;
		try {
			// 通过数据库连接，执行sql语句
			ps = getConn().prepareStatement(sql);
			// 是否有参数，如果有，则执行
			if (parameter != null) {
				parameter.setValues(ps);
			}
			// 执行数据库修改语句
			row = ps.executeUpdate();// 添删改操作都会返回受影响的行数
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, null, ps);
		}
		return row;
	}

}
