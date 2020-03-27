package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ���������ļ����������ݿ�
 * @author MG
 *
 */
public class Jdbc {
	static private String driver;
	static private String url;
	static private String uname;
	static private String upassword;
	
	static{	//���������ļ�
		Properties pro = new Properties();
		try {
			pro.load(Jdbc.class.getResourceAsStream("Jdbc_Config.properties"));
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			uname = pro.getProperty("uname");
			upassword = pro.getProperty("upassword");
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/**
	 * LinkBase ���ҷ������ݿ����Ӷ���
	 * @return ���ݿ����
	 */
	static public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver); //���ڲ������ݿ������ĺϷ���
			conn = DriverManager.getConnection(url, uname, upassword);
		} catch (ClassNotFoundException | SQLException e) {
			//e.printStackTrace();
		}
		try {
			conn.setAutoCommit(false);	//���Զ��ύ����
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return conn;
	}
	
//	static public void main(String[] args){
//		System.out.println(Jdbc.getConnection());
//	}
}
