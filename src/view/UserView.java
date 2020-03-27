package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.UserAction;
import model.user.Car;
import model.user.RentRecord;
import model.user.User;
import utils.StringCaseUtil;

/**
 * @author WXZ
 *
 */

public class UserView {
	

public void UView(){
	
		Scanner sc=new Scanner(System.in);
		UserAction user=new UserAction();
		User userlogin=null;
		while(true){
		System.out.println("1,ע�� 2,��¼ 3,����������");
		String next2 = sc.nextLine();
		if(next2.equals("1")){
			new RegisteView().registe();
			break;
		}else if(next2.equals("2")){
		    userlogin = new LoginView().userlogin();
			break;
		}else if(next2.equals("3")){
			Main.start();
		}else{
			System.out.println("��������");
		}
		}
		
	int i=0;
	loop:while(i<1){
		System.out.println(
				  "1,�鿴��������\n"
				+ "2,��������������\n"
				+ "3,������������\n"
				+ "4,����������\n"
				+ "5,����Ʒ�Ʋ���\n"
				+ "6,�⳵\n"
				+ "7,�鿴�����⳵��¼\n"
				+ "8,���� \n"
				+ "9,�˳�"
				);
		
	String toint = sc.next();
	switch(toint){
	case "1":
		ArrayList<Car> list = user.queryAllCar();
		System.out.println("-------��ѯ����-------");

		System.out.println("����id\t���ƺ�\tƷ��\t��ɫ\t����\t��ע��Ϣ\t\t�۸�\t\t���\t����״̬\t�ϼ�״̬\t����");
		for (Car car : list) {
			System.out.println(car);
		}
		break;
	case"2":
		ArrayList<Car> list1 =user.queryByRentAsc();
		System.out.println("-------�����ѯ-------");
		System.out.println("����id\t���ƺ�\tƷ��\t��ɫ\t����\t��ע��Ϣ\t\t�۸�\t\t���\t����״̬\t�ϼ�״̬\t����");
		for (Car car : list1) {
			System.out.println(car);
		}
		
		
		break;
	case "3":
		ArrayList<Car> list2 = user.queryByRentDesc();
		System.out.println("-------�����ѯ-------");
		System.out.println("����id\t���ƺ�\tƷ��\t��ɫ\t����\t��ע��Ϣ\t\t�۸�\t\t���\t����״̬\t�ϼ�״̬\t����");

		for (Car car : list2) {
			System.out.println(car);
		}
		break;
	case "4":
		System.out.println("��ǰ�ɲ�ѯ���������:");
		System.out.println("������\t������\tSUV\t��Ӣ��");
		System.out.println("���������");
		sc.nextLine();
		String category = sc.nextLine();
		 user.queryByCategory(category);
		break;
	case "5":
		System.out.println("��ǰ�ɲ�ѯ����Ʒ���У� ");
		System.out.println("����\t����\t�µ�\t����\t����");
		System.out.println("������Ʒ�ƣ�");
		sc.nextLine();
		String brand = sc.nextLine();
		user.queryByBrand(brand);

		
		break;
	case"6": 
		while(true){
		System.out.println("������Ҫ��ĳ�id");
		sc.nextLine();
		String s = sc.nextLine();
		if(StringCaseUtil.Toint(s)){
			Integer carid= Integer.parseInt(s);
		user.queryRecord(userlogin);
		user.rentCar(userlogin.getId(), carid);
		break;
		}
		}
		break;
	case "7": 
		ArrayList<RentRecord> record = user.queryRecord(userlogin);
		if(record.size()==0){
			System.out.println("����û������أ�����һ�����԰ɣ�");
			continue;
		}
		System.out.println("--------��ǰ���޼�¼--------");
		System.out.println("�������\t����id\t�û�id\t�û�����\t����\t���\t֧�����\t��ע��Ϣ\t\tƷ��\t�ͺ�\t�⳵ʱ��\t\t����ʱ��");
		for (RentRecord rentRecord : record) {
			System.out.println(rentRecord);
		}
		break;	
	case "8":  
		while(true){
		System.out.println("����Ҫ���Ķ������");
		sc.nextLine();
		String s = sc.nextLine();
    	if(StringCaseUtil.Toint(s)){
    		Integer recordid1=Integer.parseInt(s);
    	user.returnCar(userlogin.getId(), recordid1);
    	break;
    	}
		}
    	break;
		
	case "9":	
		i=1;
		break loop;
	
	default:
		System.out.println("��������������ѡ��");
	}
	}
}	
	
}	
	
	
//	
//	loop:while(true){
//	System.out.println("1,�⳵ ,2,�鿴�����⳵��¼3,���� 4,�˳�");
//			//+ "5,������ҳ��");
//	String next = sc.next();
//	Integer toint = StringCaseUtil.Toint(next);
//	if(toint==null){
//		System.out.println("������ַ��Ƿ���");
//	}
//	switch(toint){
//	case 1:
//		System.out.println("������Ҫ��ĳ�id");
//		Integer carid = Integer.parseInt(sc.next());
//		user.queryRecord(userlogin);
//		user.rentCar(userlogin.getId(), carid);
//		
//		
//		break;
//    case 2:		
//		ArrayList<RentRecord> record = user.queryRecord(userlogin);
//		if(record.size()==0){
//			System.out.println("����û������أ�����һ�����԰ɣ�");
//			continue;
//		}
//		System.out.println("�������\t����id\t�û�id\t�û�����\t����\t���\t֧�����\t��ע��Ϣ\t\tƷ��\t�ͺ�\t�⳵ʱ��\t����ʱ��");
//		for (RentRecord rentRecord : record) {
//			System.out.println(rentRecord);
//		}
//	break;
//    case 3:
//    	System.out.println("����Ҫ���Ķ������");
//    	Integer recordid1 = Integer.parseInt(sc.next());
//    	user.returnCar(userlogin.getId(), recordid1);
//    	break;
//    case 4:
//    	break loop;
////    case 5:
////    	Main.start();
////    	break;
//    default:
//    	System.out.println("��������ȷ�ķ�����");
//	}
//}
//
//} 
//}
