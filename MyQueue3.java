public class MyQueue3 {
    private  int[]  array=new  int[2];
    private int front=0;
    private int rear=0;
    private int size;
    private Object full=new Object();
    private Object empty=new Object();
    public synchronized  void put(int message) throws InterruptedException {
        if(size==array.length) {
            synchronized (full) {
                full.wait();
            }
        }
        array[rear]=message;
        rear=(rear+1)%array.length;
        size++;
        empty.notify();
    }
    public synchronized  void take() throws InterruptedException {
        if(size==0) {
            synchronized (empty) {
                empty.wait();
            }
        }
        int message=array[front];
        front=(front+1)%array.length;
        size--;
        full.notify();
    }
}
