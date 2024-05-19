class even extends Thread{
    public void run(){
        for(int j=0;j<=20;j = j+2){
            System.out.println(j);
        }
    }
}



class odd extends Thread{
    public void run(){
        for(int i=1;i<=20;i = i+2){
            System.out.println(i);
        }
    }
}


public class evenOdd {
    public static void main(String[] args) {
        Thread odd_numbers = new odd();
        Thread even_numbers = new even();

        even_numbers.start();
        odd_numbers.start();
    }
}
