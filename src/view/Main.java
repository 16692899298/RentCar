package view;

import java.util.Scanner;

/**
 * @author WXZ
 *租车页面主视图
 */
public class Main {

	public static  void start() {
	System.out.println("=====================");
	System.out.println("   欢迎来到二嗨租车！  ");
	System.out.println("=====================");
	while(true){
	System.out.println("1,用户 2,管理员,3,退出");
	Scanner sc= new Scanner(System.in);
	String next = sc.next().trim();
	if("1".equals(next)){
	new UserView().UView();
		
	}else if("2".equals(next)){
		new LoginView().adminlogin();
		
	}else if("3".equals(next)){
		System.out.println("欢迎下次再来！");
		System.exit(0);
	}
	else{
	System.out.println("请选择适合的身份");	
	}
	}
	}
	
	//411522199305633125
	public static void main(String[] args) {
		try {
			start();
		} catch (Exception e) {
			start();
		}
	}
	
	
}
