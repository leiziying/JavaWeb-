import java.util.Scanner;

public class Main1114 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long result=fun(n);
        int count=0;
      while(result!=0){
          if(result%10!=0){
             break;
          }else{
              count++;
              result=result/10;
          }
      }
        System.out.println(count);
    }

    private static long  fun(int n) {
    long sum=1;
        for (int i = 1; i <=n ; i++) {
            sum*=i;
        }
        return sum;
    }
}
