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





/**����Ա��¼
 * @param username
 * @param password
 * @return
 */
public Admin login(String username, String password) {
	Admin login = admin.login(username, password);
	return login;
}


/**�鿴����������Ϣ
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
 * �������
 * @param car
 * @return
 */
public boolean addCar(Car car) {
	return admin.addCar(car);
	
}

/**
 * �޸��������
 * @param carid
 * @param rent
 */
public void updateCarRent(int carid, Double rent) {
	admin.updateCarRent(carid, rent);
}

/**
 * �޸�����״̬
 * @param carid
 * @param status
 */
public void updateCarGrouding(int carid, int status) {
	admin.updateCarGrouding(carid, status);
	
}

/**
 * ��ѯ���м�¼
 * @return
 */
public ArrayList<RentRecord> queryAllRecord() {
	ArrayList<RentRecord> list = admin.queryAllRecord();
	return list;
}

/**
 * ͨ��userid ��ѯ
 * @param userid
 * @return
 */
public ArrayList<RentRecord> queryRecordByUserId(int userid) {
	ArrayList<RentRecord> list = admin.queryRecordByUserId(userid);
	return list;
}

/**
 * ͨ��carid ��ѯ
 * @param carid
 * @return
 */
public ArrayList<RentRecord> queryRecordByCarId(int carid) {
	ArrayList<RentRecord> list = admin.queryRecordByCarId(carid);
	return list;
}
/**
 * ��ʼ����
 */
public void init(){
	AdmindaoImpl admindao = new AdmindaoImpl();
	AdminServeImpl adminServe = new AdminServeImpl();
	this.admin=adminServe;
	adminServe.setAdmindao(admindao);
}


}
