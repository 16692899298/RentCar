package view;

import java.util.Scanner;

/**
 * @author WXZ
 *�⳵ҳ������ͼ
 */
public class Main {

	public static  void start() {
	System.out.println("=====================");
	System.out.println("   ��ӭ���������⳵��  ");
	System.out.println("=====================");
	while(true){
	System.out.println("1,�û� 2,����Ա,3,�˳�");
	Scanner sc= new Scanner(System.in);
	String next = sc.next().trim();
	if("1".equals(next)){
	new UserView().UView();
		
	}else if("2".equals(next)){
		new LoginView().adminlogin();
		
	}else if("3".equals(next)){
		System.out.println("��ӭ�´�������");
		System.exit(0);
	}
	else{
	System.out.println("��ѡ���ʺϵ����");	
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
