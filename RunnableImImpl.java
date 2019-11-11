public class RunnableImImpl  implements  Runnable{
    //定义一个多个线程共享的票源
    private  int ticket=100;
    @Override
    public void run(){
        //设置线程任务，买票
        //先判断票是否存在
       //使用死循环，让买票操作重复执行
        while(true){
            if (ticket > 0) {
                //
                //票存在，买票ticket--
                System.out.println(Thread.currentThread().getName() + "-->正在买第" + ticket + "张票");
                ticket--;
            }
        }
    }
}

