import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class TestJavaFile {

    public static void main(String[] args){
         File file;
        File dir = new File("D:"+File.separator);
        try {
            file = File.createTempFile("MyTestJavaFile",".javatemp",dir);
            System.out.println(file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
