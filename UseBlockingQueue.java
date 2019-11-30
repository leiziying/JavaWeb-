/*
* 如何利用生产者和消费者放入阻塞队列
* */
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import  java.util.concurrent.BlockingDeque;//队列满或者是空都会引起队列的阻塞
import java.util.concurrent.BlockingQueue;
public class UseBlockingQueue {
  private static BlockingQueue<String> queue=new ArrayBlockingQueue<>(2);
private static class Producer extends  Thread{
    @Override
    public void run() {
        Random random =new Random(20191130);
        while(true){
            try {
                int message=random.nextInt(100);
                queue.put(String.valueOf(message));
                System.out.println("放入消息"+message);
                Thread.sleep((3)*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
private static class Customer  extends  Thread{
    @Override
    public void run() {
        Random random =new Random(20191130);
        while(true){
            try {
                String message=queue.take();
                System.out.println("收到消息"+message);
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

    public static void main(String[] args) {
        Thread producer=new Producer();
        Thread customer=new Customer();
        producer.start();
        customer.start();
    }
}
