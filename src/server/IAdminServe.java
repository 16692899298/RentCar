package server;

import java.util.ArrayList;

import model.admin.Admin;
import model.user.Car;
import model.user.RentRecord;

public interface IAdminServe {
	public Admin login(String username,String password);
	 
	   /**����Ա�鿴����������Ϣ
	 * @return
	 */
	public ArrayList<Car> queryAllCar();
	   
	   /**����Ա�鿴ָ��������Ϣ
	 * @param id
	 * @return
	 */
	public ArrayList<Car> queryByCarId(int id);
	  
	   /**
	 * �������
	 * @return 
	 */
	public boolean addCar(Car car);

	   
	   /**�޸����޼۸�
	 * @param carid
	 * @param rent
	 */
	public void updateCarRent(int carid,Double rent);
	   
	   /**�޸��Ƿ��ϼ�
	 * @param carid
	 * @param status
	 */
	   public void updateCarGrouding(int carid,int status);
	   //�鿴�������޼�¼��Ϣ
	   public ArrayList<RentRecord> queryAllRecord();
	   //�����û���Ų�ѯ
	   public ArrayList<RentRecord> queryRecordByUserId(int userid);
	   //����������Ų�ѯ
	   public ArrayList<RentRecord> queryRecordByCarId(int carid);


	   
	
}
