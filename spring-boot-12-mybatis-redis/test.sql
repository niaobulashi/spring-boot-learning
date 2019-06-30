/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50635
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-06-30 23:32:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_code`
-- ----------------------------
DROP TABLE IF EXISTS `sys_code`;
CREATE TABLE `sys_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `kind_code` varchar(20) DEFAULT NULL COMMENT '分类编码',
  `kind_name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `code` varchar(20) DEFAULT NULL COMMENT 'CODE编码',
  `name` varchar(40) DEFAULT NULL COMMENT 'CODE名称',
  `parent_code` varchar(50) DEFAULT NULL COMMENT '父级分类编码',
  `display_sort` varchar(10) DEFAULT NULL COMMENT '排序',
  `delete_flag` varchar(2) DEFAULT NULL COMMENT '删除标记(0-未处理，1-已删除)',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  `update_user_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_code
-- ----------------------------
INSERT INTO `sys_code` VALUES ('1', 'GENDER', '性别', '0', '男', null, '0', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('2', 'GENDER', '性别', '1', '女', null, '1', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('6', 'CONFIRM_LETTER_TYPE', '确认函类型', '01', '财产追加', null, '3', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('7', 'CONFIRM_LETTER_TYPE', '确认函类型', '02', '财产赎回', null, '4', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('8', 'CONFIRM_LETTER_TYPE', '确认函类型', '03', '财产分配', null, '5', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('9', 'CONFIRM_LETTER_TYPE', '确认函类型', '04', '投配结果确认函', null, '6', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('10', 'CONFIRM_LETTER_TYPE', '确认函类型', '05', '投配接收确认函', null, '7', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('11', 'BEIJING', '省份', '01', '北京', 'PROVINCE', '0', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('12', 'HUBEI', '省份', '02', '湖北', 'PROVINCE', '1', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('13', 'WUHAN', '城市', '0201', '武汉市', 'HUBEI', '0', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('14', 'XIANNING', '城市', '0202', '咸宁市', 'HUBEI', '1', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('15', 'HUANGGANG', '城市', '0203', '黄冈市', 'HUBEI', '2', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('16', 'WUCHANG', '区县', '020101', '武昌区', 'WUHAN', '0', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('17', 'HANKOU', '区县', '020102', '汉口区', 'WUHAN', '1', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('18', 'HANYANG', '区县', '020103', '汉阳区', 'WUHAN', '2', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('19', 'YYJD', '镇级', '02010101', '杨园街道', 'WUCHANG', '0', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('20', 'HHLJD', '镇级', '02010102', '黄鹤楼街道', 'WUCHANG', '1', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('21', 'WORKTYPE', '工作类型', '01', '需求分析', null, '0', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('22', 'WORKTYPE', '工作类型', '02', '详细设计', null, '1', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('23', 'WORKTYPE', '工作类型', '03', '编码开发', null, '2', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('24', 'WORKTYPE', '工作类型', '04', '集成测试', null, '3', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('34', 'WORKTYPE', '工作类型', '05', '版本发布', '', '5', '0', '2018-10-08 17:04:27', null, null, null);
INSERT INTO `sys_code` VALUES ('49', 'COUNTRY', '国家', '0', '国家', null, '0', '0', null, null, null, null);
INSERT INTO `sys_code` VALUES ('50', 'PROVINCE', '省', '1', '省', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'hulang6666@qq.com', '13612345678', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'test', 'f3fedccee4fd2770e2a35d7083b57605bad4227869639e74b94643cdc3192b36', 'FgfYUWOmCliH581UtjLm', 'test@HH.test.com', '13300000000', '1', '1', '2019-06-05 15:54:26');
INSERT INTO `sys_user` VALUES ('3', 'guest', '1600965621d16d33f9386703d6485061eb8f30f38c70051f04e74831ff2933a7', 'd9v2BTrBXvHrU4kNPt1V', 'test@HH.qq.com', '13166666666', '1', '12', '2019-06-14 11:23:20');
INSERT INTO `sys_user` VALUES ('4', 'one', 'w123131231', '23143123412', 'q23123', '12312321321', '1', '1', '2019-06-27 23:42:13');
INSERT INTO `sys_user` VALUES ('5', 'two', '23131', '2313123', '32131231', '321312321', '1', '1', '2019-06-27 23:42:25');
