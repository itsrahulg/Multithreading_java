class MyRunnable implements Runnable {
    @Override
    public void run() {
        
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread Name: " + currentThread.getName());
    }
}

public class TheRunnable {
    public static void main(String[] args) {
    
        MyRunnable myRunnable = new MyRunnable();
        
        Thread thread = new Thread(myRunnable);
        
        thread.setName("MyRunnableThread");
        
        thread.start();
        
 
    }
}
