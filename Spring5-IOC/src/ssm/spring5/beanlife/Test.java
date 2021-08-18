package ssm.spring5.beanlife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Abraham
 * @create 16:11/周六/10/07/2021
 */
public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean7.xml");
        TV tv = context.getBean("tvwuwu", TV.class);
        System.out.println("第六步：这里test方法里面的输出:"+tv);
        ((ClassPathXmlApplicationContext)context).close();

        //如果xml里面通过set方法注入属性，就是下面的结果：
//        第一步：无参构造器
//        第二步：调用set方法做属性注入
//        第三步：后置处理器在对象初始化之前的调用
//        TV{price=699}
//        tvwuwu
//        第四步：初始化方法
//        第五步：后置处理器在对象初始化之后的调用
//        TV{price=699}
//        tvwuwu
//        第六步：这里test方法里面的输出:TV{price=699}
//        第七步：销毁当前bean

        //如果通过构造器注入属性，就会得到下面这样的结果：没有调用set方法了：
//        第一步：有参构造器
//        第三步：后置处理器在对象初始化之前的调用
//        TV{price=999}
//        tvwuwu
//        第四步：初始化方法
//        第五步：后置处理器在对象初始化之后的调用
//        TV{price=999}
//        tvwuwu
//        第六步：这里test方法里面的输出:TV{price=999}
//        第七步：销毁当前bean


    }
}
