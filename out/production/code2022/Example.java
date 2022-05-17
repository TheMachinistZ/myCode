public class Example {
  public static<T> void displayArray(T[] anArray){
      for (T entryInAnArray: anArray){
          System.out.print(entryInAnArray+"\n");
      }
  }
  //程序入口
  public static  void main(String[] args){
      String[] stringArray= new String[]{"233","556","898","8989","8989"};
      displayArray(stringArray);
      Character[] chaArray={'a','c','v','d'};
      displayArray(chaArray);
      swap(chaArray,0,3);
      displayArray(chaArray);
  }
  public static <T> void swap(T[] anArray,int position1,int position2){
       if (position1 <0 ||position2<0 || position1>anArray.length|| position2 >anArray.length )
           return;
        T temp=anArray[position1];
        anArray[position1] =anArray[position2];
        anArray[position2]=temp;
  }
}
