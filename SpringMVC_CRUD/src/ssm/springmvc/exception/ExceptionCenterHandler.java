package ssm.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 这个类是集中处理所有异常的类，所以要加入IOC容器中，如何加入呢？用一个专门的注解@ControllerAdvice
 * 注解：@ControllerAdvice 表示告诉SpringMVC表示当前类只处理异常！
 * 如果全局异常处理和该类的异常处理同时存在，那么该类的异常处理优先匹配
 */
@ControllerAdvice
public class ExceptionCenterHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handler1(Exception exception){
        System.out.println("全局的handler1"+exception);//全局的handler1java.lang.ArithmeticException: / by zero
        ModelAndView modelAndView = new ModelAndView("Myerror");
        //因为我们接下来要去错误页面，所以我们异常把出了什么错误显示在页面上
        modelAndView.addObject("exception",exception);
        return modelAndView;
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ModelAndView handler2(Exception exception){
        System.out.println("全局的handler2"+exception);
        ModelAndView modelAndView = new ModelAndView("Myerror");
        //因为我们接下来要去错误页面，所以我们异常把出了什么错误显示在页面上
        modelAndView.addObject("exception",exception);
        return modelAndView;
    }

//    @ExceptionHandler(value = {RuntimeException.class})
//    public ModelAndView handler3(Exception exception){
//        System.out.println("全局的handler3"+exception);
//        ModelAndView modelAndView = new ModelAndView("Myerror");
//        //因为我们接下来要去错误页面，所以我们异常把出了什么错误显示在页面上
//        modelAndView.addObject("exception",exception);
//        return modelAndView;
//    }
}
