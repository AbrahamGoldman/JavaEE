package ssm.spring5.annotation;

import ssm.spring5.configuration.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Abraham
 * @create 21:28/周六/10/07/2021
 */
public class Test {
    @org.junit.Test
    public void test(){
     ApplicationContext context=new ClassPathXmlApplicationContext("bean9.xml") ;
        UserDAO dao = context.getBean("userDAO", UserDAO.class);
        UserDAO dao1 = context.getBean("userDAO", UserDAO.class);
      //  if(dao!=null) dao.setName("弯月");
        System.out.println(dao);//UserDAO{name='弯月'}
        System.out.println(dao==dao1); //true   单例
    }


    @org.junit.Test
    public void test1(){
       ApplicationContext context=new ClassPathXmlApplicationContext("bean10.xml");
        UserService service = context.getBean("userService", UserService.class);
        UserDAO dao = context.getBean("uu", UserDAO.class);
        System.out.println(dao);
        System.out.println(service);  //UserService{userDAO=UserDAO{name='这个DAO叫什么名字呢？'}}
    }
    @org.junit.Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService service = context.getBean("userService", UserService.class);
        PersonDAO person = context.getBean("person", PersonDAO.class);
        System.out.println(person);//PersonDAO{name='Person还没想好'}
        System.out.println(service);//UserService{dao=PersonDAO{name='Person还没想好'}}
    }
}
