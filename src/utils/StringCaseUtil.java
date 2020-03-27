package utils;

/**
 * @author WXZ
 *字符串处理
 */
public class StringCaseUtil {

	public  static boolean Toint(String string){	
    
         if (!string.matches("^\\s*(\\+|-)?([0-9]|[1-9][0-9]*)\\s*$")) 
         {
            System.out.println("请输入合理字符！");
            return false;
         }
         else{
          //int i = Integer.parseInt(string.trim());
          return true;	
         }

	}       
        
	public static boolean Todouble(String string) {

		if (!string.matches("^[0-9]*+(.[0-9]{1,2})?$")) {
			System.out.println("字符不合法！");
			return false;
		} else {
			//, Double i = Double.parseDouble(string.trim());
			return true;
		}
	}
	public static void main(String[] args) {
	String s= "23";
	System.out.println(Todouble(s));
	
	}
	
	
}