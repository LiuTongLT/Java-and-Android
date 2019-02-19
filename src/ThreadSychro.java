//同步代码示例
public class ThreadSychro {

    static class Count{
        static int value;
        //加锁
        Object lock = new Object();

        //无同步代码
        public void add() throws InterruptedException {
            int temp = value;
            Thread.sleep(100);
            value = temp+1;
            System.out.println("Value is " + value);
        }

        //同步代码块, 锁住的是当前Count实例，相当于this
        public void add1() throws InterruptedException {
            synchronized (lock){
                int temp = value;
                Thread.sleep(100);
                value = temp+1;
                System.out.println("Value is " + value);
            }
        }

        //同步方法，锁住的是当前Count实例，相当于this
        public synchronized void add2() throws InterruptedException {
            int temp = value;
            Thread.sleep(100);
            value = temp+1;
            System.out.println("Value is " + value);
        }

        //同步静态方法，锁着的是类，相当于Count.calss
        public static synchronized void add3() throws InterruptedException {
            int temp = value;
            Thread.sleep(100);
            value = temp+1;
            System.out.println("Value is " + value);
        }

        //同步类,锁着的是类，相当于Count.calss
        public void add4() throws InterruptedException {
            synchronized (Count.class){
                int temp = value;
                Thread.sleep(100);
                value = temp+1;
                System.out.println("Value is " + value);
            }
        }
    }

    public static void main(String[] args){

        new Task().start();
        new Task().start();
    }

    static class Task extends Thread{
        static Count count = new Count();

        public void run(){
            try {
                count.add3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } {

            }
        }
    }

    static class Task1 extends Thread{

        public void run(){
            Count count = new Count();
            try {
                count.add3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } {

            }
        }
    }
}
