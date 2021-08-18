package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bean.Teacher;
import com.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * @author Abraham
 * @create 10:52/周五/30/07/2021
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherService service;

    @RequestMapping("getTeacher")
    public String handlerForTeacher(@RequestParam("id") Integer id, Model model){
        Teacher teacher = service.getTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "success";
    }


    /**
     * 目前已经可以显示所有老师信息，我们需要对所有信息进行分页处理
     *
     */
    @RequestMapping("getAll")
    public String handleList(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        //pn表示请求发过来的页码，第二个参数7表示每页显示七个数据
        PageHelper.startPage(pn,7);
        List<Teacher> teachers = service.getTeacherList();

        //还可以将集合封装进PageInfo对象,param1是封装数据，param2连续分页
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers,5);
        System.out.println("当前页码:"+pageInfo.getPageNum());
        System.out.println("获取总页码:"+pageInfo.getPages());
        System.out.println("获取总记录数:"+pageInfo.getTotal());
        System.out.println("获取当前页的数据个数:"+pageInfo.getSize());
        System.out.println("获取每页的大小:"+pageInfo.getPageSize());
        System.out.println("获取前一页:"+pageInfo.getPrePage());
        System.out.println("获取下一页:"+pageInfo.getNextPage());
        System.out.println("获取list:"+pageInfo.getList());
        System.out.println("获取首页:"+pageInfo.getNavigateFirstPage());
        System.out.println("获取末页:"+pageInfo.getNavigateLastPage());
        //获取连续分页
        int[] navigatePageNums = pageInfo.getNavigatepageNums();
        System.out.println(Arrays.toString(navigatePageNums));


        model.addAttribute("pageInfo",pageInfo);
        return "success";
    }
}
