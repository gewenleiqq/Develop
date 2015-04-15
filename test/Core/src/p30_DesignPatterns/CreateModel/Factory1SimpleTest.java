package p30_DesignPatterns.CreateModel;

/**
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * @author Administrator
 *
 */
public class Factory1SimpleTest {
	public MsgSender produce(String type) {  
        if ("mail".equals(type)) {  
            return new MailMsgSender();  
        } else if ("qq".equals(type)) {  
            return new QQMsgSender();  
        } else {  
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
    }
	public static void main(String[] args) {  
		Factory1SimpleTest factory = new Factory1SimpleTest();  
        MsgSender sender = factory.produce("qq");  
        sender.send();  
    }  
}
