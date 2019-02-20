//线程局部变量
public class ThreadLocalDemo {
    public static void main(String[] args){
        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            public Integer initialValue(){
                //provide the initial value
                return -1;
            }
        };

        // get the value
        System.out.println(Thread.currentThread().getName()+" value: "+threadLocal.get());
        // set the value
        threadLocal.set(4);
        System.out.println(Thread.currentThread().getName()+" new value: "+threadLocal.get());
        // remove the value
        threadLocal.remove();
        System.out.println(Thread.currentThread().getName()+" removed and the value: "+threadLocal.get());

        threadLocal.set(10);// this is in the main thread, though it has been changed, the value in sub-thread is not 10

        new Thread(){
            public void run(){
                // get the value
                System.out.println(Thread.currentThread().getName()+" value: "+threadLocal.get());
                // set the value
                threadLocal.set(4);
                System.out.println(Thread.currentThread().getName()+" new value: "+threadLocal.get());
                // remove the value
                threadLocal.remove();
                System.out.println(Thread.currentThread().getName()+" removed and the value: "+threadLocal.get());

            }
        }.start();
    }


}
