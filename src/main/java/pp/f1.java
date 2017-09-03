package pp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f1 {
	public static void main(String []args) {

		String value = "abc def hig abc hig abc";
	      StringTokenizer itr = new StringTokenizer(value.toString());
	      while (itr.hasMoreTokens()) {
	        String word = itr.nextToken();
	        
	        System.out.println(word);
	      }
		
		
		Date date = new Date();
		String df = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(df);
		String ds = sdf.format(date);
		System.out.println(ds);
		
		
		System.out.println("hello f1");
		
		//Character
		Character ch = new Character('a');
		ch = Character.toUpperCase(ch);
		System.out.println(ch);
		
		//String
		String str = "abc";
		str = "123".concat(str);
		str = "456" + str;
		int len = str.length();
		System.out.println(len);
		
		//StringBuilder StringBuffer
		StringBuilder sb = new StringBuilder("abc");
		sb.append("deef");
		sb.reverse();
		System.out.println(sb.capacity());
		
		//array
		int[] intArr = {12,23,45,34};
		for(int x:intArr) {
			System.out.println(x);
		}
		
		int[] rev = reverse(intArr);
		for(int x :rev) {
			System.out.println(x);
		}
		
		// date
//		date();
		
		//regex
		regexMatches();
		
		// max
		int max = max(12,12234,6565,2323);
		System.out.println(max);
	}
	
	public static int max(int... numbers) {
		if (numbers.length < 1) {
			return -1;
		}
		
		int result = numbers[0];
		for(int i=1;i<numbers.length;i++) {
			if (numbers[i] > result) {
				result = numbers[i];
			}
		}
		
		return result;
	}
	
	public static void regexMatches() {
		String str = "abc word 123 afc";
		String regex = "(.*?)(\\d+)(.*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		if(matcher.find()) {
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
		}
	}
	
	public static void date() {
		Date dt = new Date();
		System.out.println(dt.toString());
		
		try {
			Thread.sleep(1000 * 3);
			dt = new Date();
			System.out.println(dt.toString());
		} catch (Exception e) {
			System.out.println("catch an exception");
		}
	}
	
	public static int[] reverse(int[] arr) {
		int size = arr.length;
		int[] ch = new int[size];
		for(int i=0, j = arr.length-1;i<size;i++, j--) {
//			int j = size - i - 1;
			ch[j] = arr[i];
		}
		
		return ch;
	}
}
