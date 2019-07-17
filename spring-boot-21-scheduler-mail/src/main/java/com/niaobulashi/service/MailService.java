package com.niaobulashi.service;

/**
 * @program: spring-boot-learning
 * @description: 邮件
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-16 09:48
 */
public interface MailService {

    void sendHtmlMail(String to, String subject, String content, String filePath);

}

