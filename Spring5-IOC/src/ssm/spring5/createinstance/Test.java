package ssm.spring5.createinstance;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Abraham
 * @create 11:39/周五/09/07/2021
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.如果配置文件不在当前src下，就是FileSystemXmlApplicationContext，里面写（全路径|绝对路径）
        ApplicationContext context=new FileSystemXmlApplicationContext("C:\\Program Files\\javacode\\JavaEE\\Spring5\\config\\bean1.xml");
        //2.通过上下文对象调getBean
        Person xixi = context.getBean("xixi", Person.class);
        xixi.method1();//method1.dududuu ...

        //1.如果配置文件在当前src下，就是ClassPathXmlApplicationContext，里面写（相对路径）
        BeanFactory context1 = new ClassPathXmlApplicationContext("bean2.xml");
        //2.通过上下文对象调getBean
        Person haha = context1.getBean("haha", Person.class);
        haha.method1();//method1.dududuu ...

        System.out.println("+++++++++++++");

        //通过反射的方式获取对象
        Class<?> person = Class.forName("ssm.spring5.createinstance.Person");
        Person o =(Person) person.getDeclaredConstructor(null).newInstance();
        o.method1(); //method1.dududuu ...

        //ApplicationContext继承了BeanFactory
    }

    /**
     * SpringXML文件反射调用set方法注入属性
     */
    @org.junit.Test
    public void test(){
        ApplicationContext tree=new ClassPathXmlApplicationContext("bean2.xml");
        Tree bean = tree.getBean("tree1", Tree.class);
        System.out.println(bean.toString()); //Tree{age=20, name='常青树'}
    }

    /**
     * 测试反射
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @org.junit.Test
    public void test1() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("ssm.spring5.createinstance.Tree");
        Tree o = (Tree)aClass.getDeclaredConstructor().newInstance();
        o.setAge(10);
        System.out.println(o.toString());//Tree{age=10, name='null'}
    }

    /**
     * SpringXML文件调用构造器注入
     */
    @org.junit.Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car.toString());//Car{id=1001, name='上汽大众'}
    }

    /**
     * SpringXML文件p名称空间注入属性
     */
    @org.junit.Test
    public void test3(){
       ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Tree tree2 = context.getBean("tree2", Tree.class);
        System.out.println(tree2); //Tree{age=100, name='柳树'}
    }

    /**
     * 测试给属性注入 “” 和null 值 以及特殊字符比如 <>
     */
    @org.junit.Test
    public void test4(){
     ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Tree tree3 = context.getBean("tree3", Tree.class);
        System.out.println(tree3);
        //Tree{age=30, name=''}  当<property name="name" value=""></property>
        //Tree{age=30, name='null'} 当<property name="name"><null/></property>

        // Tree{age=30, name='<<Hello>>'}
//         <property name="name">
//            <value>
//                <![CDATA[<<Hello>>]]>
//            </value>
//        </property>

    }
}
