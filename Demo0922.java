import java.util.*;

public   class Demo0922{
    public class Node{
        int val;
        Node left=null;
        Node right=null;
        Node(int val){
            this.val=val;
        }
    }
    public static void preorder(Node  root){
      Stack<Node>  stack=new Stack<>();
      Node cur=root;
      while(cur!=null||!stack.isEmpty()){
          while(cur!=null){
              System.out.println(cur.val);
              stack.push(cur);
              cur=cur.left;
          }
          Node top=stack.pop();
          cur=top.right;
      }
    }
    public static void inorder2(Node root){
        Stack<Node> stack =new Stack<>();
        Node cur=root;
        Node last=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                System.out.println();
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
    }
    public  static void postorder(Node root){
        Stack<Node>  stack=new Stack<>();
        Node cur=root;
        Node last=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.peek();
            if(top.right==null||top.right==last){
                System.out.println(top.val);
                stack.pop();
                last=top;
            }else{
                cur=top.right;
            }
        }
    }
    //非递归的前序遍历
    public List<Integer> preorderTraversal(Node root){
     List<Integer>  list=new ArrayList<>();
     Stack<Node>  stack=new Stack<>();
     Node cur=root;
     while(cur!=null||stack.isEmpty()){
         while(cur!=null){
             //打印
             list.add(cur.val);
             //入栈
             stack.push(cur);
             cur=cur.left;
         }
        Node top=stack.pop();
         cur=top.right;
     }
     return list;
    }
    //非递归的中序遍历
    public List<Integer>  inorder(Node root){
        List<Integer>  list=new ArrayList<>();
        Stack<Node>  stack=new Stack<>();
        Node cur=root;
        while(cur!=null||stack.isEmpty()){
            while(cur!=null){
                //先入栈
                stack.push(cur);
                //打印
                list.add(cur.val);
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
        return list;
    }
}

