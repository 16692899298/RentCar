package utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetnetTime {
	 /*
     * ��ȡ��ǰ����ʱ��
     */
    public static Date getNetworkTime() {
    	Date date=null;
        try {
        	//��ȡ��վʱ��
            URL url=new URL("https://www.baidu.com");
            URLConnection conn=url.openConnection();
            conn.connect();
            long dateL=conn.getDate();
            date=new Date(dateL);
//���������� �����������뷵��sql��Date�������޸ķ����ķ�������
//������������Ŀǰ��ȡ��������ʱ��util.Dateת����sql.Date�Ĳ������£�
// ����������  java.sql.Date date1=new java.sql.Date(date.getTime());//�� �� ��
// ���������� java.sql.Time date2=new java.sql.Time(date.getTime());//ʱ   ��    ��
// ����������java.sql.Timestamp date3=new java.sql.Timestamp(date.getTime());
//           ��  �� ��  ʱ  ��   �� ����
// ��������      System.out.println("�����ǰʱ��������"+date1);
//����������  System.out.println("�����ǰʱ��ʱ����"+date2);
//������������System.out.println("�����ǰʱ��������ʱ�������"+date3);


//�������������������ǽ�ʱ��ת����String���Ͳ�����
            SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm");
           // return dateFormat.format(date);����string
            //return date;
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return date;
		
       
    }
    //����
    public static void main(String[] args) {
    	System.out.println(getNetworkTime());
	}
    
}
