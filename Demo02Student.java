public class Demo02Student {
    public static void main(String[]  args){
        Student stu=new Student();//new 对象就是在调用构造方法
        Student stu1=new Student("赵丽颖",20);//全参构造
        System.out.println("姓名："+stu1.getName()+".年龄"+stu1.getAge());
        //如果需要改变对象当中的成员变量的内容，仍然需要使用setXxx方法
        stu1.setAge(24);
        System.out.println("姓名："+stu1.getName()+".年龄"+stu1.getAge());
    }
}
