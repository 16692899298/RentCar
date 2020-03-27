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
 * 登录
 * @param username
 * @param password
 * @return
 */
public User login(String username, String password){
	return userserve.login(username, password);	
}

/**
 * 注册
 * @param user
 * @return
 */
public boolean registe(User user){
	
	return userserve.registe(user);
}

/**
 * 查询可租的所有汽车
 * @return
 */
public ArrayList<Car> queryAllCar() {
	ArrayList<Car> list = userserve.queryAllCar();
	return list;
}

/**
 * 升序查询
 * @return
 */
public ArrayList<Car> queryByRentAsc() {
	ArrayList<Car> list = userserve.queryByRentAsc();
	return list;
}

/**
 *降序查询 
 */
public ArrayList<Car> queryByRentDesc() {
	ArrayList<Car> list = userserve.queryByRentDesc();
	return list;
}

/**
 * model查询
 * @param model
 * @return
 */
public ArrayList<Car> queryByModel(String model) {
	ArrayList<Car> list = userserve.queryByModel(model);
	return list;
}

/**
 * 类型
 * @param category
 * @return
 */
public ArrayList<Car> queryByCategory(String category) {
	ArrayList<Car> list = userserve.queryByCategory(category);
	return list;
}

/**
 * 品牌
 * @param brand
 * @return
 */
public ArrayList<Car> queryByBrand(String brand) {
	ArrayList<Car> list = userserve.queryByBrand(brand);
	return list;
}

/**
 * 查询自己的租车记录
 * @param user
 * @return
 */
public ArrayList<RentRecord> queryRecord(User user) {
	ArrayList<RentRecord> list = userserve.queryRecord(user);
	return list;
}

/**
 * 租车
 * @param userid
 * @param carid
 */
public void rentCar(int userid, int carid) {
	userserve.rentCar(userid, carid);
	
}

/**
 * 还车
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
 * 初始化数据
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
