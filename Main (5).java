import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] files=File.listRoots();
        for (File  file:files) {
            System.out.println(file);
        }
       /* String path="我是相对路径.txt";
        File file=new File(path);
        file.createNewFile();*/
/*        String path="D:\\新建文件夹\\隐藏文件.txt";
        File file=new File(path);
        System.out.println(file.isHidden());//判断是否是隐藏文件
        System.out.println(file.canRead());//判断文件是否可读*/
        //file.delete();
        /*String parent= "D:\\新建文件夹";
        File file=new File(parent,"test.txt");
        file.createNewFile();//创建新文件
        file.delete();//删除文件
        file.deleteOnExit();//删除文件当退出的时候*/

        /*System.out.println("是否存在："+file.exists());//打印目录是否存在
        System.out.println("是否是文件夹："+file.isDirectory());
        System.out.println("该盘符的空闲空间："+file.getFreeSpace());
        System.out.println("该盘符的可用空间："+file.getUsableSpace());
        System.out.println("该盘符的总空间："+file.getTotalSpace());
        System.out.println("绝对路径："+file.getAbsoluteFile());
        System.out.println("上级路径："+file.getParent());
        System.out.println("可读："+file.canRead());//是否有权限打开
        System.out.println("可写："+file.canWrite());//
        System.out.println("可执行："+file.canExecute());*/
    }
}
