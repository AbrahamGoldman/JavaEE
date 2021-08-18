package ssm.springmvc.controller;

import ssm.springmvc.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author Abraham
 * @create 22:47/周四/15/07/2021
 */
@Controller
public class RequestParamTest {
    //这里主要测试获取请求参数，比如username password 等等 .....?username=admin&password=123456
    //下面这种是默认获取请求参数的值，形参的username会直接匹配url中？后面的请求参数名，如果匹配上了就直接赋值
    @RequestMapping("getParam")
    public String getRequestParam(String username){
        //http://localhost:8080/SpringMVC_REST/getParam?username=Smith
        System.out.println("username="+username); //username=Smith 成功获取了请求参数
        //注意这是自动传参，一旦匹配上了就自动传参，如果没有匹配的，输出就是null

        return "success";
    }

    /*
    Spring如何获取请求中的各种信息？
    @RequestParam  获取请求参数
    @RequestHeader 获取请求头
    @CookieValue   获取cookie

    @RequestParam() 中的参数，以及各自的意义：
    value : 请求参数名
    required: 当前参数是否为必要的
    defaultValue: 默认值，当需要的参数没有的时候就赋默认值

    @RequestParam("user") 和 @PathVariable("user")的区别
    @RequestParam("user")  http:.....?user=xxx   这里的user是请求参数
    @PathVariable("user")  http:.../user?...     这里的user是占位符，比如"/book/{user}"
---------------------------------------------------------------------------------------------
    @RequestHeader("") 获取请求头的信息
    value  某个请求头的名字
    required 参数是否为必要的
    defaultValue   设置默认值

---------------------------------------------------------------------------------------------
    @CookieValue
    value : 请求参数名
    required: 当前参数是否为必要的
    defaultValue: 默认值，当需要的参数没有的时候就赋默认值

    以前我们是这么获取cookie的：
    Cookie[] cookies=request.getCookie()
    for(cookie c:cookies){ if(c.getName().equals("...")){...}}
    现在我们直接一个注解搞定
     */


    @RequestMapping("getparam2")   //,defaultValue = "苍老师"
    public String getRequestParam2(@RequestParam(value="username",required = false,defaultValue = "苍老师") String user
    ,@RequestHeader(value = "User-Agent",required = true,defaultValue = "默认User-Agent")String userAgent
    ,@CookieValue(value = "JSESSIONID",defaultValue = "默认cookie") String cookie
    ){
        //required = false 就是表示这个参数非必须
        //上面这一段等价于：user=request.getParamiter("username"); 如果username没有值，就给user赋默认值：user="苍老师"
        //如果把默认值去掉，required = false 就是：username=null
        //如果把默认值去掉，required = true,http://localhost:8080/SpringMVC_REST/getparam2?user=haha 就是：username=null,因为参数不匹配


        System.out.println("username="+user); //username=苍老师
        System.out.println("User-Agent="+userAgent);
        System.out.println("cookie="+cookie);
        //cookie=5E3F6F8B1145E0FC316DE71A8A2B3242
//User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Edg/91.0.864.67
        return "success";
    }

    /**
     * 这里演示的是对javabean的赋值，springmvc会尝试着将JavaBean的属性从request中提取出来，并且尝试给入参赋值
     * 赋值的方式为调用set方法，如果没有set方法就无法赋值，该对象的属性就为空
     * 注意：参数名和属性名要求一致
     * springMVC还可以级联赋值，就是给属性的属性进行赋值：有如下方式 ，我从中截取一段供查阅
     *
     *   销量：<input name="sale" value=""/> <br>
     *     地址信息:<br>
     *     省：<input name="address.provice" value=""/><br>
     *
     * 碰到了一个问题，就是接收到客户端发过来的信息以后，成了乱码，解决办法：
     * 如果是get请求：
     * 在tomcat的server.xml配置文件中，改8080端口，加上 URIEncoding="UTF-8"
     * <Connector URIEncoding="UTF-8" port="8080" protocol="HTTP/1.1"
     *                connectionTimeout="20000"
     *                redirectPort="8443"
     *  />
     *
     * 如果是post请求：
     *需要去web.xml配置过滤器
     *
     * 如果是响应回去了乱码：
     * response.setContentType("text/html;charset=UTF-8");
     *
     *
     * @param book
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(Book book){
        System.out.println("添加图书成功:"+book);
        //添加图书成功:Book{bookName='穷爸爸与富爸爸', author='张三丰', price=69.0, stock=100, sale=500,
        // address=Address{provice='德州', city='洛杉矶', street='阳光大道459号'}}
        return "success";
    }

    /**
     * <body>
     * 登录成功<br>登录成功
     * ${requestScope.requestParam}<br> 成功获取：你好呀
     * ${sessionScope.sessionParam}<br> 成功获取：你也好
     * </body>
     *
     * 原生API可以传哪些：
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal http协议有关的内容
     * Locale :国际化有关的区域信息 :Locale locale1 = request.getLocale();
     *
     * InputStream :ServletInputStream inputStream = request.getInputStream();
     *
     * OutputStream :ServletOutputStream outputStream = response.getOutputStream();
     *
     * Reader  :BufferedReader reader = request.getReader();
     *
     * Writer :PrintWriter writer = response.getWriter();
     *
     * @param request
     * @param session
     * @param response
     * @return
     */
    @RequestMapping("/handler01")
    public String testServletAPI(HttpServletRequest request, HttpSession session,
    HttpServletResponse response
    ){
        request.setAttribute("requestParam","你好呀");
    session.setAttribute("sessionParam","你也好");
        return "success";
    }


}
