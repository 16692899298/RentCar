package server.impl;

import java.util.ArrayList;
import dao.impl.AdmindaoImpl;
import model.admin.Admin;
import model.user.Car;
import model.user.RentRecord;
import server.IAdminServe;

/**
 * @author WXZ
 *
 */
public class AdminServeImpl implements IAdminServe {
	private AdmindaoImpl admindao;

	public AdmindaoImpl getAdmindao() {
		return admindao;
	}

	public void setAdmindao(AdmindaoImpl admindao) {
		this.admindao = admindao;
	}

	public AdminServeImpl(AdmindaoImpl admindao) {
		super();
		this.admindao = admindao;
	}

	public AdminServeImpl() {

	}

	
	@Override
	public Admin login(String username, String password) {
		Admin admin = admindao.login(username, password);
		return admin;
	}

	@Override
	public ArrayList<Car> queryAllCar() {
		
		ArrayList<Car> list = admindao.queryAllCar();
		
		return list;
	}

	@Override
	public ArrayList<Car> queryByCarId(int id) {
		if(admindao.queryByCarId(id).size()==0){
			System.out.println("该车不存在！");
			return null;
		}else{
		ArrayList<Car> list = admindao.queryByCarId(id);
		return list;
		}
	}

	@Override
	public boolean addCar(Car car) {
		ArrayList<Car> allCar = admindao.queryAllCar();
		
		boolean flag = true;
		for (Car car2 : allCar) {
			if (car2.getCarnumber().equals(car.getCarnumber())) {
				flag = false;	
				break;
			} 
		}	
		if(flag){
			System.out.println("添加成功！");
			admindao.addCar(car);
		}else{
		System.out.println("添加失败，车牌号已存在！");
		}
		return flag;

	}

	@Override
	public void updateCarRent(int carid, Double rent) {
		if(admindao.queryByCarId(carid).size()==0){
			System.out.println("该车不存在！");
			return;
		}
		else{
			boolean flag= true;
			ArrayList<Car> list = admindao.queryByCarId(carid);
			for (Car car : list) {
				if (car.getStatus()==1){
					flag=false;
				}
			}
		if(flag){
			admindao.updateCarRent(carid, rent);
			System.out.println("修改成功！");
		}else{
			System.out.println("该车已经被租了，无法更改！");
		}	
		
	}
	}

	@Override
	public void updateCarGrouding(int carid, int status) {
		int i=0;
		if(admindao.queryByCarId(carid).size()==0){
			System.out.println("该车不存在！");
			return;
		}
		else{
			ArrayList<Car> list = admindao.queryByCarId(carid);
			for (Car car : list) {
				if (car.getStatus()==1){
					i=1;
				}
			}
			if(i==0){
		admindao.updateCarGrouding(carid, status);
		System.out.println("已完成修改！");
		}else{
			System.out.println("该车已被租,当前无法修改");
		}
		}

	}

	@Override
	public ArrayList<RentRecord> queryAllRecord() {
		
		ArrayList<RentRecord> list = admindao.queryAllRecord();
		return list;
	}

	@Override
	public ArrayList<RentRecord> queryRecordByUserId(int userid) {
		if(admindao.queryByCarId(userid).size()==0){
			System.out.println("该用户不存在！");
			return null;
		}else{
		ArrayList<RentRecord> list = admindao.queryRecordByUserId(userid);
		return list;
		}
	}

	@Override
	public ArrayList<RentRecord> queryRecordByCarId(int carid) {
		if(admindao.queryByCarId(carid).size()==0){
			System.out.println("该车不存在！");
			return null;
		}else{
		ArrayList<RentRecord> list = admindao.queryRecordByCarId(carid);
		return list;
		}
	}

}
