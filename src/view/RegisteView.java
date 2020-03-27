package view;

import java.util.Scanner;

import controller.UserAction;
import model.user.User;
import utils.RegUtils;

public class RegisteView {

public void registe(){
	Scanner scan = new Scanner(System.in);
	UserAction action = new UserAction();
	String username =null;
	while(true){
	while(true){
	System.out.println("请输入账号:");
	String uname =scan.nextLine();
	if(uname.length()<=40&&uname.length()>0){
	username =uname ;
	break;
	}else{
		System.out.println("长度不符合要求");
	}
	}
	String pwd=null;
	while(true){
	System.out.println("请输入密码:");
	String password = scan.nextLine();
	if(password.length()<=20&&password.length()>0){
	 pwd =password ;
	 break;
	}else{
		System.out.println("长度超过限制");
	}
	}
	String sex = null;
	while (true) {
		System.out.println("性别:0、女 , 1、男");
		sex = scan.nextLine();
		if ("0".equals(sex) || "1".equals(sex)) {
			break;
		}else{
			System.out.println("性别错误，重新选择！");
		}
	}
	System.out.println("身份证号码:");
	String idnumber = scan.nextLine();
	
	System.out.println("电话号码:");
	String tel = scan.nextLine();
    
	String addr=null;
	while(true){
	System.out.println("地址:");
	String addres = scan.nextLine();
	if(addres.length()<=100&&addres.length()>0){
		addr=addres;
		break;
	}else{
		System.out.println("长度不符合要求！");
	}
	}
	User user = new User(null, username, pwd, new Integer(sex), idnumber, tel, addr, 0);
	boolean register = action.registe(user);
	if (register) {
		System.out.println("恭喜你注册成功!");
		new UserView().UView();
	break;
	
	} else {
		System.out.println("注册失败!");
		//new UserView().UView();
	}
}
	return;
	}
}
