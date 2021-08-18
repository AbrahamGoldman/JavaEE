package ssm.springmvc.firstcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller   //通过这个标签来告诉Spring，这是控制层，就是处理请求的servlet
public class FirstController {

    @RequestMapping("/hello")  //请求映射
    public String controller(){
        System.out.println("FristController...");
      //  return "/WEB-INF/pages/success.jsp"; //直接返回一个路径，告诉Springmvc
       //我们在springmvc.xml配置了视图解析器，它会帮我们自动拼串
        return "success";
    }
    @RequestMapping("/handle")
    public String controller1(){
        System.out.println("FirstController...handle");
        return "success";
    }
}
