package pp;

public class ThreadDemo extends Thread {

	public static void main(String[] args) {
		Runnable ra = new ThreadRunable();
		Thread tra = new Thread(ra, "thread by runnable");
		tra.start();
		
		Thread te = new ThreadExtend();
		te.start();
		
		try{
			for(int i=0;i<10;i++) {
				System.out.println("main thread " + i);
				Thread.sleep(50);
			}
		}catch (InterruptedException e) {
			System.out.println("main thread interrupted");	
			
		}
		
		System.out.println("main Thread end");
	}
}
