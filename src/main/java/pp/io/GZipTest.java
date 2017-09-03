package pp.io;

/**
 * 2017-09-02
 */

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipTest {

    public static void main(String[] args) throws Exception {
        String txtfile = "test.txt";
        String gzfile = "test.gz";

        gzip(gzfile, txtfile);
        gunzip(gzfile);
    }

    public static void gzip(String gzfile, String txtfile) throws Exception {
        BufferedReader bfr = new BufferedReader(new FileReader(txtfile));
        BufferedOutputStream writer = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(gzfile)));

        int c;
        while((c=bfr.read()) != -1) {
            writer.write(c);
        }

        bfr.close();
        writer.close();

    }

    public static void gunzip(String gzfile) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(gzfile))));
        String line;
        while((line = bfr.readLine()) != null) {
            System.out.println(line);
        }
        bfr.close();
    }
}
