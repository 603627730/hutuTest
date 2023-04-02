package com.example.hututest.io;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.server.HttpServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    @GetMapping("/a")
    public void test(HttpServletResponse httpResponse) throws IOException {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

//图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("/Users/yantonghui/code/hutuTest/.mvn/line.png");
//输出code
        Console.log(lineCaptcha.getCode());
//验证图形验证码的有效性，返回boolean值

//验证图形验证码的有效性，返回boolean值
        lineCaptcha.write(httpResponse.getOutputStream());
//1112
//223
//        333

    }

    @GetMapping("send/{mail}")
    public String sendMail(@PathVariable String mail){
        MailUtil.send(mail, "录取通知书(Offer)", "恭喜您被字节跳动录取，试用期工资为400人民币/day", false);
        return "ok";

    }

}
