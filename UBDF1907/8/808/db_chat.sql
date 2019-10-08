/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : db_chat

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-08-08 10:12:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_crowd
-- ----------------------------
DROP TABLE IF EXISTS `t_crowd`;
CREATE TABLE `t_crowd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL,
  `creater_id` int(11) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_crowd
-- ----------------------------
INSERT INTO `t_crowd` VALUES ('1', 'ubdf1907', 'gsl.png', '1', '2019-08-07 11:11:11', 'ubdf1907 大数据学习群');
INSERT INTO `t_crowd` VALUES ('2', '高手群', 'gsl.png', '1', '2019-8-7 10:43:33', '高手高手高高手');
INSERT INTO `t_crowd` VALUES ('3', '华山论剑', 'gsl.png', '2', '2019-8-8 9:46:54', '华山论剑');

-- ----------------------------
-- Table structure for t_crowd_member
-- ----------------------------
DROP TABLE IF EXISTS `t_crowd_member`;
CREATE TABLE `t_crowd_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `crowd_id` int(11) NOT NULL,
  `join_time` varchar(255) NOT NULL,
  `status` int(11) NOT NULL COMMENT '1 正常 2 禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_crowd_member
-- ----------------------------
INSERT INTO `t_crowd_member` VALUES ('1', '1', '1', '2019-8-8 8:55:44', '1');
INSERT INTO `t_crowd_member` VALUES ('2', '1', '2', '2019-8-8 8:55:59', '1');
INSERT INTO `t_crowd_member` VALUES ('3', '2', '1', '2019-8-8 8:30:30 ', '1');
INSERT INTO `t_crowd_member` VALUES ('4', '2', '2', '2019-8-8 8:55:44', '1');
INSERT INTO `t_crowd_member` VALUES ('5', '2', '3', '2019-8-8 9:46:54', '1');

-- ----------------------------
-- Table structure for t_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `self_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_friend
-- ----------------------------
INSERT INTO `t_friend` VALUES ('1', '1', '2');
INSERT INTO `t_friend` VALUES ('2', '2', '1');
INSERT INTO `t_friend` VALUES ('3', '1', '3');
INSERT INTO `t_friend` VALUES ('4', '3', '1');
INSERT INTO `t_friend` VALUES ('27', '2', '3');
INSERT INTO `t_friend` VALUES ('28', '3', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '111', '我是张三', 'gsl.png');
INSERT INTO `t_user` VALUES ('2', '李四', '111', '我是李四', 'gsl.png');
INSERT INTO `t_user` VALUES ('3', 'ww', '111', 'ww', 'gsl.png');
INSERT INTO `t_user` VALUES ('4', '��ʤ��', '123456', '������', '1.jpg');
INSERT INTO `t_user` VALUES ('5', '王嘉铭', '123', '为你按下F键', '乔碧萝.jpg');
INSERT INTO `t_user` VALUES ('6', '史晓露', '111', '为你按下F键', 'F');
INSERT INTO `t_user` VALUES ('7', '李佳妮', '111', '。。', '1.jpg');
INSERT INTO `t_user` VALUES ('8', '卢姥爷', '123', '123', '123');
INSERT INTO `t_user` VALUES ('9', '刘艳辉', 'lyh', '赌徒', '赌徒');
INSERT INTO `t_user` VALUES ('10', '刘家鑫', '111', '大噶猴', '1.');
INSERT INTO `t_user` VALUES ('11', '郭帅彬', '123456', '有事没事s一下', 'dfdf');
INSERT INTO `t_user` VALUES ('12', '吴晓娟', '123', '1', '1');
INSERT INTO `t_user` VALUES ('13', '�����', '123', 'i am zhangzhejie', '1.jpg');
INSERT INTO `t_user` VALUES ('14', '侯泽华', '111', 'iamhzh', 'gsl.png');
INSERT INTO `t_user` VALUES ('15', '李东升', '111', '我是李东升', '1.gpg');
INSERT INTO `t_user` VALUES ('16', 'zhangzhejie', '123', 'i am zhangzhejie', '1.jpg');
INSERT INTO `t_user` VALUES ('17', 'ynn', '111', 'i am ynn', '1.jpj');
