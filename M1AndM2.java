public class M1AndM2 {
    public static int n=0;
    private synchronized static void add(){
        n++;
    }
    private static synchronized  void sub(){
        n--;
    }
    private static class  MyThread extends  Thread{
        @Override
        public void run() {
            for (int i = 0; i <100000 ; i++) {
                add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread();
        thread.start();
        for (int i = 0; i <100000 ; i++) {
            sub();
        }
        thread.join();
        System.out.println(n);
    }
}
