public class WaitLine {
    //声明一个内部类用于方便的声明一个顾客类
    class Custmor{
        int clock;//到达的时刻
        int transactionTime;//交易时间
        public  Custmor(int clock,int transactionTime){
            this.clock=clock;
            this.transactionTime=transactionTime;
        }

        public int getClock() {
            return clock;
        }

        public void setClock(int clock) {
            this.clock = clock;
        }

        public int getTransactionTime() {
            return transactionTime;
        }

        public void setTransactionTime(int transactionTime) {
            this.transactionTime = transactionTime;
        }
    }
    //这是一个与队列有关的通用的问题的模型，整体上非常好理解
    //在一个队列参与解决的问题中，每一个时刻都只需同时关注队列的头部和尾部
    //一个时刻三种情况需要同时被关注：1，队头的出队，2，队尾的进队
    public void smiulate(int duration,int arrivalProbablility,int maxTranscationTime){
         //这个方法的功能，就是在一个限定的时间内，以队列的形式可以服务的数量
        //有以下一些前提和要点
        // 在队尾，每一刻都有可能有顾客进来，而每个顾客的客户的服务时间不确定，但不大于某个值，
        //在队头，每一刻都有顾客正在接受服务或者出队列去接受服务
        int numberArrival=0;//总共到达的顾客
        int numberServed=0;//总共获得服务的顾客
        int transcationTimeLeft=0;//剩余服务时间，这个是不是为零，代表这是不是正在有顾客接受服务
        Custmor nextArrvial;
        Custmor nextCustmor;
        //顾客队列
        QueueInterface<Custmor> line=new QueueInterface<Custmor>() {
            @Override
            public void enQueue(Custmor custmor) {

            }

            @Override
            public Custmor deQueue() {
                return null;
            }

            @Override
            public Custmor getFront() {
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
        for (int clock=0;clock<duration;clock++){//时间在流逝，在每个时刻
            //先判断队尾的情况
            if (Math.random() < arrivalProbablility){
                numberArrival++;
                 int transactionTime=(int)(Math.random() * maxTranscationTime +1);//为这个顾客生成一个随机的交易时间
                 nextArrvial=new Custmor(clock,transactionTime);
                 line.enQueue(nextArrvial);
            }
            //再判断队头的情况
            if (transcationTimeLeft>0){
                transcationTimeLeft--;
            }else if (!line.isEmpty()){//这个分支暗含条件 transcationTimeLeft<=0 && !line.isEmpty()
                nextCustmor =line.deQueue();
                transcationTimeLeft=  nextCustmor.getTransactionTime();
                numberServed++;
            }
        }

    }
}
