package ctthyf.字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(65500);
		while(true) {
		Socket s=ss.accept();//阻塞式方法
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//历史记录
		BufferedWriter bw=new BufferedWriter(new FileWriter("src\\ctthyf\\字符流\\Log.txt",true));
		//时间戳
		Date d=new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM日dd日 HH：mm：ss");
		String date=sdf.format(d);
		bw.write(date);
		bw.newLine();
		bw.flush();
		//读数据写出来到log.txt
		String line=null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		s.close();
		}
	}
}
