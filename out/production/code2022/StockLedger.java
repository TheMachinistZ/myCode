public class StockLedger {
    class Purcase{
        double pricePerShare;
        Purcase(double pricePerShare){
            this.pricePerShare=pricePerShare;
        }

        public double getPricePerShare() {
            return pricePerShare;
        }
    }
    private QueueInterface<Purcase> ledger;
    public StockLedger(){
        ledger=new QueueInterface<Purcase>() {
            @Override
            public void enQueue(Purcase elem) {

            }

            @Override
            public Purcase deQueue() {
                return null;
            }

            @Override
            public Purcase getFront() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void clear() {

            }
        };//这里加分号的原因是，这依然是条句子，尽管这个句子的成分复杂了一点
    }
     public void buy(double sharesBought,double pricePerShare ){
          while (sharesBought>0){
              Purcase purcase=new Purcase(pricePerShare);
              ledger.enQueue(purcase);
              sharesBought--;
          }
     }
     public double sell(double sharesSell,double pricePerShare){
         double saleAmount= sharesSell * pricePerShare;//售价是已经能够算出的，而成本则是需要计算的
        double cost=0;
        while (sharesSell>0){//开始出栈并统计累加价格
            Purcase shareWasSold=ledger.deQueue();
            double pricePerShareWasSold=shareWasSold.getPricePerShare();
            cost=cost+pricePerShareWasSold;
            sharesSell--;
        }
        return saleAmount - cost;
     }
     //双端队列的花式应用，p271 示例 模拟字符串的修改并按输入序输出
     public void TypeInSmiulater(){//磨刀不误砍柴工
        DequeInterface d=new DequeInterface<Character>() {
            @Override
            public void addToFront(Character newEntry) {

            }

            @Override
            public void addToBack(Character newEntry) {

            }

            @Override
            public Character removeFront() {
                return null;
            }

            @Override
            public Character removeBack() {
                return null;
            }

            @Override
            public Character getFront() {
                return null;
            }

            @Override
            public Character getBack() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        //从设备输入装置获取字符
        Character character='2';
     while (character!='.'){//如果输入的字符不等于文件结尾符号
         if (character =='<'){
             d.removeBack();
         }else {
             d.addToBack(character);
         }
     }
        while (!d.isEmpty()){
          System.out.print(d.removeFront());
        }

    }

}
