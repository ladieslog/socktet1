package tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) throws Exception {
		//자기자신의 아이피와 port (12345)로 서버 구동한다.
		//port : 2byte 크기를 가지고 있으며 , 특정프로그램 (어플리케이션)을 구분한다.
		ServerSocket server =new ServerSocket(12345);
		System.out.println("접속 대기합니다.");
		Socket sock= server.accept();
		System.out.println("접속 되었습니다.");
		System.out.println(sock.getInetAddress());
		InputStream input =sock.getInputStream();
		int readData =input.read();
		System.out.println("수신 데이터 : "+readData);
		input.close(); sock.close();
	}
}

