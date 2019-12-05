import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
分析：
 */
public class ProducerAndCustomer {
    private static BlockingQueue<Integer > queue=new ArrayBlockingQueue<>(10);
    int size=queue.size();
    int front=0;
    int rear=queue.size();
    private static void put(Integer  message) throws InterruptedException {
        queue.put(message);
    }
    private static Integer  take() throws InterruptedException {
     return    queue.take();
    }
private  static  class Producer extends  Thread{
      @Override
      public void run() {
          while(true){
              for (int i = 0; i < 10; i++) {
                  try {
                      queue.put( i);
                      System.out.println("放入消息"+i);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
      }
  }
  private static class  Customer extends  Thread{
      @Override
      public void run() {
          while(true){
              try {
                  int num=queue.take();
                  System.out.println("取出消息"+num);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }

    public static void main(String[] args) {
        Thread p0=new Producer();
        Thread p1=new Producer();
        Thread c0=new Customer();
        Thread c1=new Customer();
        p0.start();
        p1.start();
        c0.start();
        c1.start();

    }
}
