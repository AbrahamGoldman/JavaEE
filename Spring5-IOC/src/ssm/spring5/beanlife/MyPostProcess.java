package ssm.spring5.beanlife;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Abraham
 * @create 16:17/周六/10/07/2021
 */
public class MyPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步：后置处理器在对象初始化之前的调用");
        System.out.println(bean);
        System.out.println(beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步：后置处理器在对象初始化之后的调用");
        System.out.println(bean);
        System.out.println(beanName);
        return bean;
    }
}
