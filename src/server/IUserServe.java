package server;

import java.util.ArrayList;

import model.user.Car;
import model.user.RentRecord;
import model.user.User;

/**
 * @author WXZ
 *�����
 */
public interface IUserServe {
public User login(String username, String password);//��¼
public boolean registe(User user);//ע��


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

/**
 * �û��⳵
 * 
 * @param userid
 * @param carid
 */
public void rentCar(int userid, int carid);

/**
 * �û�����
 * 
 * @param userid
 * @param carid
 */
public void returnCar(int userid, int carid);

}
