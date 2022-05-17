import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DriverOfFrequencyCounter {//FrequencyCounter 的客户程序
    public static void main(String[] args){
        //先设置一个以文件为数据源的扫描器
        FrequencyCounter frequencyCounter = new FrequencyCounter();
        try {
            Scanner scannerOfFile=new Scanner(new File("data.txt"));
            frequencyCounter.readFile(scannerOfFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         frequencyCounter.displaly();

    }
}
