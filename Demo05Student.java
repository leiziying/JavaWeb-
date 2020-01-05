public class Demo05Student {
    public static void main(String[] args) {
        Student stu=new Student();
        stu.setName("迪丽热巴");
        stu.setAge(25);
        System.out.println("姓名："+stu.getName()+",年龄:"+stu.getAge());
       Student stu2=new Student("古力娜扎",47);
        System.out.println("姓名："+stu2.getName()+",年龄:"+stu2.getAge());
        stu2.setAge(23);
        System.out.println("姓名："+stu2.getName()+",年龄:"+stu2.getAge());
    }
}
