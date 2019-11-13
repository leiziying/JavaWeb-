import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        str=reader.readLine().split(" ");
        int n=str.length-1;
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int k=Integer.parseInt(str[str.length-1]);
        for(int i=0;i<k-1;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println(arr[k-1]);
    }
}
