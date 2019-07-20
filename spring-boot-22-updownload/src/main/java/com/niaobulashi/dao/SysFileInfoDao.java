package com.niaobulashi.dao;

import com.niaobulashi.model.SysFileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-learning
 * @description: 文件
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-19 22:17
 */
public interface SysFileInfoDao extends JpaRepository<SysFileInfo, Integer> {

}
