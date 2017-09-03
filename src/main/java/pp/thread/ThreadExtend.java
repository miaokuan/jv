package pp;

public class ThreadExtend extends Thread{

	public ThreadExtend() {
		super("thread by extends Thread");
		
	}
	
	public void run(){
		try{
			for(int i=0;i<10;i++) {
				System.out.println("child thread extend " + i);
				Thread.sleep(10);
			}
		}catch (InterruptedException e) {
			System.out.println("child thread extend interrupted");	
			
		}
		
		System.out.println("child Thread extend end");
	}
}
