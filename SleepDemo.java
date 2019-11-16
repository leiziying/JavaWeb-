import java.util.Stack;

public class SleepDemo {
    private  enum  Week{
        MON,TUE,WED,THU,FRI,SAT,SUN
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread();
        System.out.println(thread.getState());
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}
