/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : home_safety_system

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-05-20 11:44:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alert_history
-- ----------------------------
DROP TABLE IF EXISTS `alert_history`;
CREATE TABLE `alert_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `alert_type` int(4) NOT NULL COMMENT '报警的类型：',
  `alert_value` double(32,0) NOT NULL,
  `alert_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `udpate_time` datetime DEFAULT NULL,
  `content` varchar(255) NOT NULL COMMENT '报警内容',
  `is_latest` int(4) NOT NULL COMMENT '用户是否已经阅读',
  `mark` int(4) DEFAULT '0' COMMENT '标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for room_monitor
-- ----------------------------
DROP TABLE IF EXISTS `room_monitor`;
CREATE TABLE `room_monitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL COMMENT 'room类型',
  `temperature` double(16,0) NOT NULL DEFAULT '0' COMMENT '监控值',
  `humidity` double(16,0) NOT NULL DEFAULT '0',
  `smoke` double(16,0) NOT NULL DEFAULT '0',
  `is_latest` int(2) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '记录产生时间',
  `update_time` datetime NOT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL,
  `sex` int(4) DEFAULT NULL COMMENT '性别',
  `phone_number` varchar(11) DEFAULT NULL COMMENT 'd电话号码',
  `address` varchar(255) DEFAULT NULL COMMENT '用户住址',
  `email` varchar(20) DEFAULT NULL COMMENT '用户邮箱',
  `state` int(4) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `create_time` datetime NOT NULL COMMENT '继续创建时间',
  `update_time` datetime NOT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_contacts
-- ----------------------------
DROP TABLE IF EXISTS `user_contacts`;
CREATE TABLE `user_contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `contact_name` varchar(32) NOT NULL COMMENT '联系人姓名',
  `sex` tinyint(2) DEFAULT NULL COMMENT 'l联系人性别',
  `phone_number` varchar(11) DEFAULT NULL COMMENT 'l联系人电话号码',
  `address` varchar(255) DEFAULT NULL COMMENT 'l联系人住址',
  `email` varchar(20) DEFAULT NULL COMMENT '联系人邮箱',
  `state` int(4) DEFAULT NULL COMMENT '联系人状态',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_room
-- ----------------------------
DROP TABLE IF EXISTS `user_room`;
CREATE TABLE `user_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `room_type` int(4) NOT NULL COMMENT '房间类型：{1：客厅，2：厨房，3：卧室}',
  `temperature_threshold` double DEFAULT NULL COMMENT '温度阈值',
  `humidity_threshold` double DEFAULT NULL COMMENT '湿度阈值',
  `smoke_concentration` double DEFAULT NULL COMMENT '烟雾浓度阈值',
  `create_time` datetime NOT NULL COMMENT '记录创建时间',
  `update_time` datetime NOT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
