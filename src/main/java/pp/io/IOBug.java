package pp.io;

//: IOBug.java
//Java 1.1 (and higher?) IO Bug
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class IOBug {
	public static void main(String[] args) throws Exception {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
		out.writeDouble(3.14159);
		out.writeBytes("That was the value of pi\n");
		out.writeBytes("This is pi/2:\n");
		out.writeDouble(3.14159 / 2);
		out.close();
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
		BufferedReader inbr = new BufferedReader(new InputStreamReader(in));
		// The doubles written BEFORE the line of text
		// read back correctly:
		System.out.println(in.readDouble());
		// Read the lines of text:
		System.out.println(inbr.readLine());
		System.out.println(inbr.readLine());
		// Trying to read the doubles after the line
		// produces an end-of-file exception:
		System.out.println(in.readDouble());
	}
} /// :~