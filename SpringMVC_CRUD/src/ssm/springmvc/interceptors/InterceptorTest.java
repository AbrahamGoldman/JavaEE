package ssm.springmvc.interceptors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Abraham
 * @create 15:40/周五/23/07/2021
 */
@Controller
public class InterceptorTest {

    @RequestMapping("/test01")
    public String interceptorTest(){
        System.out.println("interceptorTest方法被调用");
        int a=10/0;
        return "success";
    }
}
