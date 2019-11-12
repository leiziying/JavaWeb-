import java.util.Scanner;

public class DifferentChoose {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int kinds=scanner.nextInt();
            int[] arr=new int[kinds];
            for (int i = 0; i <kinds ; i++) {
                arr[i]=scanner.nextInt();
            }
            System.out.println(differentKinds(arr,kinds,40,0));
        }
    }

    private static int differentKinds(int[] arr, int n, int v, int index) {
        if(v==0){
            return 1;
        }
        if(n==0){
            return 0;
        }else{
            return  differentKinds(arr,n-1,v-arr[index],index+1)+differentKinds(arr,n-1,v,index+1);
        }
    }
}
