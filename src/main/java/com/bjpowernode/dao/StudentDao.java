package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.TestClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface StudentDao {

    Student selectStudentById(Integer id);



    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);


    int countStudent();


    //返回map
    Map<Object,Object> selectMapById(Integer id);



    List<Student> selectAllStudents();

    /*列名和属性名不一样第一种方法*/
    List<MyStudent> selectAllStudents2();

    //列名和属性名不一样第二中国方法
    List<MyStudent> selectDiffColProperty();


    /*第一种模糊查询*/

    List<Student> selectLikeOne(String name);

    List<TestClass> selectTest(TestClass testClass);
}
