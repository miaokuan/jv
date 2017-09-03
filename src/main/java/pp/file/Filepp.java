package pp.file;

import java.io.*;

public class Filepp {

    public static String read(String filename) throws IOException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader bfr = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();
        String str;
        while((str = bfr.readLine()) != null) {
            sb.append(str + "\n");
        }
        bfr.close();
        return sb.toString();
    }

    public static void write(String filename, String str) throws IOException{
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(str);
        bfw.close();
    }

    public static void main(String[] args) throws Exception {
        String str = "im content";
        String filename = "test.txt";
        write(filename, str);

        String b = read(filename);
        System.out.println(b);
    }
}
