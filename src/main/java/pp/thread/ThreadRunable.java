package pp;

public class ThreadRunable implements Runnable {

	public void run() {

		try{
			for(int i=0;i<10;i++) {
				System.out.println("child thread runuable " + i);
				Thread.sleep(30);
			}
		}catch (InterruptedException e) {
			System.out.println("child thread runuable interrupted");	
			
		}
		
		System.out.println("child Thread runuable end");
	}
}
