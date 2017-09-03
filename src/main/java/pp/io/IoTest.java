package pp;

import java.io.*;

public class IoTest {

	public static void main(String[] args) {
		
		try {
//			brRead();
			file();
		} catch (IOException ioe) {
			System.out.println("io exception");
		}
		mkdir();
		dirlist();
	}
	
	/**
	 * read from stdin
	 * @throws IOException
	 */
	public static void brRead() throws IOException {
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("input some character, 'q' to exit");
		
		do {
			c = (char) br.read();
			System.out.println(c);
		} while (c != 'q');
	}
	
	/**
	 * file write and read
	 * @throws IOException
	 */
	public static void file() throws IOException {
		File f =  new File("/tmp/jvt");
		
		// write
		FileOutputStream fop = new FileOutputStream(f);
		OutputStreamWriter writer = new OutputStreamWriter(fop, "utf-8");
		writer.append("我是中午"+'\n');
		writer.append("im english");
		writer.close();
		fop.close();
		
		// read
		FileInputStream fip = new FileInputStream(f);
		InputStreamReader reader = new InputStreamReader(fip, "utf-8");
		
		StringBuffer sb = new StringBuffer();
		
		while(reader.ready()) {
			sb.append((char) reader.read());
		}
		
		System.out.println(sb.toString());
		
		reader.close();
		fip.close();
	}
	
	public static void mkdir() {
		String d = "/tmp/jvdir";
		File f = new File(d);
		f.mkdirs();
	}
	
	public static void dirlist() {
		String dirname = "/tmp/";
		File f = new File(dirname);
		if (f.isDirectory()) {
			String[] s = f.list();
			for(String i:s) {
				File tf = new File(dirname + i);
				if (tf.isDirectory()) {
					System.out.println(i + " is a directory");
				} else {
					System.out.println(i + " is a file");
				}
			}
		} else {
			System.out.println(dirname + "is a file");
		}
	}
}
