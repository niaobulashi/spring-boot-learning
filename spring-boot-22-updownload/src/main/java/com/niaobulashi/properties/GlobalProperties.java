package com.niaobulashi.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-learning
 * @description: 获取配置文件
 * @author: 鸟不拉屎 https://niaobulashiom
 * @create: 2019-07-19 22:53
 */
@Data
@Component
public class GlobalProperties {

    /** 文件存放路径 */
    @Value("${niaobulashi.file.path}")
    private String serverPath;

    /** 文件扩展名 */
    @Value("${niaobulashi.file.extension}")
    private String extension;

}
