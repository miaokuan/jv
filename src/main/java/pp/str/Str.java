package pp.str;

public class Str {

    public static String substr(String str, int start, int length) {
        if(start > str.length()) {
            return "";
        }

        int pos = Integer.min(str.length(), start + length);
        return str.substring(start, pos);

    }

    public static void main(String[] args) {
        String str = "abcdef";

        System.out.println(substr(str, 1,2));
        System.out.println(substr(str, 1,20));
        System.out.println(substr(str, 10,20));
    }
}
