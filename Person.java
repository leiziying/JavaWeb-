/*
静态代码块的格式是：
public class 类名称{
     static{
     //静态代码块的内容
     }
}
特点：当第一次用到本类时，静态代码块执行唯一的一次
 */
public class Person {
    //静态代码块
          static {
        System.out.println("静态代码块执行！");
    }
    public Person(){
        System.out.println("构造方法执行！");
    }
}
