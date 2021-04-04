package BaiTapJavaJava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost", 5000);
			System.out.println("client da ket noi cong server port 5000");
			Scanner scanner = new Scanner(System.in);
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Moi ban nhap ten sach:");
			String str = scanner.nextLine();
			dataOutputStream.writeUTF(str);
			
			String str2 = dataInputStream.readUTF();
			System.out.println("Ket qua tim kiem: \n" + str2);
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}