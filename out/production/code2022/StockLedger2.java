public class StockLedger2 {//双端队列版
    class StockPurchase{
        private double numberOfShares;
        private double costPerShare;

        public StockPurchase(double numberOfShares, double costPerShare) {
            this.numberOfShares = numberOfShares;
            this.costPerShare = costPerShare;
        }

        public double getNumberOfShares() {
            return numberOfShares;
        }

        public double getCostPerShare() {
            return costPerShare;
        }

        public void setNumberOfShares(double numberOfShares) {
            this.numberOfShares = numberOfShares;
        }

        public void setCostPerShare(double costPerShare) {
            this.costPerShare = costPerShare;
        }
    }
    private DequeInterface<StockPurchase> waitLine;
    StockLedger2(){
        waitLine=new DequeInterface<StockPurchase>() {
            @Override
            public void addToFront(StockPurchase newEntry) {

            }

            @Override
            public void addToBack(StockPurchase newEntry) {

            }

            @Override
            public StockPurchase removeFront() {
                return null;
            }

            @Override
            public StockPurchase removeBack() {
                return null;
            }

            @Override
            public StockPurchase getFront() {
                return null;
            }

            @Override
            public StockPurchase getBack() {
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
     }
     public void buy(double numberOfShares,double costPerShares){
        StockPurchase stockPurchase=new StockPurchase(numberOfShares,costPerShares);
        waitLine.addToBack(stockPurchase);
     }
     //返回收益
     public double sell(double sharesSold,double pricePerShare){
        double saleAmount=sharesSold * pricePerShare;
        double costAmount=0;

        //根据出售数量计算成本
        while (sharesSold >0){
           //训练通过观察表象，获取本质的思维方式
           StockPurchase transaction =waitLine.removeFront();
           double numberOfShares = transaction.getNumberOfShares();
           if (sharesSold -numberOfShares >0){
               //卖完了
               costAmount= costAmount+numberOfShares * pricePerShare;

           }else {
               //没卖完
               transaction.setNumberOfShares(numberOfShares-sharesSold);
               waitLine.addToFront(transaction);
               costAmount=sharesSold * pricePerShare;
           }
           sharesSold=sharesSold-numberOfShares;
        }
        return saleAmount-costAmount;
     }

}
