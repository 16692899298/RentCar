package server;

import java.util.ArrayList;

import model.user.Car;
import model.user.RentRecord;
import model.user.User;

/**
 * @author WXZ
 *服务层
 */
public interface IUserServe {
public User login(String username, String password);//登录
public boolean registe(User user);//注册


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

/**
 * 用户租车
 * 
 * @param userid
 * @param carid
 */
public void rentCar(int userid, int carid);

/**
 * 用户还车
 * 
 * @param userid
 * @param carid
 */
public void returnCar(int userid, int carid);

}
