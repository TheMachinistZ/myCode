import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class ScannerTest {
   public static void main(String[] args){
//       String str1 = null;
//       Scanner scanner = new Scanner(System.in);
//       System.out.println("type in your info here:");
//       if (scanner.hasNext()){//在等待输入的时候阻塞
//           str1= scanner.next();
//          System.out.println(""+str1);
//       }
//       System.out.println("type in your info here:");
//       Scanner scanner1 =new Scanner(System.in);
//       int number =scanner1.nextInt();//第二次阻塞
//       System.out.println(""+number);
//       System.out.println("input in your info here:");
//       //更换scanner的数据源 使之不可被阻塞
//       Scanner scanner2 = new Scanner(str1);
//       System.out.println("unblock:"+scanner2.next());
        Scanner scanner = new Scanner(System.in);
        //不含终止符的无限循环输入
        while (scanner.hasNext()){//当数据源为输入设备（如键盘）时，它将会在等待要扫描的输入而阻塞
            //hasNext()与hasNextLine()的基本工作模式是：在输入中搜索分隔符，在搜索过程中将不是分隔符的字符串缓存。两者不同的是，
            //在输入中搜索目标，这个目标是构造或者默认的分隔符，匹配到返回true，不匹配返回false
            System.out.println("you type is :"+scanner.next());
        }
        System.out.println("the end");
        //含终止符的循环输入
       while (!scanner.hasNext("quit")){
           System.out.println("you type is :"+scanner.next());
       }
       System.out.println("the end");
   }
}

