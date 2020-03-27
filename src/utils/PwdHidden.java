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
//		        System.out.print("请输入密码:");
//		        //Console con = System.console();
//		        String pswd = new String(System.console().readPassword());//因为读取的是字符数组,所以需要用new String()来把字符数组转成字符串  
//		        System.out.println("你刚刚输入的密码是"+pswd);  
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
	

