package utils;

import java.util.Date;

public class ViewSet {
public static String  tocase(int i) {
	if(i==0){
		return "��";	
	}else{
		return"��";
	}
}
public static String  tocase(Date string) {
	if(string==null){
		return "������";	
	}else{
		return string.toString();
	}
	
}






}
