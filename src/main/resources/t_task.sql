/*
Navicat MySQL Data Transfer

Source Server         : 194
Source Server Version : 50727
Source Host           : 10.110.147.194:3306
Source Database       : web-flash

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-10-15 09:19:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_value` text,
  `update_time` varchar(11) DEFAULT NULL,
  `mm_5` int(11) DEFAULT NULL,
  `mm_30` int(11) DEFAULT NULL,
  `hh_12` int(11) DEFAULT NULL,
  `dd_1` int(11) DEFAULT NULL,
  `dd_2` int(11) DEFAULT NULL,
  `dd_4` int(11) DEFAULT NULL,
  `dd_7` int(11) DEFAULT NULL,
  `dd_15` int(11) DEFAULT NULL,
  `dd_30` int(11) DEFAULT NULL,
  `mt_3` int(11) DEFAULT NULL,
  `mt_6` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
