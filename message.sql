/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.2.1
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 192.168.2.1:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 07/11/2021 13:04:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `message_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `message_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `message_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `message_content` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `message_status` int(2) NULL DEFAULT 0,
  `message_fabulous_ip` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (69, '192.168.13.215', '2021-11-06 16:17:05', 'benjamin测试标题111', '北京.海淀', 'benjamin测试内容1111', 1, NULL);
INSERT INTO `message` VALUES (70, '192.168.13.215', '2021-11-05 20:11:50', 'QA不加班留言板，标题', 'unknow', 'QA不加班留言板，留言内容', 1, NULL);
INSERT INTO `message` VALUES (71, '172.21.172.161', '2021-11-06 18:52:16', '测试获取地址', '局域网.[]', '测试获取地址', 1, NULL);
INSERT INTO `message` VALUES (77, '171.217.91.151', '2021-11-05 23:48:07', '333', '四川省.成都市', '3333', 1, NULL);
INSERT INTO `message` VALUES (78, '112.64.109.94', '2021-11-06 16:17:33', '大砍刀', 'unknow', '不要998不要998，今天就今天，只有今天，两块钱你买不了吃亏两块钱你买不了上当，走过路过不要错过', 1, NULL);
INSERT INTO `message` VALUES (90, '171.217.91.151', '2021-11-06 16:17:25', '333', '四川省.成都市', '3333', 0, NULL);
INSERT INTO `message` VALUES (93, '192.168.13.215', '2021-11-06 16:11:43', '123123', '局域网.[]', '21321312', 0, NULL);
INSERT INTO `message` VALUES (94, '171.217.91.151', '2021-11-07 12:59:44', 'QAbujiaban.com（QA不加班）', '四川省.成都市', '劳动者不加班无需理由\n鄙视我的人这么多，你算老几?\n\n不要和我比懒，我懒得和你比', 0, NULL);
INSERT INTO `message` VALUES (95, '112.64.109.94', '2021-11-06 18:51:31', '天黑了', 'unknow', '各回各家', 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
