import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AboutStream {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\新建文件夹\\测试文本文件.txt");
        file.createNewFile();
        OutputStream os=new FileOutputStream(file);
        byte[] buf="我是中国人".getBytes("UTF-8");
        os.write(buf);
    }
}
