public class Solution {
    public int[]  multiply(int[] A){
        if(A==null&&A.length==0){
            return A;
        }
        int[] B=new int[A.length];
        for (int i = 0; i <A.length ; i++) {
            int sum=1;
            for (int j = 0; j <A.length ; j++) {
                if(i!=j){
                    sum*=A[j];
                }
            }
            B[i]=sum;
        }
        return B;
    }

    public static void main(String[] args) {

    }
}
