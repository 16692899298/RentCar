package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.AdminAction;
import model.user.Car;
import model.user.RentRecord;
import utils.StringCaseUtil;
import utils.ViewSet;

public class AdminView {

	public void queryCarView() {
		System.out.println("--------��ӭ��������������棡-----------");
		Scanner sc = new Scanner(System.in);
		AdminAction admin = new AdminAction();
		while (true) {
		System.out.println(
				          " 1,��ѯ����������Ϣ\n" 
						+ " 2,����ָ����Ų鿴������Ϣ\n" 
						+ " 3,�������\n" 
						+ " 4,�޸�������Ϣ\n" 
						+ " 5,�鿴�����û�ȫ�����޼�¼\n"
						+ " 6,�鿴ָ���û����޼�¼\n" 
						+ " 7,�鿴ָ���������޼�¼\n"
						+ " 8,�ص�������" );
			String toint = sc.nextLine();
			switch (toint) {
			case "1":
				ArrayList<Car> queryAllCar = admin.queryAllCar();
				System.out.println("--------��ѯ��������--------");
				System.out.println("���\tƷ��\t���ƺ�\t����\t��ɫ\t�ͺ�\t����\t�۸�\t\t���\t�Ƿ����\t�Ƿ����");
				for (Car car : queryAllCar) {
					System.out.println(car.getId()+"\t"+car.getBrand()+"\t"+car.getCarnumber()+"\t"+
				                     car.getCategory()+"\t"+car.getColor()+"\t"+
							car.getComments()+"\t"+car.getModel()+"\t"+car.getPrice()+"\t"+car.getRent()+"\t"+ViewSet.tocase(car.getStatus())+"\t"+ViewSet.tocase(car.getUseable()));
				}
				break;
			case "2":
				while(true){
				System.out.println("����������������ţ�");
				String string = sc.nextLine();
				if(StringCaseUtil.Toint(string)){
					Integer carid=Integer.parseInt(string);
				
				ArrayList<Car> list = admin.queryByCarId(carid);
				
				System.out.println("���\tƷ��\t���ƺ�\t����\t��ɫ\t�ͺ�\t����\t�۸�\t\t���\t�Ƿ����\t�Ƿ����");
				for (Car car : list) {
					System.out.println(car);
				}
				}
				break;
				
			}
				break;
			case "3":
				System.out.println("�밴����ʾ��������������Ϣ��");
				Car newcar = new Car();
				while(true){
				System.out.println("���ƺ�:");
				String carnumber = sc.nextLine();
				if(carnumber.length()<=10){
				newcar.setCarnumber(carnumber);
				break;
				}else{
					System.out.println("���ƺų��Ȳ��ܳ���10λ��");
				}
				}
				System.out.println("��ǰ�����Ʒ��:\n" + "Ʒ�Ʊ��  Ʒ����\n" + "1       ��־" + "\n" + "2       ����" + "\n"
						+ "3       �µ�" + "\n" + "4       ����" + "\n" + "5       ����");
				while(true){
				System.out.println("��ѡ����ʵ�Ʒ�Ʊ��:");
				String s = sc.nextLine();
				if((s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5"))){
				   if(StringCaseUtil.Toint(s)){
				   Integer brandid =Integer.parseInt(s);
				   newcar.setBrandid(brandid);
				   break;
				  }
				  }
				}
				while(true){
				System.out.println("������ó��ͺţ�");
				String model = sc.nextLine();
				if(model.length()<=40){
				newcar.setModel(model);
				break;
				} else{
					System.out.println("�ַ����ȳ�������");
				}
				}
				while(true){
				System.out.println("��ɫ:");
				String color = sc.nextLine();
				if(color.length()<=20){
				newcar.setColor(color);
				break;
				}else{
					System.out.println("�ַ����ȳ�������");
				}
				}
				System.out.println("��������:\n" + "���ͱ��  ������" + "\n" + "1       ������" + "\n" + "2       ������" + "\n"
						+ "3       SUV" + "\n" + "4       ��Ӣ��");
				
				while(true){
					System.out.println("��ѡ����ȷ�����ͱ��:");
					String s = sc.nextLine();
					if((s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4"))){
					  if(StringCaseUtil.Toint(s)){
					  int cateid =Integer.parseInt(s);
					  newcar.setCategoryid(cateid);
					  break;
					  }
					}else{
						System.out.println("�������!");
					}
					}
				
				while(true){
				System.out.println("�����뱸ע��Ϣ��");
				String comments = sc.nextLine();
				if(comments.length()<=100){
				newcar.setComments(comments);
				break;
				}else{
					System.out.println("�ַ����ȳ�������");
				}
				}
				while(true){
				System.out.println("�������ۼۣ�");
				String next3 = sc.nextLine();
				if(StringCaseUtil.Todouble(next3)&& next3.length()<=14){
				Double price =Double.parseDouble(next3);
				newcar.setPrice(price);
				break;
				}
				}
				while(true){
				System.out.println("���������");
				String next4 = sc.nextLine();
				
			    if(StringCaseUtil.Todouble(next4)&& next4.length()<=11){
				Double rent =Double.parseDouble(next4);
				newcar.setRent(rent);
				break;
				}
				}
				
				
				while(true){
					System.out.println("��ѡ���Ƿ���� ��0,����  1,��");
					
					String next4 = sc.nextLine();
					if((next4.equals("0")||next4.equals("1"))){
				    if(StringCaseUtil.Toint(next4)){
				    	Integer status=Integer.parseInt(next4);
				    	newcar.setStatus(status);
					break;
					}else{
						System.out.println("�������!!");
					}
				    }
					}
				
				
				
				
				while(true){
					
					System.out.println("��ѡ���Ƿ��ϼܣ�0,�ϼ�   1,�¼�");
					
					String next4 = sc.nextLine();
					if((next4.equals("0")||next4.equals("1"))){
				    if(StringCaseUtil.Toint(next4)){
				    	Integer useable=Integer.parseInt(next4);
				    	newcar.setUseable(useable);
					break;
					}
					}else{
						System.out.println("�������!");
					}
					
					}
				
				admin.addCar(newcar);
				break;
			case "4":
				while (true) {
					System.out.println("��ѡ���޸����ͣ�1,�޸���� 2,�޸��ϼ�״̬");
					String next = sc.nextLine();
					System.out.println("-----��ǰ���޸�������Ϣ------");
					ArrayList<Car> list2 = admin.queryAllCar();
					System.out.println("����id\t���ƺ�\tƷ��\t��ɫ\t����\t��ע��Ϣ\t\t�۸�\t\t���\t����״̬\t�ϼ�״̬\t����");

					for (Car car : list2) {
						System.out.println(car);
					}
					if (next.equals("1")) {
						Integer newid= null;
						while(true){
						System.out.println("�������޸ĳ���id��");
						String next3 = sc.nextLine();
						if(StringCaseUtil.Toint(next3)){
						newid =Integer.parseInt(next3.trim());
						break;
						}			
						}
						// �ж�id
						while(true){
						System.out.println("�������޸ĳ������");
						String next2 = sc.nextLine();
						if(StringCaseUtil.Todouble(next2.trim())&&next2.length()<=11){
						Double newrent =Double.parseDouble(next2); 
						admin.updateCarRent(newid, newrent);
						
						break;
						}
						}
						break;
						}
					 else if (next.equals("2")) {
						Integer newid =null;
						while(true){
							System.out.println("�������޸ĳ���id��");
						
							String next1= sc.nextLine();
							
						    if(StringCaseUtil.Toint(next1)){
						    	 newid=Integer.parseInt(next1);
						    	System.out.println(newid);
							break;
							}
							}
						while(true){
						System.out.println("0,�ϼܣ�1,�¼�");
						String next2 = sc.nextLine();
						if(next2.equals("0")||next2.equals("1")){
						Integer newstatus =Integer.parseInt(next2) ;
						admin.updateCarGrouding(newid, newstatus);
						break;
						}else{
							System.out.println("��ѡ����ȷ�ķ�����");
						}
                       }
						break;
					} 
					else {
						System.out.println("��ѡ����ȷ�ķ�����");
					}
					
				}
				break;
				case "5":
				ArrayList<RentRecord> list2 = admin.queryAllRecord();
				System.out.println("�������\t����id\t�û�id\t�û�����\t����\t���\t֧�����\t��ע��Ϣ\t\tƷ��\t�ͺ�\t�⳵ʱ��\t\t����ʱ��");

				for (RentRecord rentRecord : list2) {
					System.out.println(rentRecord);
				}
				break;
			case "6":
				while(true){
				System.out.println("�������û�id");
						String next = sc.nextLine();
				if(StringCaseUtil.Toint(next)){
				Integer userid = Integer.parseInt(next);
				ArrayList<RentRecord> queryRecordByUserId = admin.queryRecordByUserId(userid);			
				for (RentRecord rentRecord : queryRecordByUserId) {
					System.out.println(rentRecord);
				}
				break;
	    		}
				}
				break;
			case "7":
				while(true){
				System.out.println("����������id");				
				String next = sc.nextLine();
				if(StringCaseUtil.Toint(next)){
				Integer carid1 = Integer.parseInt(next);
				ArrayList<RentRecord> list3 = admin.queryRecordByCarId(carid1);
				System.out.println("�������\t����id\t�û�id\t�û�����\t����\t���\t֧�����\t��ע��Ϣ\t\tƷ��\t�ͺ�\t�⳵ʱ��\t\t����ʱ��");

				for (RentRecord rentRecord : list3) {
					System.out.println(rentRecord);
				}
				break;
			    }
				}
				break;
			case "8":
				Main.start();
				break;
			default:
				System.out.println("���������ѡ�");
			}

		}
	}
}
