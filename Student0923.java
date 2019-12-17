//如果一个成员变量使用了static关键字，那么这个变量不在属于对象自己，而是属于所在类，多个对象共享同一份数据
public class Student0923 {
   private  String  name;
   private  int  age;
   static String  room;//所在教室
   public Student0923(){
       //无参构造
   }
    public Student0923(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
