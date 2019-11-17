public class MatrixTraversal {
    public  static int getTraversal(int p,int q){
        int num=0;
        if(p==1&&q==1){
            return 1;
        }
        if(p>1){
            num+=getTraversal(p-1,q);
        }
        if(q>1){
            num+=getTraversal(p,q-1);
        }
        return num;
    }

    public static void main(String[] args) {
        int num=getTraversal(8,8);
        System.out.println(num);
    }
}
