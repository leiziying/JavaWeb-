public class SynchronizedDemo1125 {
    public synchronized static  void  method(){
        //具体代码
    }
    public synchronized void method2(){
        //具体代码
    }
    public static class MyThread extends Thread{
        public void run(){
            for (int i = 0; i <1000 ; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
