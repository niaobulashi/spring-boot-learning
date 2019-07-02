/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50635
Source Host           : 127.0.0.1:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-07-02 11:08:39
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'a15115cf69a20d3a54470afb83625d45af98c30be7eebcf2d5cf86d4fab4c422', 'YzcmCZNvbXocrsz9dm8e', '12321321', '11111111111213', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('4', 'niaobulashi', '9aced8c1b9e0ac996d1687f1b5510b9bcab77433ea4d3afb99e8532e8b68da8d', 'hOBPuOFXVyPWogE6cozV', 'niaobulashi@niaobulashi.com', '13111112222', '1', '12', '2019-06-16 15:03:24');
INSERT INTO `sys_user` VALUES ('5', '小刘', '12321人发人21人', '12额饿4123123131', '12321321', '11111111111213', '1', '1', '2019-06-27 20:05:44');
INSERT INTO `sys_user` VALUES ('6', '大力', 'dd910232094', '014019431', '0q309489138', '109340934', '1', '1', '2019-06-27 20:06:21');
