package utils;

import java.util.Date;

public class ViewSet {
public static String  tocase(int i) {
	if(i==0){
		return "ÊÇ";	
	}else{
		return"·ñ";
	}
}
public static String  tocase(Date string) {
	if(string==null){
		return "×âÓÃÖĞ";	
	}else{
		return string.toString();
	}
	
}






}
