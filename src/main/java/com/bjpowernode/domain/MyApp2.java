package com.bjpowernode.domain;

import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //6[重要]指定要执行的sql语句的表示，sql映射文件的namespace +"." + 标签的id值
        String sqlId = "com/bjpowernode/dao/StudentDao" + "." + "selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        //studentList.forEach(stu -> System.out.println(stu));
        for (Student student : studentList) {
            System.out.println("查询的学生" + student);
        }
        //9.关闭
        sqlSession.close();
    }
}
