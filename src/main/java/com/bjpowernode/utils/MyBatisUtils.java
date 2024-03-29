package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory;
    static {
        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //创建sqlSessionFactory对象，使用SqlSessionFactoryBuild
             factory = new SqlSessionFactoryBuilder().build(in);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取sqlSession方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if(factory != null){
             sqlSession = factory.openSession();

        }
        return sqlSession;
    }
}
