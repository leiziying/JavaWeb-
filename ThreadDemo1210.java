public class ThreadDemo1210 {
    public static class myThread extends  Thread{
        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println("这是线程1:"+i);
            }
        }
    }
    public static class myRnunable implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("这是线程2:"+i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new myRnunable());
        Thread t2=new myThread();
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());
    }
}
