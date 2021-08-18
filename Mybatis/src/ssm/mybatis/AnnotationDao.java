package ssm.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Abraham
 * @create 16:35/周二/27/07/2021
 */
public interface AnnotationDao {

    @Select("select * from t_employee where id = #{id}")
    Employee getT(Integer id);

    @Update("UPDATE `t_employee` SET `empname`= #{empname},`gender`= #{gender} ,`email`= #{email} WHERE id= #{id}")
    int upDate(Employee emp);

    @Insert("INSERT INTO `t_employee` (`empname`,`gender`,`email`) VALUES (#{empname},#{gender},#{email})")
    int insert(Employee emp);

    @Delete("DELETE FROM`t_employee` WHERE id=#{id}")
    boolean delete(Integer id);
}
