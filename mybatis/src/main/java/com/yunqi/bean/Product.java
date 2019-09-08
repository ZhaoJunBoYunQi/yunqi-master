package com.yunqi.bean;
import java.util.Date;
import java.sql.Timestamp;
public class Product{
  private Integer id;
  private String name;
  private Integer productNo;
  private Integer stock;
  private String version;
  private Date createTime;
  private Timestamp updateTime;
  public void setId(Integer id) {
      this.id = id;
  }
  public void setName(String name) {
      this.name = name;
  }
  public void setProductNo(Integer productNo) {
      this.productNo = productNo;
  }
  public void setStock(Integer stock) {
      this.stock = stock;
  }
  public void setVersion(String version) {
      this.version = version;
  }
  public void setCreateTime(Date createTime) {
      this.createTime = createTime;
  }
  public void setUpdateTime(Timestamp updateTime) {
      this.updateTime = updateTime;
  }
  public Integer getId () {
      return id;
  }
  public String getName () {
      return name;
  }
  public Integer getProductNo () {
      return productNo;
  }
  public Integer getStock () {
      return stock;
  }
  public String getVersion () {
      return version;
  }
  public Date getCreateTime () {
      return createTime;
  }
  public Timestamp getUpdateTime () {
      return updateTime;
  }
}