package ssm.springmvc.firstcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller   //加上Controller告诉SpringMVC
@RequestMapping("/haha")   //相当于base路径
public class ClassRequestMappingTest {
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("ClassRequestMappingTest...");
        return "success";
    }

    /*
    method 约定的请求方式：
    method =RequestMethod.   表示该方法接收什么样的请求方式发过来的请求，请求方式要对应
    public enum RequestMethod {
	GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE }

    params 约定请求的参数：
    params = {"username","password"} 表示发送过来的参数需要有username和password
    param1为"!email" 表示不能有email
    param1为"username=888" 表示必须带有username，且username的值必须为888
    param1为"username!=123" 表示username不能为123，或可以没有username这个参数也行
    params = {"username!=123","password","!email"}
    表示发过来的参数的username不能为123，可以没有这个参数，必须有password，不能有email

    headers 约定请求头
    User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Edg/91.0.864.67
    表示用户的浏览器必须为Edg 才行

    consumes 约定请求头中的Content-Type  表示：只接受什么样的Content-Type
    produces 告诉浏览器返回的内容类型，返回什么样的Content-Type
     */
    @RequestMapping(value = "/handle02",method = RequestMethod.POST,params = {"username!=123","password","!email"})
    public String handle02(){
        System.out.println("ClassRequestMappingTest...");
        return "success";
    }
    @RequestMapping(value = "handle03",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Edg/91.0.864.67"})
    public String handle03(){
        System.out.println("handle03...");
        return "success";
    }
}
