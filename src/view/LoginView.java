package view;

import java.util.Scanner;

import controller.AdminAction;
import controller.UserAction;
import model.admin.Admin;
import model.user.User;

public class LoginView {
	
	
public User userlogin(){
	System.out.println("-------用户登陆页面-------");
	Scanner sc=new Scanner(System.in);
	while(true){
	System.out.println("请输入用户名：");
	
	String name = sc.nextLine().trim();
	System.out.println("请输入密码:");
//	Console con = System.console();
//	char[] password = con.readPassword();
//	String pwd= new String(password);
	
	String pwd = sc.nextLine().trim();	
	User login = new UserAction().login(name, pwd);
	if(login != null && login.getUsername()!=null){
		System.out.println("登陆成功！欢迎"+name+"!");
		return login;
		
	}else{
		System.out.println("登陆失败！");
		
	}
	}
}
	public void adminlogin(){
		System.out.println("-------管理员登陆页面-------");
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("请输入用户名：");
		String name = sc.nextLine().trim();
		System.out.println("请输入密码：");
		String pwd= sc.nextLine().trim();
		Admin login = new AdminAction().login(name, pwd);
		if(login != null && login.getUsername()!=null){
			if(login.getType()==1){
			System.out.println("登陆成功！");
			new AdminView().queryCarView();
			break;
			}
			else{
				System.out.println("非管理员用户，无法登录");
			}
		}else{
			System.out.println("用户名或密码错误，登陆失败！");
				
		}
		}
	}
}
