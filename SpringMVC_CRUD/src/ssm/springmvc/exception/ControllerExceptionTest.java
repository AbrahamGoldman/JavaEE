package ssm.springmvc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerExceptionTest {

    /**
     * 处理请求，如果i等于0，会抛出异常
     * @param i
     * @return
     */
    @RequestMapping("handler01")
    public String handler(@RequestParam("i") Integer i){
        System.out.println(10/i);
        return "success";
    }

    @RequestMapping("handler02")
    public String handler02(@RequestParam("name") String name) throws NameNotFoundException {
        if("haerbin".equals(name)){return "success";}
        throw new NameNotFoundException();

    }

    /**
     * 告诉SpringMVC这个方法专门处理这个类的异常
     * value={}里面写异常类，表明处理什么样的异常
     * 我们还可以给入参传入Exception,用来接收所产生的异常
     * 注意，我们要给隐含域中传入异常就不能使用Model了要使用ModelAndView, 传入页面的同时加入异常就可以了
     * @return
     */
//    @ExceptionHandler(value={ArithmeticException.class,NullPointerException.class, NotAcceptableStatusException.class})
//    public ModelAndView handlerException(Exception exception){
//        //我们还可以把异常传进来看一看是什么异常
//        System.out.println(exception);//java.lang.ArithmeticException: / by zero
//        ModelAndView modelAndView = new ModelAndView("Myerror");
//        //因为我们接下来要去错误页面，所以我们异常把出了什么错误显示在页面上
//        modelAndView.addObject("exception",exception);
//        //出错啦 哈哈哈，错误名：java.lang.ArithmeticException: / by zero，看能不能解决
//
//        return modelAndView;
//    }

}
