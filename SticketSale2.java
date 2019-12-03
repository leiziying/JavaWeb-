public class SticketSale2 {
    /*
     * 卖票案例出现了线程安全问题
     * 卖出了不存在的票和重复的票
     * 解决线程安全问题的一种方案：使用同步方法
     * 使用步骤：
     * 1.把访问了共享数据的代码抽取出来，放到一个方法中
     * 2.在方法上添加synchronized修饰符
     * 格式：定义方法的格式
     * 修饰符  synchronized 返回值类型 方法名（参数列表）{}
     *
     * */
    public static class RunnableImpl implements  Runnable {
        private static int ticket = 100;
        //创建一个锁对象
        Object obj = new Object();

        @Override
        public  void run() {
            while (true) {
                payStaticTicket();
            }
        }
        /*
         * 定义一个同步方法
         * */
        private static synchronized void payStaticTicket() {
            if (ticket > 0) {
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
