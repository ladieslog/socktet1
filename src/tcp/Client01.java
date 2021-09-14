package tcp;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {
	public static void main(String[] args) throws Exception {
		Socket sock=new Socket("localhost",12345);
		
		OutputStream out= sock.getOutputStream();
		System.out.println("수 입력");
		int num = new Scanner(System.in).nextInt();
		out.write(num);
		
		out.write(100); out.close(); sock.close();
	}
}
