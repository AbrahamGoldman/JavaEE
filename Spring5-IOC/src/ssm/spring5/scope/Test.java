package ssm.spring5.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Abraham
 * @create 14:27/周六/10/07/2021
 */
public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean7.xml");
        Phone phone = context.getBean("phone", Phone.class);
        Phone phone1 = context.getBean("phone", Phone.class);
        System.out.println(phone.hashCode());
        System.out.println(phone1.hashCode());
        System.out.println(phone);
        System.out.println(phone1);
        //当scope的默认值为singleton，就是单例，在配置文件加载的时候就造出来了，singleton为默认值
//        1297978429
//        1297978429
//        com.spring5.scope.Phone@4d5d943d
//        com.spring5.scope.Phone@4d5d943d

        //我们把scope换成prototype试试
//        825249556
//        883151184
//        com.spring5.scope.Phone@31304f14
//        com.spring5.scope.Phone@34a3d150
    }
    @org.junit.Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        Phone phone = context.getBean("phone", Phone.class);
        Phone phone1 = context.getBean("phone", Phone.class);
        System.out.println(phone.hashCode());
        System.out.println(phone1.hashCode());
        System.out.println(phone);
        System.out.println(phone1);
        //当scope的默认值为singleton，就是单例，在配置文件加载的时候就造出来了，singleton为默认值
        //我们两次获取都是同样的值
//        1297978429
//        1297978429
//        com.spring5.scope.Phone@4d5d943d
//        com.spring5.scope.Phone@4d5d943d

        //我们把scope换成prototype试试
//        825249556
//        883151184
//        com.spring5.scope.Phone@31304f14
//        com.spring5.scope.Phone@34a3d150
    }

}
