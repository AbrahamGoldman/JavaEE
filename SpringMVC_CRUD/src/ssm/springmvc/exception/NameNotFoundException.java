package ssm.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 在@ResponseStatus(reason = "用户名错误",value = HttpStatus.NOT_ACCEPTABLE)
 * reason 表示异常的原因， value表示状态码
 */
@ResponseStatus(reason = "用户名错误",value = HttpStatus.NOT_ACCEPTABLE)
public class NameNotFoundException extends Exception {

    static final long serialVersionUID = 8751129948L;
}
