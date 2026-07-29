package multithreading_concurrency;

//public class Stack {
//
//    private int[] array;
//    private int stackTop;
//    
//
//    public Stack(int capacity) {
//        array = new int[capacity];
//        stackTop = -1;
//      
//    }
//
//    public boolean isEmpty() {
//        return stackTop < 0;
//    }
//
//    public boolean isFull() {
//        return stackTop >= array.length - 1;
//    }
//
//    // t1, t2, t3
//    public boolean push(int element) {

//            if (isFull())
//                return false;
//
//            ++stackTop;
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            }
//
//            array[stackTop] = element;
//            return true;
//        
//    }
//
//    // t1, t4, t5
//    public int pop() {

//            if (isEmpty())
//                return Integer.MIN_VALUE;
//
//            int obj = array[stackTop];
//            array[stackTop] = Integer.MIN_VALUE;
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            }
//
//            stackTop--;
//            return obj;
//        
//    }
//    
//    
//    
//    
//    
//    }
    
    
    //method 2: Above code can give exception and out of bound issue so use syncronization for the same
//public class Stack {
//
//    private int[] array;
//    private int stackTop;
//    Object lock;
//
//    public Stack(int capacity) {
//        array = new int[capacity];
//        stackTop = -1;
//        lock = new Object();
//    }
//
//    public boolean isEmpty() {
//        return stackTop < 0;
//    }
//
//    public boolean isFull() {
//        return stackTop >= array.length - 1;
//    }
//
//    // t1, t2, t3
//    public boolean push(int element) {
//        synchronized (lock) {
//            if (isFull())
//                return false;
//
//            ++stackTop;
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            }
//
//            array[stackTop] = element;
//            return true;
//        
//    }
//    }
//    // t1, t4, t5
//    public int pop() {
//        synchronized (lock) {
//            if (isEmpty())
//                return Integer.MIN_VALUE;
//
//            int obj = array[stackTop];
//            array[stackTop] = Integer.MIN_VALUE;
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            }
//
//            stackTop--;
//            return obj;
//        
//    }}
//    
    
    //method 3: instead of synchronizing the piece of code we can make the fuction only syncronized
//Queston:
    public class Stack {

        private int[] array;
        private int stackTop;
      

        public Stack(int capacity) {
            array = new int[capacity];
            stackTop = -1;
           
        }

        public boolean isEmpty() {
            return stackTop < 0;
        }

        public boolean isFull() {
            return stackTop >= array.length - 1;
        }

        // t1, t2, t3
        public  synchronized  boolean push(int element) {
           
                if (isFull())
                    return false;

                ++stackTop;

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                array[stackTop] = element;
                return true;
            
        
        }
        // t1, t4, t5
        public  synchronized  int pop() {
        
                if (isEmpty())
                    return Integer.MIN_VALUE;

                int obj = array[stackTop];
                array[stackTop] = Integer.MIN_VALUE;

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                stackTop--;
                return obj;
            
        }
        
        
        //method 4: same code of method 2 and method 3 would work for static method too...ie. use
//        use ->  public static synchronized  boolean push(int element) {
//        	//code
//        }
}
    
    
    
//    in mehtod 3, if we are not using the lock word here then what will the value of lock,
//    or
//    What object is used as the lock when an instance method is declared synchronized?
    
//    When you write:
//    	public synchronized boolean push(int element)
//    	or
//    	public synchronized int pop()
//    	
//    	Java automatically uses the current object (this) as the lock.
//    	So your code is equivalent to:
//    	public boolean push(int element) {
//    	    synchronized(this) {
//    	        // code
//    	    }
//    	}
    
    
/* in mehtod 4, if we are not using the lock word here then what will the value of lock,  or
What object is used as the lock when an instance method is declared synchronized?
    
  Java automatically uses the Stack.class as the lock.
	So your code is equivalent to:
public boolean push(int element) {
    synchronized(Stack.class) {
        // code
    }
	}
*/