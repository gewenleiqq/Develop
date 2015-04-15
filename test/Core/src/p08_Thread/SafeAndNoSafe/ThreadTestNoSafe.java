package p08_Thread.SafeAndNoSafe;

/**
 * 在例子中不安全的情况下输出的结果恰好是逐个递增的(其实是巧合，多运行几次，会产生不同的输出结果)，
 * 为什么会产生这样的结果呢?
 * 因为建立的Count对象是线程共享的，一个线程改变了其成员变量num值，下一个线程正巧读到了修改后的num，所以会递增输出。
 * @author Administrator
 *
 */
public class ThreadTestNoSafe {
	public static void main(String[] args) {  
        Runnable runnable = new Runnable() {  
            public void run() {  
                Count count = new Count();  
                count.count();  
            }  
        };  
        for(int i = 0; i < 10; i++) {  
            new Thread(runnable).start();  
        }  
    }   
}

