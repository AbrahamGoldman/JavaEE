package ssm.mybatis.mapper;

import ssm.mybatis.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Abraham
 * @create 10:37/周四/29/07/2021
 */
public interface TeacherMapper {

    Teacher getTeacherById(Integer id);

    List<Teacher> getListByCondition(Teacher teacher);

    List<Teacher> getListByIds(@Param("ids") List<Integer> ids);

    List<Teacher> getListByChoose(Teacher teacher);

    Integer updateTeacher(Teacher teacher);

    /**
     * 批量添加
     * @param list
     * @return
     */
    int insertList(@Param("teachers")List<Teacher> list);
}
