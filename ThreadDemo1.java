public class ThreadDemo1 {
    private static class MyThread extends  Thread {
        @Override
        public  void run(){
            while(true){
                System.out.println("我咋method2中打印");
                //进程会暂停运行1秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        method2();
        while(true){
            System.out.println("我在main中打印");
            //进程会暂停运行1秒
            Thread.sleep(1000);
        }
    }

    private static void method2() {
        Thread thread=new MyThread();
        thread.start();
    }

    private static void method1() throws InterruptedException {
        while(true){
            System.out.println("我在method1中打印");
            //进程暂停运行1秒
            Thread.sleep(1000);
        }
    }

}
