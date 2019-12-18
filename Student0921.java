/*
一个标准的类通常要拥有下面四个组成部分
1.所有的成员变量都要使用private关键字修饰
2.为每一对成员变量编写一对儿Getter/Setter方法
3.编写一个无参的构造方法
4.编写一个全参数的构造方法
这样的类也叫作  Java Bean
 */
public class Student0921 {
    private  String name;//姓名
    private  int age;//年龄

    public Student0921() {//无参数的构造方法
    }

    public Student0921(String name, int age) {//全参构造方法
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
