import java.util.Scanner;

public class TelephoneDictionary{
    private DictionaryInterface<Name,String> phoneBook;

    public TelephoneDictionary(DictionaryInterface<Name, String> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public TelephoneDictionary() {//构造方法应该初始化数据域
        phoneBook = new SortedDictionary<>();
    }
    public void readFile(Scanner data){
         while (data.hasNextLine()){
             String oneData = data.nextLine();
             Scanner oneDataReader = new Scanner(oneData);
             String firstName=oneDataReader.next();
             String lastName=oneDataReader.next();
             String phoneNumber =oneDataReader.next();
             Name name= new Name(firstName,lastName);
             phoneBook.add(name,phoneNumber);
         }
         data.close();
    }
   public String getPhoneNumber(Name name){
        return null;
   }
   public String remove(Name name){
       String result = phoneBook.remove(name);
       return result;
   }
   public String modify(Name name,String newPhoneNumber){
      return phoneBook.add(name,newPhoneNumber);

   }
}
