import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       while(scanner.hasNext()){
           char[] c=scanner.next().toCharArray();
           StringBuffer sb=new StringBuffer();
           Set<Character> set =new HashSet<Character>();
            for (int i = 0; i <c.length ; i++) {
               if(set.add(c[i]))
                   sb.append(c[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
