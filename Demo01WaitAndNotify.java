//等待唤醒案例：线程之间的通信
/*
* 创建一个顾客线程（消费者）：告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，进入到WAITING状态（无限等待状态）
* 创建一个老板线程（生产者）：花了5秒做包子，做好包子之后，调用notify()方法，唤醒顾客吃包子
* 注意：
*     顾客和老板线程必须得使用呢同步代码块包裹起来，保证等待和唤醒只能有一个在执行
*     同步使用的锁对象必须保证唯一
*     只有锁对象才能调用wait()和notify()方法
*     Object类中的方法：
*     wait()等待
*     notify()唤醒   唤醒在此对象监视器上等待的单个线程，会继续执行wait()方法之后的代码
* */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj=new Object();
        //创建一个顾客线程（消费者）
        new Thread(){
            @Override
            public void run() {
                //保证等待和唤醒只能有一个在执行,需要使用同技术
             while(true){
                 synchronized (obj){
                     System.out.println("告知老板要的包子的种类和数量");
                     //调用wait()方法，放弃cpu的执行，进入到WAITING状态（无线等待）
                     try {
                         obj.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     //唤醒之后执行的代码
                     System.out.println("包子已经做好了，开吃！");
                     System.out.println("-------------------------------------------------");
                 }
             }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
          while (true){
              try {
                  Thread.sleep(1000);//花5秒钟做包子
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              //保证等待和唤醒只能有一个在执行,需要使用同技术
              synchronized (obj){
                  System.out.println("老板，5秒钟之后做好包子，告知顾客，可以吃包子了");
                  obj.notify();
              }
          }
            }
        }.start();
    }
}
