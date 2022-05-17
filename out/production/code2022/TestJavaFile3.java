import java.io.File;
import java.io.IOException;

public class TestJavaFile3 {
    public static void main(String[] args){
        File file = new File("D:"+File.separator+"5555"+File.separator+"test.lol");
        if (!file.exists()){
            try {
                file.createNewFile();
                System.out.println("lol");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getPath());
    }
}

