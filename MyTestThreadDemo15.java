public class MyTestThreadDemo15 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("第一个线程:" + i);
            }
        }
    }

      public  static class MyRunnable implements  Runnable{
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("第二个线程："+i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new MyThread();
Thread t2=new Thread(new MyRunnable());
t1.start();
t2.start();
    }
}
