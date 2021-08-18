package ssm.spring5.factorybean;

import ssm.spring5.arrrylistcollectionmap.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Abraham
 * @create 12:31/周六/10/07/2021
 */
public class BookFactory implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        Class<?> aClass = Class.forName("ssm.spring5.arrrylistcollectionmap.Book");
        Book o = (Book)aClass.getDeclaredConstructor().newInstance();
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
