package util;

import java.sql.PreparedStatement;

/**
 * SQL����������
 * @author MG
 */
public interface PreparedStatementSetter {
	/**
	 * ��Ӧ�������
	 * @param ps ������
	 */
	public void setvalues(PreparedStatement ps);
}
