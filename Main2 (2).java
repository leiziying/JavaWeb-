import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String n=scanner.nextLine();
        char[] arr=n.toCharArray();
        for(int i=arr.length-1;i>-1;i--){
            System.out.print(arr[i]);
        }
    }
}
