package ex;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(9999);

			System.out.println("서버 실행");

			Socket socket = serverSocket.accept();

			if (socket != null) {
				System.out.println("클라이언트 접속 완료");
			}

			DataInputStream din = new DataInputStream(socket.getInputStream());

			String msg = din.readUTF();

			System.out.println(msg);

			din.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
