package multithreading_concurrency;

public class ThreadTester {
public static void main(String[] args) {
	
	System.out.println("main is starting");
	
	
//	chapter 1: Extending Thread Class to create a Thread
	
//	
//	Thread thread1=new Thread1();
//	thread1.setDaemon(true);
//	thread1.start();
//	System.out.println("main is existing");
	
	//method 2
//	System.out.println("main is starting");
//	Thread thread1=new Thread1("vivek");
//    //	thread1.setDaemon(true);
//	thread1.start();
//	System.out.println("main is existing");
//	
	
	
	
	
//	chapter 2 use runnable to implement class
//	method 1:
	
//	Thread thread2=new Thread(new Thread2(),"thread2");
//	thread2.start();
//		
	
	
////	Next chapter: - Synchronization in Java, Race Condition and Introduction to Concurrency, Synchronization Demo with Stacks (Synchronized Methods and Synchronized Blocks),Using Objects as Locks
//	Stack stack=new Stack(5);
//	//Thread t1
//	new Thread(()->{
//	int counter=0;
//	while(++counter<10) 
//		System.out.println("stack pushed"+" "+ stack.push(100));
//		
//	},"pusher").start();
//	
//	//Thread t2
//	new Thread(()->{
//		int counter=0;
//		while(++counter<10) 
//			System.out.println("stack popped"+" "+ stack.pop());
//			
//		},"popper").start();
//		
//	
//	
	
      //Next chapter: volatile keyword
//	 TVSet tv1 = TVSet.getTVSetInstance();
//     TVSet tv2 = TVSet.getTVSetInstance();
//
//     System.out.println(tv1 == tv2); // true
//     
//    
     
     
     //Next chapter: consumer-producer problem
//     BlockingQueue queue = new BlockingQueue(5);
//
//     queue.add(10);
//     queue.add(20);
//     queue.add(30);
//     System.out.println(queue.remove());
//     System.out.println(queue.remove());
//     
     
     //Next chapter--no any other file for this
//     Thread thread3 = new Thread(() -> {
//    	    try {
//    	        Thread.sleep(1);
//    	        for(int i = 10000; i > 0; i--);
//    	    } catch (InterruptedException e) {
//    	        e.printStackTrace();
//    	    }
//    	}, "States");
//
//    	thread3.start();
//
//    	while(true) {
//    	    Thread.State state = thread3.getState();
//    	    System.out.println(state);
//    	    if(state == Thread.State.TERMINATED) break;
//    	}
//
//    	System.out.println("main is exiting");
// 

	
	
	//Next chapter: use of join
//	Thread thread = new Thread(() -> {
//	    System.out.println(Thread.currentThread());
//	}, "Our Thread");
//
//	thread.start();
//
//	try {
//	    thread.join();
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	}
	
	
	
	
	//Nexxt chapter: Deadlock: program never terminates because thread1 and thread2 are deadlocked.
	/*Q: what will be the output of the below code??
     --program never terminates because thread1 and thread2 are deadlocked. it will deadlocked for  indefinite times*/
	
	/*String lock1 = "riddhi";
	String lock2 = "dutta";

	Thread thread1 = new Thread(() -> {
	    synchronized (lock1) {
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        synchronized (lock2) {
	            System.out.println("lock acquired");
	        }
	    }
	}, "thread1");

	Thread thread2 = new Thread(() -> {
	    synchronized (lock2) {
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        synchronized (lock1) {
	            System.out.println("lock acquired");
	        }
	    }
	}, "thread2");

	thread1.start();
	thread2.start();*/
//solution of the above deadlock situation: -use the lock in same order
	
	String lock1 = "riddhi";
	String lock2 = "dutta";

	Thread thread1 = new Thread(() -> {
	    synchronized (lock1) {
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        synchronized (lock2) {
	            System.out.println("lock acquired");
	        }
	    }
	}, "thread1");

	Thread thread2 = new Thread(() -> {
	    synchronized (lock1) {
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        synchronized (lock2) {
	            System.out.println("lock acquired");
	        }
	    }
	}, "thread2");

	thread1.start();
	thread2.start();
	
	
	System.out.println("main is exiting");
	
}
}
