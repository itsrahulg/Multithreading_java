import java.util.Random;

class SharedData {
    private int number;
    private boolean newNumberAvailable = false;

    public synchronized void setNumber(int number) {
        this.number = number;
        newNumberAvailable = true;
        notifyAll();
    }

    public synchronized int getNumber() {
        while (!newNumberAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        newNumberAvailable = false;
        return number;
    }
}

class NumberGenerator extends Thread {
    private final SharedData sharedData;
    private final Random random = new Random();

    public NumberGenerator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int number = random.nextInt(100);
            System.out.println("Generated number: " + number);
            sharedData.setNumber(number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class SquareCalculator extends Thread {
    private final SharedData sharedData;

    public SquareCalculator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int number = sharedData.getNumber();
            if (number % 2 == 0) {
                System.out.println("Square of " + number + ": " + (number * number));
            }
        }
    }
}

class CubeCalculator extends Thread {
    private final SharedData sharedData;

    public CubeCalculator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int number = sharedData.getNumber();
            if (number % 2 != 0) {
                System.out.println("Cube of " + number + ": " + (number * number * number));
            }
        }
    }
}

public class randomSquareCube {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        
        new NumberGenerator(sharedData).start();
        new SquareCalculator(sharedData).start();
        new CubeCalculator(sharedData).start();
    }
}
