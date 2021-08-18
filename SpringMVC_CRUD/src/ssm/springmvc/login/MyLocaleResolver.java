package ssm.springmvc.login;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Abraham
 * @create 10:29/周六/24/07/2021
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String locale = request.getParameter("locale");
        if(locale!=null&& !"".equals(locale)) {
            String[] s = locale.split("_");
            Locale locale1 = new Locale(s[0], s[1]);
            return locale1;

        }
        return request.getLocale();
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
           throw new RuntimeException("不能设置区域信息");
    }
}
