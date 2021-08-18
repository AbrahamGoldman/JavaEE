package ssm.springmvc.viewtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abraham
 * @create 22:46/周六/17/07/2021
 */
@Controller
public class ViewControllerTest {

    @RequestMapping("hello")
    public String hello() {
        System.out.println("hello方法");
        //        return "success";

        //如果要跳转的页面在web目录下，就用下面这两种写法
        //  return "../../hello";
        return "forward:/hello.jsp";  //forward是转发的意思
    }

    @RequestMapping("handler01")
    public String handler() {
        System.out.println("handler方法");
        return "forward:/hello";  //意思是转到hello方法
    }

    //上面我们都是写的请求转发，现在我们试试重定向
    //注意:重定向不需要写全路径，SpringMVC会自动加上项目名
    @RequestMapping("handler02")
    public String handler02() {
        System.out.println("重定向handler02");
        return "redirect:/hello.jsp";  //重定向到web目录下的hello.jsp
    }

    //我们还可以多次重定向
    @RequestMapping("handler03")
    public String handler03() {
        System.out.println("重定向handler03");
        return "redirect:/handler02";  //重定向到handler02方法
    }

    @RequestMapping("handlerview")
    public String handlerView(ModelAndView model){
        List<String> videl=new ArrayList<>();
        videl.add("国产精品");
        videl.add("日韩XXX");
        List<String> imgs=new ArrayList<>();
        imgs.add("苍XX");
        imgs.add("本田XX");
        model.addObject("videl",videl);
        model.addObject("img",imgs);
        return "meinv:youma";
    }

}
