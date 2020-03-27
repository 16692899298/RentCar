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
		System.out.println("--------欢迎来到汽车管理界面！-----------");
		Scanner sc = new Scanner(System.in);
		AdminAction admin = new AdminAction();
		while (true) {
		System.out.println(
				          " 1,查询所有汽车信息\n" 
						+ " 2,根据指定编号查看汽车信息\n" 
						+ " 3,添加汽车\n" 
						+ " 4,修改汽车信息\n" 
						+ " 5,查看所有用户全部租赁记录\n"
						+ " 6,查看指定用户租赁记录\n" 
						+ " 7,查看指定汽车租赁记录\n"
						+ " 8,回到主界面" );
			String toint = sc.nextLine();
			switch (toint) {
			case "1":
				ArrayList<Car> queryAllCar = admin.queryAllCar();
				System.out.println("--------查询所有汽车--------");
				System.out.println("编号\t品牌\t车牌号\t类型\t颜色\t型号\t车型\t价格\t\t租金\t是否可租\t是否可用");
				for (Car car : queryAllCar) {
					System.out.println(car.getId()+"\t"+car.getBrand()+"\t"+car.getCarnumber()+"\t"+
				                     car.getCategory()+"\t"+car.getColor()+"\t"+
							car.getComments()+"\t"+car.getModel()+"\t"+car.getPrice()+"\t"+car.getRent()+"\t"+ViewSet.tocase(car.getStatus())+"\t"+ViewSet.tocase(car.getUseable()));
				}
				break;
			case "2":
				while(true){
				System.out.println("请输入完整汽车编号：");
				String string = sc.nextLine();
				if(StringCaseUtil.Toint(string)){
					Integer carid=Integer.parseInt(string);
				
				ArrayList<Car> list = admin.queryByCarId(carid);
				
				System.out.println("编号\t品牌\t车牌号\t类型\t颜色\t型号\t车型\t价格\t\t租金\t是否可租\t是否可用");
				for (Car car : list) {
					System.out.println(car);
				}
				}
				break;
				
			}
				break;
			case "3":
				System.out.println("请按照提示输入完整汽车信息：");
				Car newcar = new Car();
				while(true){
				System.out.println("车牌号:");
				String carnumber = sc.nextLine();
				if(carnumber.length()<=10){
				newcar.setCarnumber(carnumber);
				break;
				}else{
					System.out.println("车牌号长度不能超过10位！");
				}
				}
				System.out.println("当前可添加品牌:\n" + "品牌编号  品牌名\n" + "1       标志" + "\n" + "2       大众" + "\n"
						+ "3       奥迪" + "\n" + "4       奔驰" + "\n" + "5       宝马");
				while(true){
				System.out.println("请选择合适的品牌编号:");
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
				System.out.println("请输入该车型号：");
				String model = sc.nextLine();
				if(model.length()<=40){
				newcar.setModel(model);
				break;
				} else{
					System.out.println("字符长度超过限制");
				}
				}
				while(true){
				System.out.println("颜色:");
				String color = sc.nextLine();
				if(color.length()<=20){
				newcar.setColor(color);
				break;
				}else{
					System.out.println("字符长度超过限制");
				}
				}
				System.out.println("类型如下:\n" + "类型编号  类型名" + "\n" + "1       紧凑型" + "\n" + "2       舒适型" + "\n"
						+ "3       SUV" + "\n" + "4       精英型");
				
				while(true){
					System.out.println("请选择正确的类型编号:");
					String s = sc.nextLine();
					if((s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4"))){
					  if(StringCaseUtil.Toint(s)){
					  int cateid =Integer.parseInt(s);
					  newcar.setCategoryid(cateid);
					  break;
					  }
					}else{
						System.out.println("输入错误!");
					}
					}
				
				while(true){
				System.out.println("请输入备注信息：");
				String comments = sc.nextLine();
				if(comments.length()<=100){
				newcar.setComments(comments);
				break;
				}else{
					System.out.println("字符长度超过限制");
				}
				}
				while(true){
				System.out.println("请输入售价：");
				String next3 = sc.nextLine();
				if(StringCaseUtil.Todouble(next3)&& next3.length()<=14){
				Double price =Double.parseDouble(next3);
				newcar.setPrice(price);
				break;
				}
				}
				while(true){
				System.out.println("请输入租金：");
				String next4 = sc.nextLine();
				
			    if(StringCaseUtil.Todouble(next4)&& next4.length()<=11){
				Double rent =Double.parseDouble(next4);
				newcar.setRent(rent);
				break;
				}
				}
				
				
				while(true){
					System.out.println("请选择是否可租 ：0,可租  1,否");
					
					String next4 = sc.nextLine();
					if((next4.equals("0")||next4.equals("1"))){
				    if(StringCaseUtil.Toint(next4)){
				    	Integer status=Integer.parseInt(next4);
				    	newcar.setStatus(status);
					break;
					}else{
						System.out.println("输入错误!!");
					}
				    }
					}
				
				
				
				
				while(true){
					
					System.out.println("请选择是否上架：0,上架   1,下架");
					
					String next4 = sc.nextLine();
					if((next4.equals("0")||next4.equals("1"))){
				    if(StringCaseUtil.Toint(next4)){
				    	Integer useable=Integer.parseInt(next4);
				    	newcar.setUseable(useable);
					break;
					}
					}else{
						System.out.println("输入错误!");
					}
					
					}
				
				admin.addCar(newcar);
				break;
			case "4":
				while (true) {
					System.out.println("请选择修改类型：1,修改租金 2,修改上架状态");
					String next = sc.nextLine();
					System.out.println("-----当前可修改汽车信息------");
					ArrayList<Car> list2 = admin.queryAllCar();
					System.out.println("汽车id\t车牌号\t品牌\t颜色\t类型\t备注信息\t\t价格\t\t租金\t租赁状态\t上架状态\t车型");

					for (Car car : list2) {
						System.out.println(car);
					}
					if (next.equals("1")) {
						Integer newid= null;
						while(true){
						System.out.println("请输入修改车的id：");
						String next3 = sc.nextLine();
						if(StringCaseUtil.Toint(next3)){
						newid =Integer.parseInt(next3.trim());
						break;
						}			
						}
						// 判断id
						while(true){
						System.out.println("请输入修改车的租金：");
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
							System.out.println("请输入修改车的id：");
						
							String next1= sc.nextLine();
							
						    if(StringCaseUtil.Toint(next1)){
						    	 newid=Integer.parseInt(next1);
						    	System.out.println(newid);
							break;
							}
							}
						while(true){
						System.out.println("0,上架，1,下架");
						String next2 = sc.nextLine();
						if(next2.equals("0")||next2.equals("1")){
						Integer newstatus =Integer.parseInt(next2) ;
						admin.updateCarGrouding(newid, newstatus);
						break;
						}else{
							System.out.println("请选择正确的服务编号");
						}
                       }
						break;
					} 
					else {
						System.out.println("请选择正确的服务编号");
					}
					
				}
				break;
				case "5":
				ArrayList<RentRecord> list2 = admin.queryAllRecord();
				System.out.println("订单编号\t汽车id\t用户id\t用户姓名\t车型\t租金\t支付金额\t备注信息\t\t品牌\t型号\t租车时间\t\t还车时间");

				for (RentRecord rentRecord : list2) {
					System.out.println(rentRecord);
				}
				break;
			case "6":
				while(true){
				System.out.println("请输入用户id");
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
				System.out.println("请输入汽车id");				
				String next = sc.nextLine();
				if(StringCaseUtil.Toint(next)){
				Integer carid1 = Integer.parseInt(next);
				ArrayList<RentRecord> list3 = admin.queryRecordByCarId(carid1);
				System.out.println("订单编号\t汽车id\t用户id\t用户姓名\t车型\t租金\t支付金额\t备注信息\t\t品牌\t型号\t租车时间\t\t还车时间");

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
				System.out.println("请输入合理选项！");
			}

		}
	}
}
