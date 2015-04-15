package p09_Classpath;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class Test {
	public static void main(String args[]){
		Test t=new Test();
		System.out.println(t.getByClassPath());
		
		System.out.println(t.getByJvm());
		
	}
	
	
	/**
	 * 使用类路径
	 * @方法功能说明：
	 * @作者        : Administrator
	 * @创建时间    ：2014年12月25日 下午2:46:37 
	 * @return
	 */
	private String getByClassPath(){
		ProtectionDomain proDomain = Test.class.getProtectionDomain();
		CodeSource codSrc = proDomain.getCodeSource();
		String path = codSrc.getLocation().getPath();
		try {
			path=java.net.URLDecoder.decode(path, "UTF-8");
			return path;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private String getByJvm(){
		//利用了java运行时的系统属性来得到jar文件位置，也是/xxx/xxx.jar这种形式。
		String path = System.getProperty("java.class.path");

		int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
		int lastIndex = path.lastIndexOf(File.separator) + 1;
		path = path.substring(firstIndex, lastIndex);
		
		return path;
	}
	

	 

	//这样，我们就获得了jar包的位置，但是这还不够，我们需要的是jar包的目录。


}	
