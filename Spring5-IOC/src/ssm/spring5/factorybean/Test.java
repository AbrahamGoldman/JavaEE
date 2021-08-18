package ssm.spring5.factorybean;

import ssm.spring5.arrrylistcollectionmap.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Abraham
 * @create 12:37/周六/10/07/2021
 */
public class Test {
    public static void main(String[] args) {
        //Spring默认的是：加载配置文件的时候，就直接把单例造出来了
        ApplicationContext context=new ClassPathXmlApplicationContext("bean6.xml");
        Book book = context.getBean("bookFactory", Book.class);
        book.setName("计算机科学");
        System.out.println(book);  //Book{name='计算机科学'}
        //配置文件如下，这就是工厂bean，我们在配置文件中写的是工厂，但是实际调用的是工厂实现类的getObject()
        //<bean id="bookFactory" class="com.spring5.factorybean.BookFactory"></bean>
    }
}
