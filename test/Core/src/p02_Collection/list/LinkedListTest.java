package p02_Collection.list;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {  
        LinkedList<String> link=new LinkedList<String>();  
        link.add("A");//向链表中添加数据  
        link.add("B");  
        link.add("C");  
        System.out.println("初始化链表"+link);//输出链表内容  
        link.addFirst("D");//在链表的表头增加内容  
        link.addLast("E");//在链表的表尾增加内容  
        System.out.println("增加之后的链表"+link);  
         
        System.out.println(link.element());//用element()方法找表头，输出  
        System.out.println(link);//找完之后的链表  
        System.out.println(link.peek());//用peek()方法找到表头，并且不删除  
        System.out.println(link);//找完之后的链表  
        System.out.println(link.poll());//找到并删除链表的头  
        System.out.println(link);//找完之后的链表  
        /** 
         * 用FIFO方式取出内容 
         */  
        for(int i=0;i<link.size()+1;i++){  
            System.out.println(link.poll()+";");  
        }  
        
        System.out.print(link.getFirst());  
    }  
}
