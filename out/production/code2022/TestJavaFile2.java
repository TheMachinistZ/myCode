import java.io.File;
import java.io.IOException;

public class TestJavaFile2 {
   public static  void main(String[] args){
       File  file = new File("D:"+File.separator+"6666"+File.separator+"777"+File.separator+"testJava.txt");//这个File类可以是文件也可以是一个目录
       File parentFile = file.getParentFile();

       if (!parentFile.exists()){
           parentFile.mkdirs();
       }

       if (!file.exists()){
           try {
               file.createNewFile();
           } catch (IOException e) {

               e.printStackTrace();
           }
       }
      System.out.println(file.getPath());
   }
}
