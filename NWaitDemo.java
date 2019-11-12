public class NWaitDemo {
   private static  Object o=new Object();
    private static int n=0;
    private static class Sub extends  Thread{
        @Override
        public void run(){
            while(true){
                synchronized (o){
                    if(n==0){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    n--;
                    System.out.println(getName()+";"+n);
                    o.notify();
                }
            }
        }
    }
    public  static class  Add extends  Thread{
        @Override
        public void run(){
            while(true){
                synchronized (o){
                    if(n==10){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    n++;
                    System.out.println(getName()+":"+n);
                    o.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread a=new Sub();
        Thread b=new Add();
        a.start();
        b.start();
    }
}
