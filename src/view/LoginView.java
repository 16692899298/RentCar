package view;

import java.util.Scanner;

import controller.AdminAction;
import controller.UserAction;
import model.admin.Admin;
import model.user.User;

public class LoginView {
	
	
public User userlogin(){
	System.out.println("-------�û���½ҳ��-------");
	Scanner sc=new Scanner(System.in);
	while(true){
	System.out.println("�������û�����");
	
	String name = sc.nextLine().trim();
	System.out.println("����������:");
//	Console con = System.console();
//	char[] password = con.readPassword();
//	String pwd= new String(password);
	
	String pwd = sc.nextLine().trim();	
	User login = new UserAction().login(name, pwd);
	if(login != null && login.getUsername()!=null){
		System.out.println("��½�ɹ�����ӭ"+name+"!");
		return login;
		
	}else{
		System.out.println("��½ʧ�ܣ�");
		
	}
	}
}
	public void adminlogin(){
		System.out.println("-------����Ա��½ҳ��-------");
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("�������û�����");
		String name = sc.nextLine().trim();
		System.out.println("���������룺");
		String pwd= sc.nextLine().trim();
		Admin login = new AdminAction().login(name, pwd);
		if(login != null && login.getUsername()!=null){
			if(login.getType()==1){
			System.out.println("��½�ɹ���");
			new AdminView().queryCarView();
			break;
			}
			else{
				System.out.println("�ǹ���Ա�û����޷���¼");
			}
		}else{
			System.out.println("�û�����������󣬵�½ʧ�ܣ�");
				
		}
		}
	}
}
