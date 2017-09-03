package pp;

public class GenericsT {

	/**
	 * 泛型方法
你可以写一个泛型方法，该方法在调用时可以接收不同类型的参数。根据传递给泛型方法的参数类型，编译器适当地处理每一个方法调用。
下面是定义泛型方法的规则：
所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。
每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。

	 * @param arr
	 */
	public static < E > void printArray(E[] arr) {
		for(E e:arr) {
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		String [] sarr = {"abc","sdf","fwef"};
		Integer [] intArr = {12,34,65};
		Double [] darr = {12.4,434.5,232.34};
		
		printArray(sarr);
		printArray(intArr);
		printArray(darr);
		
		String m = max(sarr);
		System.out.println("max string:"+m);
		
		int im = max(intArr);
		System.out.println("max int:"+im);
		
		double dm = max(darr);
		System.out.println("max double:"+dm);
	}
	
	/**
	 * 有界的类型参数:
可能有时候，你会想限制那些被允许传递到一个类型参数的类型种类范围。例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
	 * @param args
	 * @return
	 */
	public static < T extends Comparable<T> > T max(T... args) {
		T max = args[0];
		for(int i=1;i<args.length;i++) {
			if (args[i].compareTo(max) > 0) {
				max = args[i];
			}
		}
		return max;
	}
}
