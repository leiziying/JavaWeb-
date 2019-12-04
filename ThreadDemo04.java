public class ThreadDemo04 {
    public static class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println("这是我的线程");
        }
    }

    public static void main(String[] args) {
        Thread t0=new MyThread();
        Thread t1=new MyThread();
        Thread t2=new MyThread();
        t0.start();
        t1.start();
        t2.start();
    }
}
