package ssm.spring5.createinstance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这里主要测试给属性中赋对象值
 *
 * @author Abraham
 * @create 22:02/周五/09/07/2021
 */
public class Test1 {
    /**
     * 测试外部bean的方式给属性赋值
     */
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Man man = context.getBean("man", Man.class);
        System.out.println(man);//Man{car=Car{id=1002, name='广汽本田'}}
    }

    /**
     * 测试内部bean的方式给属性赋值
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Man bean = context.getBean("man1", Man.class);
        System.out.println(bean);//Man{car=Car{id=1003, name='德国奔驰'}}
    }

    /**
     * 测试级联赋值
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Man bean = context.getBean("man3", Man.class);
        System.out.println(bean);
        //Man{car=Car{id=1005, name='杜卡迪'}}
        //Man{car=Car{id=1005, name='宝马'}}
    }

}
