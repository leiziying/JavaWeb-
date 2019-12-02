public   class  TicketSell {
    public static class RunnableIimpl implements Runnable {
        //定义一个多个线程共享的票源
        private int ticket = 100;
        //设置线程任务：卖票
        @Override
        public void run() {
            //使用死循环让买票重复循环
            while (true) {
                //判断票是否存在
                if (ticket > 0) {
                    //存在：卖票
                    try{
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--->正在卖第" + ticket + "张票");
                    ticket--;
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableIimpl runnableIimpl = new RunnableIimpl();
        //创建Thread类对象，构造方法中传递Runnable接口的实现类对象
       Thread t0=new Thread(runnableIimpl);
       Thread t1=new Thread(runnableIimpl);
       Thread t2=new Thread(runnableIimpl);
       //调用start方法，开启多线程
       t0.start();
       t1.start();
       t2.start();
    }

}