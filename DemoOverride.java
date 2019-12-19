/*
重写（Override）：在继承关系当中，方法的名称一样，参数列表【也一样】，覆盖，覆写。
重载（Overload）:方法名称一样，参数列表【不一样】
方法的覆盖重写的特点：创建的是子类对象，则优先用子类方法
方法覆盖重写的注意事项：
    1.必须保证父子类之间方法的名称相同，参数列表也相同
    @Override 写在方法前面用来检测是不是有效的正确覆盖重写（最好写上，更加安全）
    这个注解就算不写，只要满足要求，也是正确的方法覆盖重写

    2.子类方法的返回必须[小于等于]父类方法的返回值范围。
     String有一个父类，Object
     Object类是所有的公共最高父类（祖宗类），位于继承关系的顶端，java.lang.String就是Object的子类

   3.子类方法的权限必须大于等于父类方法的权限修饰符。
     小扩展提示（从大到小）：public  > protected > (default)>  private
     备注：（default）不是关键字default，而是什么都不写，留空
      */
public class DemoOverride{
    public int num;
}
