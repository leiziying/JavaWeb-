public class HeadDemo {
    public static void main(String[] args) {
      class MyPriorityQueue{
         private int[] array=new int[100];
         private int size=0;
                 public void offer(int a){
                     array[size++]=a;
                     shiftUp(array,size-1);
                 }
                 public int poll(){
                     int oldValue=array[0];
                     array[0]=array[--size];
                     shiftDown(array,size,0);
                     return oldValue;
                 }
                 public int peek(){
                     return array[0];
                 }
      }
    }
    public static void shiftUp(int[]  array,int index){
        while(index>0){
            int parent=(index-1)/2;
            if(array[parent]>array[index]){
                break;
            }
            int t=array[parent];
            array[parent]=array[index];
            array[index]=t;
            index=parent;
        }
    }
    public static void shiftDown(int[]  array,int size,int index){
        int left=2*index+1;
        while(left<size){
            int min=left;
            int right=2*index+2;
            if(right<size) {
                if (array[right] < array[left]) {
                    min = right;
                }
            }
            if(array[index]<=array[min]){
                break;
            }
        }
    }
}
