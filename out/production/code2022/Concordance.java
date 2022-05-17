import java.util.Iterator;
import java.util.Scanner;

public class Concordance {
   private DictionaryInterface<String,ListWithIterator<Integer>> wordTable;

    public Concordance(DictionaryInterface<String, ListWithIterator<Integer>> wordTable) {
        this.wordTable = wordTable;
    }
    public void readFile(Scanner data){
        int lineNumber=1;
        while (data.hasNextLine()){
            String line =data.nextLine();
            Scanner lineProcessor = new Scanner(line);
            lineProcessor.useDelimiter("//w+");
            while (lineProcessor.hasNext()){
                String word = lineProcessor.next();
                ListWithIterator<Integer> listWithIterator = wordTable.getValue(word);//获取列表
                if (listWithIterator==null){
                    listWithIterator = new ListWithIterator<Integer>() {
                        @Override
                        public Iterator<Integer> getIterator() {
                            return null;
                        }

                        @Override
                        public void add(Integer newEnty) {

                        }

                        @Override
                        public void add(int newPosition, Integer newEntry) {

                        }

                        @Override
                        public Integer remove(int givenPosition) {
                            return null;
                        }

                        @Override
                        public void clear() {

                        }

                        @Override
                        public Integer replacce(int givenPosition, Integer newEntry) {
                            return null;
                        }

                        @Override
                        public Integer getEntry(int givenPosition) {
                            return null;
                        }

                        @Override
                        public Integer[] toArray() {
                            return new Integer[0];
                        }

                        @Override
                        public boolean contains(Integer anEntry) {
                            return false;
                        }

                        @Override
                        public int getLength() {
                            return 0;
                        }

                        @Override
                        public boolean isEmpty() {
                            return false;
                        }
                    };
                    wordTable.add(word,listWithIterator);
                }
                listWithIterator.add(lineNumber);


            }
            lineNumber++;
        }

    }
    public  void display(){
        Iterator<String> keyIterator =wordTable.getKeyIterator();
        Iterator<ListWithIterator<Integer>> valueIterator =wordTable.getValueIterator();
        while (keyIterator.hasNext()){
            System.out.println(""+keyIterator.next());
            //返回的不是一个值，而是一个数据结构：当返回的是一个数据结构而不是一个值的时候，这个数据结构应该至少提供迭代器，即至少提供一个遍历它的方法
            // 另外的，迭代器可以认为是提供了一层另外的抽象：对数据结构访问行为的封装。
            // 比如iterator.next()就是提供了无视特定数据结构对数据组织方式的，访问下一条数据项的能力
            //例如，无论是二叉树还是字典，都可以用iterator.next()，规格统一的访问下一条数据，而无视他们不同的结构。
            while (valueIterator.next().getIterator().hasNext()){
                System.out.println(""+valueIterator.next().getIterator().next());        }
        }
    }
    //2022/2/25 readFile复习
    public void readFile2(Scanner data){
       int numberOfLine=1;
       while (data.hasNextLine()){
           String line=data.nextLine();
           line=line.toLowerCase();
           Scanner scanner = new Scanner(line);
           while (scanner.hasNext()){
               ListWithIterator<Integer> listWithIterator = wordTable.getValue(scanner.next());
               //下面的分支只是代表这个词是第一次出现，还是重复出现，第一次出现比重复出现多一道处理工序
               if (listWithIterator == null){//第一次出现
                   listWithIterator = new ListWithIterator() {
                       @Override
                       public Iterator getIterator() {
                           return null;
                       }

                       @Override
                       public void add(Object newEnty) {

                       }

                       @Override
                       public void add(int newPosition, Object newEntry) {

                       }

                       @Override
                       public Object remove(int givenPosition) {
                           return null;
                       }

                       @Override
                       public void clear() {

                       }

                       @Override
                       public Object replacce(int givenPosition, Object newEntry) {
                           return null;
                       }

                       @Override
                       public Object getEntry(int givenPosition) {
                           return null;
                       }

                       @Override
                       public Object[] toArray() {
                           return new Object[0];
                       }

                       @Override
                       public boolean contains(Object anEntry) {
                           return false;
                       }

                       @Override
                       public int getLength() {
                           return 0;
                       }

                       @Override
                       public boolean isEmpty() {
                           return false;
                       }
                   };
                   wordTable.add(listWithIterator);
               }
               listWithIterator.add(numberOfLine);
           }
           numberOfLine++;
       }
       data.close();
    }
    public ListWithIterator<Integer> getNumberLines(String key){
         return  wordTable.getValue(key);
    }
}
