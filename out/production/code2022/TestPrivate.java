public class TestPrivate {

    public static void main(String[] args){
        Item item =new Item("222",3);
        System.out.println(""+item);
    }
}

class Item{
   private int data;
   private String name;
    public Item(String name,int data){
      this.data =data;
      this.name =name;
    }
   private int getData(){
        return  this.data;
   }
}