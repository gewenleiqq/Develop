package org.ssi.service.impl;  
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;
import org.ssi.api.dao.UserInfoDao;
import org.ssi.api.service.UserInfoService;
import org.ssi.mybatis.bean.UserInfo;
  
  
@Service("userInfoService")  
public class UserInfoServiceImpl implements UserInfoService {  
      
    @Autowired 
    private UserInfoDao userInfoDao;  
      
    public  UserInfo findByName(String name) {  
        return userInfoDao.findByName(name);  
    }

    @Transactional(value="isMysql")
	public void addUserInfo(UserInfo ui) {
		userInfoDao.insertUser(ui);
//		throw new RuntimeException("fsffs");
	}
	
    @Transactional(value="isMysql")
	public void deleteUserInfo(int id) {
		// TODO Auto-generated method stub
		userInfoDao.deleteById(id);
//		throw new RuntimeException("fsffs");
	}  
  
}  