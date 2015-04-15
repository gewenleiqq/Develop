package org.ssi.api.dao;

import org.ssi.mybatis.bean.UserInfo;
 public interface UserInfoDao {
     public UserInfo findByName(String name);
     public void insertUser(UserInfo user);
     public void deleteById(Integer id);
 }