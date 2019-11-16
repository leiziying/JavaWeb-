import java.util.Scanner;

public class Main {
    private  static Scanner sc;

    public static void main(String[] args) {
        sc=new Scanner(System.in);
        String str;
        char[] ch;
        int a[]=new int[10];
        str=sc.next();
        ch=str.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            a[(int)ch[i]-48]+=1;
        }
        for (int i = 0; i <a.length ; i++) {
            if(a[i]!=0){
                System.out.println(i+":"+a[i]);
            }
        }
    }
}
