package ssm.springmvc.firstcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * url地址 模糊匹配
 * ？  *   **
 * ？ 表示匹配任意的单个字符
 * *  表示匹配任意的多个字符和一层目录
 * ** 表示匹配多层目录
 */
@Controller
@RequestMapping("url")
public class RequestMappingURLTest {

    @RequestMapping("/ant01")  //只能匹配 href="url/ant01"
    public String antTest(){
        System.out.println("urlTest");
        return "success";
    }
    @RequestMapping("/ant0?")  //用了模糊匹配以后 href="url/ant05" 可以匹配到
    public String antTest1(){
        System.out.println("urlTest1....<>");
        return "success";
    }

    //ant1 后面必须再加上一层，如果不加就报错，ant1后面加不加字母无所谓，但是必须加上一层路径
    @RequestMapping("/ant1*/*")  //用了模糊匹配以后 href="url/ant1/hgh"
    public String antTest2(){
        System.out.println("urlTest2....<>");
        return "success";
    }
    @RequestMapping("/ant0/**/")  //用了模糊匹配以后 href="url/ant0/dfd/dfd"
    public String antTest3(){
        System.out.println("urlTest3....<>");
        return "success";
        //可以匹配如下几种：
        //url/ant0
    }
    @RequestMapping("/{xixi}/{haha}")  //注意 它和 /**  或者/*/* 不同，*不能获取*代表的值，但是这个可以
    public String pathVariable(@PathVariable("xixi") String str1,@PathVariable("haha") String str2){
        System.out.println("str1="+str1+", str2="+str2);
        return "success";
        //  <a href="url/dfd/dxsxs">pathVariable测试</a>
        // 结果为：str1=dfd, str2=dxsxs
    }
}
