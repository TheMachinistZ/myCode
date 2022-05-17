import java.time.temporal.ValueRange;
import java.util.Iterator;
import java.util.Scanner;

public class FrequencyCounter {
     private DictionaryInterface<String,Integer> wordTable;
     public FrequencyCounter(){//所有的构造方法都应初始化数据域
          wordTable = new SortedDictionary<>();
     }//end default constructor
     public void readFile(Scanner fileReaderScanner){
          //先设定分割符：即指定读取规则
          fileReaderScanner.useDelimiter("//w+");
          //开始读取
          while (fileReaderScanner.hasNext()){
               //读出一个字
               String word =fileReaderScanner.next();
               //光读出来不行，转化为小写字母
               word=word.toLowerCase();
               //判断这个字在字典中是否存在，存在则频度加1，并用替换的方式更新项 不存在 则以频度为1的键值对的项的状态存入字典
               Integer frequency = wordTable.getValue(word);
               if (frequency != null){
                    frequency++;
                    wordTable.add(word,frequency);
               }else {
                    frequency=1;//人为置为1
                    wordTable.add(word,frequency);
               }

          }
          fileReaderScanner.close();
     }
     public void displaly(){
          Iterator<String> keyIterator =wordTable.getKeyIterator();
          Iterator<Integer> valueIterator =wordTable.getValueIterator();
          while (keyIterator.hasNext()){
               System.out.println(keyIterator.next()+""+valueIterator.next());
          }
     }
     public void disPlay(String key){
          System.out.println("the frequency of"+key+"is "+wordTable.getValue(key));
     }
     public void disPlay(Integer frequency){//显示具有某个频度的字
          Iterator<String> keyIterator = wordTable.getKeyIterator();
          Iterator<Integer> valueIterator =wordTable.getValueIterator();
          boolean atleastOneWord=false;
          while (keyIterator.hasNext()){
               if (valueIterator.next() == frequency){
                    atleastOneWord=true;
                    System.out.println(""+keyIterator.next());
               }
          }
          if (!atleastOneWord){//当事情的反面出现的时候
               System.out.println("none");
          }
     }


}
