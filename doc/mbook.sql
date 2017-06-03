/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : mbook

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-06-04 00:16:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT '逻辑UID',
  `category` varchar(32) NOT NULL COMMENT '类别',
  `name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '书名',
  `author` varchar(16) NOT NULL COMMENT '作者',
  `description` text NOT NULL COMMENT '简介',
  `price` int(11) NOT NULL COMMENT '价格',
  `stock` int(32) NOT NULL COMMENT '库存量',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增UID',
  `uid` varchar(32) NOT NULL COMMENT '图书类别UID',
  `description` varchar(20) NOT NULL COMMENT '图书类别描述',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '3ffe9403ae4f4a5f86faa80702b3c68e', '计算机', '0', '2017-06-02 18:37:45', '2017-06-02 18:37:45');
INSERT INTO `category` VALUES ('2', 'ba3a49dff7434ab98bcb58023ac69f17', '文学', '0', '2017-06-03 09:12:09', '2017-06-03 09:12:09');
INSERT INTO `category` VALUES ('3', '979d73ae29a74cee8b2bd904a15c75d2', '历史', '0', '2017-06-03 09:12:49', '2017-06-03 09:12:49');
