package ssm.springmvc.viewresolverandview;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class MyView implements View {


    /**
     *
     * @return 返回的类型，我们设定为返回一个html页面
     */
    @Override
    public String getContentType() {
        return "text/html";
    }

    /**
     * render 视图渲染 ，想做任何的渲染都在这里写了，这就是
     * @param map
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("之前保存的内容"+map);
        httpServletResponse.setContentType("text/html"); //这里要设置内容类型，不需要设置编码格式
        httpServletResponse.getWriter().write("<h1>开始展示</h1>");

    }
}
