import java.util.Scanner;

public class Main1123 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.println(addAB(a,b));

        }

    private static int addAB(int a, int b) {
        return a+b;
    }
}

