package utils;

/**
 * @author WXZ
 *�ַ�������
 */
public class StringCaseUtil {

	public  static boolean Toint(String string){	
    
         if (!string.matches("^\\s*(\\+|-)?([0-9]|[1-9][0-9]*)\\s*$")) 
         {
            System.out.println("����������ַ���");
            return false;
         }
         else{
          //int i = Integer.parseInt(string.trim());
          return true;	
         }

	}       
        
	public static boolean Todouble(String string) {

		if (!string.matches("^[0-9]*+(.[0-9]{1,2})?$")) {
			System.out.println("�ַ����Ϸ���");
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