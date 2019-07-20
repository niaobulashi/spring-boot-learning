package com.niaobulashi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: spring-boot-learning
 * @description: 文件信息表
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-19 22:08
 */
@Data
@Entity
@Table(name = "sys_file_info")
public class SysFileInfo implements Serializable {

    @Id
    @GeneratedValue
    private Integer fileId;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Long fileSize;
}
