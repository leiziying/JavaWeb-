import java.util.*;

public class Gift {
    public static int getValue(int[] gifts, int n) {
return  quickSort(gifts,0,n-1);
    }

    private static int quickSort(int[] arr, int low, int high) {
        int mid=(high+1)>>1;
        int pivot=partition(arr,low,high);
        while(pivot!=mid){
            if(pivot<mid){
                pivot=partition(arr,pivot+1,high);
            }else{
                pivot=partition(arr,low,pivot-1);
            }
        }
        int res=arr[pivot];
        if(!check(arr,high+1,res)){
            return  0;
        }
        return  res;
    }

    private static boolean check(int[] arr, int n, int res) {
        int count=0;
        for (int i= 0; i <n ; i++) {
            if(arr[i]==res){
                ++count;
            }
        }
        if(count*2<=n){
            return  false;
        }else {
            return  true;
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int left=low;
        int right=high;
        int temp=arr[low];
        while(left<right){
            while(left<right&&arr[right]>=temp){
                --right;
            }
            if(left<right){
                arr[left]=arr[right];
            }
            while(left<right&&arr[left]<=temp){
                ++left;
            }
            if(left<right){
                arr[right]=arr[left];
            }
        }
        arr[left]=temp;
        return  left;
    }

}