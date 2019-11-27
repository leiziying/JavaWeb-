public class OneTwoThreeV3 {
        private  static class Foo {
            private volatile int n=0;
            public void one() throws InterruptedException {
                    if (n != 0) {
                       // Thread.yield();//通过调用yield();释放CPU
                        synchronized (this){
                            wait();
                        }
                       return;
                    }
                System.out.println("one");
                    n=1;
                    synchronized (this){
                        notifyAll();
                    }
            }
            public void two() throws InterruptedException {
                if(n!=1){
                   // Thread.yield();
                    synchronized (this){
                        wait();
                    }
                    return;
                }
                System.out.println("two");
                n=2;
                synchronized (this){
                    notifyAll();
                }
            }
            public void three() throws InterruptedException {
               if(n!=2){
                  // Thread.yield();
                   synchronized (this){
                       wait();
                   }
               return;
               }
                System.out.println("three");
               n=0;
               synchronized (this){
                   notifyAll();
               }
            }
        }
        private static Foo foo=new Foo();
        private static class  OneThread extends  Thread{
            @Override
            public void run() {
                while(true){
                    try {
                        foo.one();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        private static class TwoThread extends  Thread{
            @Override
            public void run() {
                while(true){
                    try {
                        foo.two();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        private static  class ThreeThread extends  Thread{
            @Override
            public void run() {
                while(true){
                    while(true){
                        try {
                            foo.three();
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            Thread one=new OneThread();
            Thread two=new TwoThread();
            Thread three =new ThreeThread();
            one.start();
            two.start();
            three.start();
        }
    }

