import java.util.Scanner;

public class LuoXuan {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int r=s.nextInt();
        int co=s.nextInt();
        int[][] arr=new int[m][n];
        int x;
        int y;
        int z=1;
        int c=0;
        while(true){
            if(z>m*n)
                break;
            for(x=c,y=c;y<n-c;y++){
                arr[x][y]=z;
                z++;
            }
            for(x=c+1,y=n-1-c;x<m-c;x++){
                arr[x][y]=z;
                z++;
            }
            for(x=m-1-c,y=n-2-c;y>=c;y--){
                arr[x][y]=z;
                z++;
            }
            for(x=m-2-c,y=c;x>c;x--){
                arr[x][y]=z;
                z++;
            }
            c++;
        }
        System.out.println(arr[r-1][co-1]);
    }
}
