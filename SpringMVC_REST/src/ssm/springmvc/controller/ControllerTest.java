package ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Abraham
 * @create 16:43/周四/15/07/2021
 */
@Controller
public class ControllerTest {
    //get请求，对应查询方法
    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public String getBook(@PathVariable("id")Integer id){
        System.out.println("查询图书"+id);//查询图书1
        return "success";
    }

    //delete请求 对应删除方法
    @RequestMapping(value = "/book/{id}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id")Integer id){
        System.out.println("删除图书"+id); //删除图书1
        return "success";
    }


    //post请求，对应新增方法
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String postBook(){
        System.out.println("新增图书"); //新增图书
        return "success";
    }

    //put请求  对应更新请求
    @RequestMapping(value = "/book/{id}",method = RequestMethod.PUT)
    public String putBook(@PathVariable("id")Integer id){
        System.out.println("更新图书"+id);//更新图书1
        return "success";
    }







}
