package ssm.springmvc.output;

import ssm.springmvc.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class ModelAttributeTest {
    private Object o1;
    private Object o2;
    private Object o3;
    private Object o4;
    private Object b1;
    private Object b2;
    @ModelAttribute
    public void getBook(Map<String,Book> mv){
        o1=mv;
        System.out.println("开始从数据库获取图书");

        //模拟从数据库获取图书
        Book book=new Book("三国","老王",39.00,100,500);
        b1=book;
        mv.put("xixi",book);
        System.out.println("看看mv是什么类型的："+mv.getClass());
        //看看mv是什么类型的：class org.springframework.validation.support.BindingAwareModelMap

    }

    @RequestMapping("/update")
    public String updateBook(@ModelAttribute("xixi") Book book, Model model,ModelAndView modelAndView,Map<String,Book> map){
        o2=model;
        o3=modelAndView;
        o4=map;
        b2=book;
        Object obj = model.getAttribute("xixi");
        System.out.println("map的类型："+map.getClass());
        //class org.springframework.validation.support.BindingAwareModelMap
        System.out.println("model的类型："+model.getClass());
        //model的类型：class org.springframework.validation.support.BindingAwareModelMap
        System.out.println("modelAndView的类型："+modelAndView.getClass());
        //modelAndView的类型：class org.springframework.web.servlet.ModelAndView
        System.out.println("正在更新到数据库");
        System.out.println(book);
        System.out.println("o1==o2:"+(o1==o2));   //o1==o2:true
        System.out.println("o1==o3:"+(o1==o3));   //o1==o3:false
        System.out.println("o1==o4:"+(o1==o4));   //o1==o4:true
        System.out.println("o2==o3:"+(o2==o3));   //o2==o3:false
        System.out.println("b1==b2:"+(b1==b2));   //b1==b2:true
        System.out.println("b2==obj:"+(b2==obj)); //b2==obj:true
        //开始从数据库获取图书
        //正在更新到数据库
        //Book{bookName='三国', author='老李', price=100.0, stock=100, sale=100}
        return "success";
    }
}
