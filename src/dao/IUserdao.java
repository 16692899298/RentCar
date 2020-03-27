package dao;

import java.util.ArrayList;

import model.user.Car;
import model.user.RentRecord;
import model.user.User;

public interface IUserdao {

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);

	/**
	 * 用户注册
	 * 
	 * @param user
	 */
	public void registe(User user);

	/**
	 * 用户查看上架汽车信息 全部上架及根据价格、车型、品牌
	 * 
	 * @return
	 */
	public ArrayList<Car> queryAllCar();

	/**
	 * 价格
	 * 
	 * @return
	 */
	public ArrayList<Car> queryByRentAsc();

	public ArrayList<Car> queryByRentDesc();

	/**
	 * 根据名称
	 * 
	 * @param model
	 * @return
	 */
	public ArrayList<Car> queryByModel(String model);

	/**
	 * 根据车型
	 * 
	 * @param category
	 * @return
	 */
	public ArrayList<Car> queryByCategory(String category);

	/**
	 * 品牌
	 * 
	 * @param Brand
	 * @return
	 */
	public ArrayList<Car> queryByBrand(String Brand);

	/**
	 * 用户查看自己的租车记录
	 * 
	 * @param user
	 * @return
	 */
	public ArrayList<RentRecord> queryRecord(User user);
	public ArrayList<RentRecord> queryRecord(Integer userid,Integer carid);
	public RentRecord queryRecordByRecordId(Integer userid, Integer recordid) ;


	/**
	 * 用户租车
	 * 
	 * @param userid
	 * @param carid
	 */
	

	public void RentCar(int userid, int carid);

	
	/**
	 * 用户还车
	 * 
	 * @param userid
	 * @param carid
	 */
	public void returnCar(int userid, int recordid,int carid);

	

	


}
