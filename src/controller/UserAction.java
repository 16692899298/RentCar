package controller;

import java.util.ArrayList;

import dao.impl.UserdaoImpl;
import model.user.Car;
import model.user.RentRecord;
import model.user.User;
import server.IUserServe;
import server.impl.UserServeImpl;

public class UserAction {
private IUserServe userserve;
/**
 * ��¼
 * @param username
 * @param password
 * @return
 */
public User login(String username, String password){
	return userserve.login(username, password);	
}

/**
 * ע��
 * @param user
 * @return
 */
public boolean registe(User user){
	
	return userserve.registe(user);
}

/**
 * ��ѯ�������������
 * @return
 */
public ArrayList<Car> queryAllCar() {
	ArrayList<Car> list = userserve.queryAllCar();
	return list;
}

/**
 * �����ѯ
 * @return
 */
public ArrayList<Car> queryByRentAsc() {
	ArrayList<Car> list = userserve.queryByRentAsc();
	return list;
}

/**
 *�����ѯ 
 */
public ArrayList<Car> queryByRentDesc() {
	ArrayList<Car> list = userserve.queryByRentDesc();
	return list;
}

/**
 * model��ѯ
 * @param model
 * @return
 */
public ArrayList<Car> queryByModel(String model) {
	ArrayList<Car> list = userserve.queryByModel(model);
	return list;
}

/**
 * ����
 * @param category
 * @return
 */
public ArrayList<Car> queryByCategory(String category) {
	ArrayList<Car> list = userserve.queryByCategory(category);
	return list;
}

/**
 * Ʒ��
 * @param brand
 * @return
 */
public ArrayList<Car> queryByBrand(String brand) {
	ArrayList<Car> list = userserve.queryByBrand(brand);
	return list;
}

/**
 * ��ѯ�Լ����⳵��¼
 * @param user
 * @return
 */
public ArrayList<RentRecord> queryRecord(User user) {
	ArrayList<RentRecord> list = userserve.queryRecord(user);
	return list;
}

/**
 * �⳵
 * @param userid
 * @param carid
 */
public void rentCar(int userid, int carid) {
	userserve.rentCar(userid, carid);
	
}

/**
 * ����
 * @param userid
 * @param recordid1
 */
public void returnCar(int userid, int recordid1) {
	userserve.returnCar(userid, recordid1);
	
}



public IUserServe getUserserve() {
	return userserve;
}

public void setUserserve(IUserServe userserve) {
	this.userserve = userserve;
}

public UserAction(IUserServe userserve) {
	super();
	this.userserve = userserve;
}

public UserAction() {
	init();
}
/**
 * ��ʼ������
 */
public void init(){
	UserdaoImpl userdao = new UserdaoImpl();
	UserServeImpl userServe = new UserServeImpl();
	this.userserve=userServe;
	userServe.setUserdao(userdao);
}
@Override
public String toString() {
	return "UserAction [userserve=" + userserve + "]";
}

}
