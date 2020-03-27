package dao;

import java.util.ArrayList;

import model.admin.Admin;
import model.user.Car;
import model.user.RentRecord;
import model.user.User;

/**
 * @author WXZ
 *管理员
 */
public interface IAdmindao {
  
   /**管理员登录
 * @param username
 * @param password
 * @return
 */
public Admin login(String username,String password);
 
   /**管理员查看所有汽车信息
 * @return
 */
public ArrayList<Car> queryAllCar();
   
   /**管理员查看指定汽车信息
 * @param id
 * @return
 */
public ArrayList<Car> queryByCarId(int id);
  
   /**
 * 添加汽车
 */
public void addCar(Car car);

   
   /**修改租赁价格
 * @param carid
 * @param rent
 */
public void updateCarRent(int carid,Double rent);
   
   /**修改是否上架
 * @param carid
 * @param status
 */
public void updateCarGrouding(int carid,int status);
   //查看所有租赁记录信息
   public ArrayList<RentRecord> queryAllRecord();
   //按照用户编号查询
   public ArrayList<RentRecord> queryRecordByUserId(int userid);
   //按照汽车编号查询
   public ArrayList<RentRecord> queryRecordByCarId(int carid);


   
}
