package ssm.mybatis.dao;

import ssm.mybatis.bean.Person;

/**
 * @author Abraham
 * @create 16:14/周三/28/07/2021
 */
public interface PersonDao {
    Person getPerson(Integer id);

    Person SimpleGetPerson(Integer id);
}
