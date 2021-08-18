package ssm.springmvc.output;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;

/**
 * SpringMVC除了在方法的形参传入HttpServletRequest,Response,Session来设置参数外，还有其他的方法
 * 形参处传入的Map , Model , ModelMap 等都会直接传入到域中，下面来测试是传到了哪个域。
 *登录成功 pageScope: requestScope:嘻嘻 sessionScope: application:
 *传入到request域
 *
 * 我们还查看了Map , Model , ModelMap 的参数分别是哪些类：getClass()
 *class org.springframework.validation.support.BindingAwareModelMap
 * 发现它们都是同一个实现类：BindingAwareModelMap，中文名字叫：绑定感知模型映射
 *
 */
@Controller
@SessionAttributes(value={"xixi"},types={String.class}) //value根据名字匹配，types根据类匹配
public class OutPutTest {
    @RequestMapping("outPut")
    public String outPutTest(){
        System.out.println("outPutTest1....");
        return "success";
    }

    @RequestMapping("scopeTest1")
    public String OutPutTest1(Map<String,Object> map){
        map.put("xixi","嘻嘻");
        map.put("haha","哈哈");
        System.out.println("Map-map："+map.getClass());
        //class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }
    @RequestMapping("scopeTest2")
    public String OutPutTest2(Model model){
        model.addAttribute("xixi","嘻嘻");
        System.out.println("Model-model："+model.getClass());
        //class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }
    @RequestMapping("scopeTest3")
    public String OutPutTest3(ModelMap map){
        map.addAttribute("xixi","喜喜");
        System.out.println("ModelMap-map："+map.getClass());
        //class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("scopeTest4")
    public ModelAndView OutPutTest4(){
        //ModelAndView：模型和视图。模型：数据或javaBean，view视图层就是jsp页面
        ModelAndView modelAndView=new ModelAndView("success");
        //这里的addObject也就将数据保存到request域中,requestScope:${requestScope.xixi}<br>
        modelAndView.addObject("xixi","ModeAndView");
        return modelAndView;
    }

//    @RequestMapping("toLogin")
//    public String login() {
//
//        return "login";
//    }

}
