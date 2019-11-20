import java.util.Scanner;

public class Main1120 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] num=new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i]=scanner.nextInt();
        }
        scanner.close();
        for (int i = 0; i <num.length ; i++) {
            if(num[i]!=0){
                System.out.println(i);
                num[i]--;
                break;
            }
        }
        for (int i = 0; i <num.length ; i++) {
            while(num[i]>0){
                System.out.print(i);
                num[i]--;
            }
        }
        System.out.println();
    }
}
