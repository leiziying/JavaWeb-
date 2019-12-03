public class SticketSale {
    /*
    * 卖票案例出现了线程安全问题
    * 卖出了不存在的票和重复的票
    * 解决线程安全问题的一种方案：使用同步代码块
    * 格式：
    *     synchronized(锁对象){
    *       可能会出现线程安全问题的代码（访问了共享数据的代码）
    *     }
    *     注意：
    *       1.同步代码块中的锁对象，可以使用人任意的对象
    *       2.但是必须保证多个线程使用的锁对象是同一个
    *       3.锁对象作用：
    *           把同步代码块锁住，只让一个线程在同步代码块中执行
    * */
    public static class RunnableImpl implements  Runnable{
        private static int ticket=100;
        //创建一个锁对象
        Object obj=new Object();
        @Override
        public void run() {
            while(true){
                synchronized (obj){
                if(ticket>0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                }
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable=new RunnableImpl();
        Thread t0=new Thread(runnable);
        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        t0.start();
        t1.start();
        t2.start();
    }
}
