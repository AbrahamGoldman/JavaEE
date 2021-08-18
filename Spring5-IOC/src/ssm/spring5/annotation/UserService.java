package ssm.spring5.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


//@Controller
//    @Repository
//@Component
    @Service
public class UserService {

        //@Autowired 这个注解是根据类型匹配，如果有多个实现类的话就换Qualifier
//    @Qualifier(value="userDAO")   //如果有多个实现类，就在实现类头部备注昵称 ，这里填入昵称即可
       // @Qualifier(value="userDAO")
//        @Qualifier("person")

    //卧槽，原来要两个一起用，卧槽，我在这里搞了搞了一个小时，试了各种办法，原来要用两个注解，以后知道了
    //嗯  这里要用两个注解，用一个注解还不行
        @Qualifier("person")
        @Autowired
       private DAO dao;


    @Override
    public String toString() {
        return "UserService{" +
                "dao=" + dao +
                '}';
    }
}
