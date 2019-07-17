package com.niaobulashi;

import com.niaobulashi.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleMailApplicationTests {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件字段
        Context context = new Context();
        context.setVariable("siteTitle", "鸟不拉屎");
        context.setVariable("permalink", "https://niaobulashi.com/archives/canteen.html/comment-page-1#comment-1152");
        context.setVariable("title", "公司食堂伙食看起来还不错的亚子（体重有所回升）");
        context.setVariable("author", "测试员");
        context.setVariable("time", "2019-07-16 08:52:46");
        context.setVariable("text", "真的很不错！");
        context.setVariable("ip", "127.0.0.1");
        context.setVariable("mail", "123321@qq.com");
        context.setVariable("status", "通过");
        context.setVariable("manage", "https://niaobulashi.com");
        // 将字段加载到页面模板中
        String emailContent = templateEngine.process("sendMail", context);
        // 添加附件
        String filePath="E:\\workspace\\javaWorkspace\\spring-boot-learning\\spring-boot-21-scheduler-mail\\doc\\test.log";
        mailService.sendHtmlMail("hulang6666@qq.com","主题：这是模板邮件",emailContent, filePath);
    }
}
