public class DemoTicket {
    //模拟 买票案例
    //创建三个线程，同时开启，对共享 的票进行出售
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImImpl run=new RunnableImImpl();
        //创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        Thread t0=new Thread(run);
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        //调动start方法开启线程
        t0.start();
        t1.start();
        t2.start();
    }
}
