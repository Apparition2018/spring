/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : jpa

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 15/11/2019 15:34:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jpa_persons
-- ----------------------------
DROP TABLE IF EXISTS `jpa_persons`;
CREATE TABLE `jpa_persons`  (
  `id` int(11) NOT NULL,
  `last_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `birth` datetime(6) NULL DEFAULT NULL,
  `address_id` int(11) NULL DEFAULT NULL,
  `add_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKqxvej0aspup6unktlrfguosi2`(`address_id`) USING BTREE,
  CONSTRAINT `FKqxvej0aspup6unktlrfguosi2` FOREIGN KEY (`address_id`) REFERENCES `jpa_address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
