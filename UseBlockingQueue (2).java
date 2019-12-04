import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class UseBlockingQueue {
    /*
    如果满了就不能再往里放了，如果空了就不能再往出取了
     */
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    private static  class  Producer extends  Thread{
        @Override
        public void run() {
            Random random=new Random(20191204);
            while(true){
                //随机生成100以内的数字放到队列当中
                try {
                    int message=random.nextInt(100);
                    queue.put(String.valueOf(message));
                    System.out.println("放入消息："+message);
                    Thread.sleep(random.nextInt(3)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Customer extends  Thread{
        @Override
        public void run() {
            Random random=new Random(20191204);
            while(true){
                try {
                    String message=queue.take();
                    System.out.println("收到消息："+message);
                    Thread.sleep(random.nextInt(3)*100);
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
