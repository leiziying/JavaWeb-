public class MyQueue {
    private  int[]  array=new int[10];
    private int front=0;
    private int rear=0;
    private int size=0;
    private  Object empty=new Object();//如果是空的就等到empty上
    private Object  full=new Object();//如果满了就等到full上
    public synchronized  void put(int message) throws InterruptedException {//给put加锁
          synchronized (full){//当是满的时候就等待在full上
              full.wait();
          }
       /* array[rear]=message;
        rear=(rear+1)%array.length;
        size++;*/
    }
    private static MyQueue queue=new MyQueue();
    private static class MyThread extends  Thread{//定义一个线程
        @Override
        public void run() {
            try {
                queue.put(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread();
        t.start();
        Thread.sleep(100);
        synchronized (queue.full){
            System.out.println("我加到锁了");//如果加到锁，说明
        }
    }
}
