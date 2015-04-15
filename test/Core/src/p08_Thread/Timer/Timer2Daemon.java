package p08_Thread.Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 守护线程与普通线程写法上基本么啥区别，调用线程对象的方法setDaemon(true)，则可以将其设置为守护线程。
 * 守护线程使用的情况较少，但并非无用，举例来说，JVM的垃圾回收、内存管理等线程都是守护线程。
 * 还有就是在做数据库应用时候，使用的数据库连接池，连接池本身也包含着很多后台线程，监控连接个数、超时时间、状态等等。
 * @author Administrator
 */
public class Timer2Daemon {
    public static void main(String[] args) {
        //打印主线程名称
        System.out.println(Thread.currentThread().getName()+"............");
        //默认值为false
        final Timer tr = new Timer("daemon thread0001", true);
  
        tr.schedule(new TimerTask() {
            @Override
            public void run() {
            	int i=0;
            	while(true){
                      System.out.println("守护线程1第" + i++ + "次执行！"); 
                      try { 
                              Thread.sleep(7); 
                      } catch (InterruptedException e) { 
                              e.printStackTrace(); 
                      } 
            		  
            	}
            }//这里的new Date()表示了立即执行
        }, new Date(),1000);
       
        class Td1 implements Runnable {
      		public void run() {
      			  for (int i = 0; i < 5; i++) { 
                        System.out.println("线程1第" + i + "次执行！"); 
                        try { 
                                Thread.sleep(7); 
                        } catch (InterruptedException e) { 
                                e.printStackTrace(); 
                        } 
      			  } 
      		}
      	}
          Thread a = new Thread(new Td1());
          a.start();
    }
    
}

