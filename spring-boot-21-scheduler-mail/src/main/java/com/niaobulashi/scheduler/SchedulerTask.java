package com.niaobulashi.scheduler;

import com.niaobulashi.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @program: spring-boot-learning
 * @description: 定时任务
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-16 20:21
 */
@Component
public class SchedulerTask {

    private int count=0;

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 每隔一分钟执行一次
     */
    @Scheduled(cron="0 */1 * * * ?")
    private void process(){

        System.out.println("this is scheduler task runing  "+(count++));
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
        String filePath="E:\\workspace\\javaWorkspace\\spring-boot-learning\\spring-boot-21-schedule-mail\\doc\\test.log";
        mailService.sendHtmlMail("hulang6666@qq.com","主题：这是模板邮件",emailContent, filePath);
    }
}

