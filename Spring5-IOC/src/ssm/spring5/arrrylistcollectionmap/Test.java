package ssm.spring5.arrrylistcollectionmap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Abraham
 * @create 11:05/周六/10/07/2021
 */
public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
        Student stu = context.getBean("stu", Student.class);
        System.out.println(stu);
        //Student{score=[102, 112, 19], books=[Book{name='查密莉亚'}, Book{name='国富论'}, Book{name='富爸爸与穷爸爸'}],
        // courseList=[Course{name='计算机与科学'}, Course{name='金融学'}], map={10=张飞, 20=关羽, 30=赵云},
        // family={爸爸=Person{name='周', age=52}, 妈妈=Person{name='吴', age=49}}}
    }

    @org.junit.Test
    public void test1(){
     ApplicationContext context=new ClassPathXmlApplicationContext("bean5.xml");
        TestUtil bean = context.getBean("test", TestUtil.class);
        TestUtil1 bean1 = context.getBean("test1", TestUtil1.class);
        System.out.println(bean); //TestUtil{map={10=xixi, 20=haha}}
        System.out.println(bean1); //TestUtil1{map={10=xixi, 20=haha}}
    }
}
