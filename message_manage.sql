/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.12.2
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 192.168.12.2:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 08/11/2021 21:05:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message_manage
-- ----------------------------
DROP TABLE IF EXISTS `message_manage`;
CREATE TABLE `message_manage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_manage` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_manage
-- ----------------------------
INSERT INTO `message_manage` VALUES (1, 'False');

SET FOREIGN_KEY_CHECKS = 1;
