package pp;

import java.io.*;
import java.net.*;

public class SocketServerT extends Thread {

	ServerSocket serverSocket;
	
	public SocketServerT(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(1000 * 30);
	}
	
	public void run()
	{
		while(true) {
			try {
				System.out.println("Waiting for client on port " +
			            serverSocket.getLocalPort() + "...");
				
				Socket ss = serverSocket.accept();
				System.out.println("Just connected to "
		                  + ss.getRemoteSocketAddress());
				
				DataInputStream in = new DataInputStream(ss.getInputStream());
				System.out.println(in.readUTF());
//				in.close();
				
				DataOutputStream out = new DataOutputStream(ss.getOutputStream());
				out.writeUTF("hi");
//				out.close();
				
				ss.close();
			}catch(SocketTimeoutException s) {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException ioe) {
				ioe.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		try{
			Thread t = new SocketServerT(port);
			t.start();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
