package org.ssi.mybatis.bean;
/**
 * 用户类
 *
 * @author db2admin
 *
 */
public class UserInfo {
 private String name;
 private Integer age;
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public Integer getAge() {
  return age;
 }
 public void setAge(Integer age) {
  this.age = age;
 }
 public UserInfo() {
 }
}