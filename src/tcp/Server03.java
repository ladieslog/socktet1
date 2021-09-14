package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class UserThread extends Thread{
	Socket s;
	public UserThread(Socket s) {
		this.s=s;
		System.out.println(s.getInetAddress()+"님이 접속했습니다.");
		start();
	}
	public void run() {
		InputStream in;
		String readData= null;
		try {
			in = s.getInputStream();
			DataInputStream dis =new DataInputStream(in);
			readData =dis.readUTF(); 	//수신대기
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Server03 {
	public static void main(String[] args) throws Exception {
		ServerSocket server =new ServerSocket(12345);
		while(true) {
			System.out.println("접속을 기다립니다.");
			Socket s= server.accept();
			new UserThread(s);
		}
	}
}
