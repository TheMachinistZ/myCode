import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.io.File;
import java.util.Scanner;

public class Driver {
   private static final Name INPUT_ERROR=new Name("error","error");
   private static final Name QUIT=new Name("quit","quit");
   public static void main(String[] args){
       //初始化字典数据结构阶段
       TelephoneDictionary telephoneDictionary = new TelephoneDictionary();
       String fileName ="data.txt";
       try {
           //从磁盘中读取数据到内存的字典数据结构中
           Scanner data =new Scanner(new File(fileName));
           telephoneDictionary.readFile(data);
       }catch (Exception e){

       }
       //在字典数据结构中查询阶段
       Name nextName=getName();
       while (!nextName.equals(QUIT)){
          if (nextName.equals(INPUT_ERROR)){
              System.out.println("ERROR IN entering NAME,TRY AGAIN.");
          }else {
              //在输入名字既不是退出控制符，也不存在错误的情况下开始查询
              String phoneNumber= telephoneDictionary.getPhoneNumber(nextName);
              if (phoneNumber != null){
                  System.out.println(nextName+"is not in the dictionary" );
              }else {
                  System.out.println("The phoneNnuber for"+nextName+"is"+phoneNumber);
              }
          }
          nextName =getName();
       }
   }

    private static Name getName() {
        Name result =null;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the first and last name here:"+"or quit and end:");
        String name = keyboard.nextLine();
        if (name.trim().toLowerCase().equals("quit")){
            System.out.println("bye bye");
        }else {
            String firstName=null;
            String lastName=null;
            Scanner stringReader =new Scanner(name);
           if (stringReader.hasNext()){
               firstName=stringReader.next();
               if (stringReader.hasNext()){
                   lastName=stringReader.next();
                   result = new Name(firstName,lastName);
               }else{
                   result =INPUT_ERROR;//在有firstName的基础上发现的错误，自然是在这个分支里的又一个分支
               }
           }else {
               result =INPUT_ERROR;
           }
        }
        return result;
    }
    //2022/2/21 复习
    private static  Name getName1(){
       Name result=null;
       Scanner keyboard = new Scanner(System.in);
       System.out.println("type the first name and last name who you want to search for");
       String dataFromKeyboard = keyboard.nextLine();
       Scanner stringReader = new Scanner(dataFromKeyboard);
       if (dataFromKeyboard.trim().equals(QUIT)){
           System.out.println("bye bye");
           result=null;
       }else {
           String firstName=null;
           String lastName=null;
           if (stringReader.hasNext()){
               firstName=stringReader.next();
               if (stringReader.hasNext()){
                   lastName = stringReader.next();
                   result = new Name(firstName,lastName);
               }else {
                   result=INPUT_ERROR;
               }
           }else {
                   result=INPUT_ERROR;
           }
       }
       return result;
    }
}
