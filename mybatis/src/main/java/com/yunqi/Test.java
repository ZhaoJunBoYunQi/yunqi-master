package com.yunqi;

import com.yunqi.dao.YQDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.util.HashMap;

/**
 * @author: yunqi
 * @createdTime: 2019/6/1
 * 描述
 */
public class Test {
    public static void main(String[] args) {

        String resource = "mybatis/mybatis-config.xml";
        YQDao dao;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sessionFactory.openSession();
            dao = sqlSession.getMapper(YQDao.class);
            int sum  = dao.query(2);
            System.out.println(sum);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void test(String[] args) throws Exception {
        HashMap hashMap = new HashMap();
        YQDao yqDao;
        String resource ="mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        yqDao=sqlSession.getMapper(YQDao.class);
        int num = yqDao.query(2);
    }


}
