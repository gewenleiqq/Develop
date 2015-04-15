package p02_Collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * map entry 是一个 key-value 接口
 * @类功能说明:   
 * @公司名称     :中企动力
 * @作者                ：Administrator 
 * @创建时间      ：2014年12月8日 下午4:41:12  
 * @版本                ：V1.0
 */
public class MapEntry {

	public static void main(String[] args) {
		Map<String, Integer> hs=new HashMap<String, Integer>();
		
		System.out.println(hs);
		hs.put("12", 444);
		Set<Entry<String, Integer>> s = hs.entrySet();
		Iterator<Entry<String, Integer>> is = s.iterator();
		if(is.hasNext())
		System.out.println(is.next());
	}

}
