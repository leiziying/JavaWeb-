public class JoinDemo {
    private static  class MyThread extends  Thread{
        @Override
        public void run(){
          printCuurentThreadName();
        }
    }
    private  static void printCuurentThreadName(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException {
     /*   Thread  t1=new MyThread();
        t1.start();
        //并不会等到t1结束，才执行这里
        System.out.println(System.currentTimeMillis());
        t1.join(2000);
        System.out.println(System.currentTimeMillis());*/
     Thread thread=new MyThread();
     thread.start();
     printCuurentThreadName();
    }
}
