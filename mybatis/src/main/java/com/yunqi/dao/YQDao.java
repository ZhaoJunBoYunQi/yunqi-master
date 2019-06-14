package com.yunqi.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @author: yunqi
 * @createdTime: 2019/6/1
 * 描述
 */
public interface YQDao {
    @Select("select stock from product where id = #{id}")
    int query(Integer id);
}
