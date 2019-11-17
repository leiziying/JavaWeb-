import java.util.Scanner;

public class YuanYIng {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char[] array=str.toCharArray();
        char c='x';
        for (int i = 0; i <array.length ; i++) {
            if(array[i]=='a'){
                c='a';
                System.out.println("a");
                break;
            }
            if(array[i]=='e'){
                c='e';
                System.out.println("e");
                break;
            }
            if(array[i]=='i'){
                c='i';
                System.out.println("i");
                break;
            }
            if(array[i]=='o'){
                c='o';
                System.out.println("o");
                break;
            }
            if(array[i]=='u'){
                c='u';
                System.out.println("u");
                break;
            }
        }
        if(c=='x'){
            System.out.println("n");
        }

    }
}
