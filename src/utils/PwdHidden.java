package utils;

import java.io.Console;
import java.util.Scanner;

public class PwdHidden {
	
//	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
//		System.out.println("1");
//		Console console = System.console();
//		String password ;	
//		password = new String(console.readPassword(sc.next()));
//		System.out.println("password="+password);
//		 public static void main(String[] args){
//		        System.out.print("����������:");
//		        //Console con = System.console();
//		        String pswd = new String(System.console().readPassword());//��Ϊ��ȡ�����ַ�����,������Ҫ��new String()�����ַ�����ת���ַ���  
//		        System.out.println("��ո������������"+pswd);  
//		    }  
	
		 public static void main(String[] args){
		  Console console;
		  char[] pwd;
		  if((console = System.console()) != null && (pwd = console.readPassword("[%s]", "Please Enter Password:")) != null){
		   System.out.println(String.valueOf(pwd));
		  }
		 }
		}
	
	
	
	
		
	//}
	

