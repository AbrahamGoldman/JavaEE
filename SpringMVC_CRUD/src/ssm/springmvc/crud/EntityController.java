package ssm.springmvc.crud;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 测试HttpEntity 和 ResponseEntity
 * @author Abraham
 * @create 21:03/周四/22/07/2021
 */
@Controller
public class EntityController {

    @ResponseBody
    @RequestMapping("/haha")
    public String getSomething(){
        //它不会去success.jsp页面
        return "success";
    }

    /**
     * HttpEntity<String> str 比@ResponseBody 更强，这个拿到整个请求的数据
     * @RequestHeader("")这个只是获取单个请求头参数
     * @param str
     * @return
     */
    @RequestMapping("/haha1")
    public String getSomething1(HttpEntity<String> str){
        System.out.println(str);
       //<username=dd&password=123,[host:"localhost:8080", connection:"keep-alive",
        // content-length:"24", cache-control:"max-age=0", sec-ch-ua:"" Not;
        // A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91"", sec-ch-ua-mobile:"?0",
        // upgrade-insecure-requests:"1", origin:"http://localhost:8080",
        // user-agent:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36",
        // accept:"text/html,application/xhtml+xml,application/xml;
        // q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;
        // v=b3;q=0.9", sec-fetch-site:"same-origin", sec-fetch-mode:"navigate",
        // sec-fetch-user:"?1", sec-fetch-dest:"document",
        // referer:"http://localhost:8080/SpringMVC_CRUD/",
        // accept-encoding:"gzip, deflate, br", accept-language:"en-GB,en-US;q=0.9,en;q=0.8",
        // cookie:"JSESSIONID=BAB0DFAC17218B1BCBEFC1243561296E",
        // Content-Type:"application/x-www-form-urlencoded;charset=UTF-8"]>

        //它不会去success.jsp页面
        return "success";
    }

    /**
     * 泛型中的String表示：响应体中内容的类型
     * @return
     */
    @RequestMapping("haha2")
    public ResponseEntity<String> getSomething2(){
        //响应体中的内容
        String body="success";
        //自定义响应头
        MultiValueMap<String,String> headers=new HttpHeaders();
        headers.add("Set-Cookie","birth=1995-3-20");
        //HttpStatus.OK 响应状态
        ResponseEntity<String> responseEntity =
                new ResponseEntity<>(body, headers, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("/load")
    public ResponseEntity<byte[]> getSomething3() throws IOException {
        FileInputStream is=null;
        try {
            is=new FileInputStream("C:\\Users\\Abraham\\Desktop\\图片\\th.jpg");
            //响应体中的内容
            byte[] body=new byte[is.available()];

            is.read(body);

            //自定义响应头
            MultiValueMap<String,String> headers=new HttpHeaders();
            //Content-Disposition响应标头是指示内容是否预期在浏览器中内联显示的标题，
            // 即，作为网页或作为网页的一部分或作为附件下载并且本地保存。
            headers.set("Content-Disposition","attachment;filename=th.jpg");
            //HttpStatus.OK 响应状态
            ResponseEntity<byte[]> responseEntity =
                    new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
            return responseEntity;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(is!=null)
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    /**
     * 用来接收上传的单个文件
     * 形参：@RequestParam("filename")MultipartFile file 这个参数直接封装了文件信息，可以直接保存
     * @return
     */
    @RequestMapping("/upload")
    public String receive(@RequestParam("username") String username,
                          @RequestParam("password")String password ,
                          @RequestParam("filename")MultipartFile file) throws IOException {

        System.out.println(file.getName());//filename
        System.out.println(file.getOriginalFilename());//夕阳.jpg
        file.transferTo(new File("C:\\Users\\Abraham\\Desktop\\1.jpg"));
        return "success";
    }

    /**
     * 如果文件的name属性值一样，我们用一个MultipartFile[] file 数组来接收多个文件，
     * 只需要遍历每个MultipartFile即可
     * @param username
     * @param password
     * @param file
     * @return
     */
    @RequestMapping("/uploadMultip")
    public String recervese(@RequestParam("username") String username,
                            @RequestParam("password")String password ,
                            @RequestParam("filename")MultipartFile[] file
    ) throws IOException {
        System.out.println("用户名："+username+",密码："+password);
        for (MultipartFile multipartFile : file) {
            if (!multipartFile.isEmpty()) {
                multipartFile.transferTo(new File("C:\\Users\\Abraham\\Desktop\\保存\\" + multipartFile.getOriginalFilename()));
            }
        }
        return "success";
    }
    /**
     * 多文件上传，如果文件的name属性值不一样
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/uploadMultip2")
    public String recervese2(@RequestParam("username") String username,
                            @RequestParam("password")String password ,
                            @RequestParam("filename1")MultipartFile file1,
                            @RequestParam("filename2")MultipartFile file2,
                            @RequestParam("filename3")MultipartFile file3
    ) throws IOException {
        System.out.println("用户名："+username+",密码："+password);
        file1.transferTo(new File("C:\\Users\\Abraham\\Desktop\\保存\\" + file1.getOriginalFilename()));
        file2.transferTo(new File("C:\\Users\\Abraham\\Desktop\\保存\\" + file2.getOriginalFilename()));
        file3.transferTo(new File("C:\\Users\\Abraham\\Desktop\\保存\\" + file3.getOriginalFilename()));
        return "success";
    }

}
