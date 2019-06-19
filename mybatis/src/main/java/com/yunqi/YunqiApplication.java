package com.yunqi;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class YunqiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunqiApplication.class, args);
        String resource =  "mybatis/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sessionFactory.openSession();
            int  sum = sqlSession.selectOne("com.yunqi.dao.YQDao.query", 2);
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
