class PrimeNumbersThread extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int count = 0, num = 2;
        
        System.out.println("First 20 prime numbers:");
        while (count < 20) {
            if (isPrime(num)) {
                System.out.println(num);
                count++;
            }
            num++;
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by PrimeNumbersThread: " + (endTime - startTime) + " ms");
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

class FibonacciThread extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        
        System.out.println("First 15 Fibonacci numbers:");
        int n1 = 0, n2 = 1;
        System.out.println(n1);
        System.out.println(n2);
        
        for (int i = 2; i < 15; i++) {
            int n3 = n1 + n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("time taken by FibonacciThread: " + (endTime - startTime) + " ms");
    }
}

public class threadsTimeTaken {
    public static void main(String[] args) {
        new PrimeNumbersThread().start();
        new FibonacciThread().start();
    }
}
