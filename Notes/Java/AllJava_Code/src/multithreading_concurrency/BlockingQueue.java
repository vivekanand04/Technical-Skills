package multithreading_concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    public boolean add(int item) {
        synchronized (q) {
            if (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            q.add(item);
            q.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (q) {
            if (q.size() == 0) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int element = q.poll();
            q.notifyAll();
            return element;
        }
    }
}




/*case 2 : if queue was full and two subsequesnt thread came t1 and t2 that was add in nature then both would go in
 wait state..when the remove thread come it would remove and notify to all thread then which thread out of t1 nad t2 will push???
 ans: use while instead of if in---     if (q.size() == capacity){} ,,, and in--    if (q.size() == 0) {}
 */





