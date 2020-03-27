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
		System.out.println("1,注册 2,登录 3,返回主界面");
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
			System.out.println("输入有误！");
		}
		}
		
	int i=0;
	loop:while(i<1){
		System.out.println(
				  "1,查看所有汽车\n"
				+ "2,按照租金升序查找\n"
				+ "3,按照租金降序查找\n"
				+ "4,按照类别查找\n"
				+ "5,按照品牌查找\n"
				+ "6,租车\n"
				+ "7,查看本人租车记录\n"
				+ "8,还车 \n"
				+ "9,退出"
				);
		
	String toint = sc.next();
	switch(toint){
	case "1":
		ArrayList<Car> list = user.queryAllCar();
		System.out.println("-------查询所有-------");

		System.out.println("汽车id\t车牌号\t品牌\t颜色\t类型\t备注信息\t\t价格\t\t租金\t租赁状态\t上架状态\t车型");
		for (Car car : list) {
			System.out.println(car);
		}
		break;
	case"2":
		ArrayList<Car> list1 =user.queryByRentAsc();
		System.out.println("-------升序查询-------");
		System.out.println("汽车id\t车牌号\t品牌\t颜色\t类型\t备注信息\t\t价格\t\t租金\t租赁状态\t上架状态\t车型");
		for (Car car : list1) {
			System.out.println(car);
		}
		
		
		break;
	case "3":
		ArrayList<Car> list2 = user.queryByRentDesc();
		System.out.println("-------降序查询-------");
		System.out.println("汽车id\t车牌号\t品牌\t颜色\t类型\t备注信息\t\t价格\t\t租金\t租赁状态\t上架状态\t车型");

		for (Car car : list2) {
			System.out.println(car);
		}
		break;
	case "4":
		System.out.println("当前可查询汽车类别有:");
		System.out.println("紧凑型\t舒适型\tSUV\t精英型");
		System.out.println("请输入类别：");
		sc.nextLine();
		String category = sc.nextLine();
		 user.queryByCategory(category);
		break;
	case "5":
		System.out.println("当前可查询汽车品牌有： ");
		System.out.println("标致\t大众\t奥迪\t奔驰\t宝马");
		System.out.println("请输入品牌：");
		sc.nextLine();
		String brand = sc.nextLine();
		user.queryByBrand(brand);

		
		break;
	case"6": 
		while(true){
		System.out.println("请输入要租的车id");
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
			System.out.println("您还没租过车呢！快租一辆试试吧！");
			continue;
		}
		System.out.println("--------当前租赁记录--------");
		System.out.println("订单编号\t汽车id\t用户id\t用户姓名\t车型\t租金\t支付金额\t备注信息\t\t品牌\t型号\t租车时间\t\t还车时间");
		for (RentRecord rentRecord : record) {
			System.out.println(rentRecord);
		}
		break;	
	case "8":  
		while(true){
		System.out.println("输入要还的订单编号");
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
		System.out.println("输入有误，请重新选择！");
	}
	}
}	
	
}	
	
	
//	
//	loop:while(true){
//	System.out.println("1,租车 ,2,查看本人租车记录3,还车 4,退出");
//			//+ "5,返回主页面");
//	String next = sc.next();
//	Integer toint = StringCaseUtil.Toint(next);
//	if(toint==null){
//		System.out.println("输入的字符非法！");
//	}
//	switch(toint){
//	case 1:
//		System.out.println("请输入要租的车id");
//		Integer carid = Integer.parseInt(sc.next());
//		user.queryRecord(userlogin);
//		user.rentCar(userlogin.getId(), carid);
//		
//		
//		break;
//    case 2:		
//		ArrayList<RentRecord> record = user.queryRecord(userlogin);
//		if(record.size()==0){
//			System.out.println("您还没租过车呢！快租一辆试试吧！");
//			continue;
//		}
//		System.out.println("订单编号\t汽车id\t用户id\t用户姓名\t车型\t租金\t支付金额\t备注信息\t\t品牌\t型号\t租车时间\t还车时间");
//		for (RentRecord rentRecord : record) {
//			System.out.println(rentRecord);
//		}
//	break;
//    case 3:
//    	System.out.println("输入要还的订单编号");
//    	Integer recordid1 = Integer.parseInt(sc.next());
//    	user.returnCar(userlogin.getId(), recordid1);
//    	break;
//    case 4:
//    	break loop;
////    case 5:
////    	Main.start();
////    	break;
//    default:
//    	System.out.println("请输入正确的服务编号");
//	}
//}
//
//} 
//}
