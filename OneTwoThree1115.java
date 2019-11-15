public class OneTwoThree1115 {
    private static class Foo{
        public void one(){
            System.out.println("one");
        }
        public void two(){
            System.out.println("two");
        }
        public void three(){
            System.out.println("three");
        }
    }
    private static Foo foo=new Foo();
    private static class  OneThread extends  Thread{
        @Override
        public void run(){
            while(true){
                foo.one();
            }
        }
    }
    private static class TwoThread extends  Thread{
        @Override
        public void run(){
            while(true){
                foo.two();
            }
        }
    }
    private static  class  ThreeThread extends  Thread{
     @Override
     public void run(){
         while(true){
             foo.three();
         }
     }
    }

    public static void main(String[] args) {
        Thread one =new OneThread();
        Thread two=new TwoThread();
        Thread three=new ThreeThread();
        one.start();
        two.start();
        three.start();
    }
}
