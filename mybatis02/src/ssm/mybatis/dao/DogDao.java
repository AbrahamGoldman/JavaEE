package ssm.mybatis.dao;

import ssm.mybatis.bean.Dog;

/**
 * @author Abraham
 * @create 15:41/周三/28/07/2021
 */
public interface DogDao {
    Dog getIt(Integer id);

    Dog SimpleGetDog(Integer id);
}
