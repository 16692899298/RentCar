package dao;

import java.util.ArrayList;

import model.admin.Admin;
import model.user.Car;
import model.user.RentRecord;
import model.user.User;

/**
 * @author WXZ
 *����Ա
 */
public interface IAdmindao {
  
   /**����Ա��¼
 * @param username
 * @param password
 * @return
 */
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
 */
public void addCar(Car car);

   
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
