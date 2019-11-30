import java.util.Random;

public class MyQueue2 {
    private  int[]  array=new  int[2];
    private int front=0;
    private int rear=0;
    private int size;
    public synchronized  void put(int message)  throws  InterruptedException{
        if(size==array.length){
            wait();
        }
        array[rear]=message;
        rear=(rear+1)%array.length;
        size++;
        notify();
    }
    public synchronized  int take()  throws  InterruptedException{
       if(size==0){
            wait();
        }
        int message=array[front];
        front=(front+1)%array.length;
        size--;
        notify();
        return  message;
    }
    private static final MyQueue2 queue2=new MyQueue2();
    private static class Producer extends  Thread {
        @Override
        public void run() {
            Random random=new Random();
            while(true) {
                try {
                    int message=random.nextInt(100);
               queue2.put(message);
                    System.out.println("放入消息："+message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Customer extends  Thread{
        @Override
        public void run() {
            while(true){
                try {
                    System.out.println( "收到消息："+queue2.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Producer();
        Thread t2=new Producer();
        Thread t3=new Producer();
        Thread c1=new Customer();
        Thread c2=new Customer();
        Thread c3=new Customer();
        Thread c4=new Customer();
        t1.start();;
        t2.start();
        t3.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
