package controller;

import java.util.ArrayList;

import dao.impl.AdmindaoImpl;
import model.admin.Admin;
import model.user.Car;
import model.user.RentRecord;
import server.impl.AdminServeImpl;

/**
 * @author WXZ
 *
 */
public class AdminAction {
private AdminServeImpl admin;





@Override
public String toString() {
	return "AdminAction [admin=" + admin + "]";
}


public AdminServeImpl getAdmin() {
	return admin;
}


public void setAdmin(AdminServeImpl admin) {
	this.admin = admin;
}


public AdminAction() {
	init();
}


public AdminAction(AdminServeImpl admin) {
	super();
	this.admin = admin;
}





/**管理员登录
 * @param username
 * @param password
 * @return
 */
public Admin login(String username, String password) {
	Admin login = admin.login(username, password);
	return login;
}


/**查看所有汽车信息
 * @return
 */
public ArrayList<Car> queryAllCar() {
	ArrayList<Car> list = admin.queryAllCar();
	return list;
}


/**
 * @param id
 * @return
 */
public ArrayList<Car> queryByCarId(int id) {
	ArrayList<Car> list = admin.queryByCarId(id);
	return list;
}

/**
 * 添加汽车
 * @param car
 * @return
 */
public boolean addCar(Car car) {
	return admin.addCar(car);
	
}

/**
 * 修改汽车租金
 * @param carid
 * @param rent
 */
public void updateCarRent(int carid, Double rent) {
	admin.updateCarRent(carid, rent);
}

/**
 * 修改汽车状态
 * @param carid
 * @param status
 */
public void updateCarGrouding(int carid, int status) {
	admin.updateCarGrouding(carid, status);
	
}

/**
 * 查询所有记录
 * @return
 */
public ArrayList<RentRecord> queryAllRecord() {
	ArrayList<RentRecord> list = admin.queryAllRecord();
	return list;
}

/**
 * 通过userid 查询
 * @param userid
 * @return
 */
public ArrayList<RentRecord> queryRecordByUserId(int userid) {
	ArrayList<RentRecord> list = admin.queryRecordByUserId(userid);
	return list;
}

/**
 * 通过carid 查询
 * @param carid
 * @return
 */
public ArrayList<RentRecord> queryRecordByCarId(int carid) {
	ArrayList<RentRecord> list = admin.queryRecordByCarId(carid);
	return list;
}
/**
 * 初始数据
 */
public void init(){
	AdmindaoImpl admindao = new AdmindaoImpl();
	AdminServeImpl adminServe = new AdminServeImpl();
	this.admin=adminServe;
	adminServe.setAdmindao(admindao);
}


}
