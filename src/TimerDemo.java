import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    public static void main(String[] args){
        Timer timer = new Timer();

        //在指定的延迟执行任务
//        timer.schedule(new TimerTask() {
//            long startTime = System.currentTimeMillis();
//            @Override
//            public void run() {
//                //打印预计执行时间
//                System.out.println("Schedule time: "+(scheduledExecutionTime()-startTime));
//                //打印实际执行时间
//                System.out.println("Run at: " + (System.currentTimeMillis()-startTime));
//            }
//        },1000);
//
//        //再添加一个任务扰乱了上面的任务
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },900);

        //重复执行任务
        //schedule 和 scheduleAtFixedRate 的区别是：在有别的任务干扰时，schedule的后续任务会叠加第二次的干扰时间，而scheduleAtFixedRate的
        //后续任务不会受到干扰

//        timer.schedule(new TimerTask() {
//            long startTime = System.currentTimeMillis();
//            @Override
//            public void run() {
//                //打印预计执行时间
//                System.out.println("Schedule time: "+(scheduledExecutionTime()-startTime));
//                //打印实际执行时间
//                System.out.println("Run at: " + (System.currentTimeMillis()-startTime));
//            }
//        },0,1000);//从0ms开始执行，每隔1000ms执行一次

//        timer.scheduleAtFixedRate(new TimerTask() {
//            long startTime = System.currentTimeMillis();
//            @Override
//            public void run() {
//                //打印预计执行时间
//                System.out.println("Schedule time: "+(scheduledExecutionTime()-startTime));
//                //打印实际执行时间
//                System.out.println("Run at: " + (System.currentTimeMillis()-startTime));
//            }
//        },0,1000);
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },900);

        //取消任务
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                //timertask在运行的时候是不能被取消的
//                //cancel();
//                System.out.println("Run");
//            }
//        };
//
//        timer.schedule(timerTask,1000);
//        //取消任务
//        timerTask.cancel();

        TimerTask timerTask = new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                //timertask在运行的时候是不能被取消的, 但是重复执行的后续任务是可以被取消的，正在执行的任务不受影响
                //if(count==2) cancel();
                if(count == 2) timer.cancel();//后续任务不会被执行且能推出timer，除此之外还可以设置timer中的线程设置为守护线程
                System.out.println("Run: "+count++);
            }
        };

        timer.schedule(timerTask,0,1000);//timer 的线程不是守护线程，即使run（）已经结束了，jvm还是不会关闭
        //取消Timer
        //timer.cancel();//但是run()不会被执行
    }
}
