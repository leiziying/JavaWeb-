import java.util.Scanner;
/*
　　小明非常不喜欢数字 2，包括那些数位上包含数字 2 的数。如果一个数的数位不包含数字 2，小明将它称为洁净数。
　　请问在整数 1 至 n 中，洁净数有多少个
*/

public class NotInclude2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count=0;
        int n=scanner.nextInt();
      int q=0;
        boolean flag=true;
        for (int i=1;i<=n;i++){
            q=i;
         while(q%10!=2){
          q/=10;
          if(q==0){
            count++;
            break;
          }
         }
         }
        System.out.println(count);
    }
}