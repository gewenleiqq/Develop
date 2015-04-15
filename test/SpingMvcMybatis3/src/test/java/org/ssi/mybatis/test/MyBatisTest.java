package org.ssi.mybatis.test;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.ssi.api.dao.UserInfoDao;
import org.ssi.mybatis.bean.UserInfo;
/**
 * myBatis-junit4数据库测试
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MyBatisTest {
	 /**
	  * 获得MyBatis SqlSessionFactory
	  * SqlSessionFactory负责创建SqlSession，一旦创建成功，就可以用SqlSession实例来执行映射语句，commit，rollback，close等方法。
	  * @return
	  */
	private  SqlSessionFactory getSessionFactory() {
	  SqlSessionFactory sessionFactory = null;
	  String resource = "config/mybatisConfig.xml";
	  try {
	   sessionFactory = new SqlSessionFactoryBuilder().build(Resources
	     .getResourceAsReader(resource));
	   SqlSession a = sessionFactory.openSession();
//	   a.selectList(arg0)
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  return sessionFactory;
	}
	
	
	@Autowired 
	UserInfoDao userInfoDao;
	
	@Test
	public void findByName() {
		  // test select
		UserInfo user = userInfoDao.findByName("andy");
		System.out.println(user.getAge());
		 Long.toBinaryString(12);
		  // test insert
		  UserInfo user1 = new UserInfo();
		  user1.setName("xl");
		  user1.setAge(22);
		 
//		  userMapper.insertUser(user1);
//
//		  //it is a must or no data will be insert into server.
//		  sqlSession.commit();
	}
}