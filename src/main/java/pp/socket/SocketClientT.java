package pp;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class SocketClientT {

	public static void main(String[] args) {
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		System.out.println("Connecting to " + host
                + " on port " + port);
		
		try{
			Socket client = new Socket(host, port);
			System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());
			
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			out.writeUTF("Hello from "
                    + client.getLocalSocketAddress());
			
			DataInputStream in = new DataInputStream(client.getInputStream());
			
			System.out.print("server say:"+in.readUTF());
			client.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}
