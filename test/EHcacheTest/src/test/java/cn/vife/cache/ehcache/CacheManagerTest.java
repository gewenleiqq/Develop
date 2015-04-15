package cn.vife.cache.ehcache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
 
public class CacheManagerTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(CacheManagerTest.class.getName());
	  private static final int CACHES_IN_EHCACHE_XML = 15;

     /***
      * the CacheManager Singleton instance
      */
	  protected CacheManager singletonManager;
	  
	 /***
	  * a CacheManager which is created as an instance
	   */
	  protected CacheManager instanceManager;
	  
	 @After
	 public void tearDown() throws Exception {
           if (singletonManager != null) {
                 if (singletonManager.getStatus().equals(Status.STATUS_ALIVE)) {
                     Assert.assertTrue(CacheManager.ALL_CACHE_MANAGERS.contains(singletonManager));
                 }
                 singletonManager.shutdown();
                 Assert.assertFalse(CacheManager.ALL_CACHE_MANAGERS.contains(singletonManager));
             }
           if (instanceManager != null) {
               if (instanceManager.getStatus().equals(Status.STATUS_ALIVE)) {
            	   Assert.assertTrue(CacheManager.ALL_CACHE_MANAGERS.contains(instanceManager));
                }
                instanceManager.shutdown();
                Assert.assertFalse(CacheManager.ALL_CACHE_MANAGERS.contains(instanceManager));
            }
           System.out.println("shut");
	 }
	 
	 @Test
	 public void testCreateCacheManagerFromFile() throws CacheException {
		 singletonManager = CacheManager.create(getClass().getResource("/ehcache1.xml"));
	     Assert.assertNotNull(singletonManager);
	     Cache page = singletonManager.getCache("sampleCache1");
	     for(int i=0;i<10000;i++){
	    	 Element el=new Element(i, i+"--s-safsagggggggggggggaggg", true);
	    	 page.put(el);
	     }
	     Assert.assertEquals(10000, page.getKeys().toArray().length);
	     Assert.assertNotNull(page);
	     LOG.warn(page+"");
	 }
	 
	 @Test
	 public void testCacheToLocal() throws CacheException {
		 singletonManager = CacheManager.create(getClass().getResource("/ehcache1.xml"));
	     Assert.assertNotNull(singletonManager);
	     Cache page = singletonManager.getCache("sampleCache3");
	     for(int i=0;i<10000;i++){
	    	 Element el=new Element(i, i+"--s-safsfasdf分的萨芬的撒范德萨分撒旦法agggggggggggggaggg", true);
	    	 page.put(el);
	     }
	     Assert.assertEquals(10001, page.getKeys().toArray().length);
	     Assert.assertNotNull(page);
	     LOG.warn(page+"");
	 }
}
