package ssm.spring5.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


//下面的四个注解都能使用，（value=）这个可以写也可以不写，一般不写
//@Component
//@Service
//@Controller
@Repository("uu")
public class UserDAO implements DAO{
   @Value(value = "名字还没想好")
    private String name;


    @Override
    public String toString() {
        return "UserDAO{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void add() {
        System.out.println("UserDAO中的add方法。。。。");
    }
}
