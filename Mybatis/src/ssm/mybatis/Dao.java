package ssm.mybatis;


/**
 * @author Abraham
 * @create 16:48/周一/26/07/2021
 */
//@Alias("ddd")   //针对批量操作的起别名
public interface Dao {

    Employee getT(Integer id);

    int upDate(Employee emp);

    int insert(Employee emp);

    boolean delete(Integer id);

}