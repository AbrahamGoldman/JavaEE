package ssm.mybatis.dao;

import ssm.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Abraham
 * @create 22:57/周二/27/07/2021
 */
public interface Dao {
    Employee getT(Integer id);

    int upDate(Employee emp);

    int insert(Employee emp);

    boolean delete(Integer id);

    Employee getTByIdAndEmpName(@Param("id") Integer id, @Param("empname") String empname);

    List<Employee> getAllEmployee();

    Map<String, Object> getOneReturnMap(Integer id);

    @MapKey("id")
    Map<Integer, Employee> getAllReturnMap();

}
