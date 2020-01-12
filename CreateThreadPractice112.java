public class CreateThreadPractice112 {
    private static class P1 extends  Thread{
        private int count=100_0000;
        @Override
        public void run() {
            long sum=0;
            for (int i = 1; i <=count ; i++) {
                sum+=i;
            }
            System.out.println("P1:1+2+...+n="+sum);
        }
    }
    private static class P2 extends  Thread{
        private int count=100_0000;
        @Override
        public void run() {
            long sum=0;
            for (int i = 1; i <=count ; i+=2) {
                sum+=i;
            }
            System.out.println("P2:1+3+5...+n="+sum);
        }
    }
    private static class P3 extends  Thread{
        private int count=100_0000;

        @Override
        public void run() {
            long sum=0;
            for (int i = 1; i <=count ; i++) {
                sum+=(i*i);
            }
            System.out.println("P3:1+4+....+n="+sum);
        }
    }

    public static void main(String[] args) {
        new P1().start();
        new P2().start();
        new P3().start();
    }
}
