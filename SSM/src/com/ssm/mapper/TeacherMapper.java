package com.ssm.mapper;


import com.ssm.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Abraham
 * @create 10:37/周四/29/07/2021
 */
public interface TeacherMapper {

    Teacher getTeacherById(Integer id);

    /**
     * 批量插入之后，测试分页功能是否正常
     * @return
     */
    List<Teacher> getTeacherList();

    List<Teacher> getListByCondition(Teacher teacher);

    List<Teacher> getListByIds(@Param("ids") List<Integer> ids);

    List<Teacher> getListByChoose(Teacher teacher);

    Integer updateTeacher(Teacher teacher);
}
