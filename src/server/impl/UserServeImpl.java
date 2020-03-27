package server.impl;

import java.util.ArrayList;

import dao.IUserdao;
import dao.impl.UserdaoImpl;
import model.user.Car;
import model.user.RentRecord;
import model.user.User;
import server.IUserServe;
import utils.IdcardUtils;
import utils.RegUtils;

public class UserServeImpl implements IUserServe{
private UserdaoImpl userdao;


public IUserdao getUserdao() {
	return userdao;
}

public void setUserdao(UserdaoImpl userdao) {
	this.userdao = userdao;
}
public UserServeImpl(UserdaoImpl userdao) {
	super();
	this.userdao = userdao;
}

public UserServeImpl() {
	
}

@Override
public String toString() {
	return "UserServeImpl [userdao=" + userdao + "]";
}


	/**
	 *登录
	 */
	@Override
	public User login(String username, String password) {
		
		
		 User user = userdao.login(username, password);				
		
		return user;
	}
/**
 * 注册
 */
	@Override
	public boolean registe(User user) {
	
		        //1 先判断用户名是否被注册
				int i = userdao.getUserByName(user.getUsername());
				int j = userdao.getUserByIdnumber(user.getIdnumber());
				if(i>0){
					// 被注册
				System.out.println("用户名已经被注册!");
					return false;
				}else if(j>0){
					System.out.println("身份证已被注册!");
					return false;
				}else if(!RegUtils.isMoblie(user.getTel())){
					System.out.println("手机号不合法！");
					return false;
				}else if(!IdcardUtils.validateCard(user.getIdnumber())){
					System.out.println("身份证不合法！");
					return false;
				}
				
				else{
					// 可注册
					userdao.registe(user);	
					return true;
				}
		
	
	}



/**
 * 查询所有汽车
 */
	@Override
	public ArrayList<Car> queryAllCar() {
		ArrayList<Car> list = userdao.queryAllCar();
		return list;
	}
/**
 * 升序查询
 */
	@Override
	public ArrayList<Car> queryByRentAsc() {
		ArrayList<Car> list = userdao.queryByRentAsc();
		return list;
	}
/**
 * 降序查询
 */
	@Override
	public ArrayList<Car> queryByRentDesc() {
		ArrayList<Car> list = userdao.queryByRentDesc();
		return list;
	}
/**
 * 车型查询
 */
	@Override
	public ArrayList<Car> queryByModel(String model) {
		ArrayList<Car> queryAllCar = userdao.queryAllCar();
		ArrayList<Car> list=null;
		for (Car car : queryAllCar) {
			if(car.getModel().equals(model)){
				 list=  userdao.queryByModel(model);
							
			}else{
				System.out.println("请输入正确车型！");
				return null;
			}
		}
		return list;
	}
/**
 * 类型查询
 */
	@Override
	public ArrayList<Car> queryByCategory(String category) {
		ArrayList<Car> queryAllCar = userdao.queryAllCar();
		  ArrayList<String> list= new ArrayList<String>();
		  
		  for (Car car : queryAllCar) {
			  //if(car.getCategory().equals(category)){
				  list.add(car.getCategory());						
			  //}
		  }
		  
		  
		
		if(!list.contains(category)){
			System.out.println("暂无该类型的车辆！");
			return null;
		} else{
			ArrayList<Car> queryByCategory = userdao.queryByCategory(category);
			System.out.println("汽车id\t车牌号\t品牌\t颜色\t类型\t备注信息\t\t价格\t\t租金\t租赁状态\t上架状态\t车型");
			for (Car car : queryByCategory) {
				System.out.println(car);
			}
			return null;
		
		}
		 
		
	}
	
/**
 * 品牌查询
 */
	@Override
	public ArrayList<Car> queryByBrand(String brand) {
		ArrayList<Car> queryAllCar = userdao.queryAllCar();
		  ArrayList<String> list= new ArrayList<String>();
		  
		  for (Car car : queryAllCar) {
			  //if(car.getBrand().equals(brand)){
				  list.add(car.getBrand());						
			  //}
		  }
		  
		  
		  
		if(!list.contains(brand.trim())){
			System.out.println("请输入正确品牌！");
			return null;
		} else{
		 ArrayList<Car> queryByBrand = userdao.queryByBrand(brand.trim());
			System.out.println("汽车id\t车牌号\t品牌\t颜色\t类型\t备注信息\t\t价格\t\t租金\t租赁状态\t上架状态\t车型");
		for (Car car : queryByBrand) {
			System.out.println(car);
		}
		return null;
		}
	}
/**
 * 查询当前用户的所有租赁记录
 */
	@Override
	public ArrayList<RentRecord> queryRecord(User user) {
		ArrayList<RentRecord> list = userdao.queryRecord(user);
		return list;
	}
/**
 * 租车
 */
	@Override
	public void rentCar(int userid, int carid) {
		ArrayList<Car> queryAllCar = userdao.queryAllCar();
		int flag=0;
		for (Car car : queryAllCar) {
			if(car.getId()==carid){
				flag=1;
				break;
			}
		}
		if(flag==1){
			userdao.RentCar(userid, carid);
			System.out.println("租车成功！即时开始计费");
			}else{			
			System.out.println("该车不存在 或 已经被租用！");
			}
		}
		
	
/**
 * 还车
 */
	@Override
	public void returnCar(int userid, int recordid1) {
		boolean flag=true;
		RentRecord rentRecord = userdao.queryRecordByRecordId(userid, recordid1);
		if(rentRecord==null){
			System.out.println("请输入正确的记录编号！");
		}else{
				
				if(rentRecord.getId()==recordid1&&rentRecord.getPayment()>=0){
					userdao.returnCar(userid, recordid1,rentRecord.getCarid());			
					System.out.println("还车成功！");
					RentRecord record = userdao.queryRecordByRecordId(userid, recordid1);
					System.out.println("支付金额："+record.getPayment());
					
				}else{
					
					System.out.println("出现错误 ，还车失败！");
				}				
			
		}
	}

}
