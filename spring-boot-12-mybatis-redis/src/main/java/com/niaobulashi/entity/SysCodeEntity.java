package com.niaobulashi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: spring-boot-learning
 * @description: 数字字典
 * @author: https://niaobulashi.com
 * @create: 2019-06-30 10:10
 */
@Data
public class SysCodeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    // 分类编码
    private String kindCode;

    // 分类名称
    private String kindName;

    // CODE编码
    private String code;

    // CODE名称
    private String name;

    // 父级分类编码
    private String parentCode;

    // 排序
    private String disPlaySort;

    // 删除标记(0-未处理，1-已删除)
    private String deleteFlag;

    // 创建日期
    private Date createTime;

    // 创建人
    private String createUserId;

    // 修改日期
    private Date updateTime;

    // 修改人
    private String updateUserId;
}
