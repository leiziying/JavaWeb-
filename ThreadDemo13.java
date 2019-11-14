public class ThreadDemo13 {
    public static class MyThread extends  Thread{
        @Override
      public synchronized void  run(){
            for (int i = 0; i <20 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
             /*   try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
      }
    }
    public static class MyRunnable implements  Runnable{
        @Override
        public   synchronized  void run(){
            for (int i = 0; i <20 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
               /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
    public static void main(String[] args) {
        Thread mt1=new MyThread();
        Runnable runnable=new MyRunnable();
        Thread mt2=new Thread(runnable);
        mt1.start();
        mt2.start();
    }
}