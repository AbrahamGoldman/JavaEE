package ssm.springmvc.crud;

import ssm.springmvc.crud.bean.Employee;
import ssm.springmvc.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author Abraham
 * @create 14:19/周四/22/07/2021
 */
@Controller
public class AjaxController {

    @Autowired
    private EmployeeDao dao;

    /**
     * 注解@ResponseBody 将返回的数据放在响应体中，如果是对象，JackSON将自动转成JSON格式
     * 我是通过http://localhost:8080/SpringMVC_CRUD/ajaxGet 这个直接就能获取到
     *
     * @return
     */
    @ResponseBody//将返回的数据放在响应体中，如果是对象，JackSON将自动转成JSON格式
    @RequestMapping("/ajaxGet")
    public Collection<Employee> ajaxGet() {
        Collection<Employee> all = dao.getAll();
        return all;
    }

    /**
     * 注解@RequestBody String body 的意思是将请求体赋值给body
     * 注意区别于 @RequestParam
     * @param body
     * @return
     */
    @RequestMapping("/testBody")
    public String getBody(@RequestBody String body) {
        System.out.println("body:" + body);
        return "success";
//        body:------WebKitFormBoundaryaiurDqXZV9HVAAbx
//        Content-Disposition: form-data; name="username"
//
//        dd
//                ------WebKitFormBoundaryaiurDqXZV9HVAAbx
//        Content-Disposition: form-data; name="password"
//
//        123
//                ------WebKitFormBoundaryaiurDqXZV9HVAAbx
//        Content-Disposition: form-data; name="file"; filename="hehe.txt"
//        Content-Type: text/plain
//
//        喜刷刷喜刷刷
//                ------WebKitFormBoundaryaiurDqXZV9HVAAbx--
    }

    /**
     * 注解：@RequestParam("username") String name ，它是精确的获取某个属性的值
     * 而@RequestBody是获取整个请求体
     * @param name
     * @return
     */
    @RequestMapping("/testBody2")
    public String getBody2(@RequestParam("username") String name){
        System.out.println("name="+name);//name=haha
        return "success";
    }



    /**
     * 这里要测试客户端也就是页面使用Ajax请求发送JSON数据给服务器，然后服务器封装成对象
     * @param employee
     * @return
     */
    @RequestMapping("/testBody3")
    public String getAjaxJSON(@RequestBody Employee employee){
        System.out.println("employee="+employee);
        //employee=Employee [id=null, lastName=卢布dfdfdfdf, email=125656566@qq.com, gender=1,
        // department=null, birth=Thu Jul 22 18:10:40 GMT+08:00 , salary=null]
        return "success";
    }



}
