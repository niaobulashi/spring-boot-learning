/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50635
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-07-13 14:39:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '鸟普拉斯集团');
INSERT INTO `sys_dept` VALUES ('101', '深圳总公司');
INSERT INTO `sys_dept` VALUES ('102', '长沙分公司');
INSERT INTO `sys_dept` VALUES ('103', '研发部门');
INSERT INTO `sys_dept` VALUES ('104', '市场部门');
INSERT INTO `sys_dept` VALUES ('105', '测试部门');
INSERT INTO `sys_dept` VALUES ('106', '财务部门');
INSERT INTO `sys_dept` VALUES ('107', '运维部门');
INSERT INTO `sys_dept` VALUES ('108', '市场部门');
INSERT INTO `sys_dept` VALUES ('109', '财务部门');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色');
INSERT INTO `sys_role` VALUES ('3', '访客');

-- ----------------------------
-- Table structure for `sys_test`
-- ----------------------------
DROP TABLE IF EXISTS `sys_test`;
CREATE TABLE `sys_test` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT 'name',
  `age` int(4) DEFAULT NULL COMMENT 'age',
  `nick_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT 'nick_name',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_test
-- ----------------------------
INSERT INTO `sys_test` VALUES ('1', 'Tom', '13', '123', '2019-07-11 00:16:02');
INSERT INTO `sys_test` VALUES ('2', 'Alice', '16', '2', '2019-07-11 00:16:06');
INSERT INTO `sys_test` VALUES ('7', 'Yoo', '18', '3', '2019-07-11 00:16:08');
INSERT INTO `sys_test` VALUES ('8', 'Y1o', '128', null, '2019-07-12 00:16:40');

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
  `dept_id` bigint(11) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `amt` decimal(11,2) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'hulang6666@qq.com', '13612345678', '1', '100', '2016-11-11 11:11:11', '25.96');
INSERT INTO `sys_user` VALUES ('2', 'test', 'f3fedccee4fd2770e2a35d7083b57605bad4227869639e74b94643cdc3192b36', 'FgfYUWOmCliH581UtjLm', 'test@HH.test.com', '13300000000', '1', '103', '2019-06-05 15:54:26', '123.54');
INSERT INTO `sys_user` VALUES ('3', 'guest', '1600965621d16d33f9386703d6485061eb8f30f38c70051f04e74831ff2933a7', 'd9v2BTrBXvHrU4kNPt1V', 'test@HH.qq.com', '13166666666', '1', '105', '2019-06-14 11:23:20', '19.09');
INSERT INTO `sys_user` VALUES ('4', 'one', 'w123131231', '23143123412', 'q23123', '12312321321', '1', '106', '2019-06-27 23:42:13', '35.99');
INSERT INTO `sys_user` VALUES ('5', 'two', '23131', '2313123', '32131231', '321312321', '1', '106', '2019-06-27 23:42:25', '2.64');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('2', '3');
INSERT INTO `sys_user_role` VALUES ('3', '3');
INSERT INTO `sys_user_role` VALUES ('4', '2');
INSERT INTO `sys_user_role` VALUES ('5', '2');
