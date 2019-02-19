import java.awt.desktop.SystemEventListener;

//线程协同
public class MultipleThreadDemo {
    static boolean isWaiting = true;

    synchronized static void get() throws InterruptedException {
        if(isWaiting)
        {
            System.out.println("Waiting");
            MultipleThreadDemo.class.wait();
            System.out.println("Ready and Get");
        }
        else
        {
            System.out.println("Get");
        }
    }

    synchronized static void set() throws InterruptedException {
        if(isWaiting)
        {
            System.out.println("Prepare");
            Thread.sleep(100);
            MultipleThreadDemo.class.notify();
            System.out.println("Ready and Notify");
        }
        else
        {
            System.out.println("Ready");
        }
    }

    public static void main(String[] args){

        new Task1().start();
        new Task2().start();
    }

    static class Task1 extends Thread{
        public void run(){
            try {
                get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task2 extends Thread{
        public void run(){
            try {
                set();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
