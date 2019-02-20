//Thread创建实例
public class ThreadBuild {

    public static void main(String[] args){
        //重写Thread的run方法创建线程
        Thread thread1 = new Thread(){
            public void run(){
                //do something
            }
        };

        //实现Runnable接口创建线程
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
            }
        });
    }
}
