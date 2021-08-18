package ssm.springmvc.login;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;


@Controller
public class LoginController {
    /**
     * 这个对象是我们在-servlet.xml中配置的，可以直接拿来用，它能够过去国际化页面中的key
     */
    @Autowired
    private ResourceBundleMessageSource source;
    /**
     * 国际化的登录页面，还演示了如何过去国际化页面中的key
     * @return
     */
//    @RequestMapping("toLogin")
//    public String toLogin(Locale locale){
//        //第一个参数为key，第二个参数是占位符，第三个参数是区域信息
//        String welcome = source.getMessage("welcome",null,locale);
//        System.out.println(welcome);//欢迎来到这里
//        System.out.println("去登录页面");
//        return "login";
//    }

//    @RequestMapping("toLogin")
//    public String toLogin(@RequestParam(value = "locale",required = false) String localeStr,
//                          HttpSession session, HttpServletRequest request){
//        Locale locale1;
//        if(localeStr!=null&& !"".equals(localeStr)) {
//            String[] s = localeStr.split("_");
//             locale1 = new Locale(s[0], s[1]);
//        }else{locale1 =request.getLocale();}
//        session.setAttribute(SessionLocaleResolver.class.getName() +".LOCALE",locale1);
//
//        //下面是获取国际化页面的key的值，第一个参数为key，第二个参数是占位符，第三个参数是区域信息
//        String welcome = source.getMessage("welcome",null,locale1);
//        System.out.println(welcome);//欢迎来到这里
//        System.out.println("去登录页面");
//
//        return "login";
//    }

    @RequestMapping("toLogin")
    public String toLogin(@RequestParam(value = "locale",required = false) Locale locale){
        //下面是获取国际化页面的key的值，第一个参数为key，第二个参数是占位符，第三个参数是区域信息
        String welcome = source.getMessage("welcome",null,locale);
        System.out.println(welcome);//欢迎来到这里
        System.out.println("去登录页面");
        return "login";
    }

}
