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
	System.out.println("�������˺�:");
	String uname =scan.nextLine();
	if(uname.length()<=40&&uname.length()>0){
	username =uname ;
	break;
	}else{
		System.out.println("���Ȳ�����Ҫ��");
	}
	}
	String pwd=null;
	while(true){
	System.out.println("����������:");
	String password = scan.nextLine();
	if(password.length()<=20&&password.length()>0){
	 pwd =password ;
	 break;
	}else{
		System.out.println("���ȳ�������");
	}
	}
	String sex = null;
	while (true) {
		System.out.println("�Ա�:0��Ů , 1����");
		sex = scan.nextLine();
		if ("0".equals(sex) || "1".equals(sex)) {
			break;
		}else{
			System.out.println("�Ա��������ѡ��");
		}
	}
	System.out.println("���֤����:");
	String idnumber = scan.nextLine();
	
	System.out.println("�绰����:");
	String tel = scan.nextLine();
    
	String addr=null;
	while(true){
	System.out.println("��ַ:");
	String addres = scan.nextLine();
	if(addres.length()<=100&&addres.length()>0){
		addr=addres;
		break;
	}else{
		System.out.println("���Ȳ�����Ҫ��");
	}
	}
	User user = new User(null, username, pwd, new Integer(sex), idnumber, tel, addr, 0);
	boolean register = action.registe(user);
	if (register) {
		System.out.println("��ϲ��ע��ɹ�!");
		new UserView().UView();
	break;
	
	} else {
		System.out.println("ע��ʧ��!");
		//new UserView().UView();
	}
}
	return;
	}
}
