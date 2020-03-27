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
 * @author WXZ JDBC���������أ������� ͨ�õ���ɾ�Ĳ�
 */

public class JdbcUtil {
	private static String user; // �û���
	private static String password; // ����
	private static String driver; // ����
	private static String url; // �����ַ���

	static {
		try {
			// 0.���������ļ�
			InputStream stream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pro = new Properties();
			pro.load(stream);
			JdbcUtil.user = pro.getProperty("user");
			JdbcUtil.password = pro.getProperty("password");
			JdbcUtil.driver = pro.getProperty("driver");
			JdbcUtil.url = pro.getProperty("url");
			// 1.��������
			Class.forName(driver);
			// System.out.println("Oracle����������ɡ���������");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	// 2.�������ݿ�
	
	public static Connection getConn() {

		Connection conn = null;
		try {
			// ��ȡ�����ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			 System.out.println("�����ӵ�"+conn+"...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 3.�ر����ݿ������
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
						// System.out.println("�ر����ݿ�����");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ģ��ͨ�ò�ѯ
	 * @param sql        ����Ĳ�ѯ���
	 * @param parameter  ��ѯ��䵱�еĲ���
	 * @param handler    ���صĽ����
	 * @return 
	 */	
	
	public static void query(String sql, PreparedStatementParameter parameter,
			ResultSetHandler handler) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// ͨ�����ݿ����ӣ�ִ��sql���
			ps = getConn().prepareStatement(sql);
			// �Ƿ��в���������У���ִ��
			if (parameter != null) {
				parameter.setValues(ps);
			}
			// ִ�����ݿ��ѯ���
			rs  = ps.executeQuery();
			// ��������
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
	 * ģ��ͨ����ɾ��
	 * @param sql       ����Ĳ�ѯ���
	 * @param parameter ��ѯ��䵱�еĲ���
	 * @return
	 */
	public static int updateAll(String sql, PreparedStatementParameter parameter) {
		int row = 0;
		PreparedStatement ps = null;
		try {
			// ͨ�����ݿ����ӣ�ִ��sql���
			ps = getConn().prepareStatement(sql);
			// �Ƿ��в���������У���ִ��
			if (parameter != null) {
				parameter.setValues(ps);
			}
			// ִ�����ݿ��޸����
			row = ps.executeUpdate();// ��ɾ�Ĳ������᷵����Ӱ�������
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, null, ps);
		}
		return row;
	}

}
