/*
Navicat MySQL Data Transfer

Source Server         : 我的mysql
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : db_chat

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-08-03 17:41:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `self_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_friend
-- ----------------------------
INSERT INTO `t_friend` VALUES ('1', '1', '2');
INSERT INTO `t_friend` VALUES ('2', '2', '1');
INSERT INTO `t_friend` VALUES ('3', '1', '3');
INSERT INTO `t_friend` VALUES ('4', '3', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '111', '我是张三', 'gsl.png');
INSERT INTO `t_user` VALUES ('2', '李四', '111', '我是李四', 'gsl.png');
INSERT INTO `t_user` VALUES ('3', 'ww', '111', 'ww', 'gsl.png');
