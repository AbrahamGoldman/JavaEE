package com.ssm.service;

import com.ssm.bean.Teacher;
import com.ssm.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abraham
 * @create 9:39/周五/30/07/2021
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper mapper;

//    @Autowired
//    private  SqlSessionFactory factory;
//
//    public TeacherMapper getMapper(){
//        SqlSession sqlSession = factory.openSession();
//        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        return mapper;
//    }

    public Teacher getTeacherById(Integer id){
     //   TeacherMapper mapper = this.getMapper();
        return mapper.getTeacherById(id);
    }
    public List<Teacher> getTeacherList(){
     //   TeacherMapper mapper = this.getMapper();
        return mapper.getTeacherList();
    }


}
