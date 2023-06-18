/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : zuul

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 18/06/2023 17:30:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  `room_Id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreign_key_1`(`room_Id`) USING BTREE,
  CONSTRAINT `foreign_key_1` FOREIGN KEY (`room_Id`) REFERENCES `room_info` (`id`) ON DELETE NO ACTION ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (0, '无尽之刃', 18, 3);
INSERT INTO `goods` VALUES (1, '死亡之爪', 39, 8);
INSERT INTO `goods` VALUES (2, '红水晶', 41, 1);
INSERT INTO `goods` VALUES (3, '三相之力', 43, 2);
INSERT INTO `goods` VALUES (4, '破败之刃', 23, 2);
INSERT INTO `goods` VALUES (5, '龙息', 74, 6);
INSERT INTO `goods` VALUES (6, '多兰盾', 98, 1);
INSERT INTO `goods` VALUES (7, '猫', 27, 3);
INSERT INTO `goods` VALUES (8, '狗', 73, 0);
INSERT INTO `goods` VALUES (9, '苹果', 51, 0);
INSERT INTO `goods` VALUES (10, '梨子', 21, 6);
INSERT INTO `goods` VALUES (11, '魔法书', 33, 3);
INSERT INTO `goods` VALUES (12, '鸭子', 92, 0);
INSERT INTO `goods` VALUES (13, '巨神之锤', 83, 1);
INSERT INTO `goods` VALUES (14, '篮球', 13, 8);
INSERT INTO `goods` VALUES (15, '足球', 99, 8);

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (0, 'garden', '花园');
INSERT INTO `room_info` VALUES (1, 'classroom', '教室');
INSERT INTO `room_info` VALUES (2, 'canteem', '食堂');
INSERT INTO `room_info` VALUES (3, 'office', '办公室');
INSERT INTO `room_info` VALUES (4, 'lobby', '大堂');
INSERT INTO `room_info` VALUES (5, 'playground', '操场');
INSERT INTO `room_info` VALUES (6, 'dorm', '宿舍');
INSERT INTO `room_info` VALUES (7, 'gate', '校门');
INSERT INTO `room_info` VALUES (8, 'trainingroom', '训练室');

SET FOREIGN_KEY_CHECKS = 1;
