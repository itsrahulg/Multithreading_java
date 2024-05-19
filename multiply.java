class fiveTable extends Thread{
    public void run(){
        System.out.println("5 multiplication table:");

        for(int i=1;i<=10;i++){
            System.out.println("5 x " + i + " " + "= " + (5*i));
        }
        System.out.println();
    }
}

class sevenTable extends Thread{
    public void run(){
        System.out.println("7 multiplication table:");

        for(int i=1;i<=10;i++){
            System.out.println("7 x " + i + " " + "= " + (7*i));
        }
        System.out.println();
    }
}


class thirteenTable extends Thread{
    public void run(){
        System.out.println("13 multiplication table:");

        for(int i=1;i<=10;i++){
            System.out.println("13 x " + i + " " + "= " + (13*i));
        }
        System.out.println();
    }
}





public class multiply {
    public static void main(String[] args) {
        Thread fivetable = new fiveTable();
        Thread seventable = new sevenTable();
        Thread thirteentable = new thirteenTable();

        fivetable.start();
        seventable.start();
        thirteentable.start();
    }
}
