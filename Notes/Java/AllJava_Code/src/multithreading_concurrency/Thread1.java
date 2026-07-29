package multithreading_concurrency;

public class Thread1 extends Thread{

	public Thread1 (String name) {
		super(name);
	}
	
	@Override
	
public void run() {
//	for( int i=0;i<5;i++) {
//		System.out.println("thread 1"+i);
		
		
		//method 2
		for( int i=0;i<5;i++) {
			System.out.println("thread 1" +" " +Thread.currentThread().getName()+i);
		
		
	}
}
}
