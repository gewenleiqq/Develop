package org.ssi.api.service;  
  
import org.ssi.mybatis.bean.UserInfo;
  
  
public interface UserInfoService {  
  
    UserInfo findByName(String name); 
    void addUserInfo(UserInfo ui);
    void deleteUserInfo(int id);
}  