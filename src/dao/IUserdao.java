package dao;

import java.util.ArrayList;

import model.user.Car;
import model.user.RentRecord;
import model.user.User;

public interface IUserdao {

	/**
	 * �û���¼
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);

	/**
	 * �û�ע��
	 * 
	 * @param user
	 */
	public void registe(User user);

	/**
	 * �û��鿴�ϼ�������Ϣ ȫ���ϼܼ����ݼ۸񡢳��͡�Ʒ��
	 * 
	 * @return
	 */
	public ArrayList<Car> queryAllCar();

	/**
	 * �۸�
	 * 
	 * @return
	 */
	public ArrayList<Car> queryByRentAsc();

	public ArrayList<Car> queryByRentDesc();

	/**
	 * ��������
	 * 
	 * @param model
	 * @return
	 */
	public ArrayList<Car> queryByModel(String model);

	/**
	 * ���ݳ���
	 * 
	 * @param category
	 * @return
	 */
	public ArrayList<Car> queryByCategory(String category);

	/**
	 * Ʒ��
	 * 
	 * @param Brand
	 * @return
	 */
	public ArrayList<Car> queryByBrand(String Brand);

	/**
	 * �û��鿴�Լ����⳵��¼
	 * 
	 * @param user
	 * @return
	 */
	public ArrayList<RentRecord> queryRecord(User user);
	public ArrayList<RentRecord> queryRecord(Integer userid,Integer carid);
	public RentRecord queryRecordByRecordId(Integer userid, Integer recordid) ;


	/**
	 * �û��⳵
	 * 
	 * @param userid
	 * @param carid
	 */
	

	public void RentCar(int userid, int carid);

	
	/**
	 * �û�����
	 * 
	 * @param userid
	 * @param carid
	 */
	public void returnCar(int userid, int recordid,int carid);

	

	


}
