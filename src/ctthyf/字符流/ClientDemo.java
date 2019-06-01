package ctthyf.字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ClientDemo {
public static void main(String[] args) throws IOException  {
	Socket s=new Socket("192.168.123.97",65500);
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	//读写键盘录入数据
	String line=null;
	while((line=br.readLine())!=null) {
		if(line.equalsIgnoreCase("exit")) {
			break;
		}
		bw.write(line);
		bw.newLine();
		bw.flush();
	}

	
	s.close();
}
}
