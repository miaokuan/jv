package pp.io;

//: Redirecting.java
//Demonstrates the use of redirection for
//standard IO in Java 1.1
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

class IORedirect {
	public static void main(String[] args) {
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("IORedirect.java"));
			// Produces deprecation message:
			PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
			System.setIn(in);
			System.setOut(out);
			System.setErr(out);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while ((s = br.readLine()) != null)
				System.out.println(s);
			out.close(); // Remember this!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} /// :~