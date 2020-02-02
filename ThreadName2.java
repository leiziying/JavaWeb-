public class ThreadName2 {
    private static class MyThread  extends  Thread{
        public MyThread() {
        }

        public MyThread(String name){
         super(name);
        }
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new MyThread();
        Thread t2=new MyThread("我是AAA");
        Thread t3=new Thread(new MyThread());
        Thread t4=new Thread(new MyThread(),"我是BBB");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
