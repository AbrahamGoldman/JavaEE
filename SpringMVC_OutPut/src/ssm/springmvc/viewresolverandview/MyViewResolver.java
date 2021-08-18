package ssm.springmvc.viewresolverandview;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author Abraham
 * @create 15:40/周一/19/07/2021
 */
public class MyViewResolver implements ViewResolver, Ordered {
    //因为我们要对解析器进行排序，所以这里必须是加入order，order的值越小就越先执行 ,InternalResourceViewResolver中的order为最大值
    private Integer order;
    @Override
    public int getOrder() {
        return this.order;
    }
    public void setOrder(Integer order){
        this.order=order;
    }

    /**
     * 只处理meinv:前缀的,如果是以meinv:这个前缀开始的，那么就解析成功，否则返回null, 下一个解析器继续解析
     * @param s handlerAdapter调用方法返回的字符串地址，也就是视图名，要去到的地址
     * @param locale
     * @return
     * @throws Exception
     */
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        if(s.startsWith("meinv:"))
            return new MyView();
        return null;
    }
}
