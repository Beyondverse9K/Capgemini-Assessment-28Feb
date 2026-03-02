package multi_threading;

class A {
    synchronized void methodA(B b) {
        System.out.println("Thread 1: Holding lock on object A...");
        
        try {
            // Sleep to ensure Thread 2 has time to lock object B
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception occurred in A");
        }
        
        System.out.println("Thread 1: Waiting for lock on object B...");
        // This is now outside the catch block, so it will execute
        b.last(); 
    }
    
    synchronized void last() {
        System.out.println("Inside A's last() method");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread 2: Holding lock on object B...");
        
        try {
            // Sleep to ensure Thread 1 has time to lock object A
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception occurred in B");
        }
        
        System.out.println("Thread 2: Waiting for lock on object A...");
        // This is now outside the catch block, so it will execute
        a.last(); 
    }
    
    synchronized void last() {
        System.out.println("Inside B's last() method");
    }
}

public class Deadlock {

    public static void main(String[] args) {
        A a  = new A();
        B b  = new B();
        
        Thread t1 = new Thread() {
            @Override
            public void run() {
                a.methodA(b);
            }
        };
        
        Thread t2 = new Thread() {
            @Override
            public void run() {
                b.methodB(a);
            }
        };
        
        t1.start();
        t2.start();
    }
}