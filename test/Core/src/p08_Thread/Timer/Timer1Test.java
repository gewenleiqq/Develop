package p08_Thread.Timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer1Test {
	static SimpleDateFormat sdf = new SimpleDateFormat(
             "YYYY-MM-dd hh:mm:ss");
    public static void main(String[] args) {
        /*
         * 创建Timer对象： 一种线程设施，用于安排以后在后台线程中执行的任务。 可安排任务执行一次，或者定期重复执行。<br>　　　　　　　　　　*
         */
        Timer tm = new Timer("MyThread");
       
        /*
         * 安排指定的任务
         */
        Calendar cal = Calendar.getInstance();
//        cal.set(2015, 2, 2, 10, 11, 00);
        cal.add(Calendar.SECOND, 10);//10秒后执行
        System.out.println(sdf.format(cal.getTime()));
        tm.schedule(new TimerTask() {
            @Override
            public void run() {
            	System.err.print(Thread.currentThread().getName()+" at ");//输出线程的名称，其值为  MyThread<br>
                /*
                 * 输出每秒时间
                 */
                String time = sdf.format(new Date());
                System.err.println(time);
 
            }
        }, cal.getTime(), 1000);
    }
}
