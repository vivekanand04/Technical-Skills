package multithreading_concurrency;


public class TVSet {

    private static volatile TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("TV Set instantiated");
    }

    public static TVSet getTVSetInstance() {

        if (tvSetInstance == null) { // optimisation

            synchronized (TVSet.class) { // t1/t2

                if (tvSetInstance == null) { // double checking
                    tvSetInstance = new TVSet();
                }
            }
        }

        // heavy work done here
        return tvSetInstance;
    }
}

/*
Q1) why we have declared the tvSetInstance using the "volatile"
-- so that any thread can access this variable form memeory only..see the notes diagram
Q2) why we have checked the tvSetInstance two times
---Imagine two threads:
T1 enters and sees tvSetInstance == null
T2 enters and also sees tvSetInstance == null
Both reach the synchronized block.
T1 gets the lock first and creates the object.
When T2 gets the lock, it must check again:
if(tvSetInstance == null)
Now it's not null, so T2 does not create another object.
Without the second check, both threads could create separate objects, breaking the Singleton pattern.
*/

// time 0 - t1, t2
// time 5 - t5, t6, t7.....