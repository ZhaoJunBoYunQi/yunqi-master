package com.yunqi.bean;
public class FhDept{
  private Integer id;
  private String name;
  private Integer pid;
  public void setId(Integer id) {
      this.id = id;
  }
  public void setName(String name) {
      this.name = name;
  }
  public void setPid(Integer pid) {
      this.pid = pid;
  }
  public Integer getId () {
      return id;
  }
  public String getName () {
      return name;
  }
  public Integer getPid () {
      return pid;
  }
}