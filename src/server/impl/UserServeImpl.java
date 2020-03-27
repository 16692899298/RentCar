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
	 *��¼
	 */
	@Override
	public User login(String username, String password) {
		
		
		 User user = userdao.login(username, password);				
		
		return user;
	}
/**
 * ע��
 */
	@Override
	public boolean registe(User user) {
	
		        //1 ���ж��û����Ƿ�ע��
				int i = userdao.getUserByName(user.getUsername());
				int j = userdao.getUserByIdnumber(user.getIdnumber());
				if(i>0){
					// ��ע��
				System.out.println("�û����Ѿ���ע��!");
					return false;
				}else if(j>0){
					System.out.println("���֤�ѱ�ע��!");
					return false;
				}else if(!RegUtils.isMoblie(user.getTel())){
					System.out.println("�ֻ��Ų��Ϸ���");
					return false;
				}else if(!IdcardUtils.validateCard(user.getIdnumber())){
					System.out.println("���֤���Ϸ���");
					return false;
				}
				
				else{
					// ��ע��
					userdao.registe(user);	
					return true;
				}
		
	
	}



/**
 * ��ѯ��������
 */
	@Override
	public ArrayList<Car> queryAllCar() {
		ArrayList<Car> list = userdao.queryAllCar();
		return list;
	}
/**
 * �����ѯ
 */
	@Override
	public ArrayList<Car> queryByRentAsc() {
		ArrayList<Car> list = userdao.queryByRentAsc();
		return list;
	}
/**
 * �����ѯ
 */
	@Override
	public ArrayList<Car> queryByRentDesc() {
		ArrayList<Car> list = userdao.queryByRentDesc();
		return list;
	}
/**
 * ���Ͳ�ѯ
 */
	@Override
	public ArrayList<Car> queryByModel(String model) {
		ArrayList<Car> queryAllCar = userdao.queryAllCar();
		ArrayList<Car> list=null;
		for (Car car : queryAllCar) {
			if(car.getModel().equals(model)){
				 list=  userdao.queryByModel(model);
							
			}else{
				System.out.println("��������ȷ���ͣ�");
				return null;
			}
		}
		return list;
	}
/**
 * ���Ͳ�ѯ
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
			System.out.println("���޸����͵ĳ�����");
			return null;
		} else{
			ArrayList<Car> queryByCategory = userdao.queryByCategory(category);
			System.out.println("����id\t���ƺ�\tƷ��\t��ɫ\t����\t��ע��Ϣ\t\t�۸�\t\t���\t����״̬\t�ϼ�״̬\t����");
			for (Car car : queryByCategory) {
				System.out.println(car);
			}
			return null;
		
		}
		 
		
	}
	
/**
 * Ʒ�Ʋ�ѯ
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
			System.out.println("��������ȷƷ�ƣ�");
			return null;
		} else{
		 ArrayList<Car> queryByBrand = userdao.queryByBrand(brand.trim());
			System.out.println("����id\t���ƺ�\tƷ��\t��ɫ\t����\t��ע��Ϣ\t\t�۸�\t\t���\t����״̬\t�ϼ�״̬\t����");
		for (Car car : queryByBrand) {
			System.out.println(car);
		}
		return null;
		}
	}
/**
 * ��ѯ��ǰ�û����������޼�¼
 */
	@Override
	public ArrayList<RentRecord> queryRecord(User user) {
		ArrayList<RentRecord> list = userdao.queryRecord(user);
		return list;
	}
/**
 * �⳵
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
			System.out.println("�⳵�ɹ�����ʱ��ʼ�Ʒ�");
			}else{			
			System.out.println("�ó������� �� �Ѿ������ã�");
			}
		}
		
	
/**
 * ����
 */
	@Override
	public void returnCar(int userid, int recordid1) {
		boolean flag=true;
		RentRecord rentRecord = userdao.queryRecordByRecordId(userid, recordid1);
		if(rentRecord==null){
			System.out.println("��������ȷ�ļ�¼��ţ�");
		}else{
				
				if(rentRecord.getId()==recordid1&&rentRecord.getPayment()>=0){
					userdao.returnCar(userid, recordid1,rentRecord.getCarid());			
					System.out.println("�����ɹ���");
					RentRecord record = userdao.queryRecordByRecordId(userid, recordid1);
					System.out.println("֧����"+record.getPayment());
					
				}else{
					
					System.out.println("���ִ��� ������ʧ�ܣ�");
				}				
			
		}
	}

}
