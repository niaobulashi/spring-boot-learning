package com.niaobulashi.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @program: spring-boot-23-shiro-remember
 * @description: 验证码
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-26 10:19
 */
@Controller
@RequestMapping("/captcha")
public class KaptchaController {

    private static final Logger logger = LoggerFactory.getLogger(KaptchaController.class);

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @GetMapping("/captchaImage")
    public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletOutputStream out = response.getOutputStream();
        try {
            HttpSession session = request.getSession();
            response.setDateHeader("Expires", 0);
            // Set standard HTTP/1.1 no-cache headers.
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            // Set standard HTTP/1.0 no-cache header.
            response.setHeader("Pragma", "no-cache");
            // return a jpeg
            response.setContentType("image/jpeg");
            // create the text for the image
            String capText = captchaProducer.createText();
            //将验证码存到session
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
            logger.info(capText);
            // 创建一张文本图片
            BufferedImage bi = captchaProducer.createImage(capText);
            // 响应
            out = response.getOutputStream();
            // 写入数据
            ImageIO.write(bi, "jpg", out);

            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

