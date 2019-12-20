
public class DemoStatic {
    public static void main(String[] args) {
        Student0923  one=new Student0923("郭靖",19);
        one.room="101教室";
        System.out.println("姓名："+one.getName()+",年龄"+one.getAge()+"，教室："+one.room);
        Student0923  two=new Student0923("黄蓉",20);
        System.out.println("姓名："+two.getName()+",年龄"+two.getAge()+"，教室："+two.room);
    }
}
