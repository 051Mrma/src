package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.TestClass;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1002);
        System.out.println(student);
    }
    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("zhangfei", 20);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testCountStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int i = dao.countStudent();
        System.out.println("查询结果" + i);
    }

    @Test
    public void testSelectMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println(map);
    }

    @Test
    public void testSelectAllStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectAllStudents2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectAllStudents2();
        for (MyStudent myStudent : myStudents) {
            System.out.println(myStudent);
        }
    }

    @Test
    public void testSelectDiffColProperty(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectDiffColProperty();
        for (MyStudent myStudent : myStudents) {
            System.out.println(myStudent);
        }
    }

    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        TestClass tc = new TestClass();
        tc.setTestID(1001);
        tc.setTestName("wangwu");
        List<TestClass> test = dao.selectTest(tc);
        for (TestClass testClass : test) {
            System.out.println(testClass);
        }


    }
}
