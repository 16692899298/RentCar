package utils;

import java.sql.ResultSet;


public interface ResultSetHandler {
	/**
	 * 处理结果集
	 * @param rs
	 */
	public void handlerRS(ResultSet rs);
}
