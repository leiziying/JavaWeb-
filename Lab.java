/*
1.收集现场
   1.数组有序有问题
   2.快速排序有问题
   3.选边上做基准值
   4.数据量小没问题，大有问题
2.推理
  案发原因：快排退化成单支树了，栈里放不下
3.解决办法
  1.栈小了==>把栈调大
  2.退化成单支树了==》选基准值办法调整
  3.栈溢出了==》
 */
import java.util.Arrays;
public class Lab{
        interface  SortMethod{
            /**
             * @return 排序方法名称
             *
             */
            String getName();
            /**
             * 排序 a
             * @param a
             */
            void sort(int[] a);
        }
        interface BuildMethod{

        }

    }


