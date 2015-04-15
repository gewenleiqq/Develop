package p14_Calendar;


import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;


/*
 * 演示 Calendar 的一般操作
 */
public class CalendarTest{

  public static void main(String[] args) throws ParseException{
    // 字符串转换日期格式
    DateFormat fmtDateTime = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    // 得到日期格式对象
    Date date1 = fmtDateTime.parse("2013-01-21 15:01:20");
    System.out.println(date1);
    
    
    
    // 完整显示日期时间
    String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date());
    System.out.println(str);

    // 创建 Calendar 对象
    Calendar calendar = Calendar.getInstance();
    // 初始化 Calendar 对象，但并不必要，除非需要重置时间
    calendar.setTime(new Date());

    // setTime 类似上面一行
    // Date date = new Date();
    // calendar.setTime(date);

    // 显示年份
    int year = calendar.get(Calendar.YEAR);
    System.out.println("YEAR is = " + String.valueOf(year));

    // 显示月份 (从0开始, 实际显示要加一)
    int MONTH = calendar.get(Calendar.MONTH);
    System.out.println("MONTH is = " + (MONTH + 1));

    // 今年的第 N 天
    int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);
    System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);

    // 本月第 N 天
    int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));

    // 3小时以后
    calendar.add(Calendar.HOUR_OF_DAY, 3);
    int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);
    System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);

    // 当前分钟数
    int MINUTE = calendar.get(Calendar.MINUTE);
    System.out.println("MINUTE = " + MINUTE);

    // 15 分钟以后
    calendar.add(Calendar.MINUTE, 15);
    MINUTE = calendar.get(Calendar.MINUTE);
    System.out.println("MINUTE + 15 = " + MINUTE);

    // 30分钟前
    calendar.add(Calendar.MINUTE, -30);
    MINUTE = calendar.get(Calendar.MINUTE);
    System.out.println("MINUTE - 30 = " + MINUTE);

    // 格式化显示
    str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
    System.out.println(str);

    // 重置 Calendar 显示当前时间
    calendar.setTime(new Date());
    str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
    System.out.println(str);

    // 创建一个 Calendar 用于比较时间
    Calendar calendarNew = Calendar.getInstance();

    // 设定为 5 小时以前，后者大，显示 -1
    calendarNew.add(Calendar.HOUR, -5);
    System.out.println("时间比较：" + calendarNew.compareTo(calendar));

    // 设定7小时以后，前者大，显示 1
    calendarNew.add(Calendar.HOUR, +7);
    System.out.println("时间比较：" + calendarNew.compareTo(calendar));

    // 退回 2 小时，时间相同，显示 0
    calendarNew.add(Calendar.HOUR, -2);
    System.out.println("时间比较：" + calendarNew.compareTo(calendar));
  }
  
  /** 
	 * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8 
	 * @param timeZoneOffset 
	 * @return 
	 */  
	public String getFormatedDateString(int timeZoneOffset){  
	    if (timeZoneOffset > 13 || timeZoneOffset < -12) {  
	        timeZoneOffset = 0;  
	    }  
	    //final TimeZone zone = TimeZone.getTimeZone("GMT+8");  //获取东八区
	    TimeZone timeZone;  
	    String[] ids = TimeZone.getAvailableIDs(timeZoneOffset * 60 * 60 * 1000);  
	    if (ids.length == 0) {  
	        // if no ids were returned, something is wrong. use default TimeZone  
	        timeZone = TimeZone.getDefault();  
	    } else {  
	        timeZone = new SimpleTimeZone(timeZoneOffset * 60 * 60 * 1000, ids[0]);  
	    }  
	  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    sdf.setTimeZone(timeZone);  
	    return sdf.format(new Date());  
	}  
}
