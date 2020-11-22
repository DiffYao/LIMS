/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : bookman

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2020-03-12 12:39:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `isbn` varchar(100) DEFAULT NULL,
  `category_code` varchar(100) DEFAULT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publisher_code` varchar(100) DEFAULT NULL,
  `publisher_name` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `edition` tinyint(4) DEFAULT NULL,
  `translator` varchar(100) DEFAULT NULL,
  `language_code` varchar(100) DEFAULT NULL,
  `language_name` varchar(100) DEFAULT NULL,
  `pages` int(10) DEFAULT NULL,
  `words` int(10) DEFAULT NULL,
  `location_code` varchar(100) DEFAULT NULL,
  `location_name` varchar(100) DEFAULT NULL,
  `total_number` int(10) DEFAULT '0',
  `left_number` int(10) DEFAULT '0',
  `description` varchar(2000) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  `img_path` varchar(2000) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `creater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('1', '水电费', '1223', '02', 'B　哲学、宗教', '水电费', '7-302', '清华大学出版社-北京', '12.00', null, '张胜', 'CH', '汉语', '56', '12055', '一号架', '一号架', '13', '2', '啥的方式', null, null, null, null, '2020-01-06 09:50:02', null, '2020-03-11 23:17:19');
INSERT INTO `tb_book` VALUES ('6', '来自星星的你', '7-80142-676-2', '05', 'F　经济', '三毛', '7-302', '清华大学出版社-北京', '12.00', '1', '张三', 'CH', '汉语', '123', '123000', '一号架', '一号架', '12', '12', '', null, null, null, null, '2020-01-09 13:57:55', null, '2020-02-01 15:06:25');
INSERT INTO `tb_book` VALUES ('7', '三毛说1', '223313', '03', 'D　政治、法律', '三毛1', '7-81029', '暨南大学出版社-广州', '22.00', '2', '是的', 'CH', '汉语', '25', '23', '三号架', '三号架', '26', '24', '水电费', null, null, null, null, '2020-01-09 14:16:28', null, '2020-01-09 23:31:18');
INSERT INTO `tb_book` VALUES ('8', '梦溪笔谈', '111222', '06', 'G　文化、科学、教育、体育', '沈括', '7-302', '清华大学出版社-北京', '123.00', null, '', 'CH', '汉语', '322', '123', '一号架', '一号架', '3', '1', '', null, null, null, null, '2020-01-12 11:16:53', null, '2020-02-04 15:21:33');
INSERT INTO `tb_book` VALUES ('9', '水电费', '333', '02', 'B　哲学、宗教', '水电费', '7-302', '清华大学出版社-北京', '0.00', '1', '', 'CH', '汉语', '0', '1', '一号架', '一号架', '1', '1', '', null, null, null, null, '2020-01-12 11:20:13', null, '2020-01-12 11:20:13');
INSERT INTO `tb_book` VALUES ('10', '大秦帝国', '111', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', null, null, null, null, '2020-01-12 11:22:49', null, '2020-02-04 15:31:28');
INSERT INTO `tb_book` VALUES ('11', '大秦帝国', '9-100', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:21', '', '2020-02-06 16:32:21', '', '2020-02-06 16:32:21');
INSERT INTO `tb_book` VALUES ('12', '大秦帝国', '9-101', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:27', '', '2020-02-06 16:32:27', '', '2020-02-06 16:32:27');
INSERT INTO `tb_book` VALUES ('13', '大秦帝国', '9-102', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:30', '', '2020-02-06 16:32:30', '', '2020-02-06 16:32:30');
INSERT INTO `tb_book` VALUES ('14', '大秦帝国', '9-103', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:33', '', '2020-02-06 16:32:33', '', '2020-02-06 16:32:33');
INSERT INTO `tb_book` VALUES ('15', '大秦帝国', '9-104', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:35', '', '2020-02-06 16:32:35', '', '2020-02-06 16:32:35');
INSERT INTO `tb_book` VALUES ('16', '大秦帝国', '9-105', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:37', '', '2020-02-06 16:32:37', '', '2020-02-06 16:32:37');
INSERT INTO `tb_book` VALUES ('17', '大秦帝国', '9-106', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:40', '', '2020-02-06 16:32:40', '', '2020-02-06 16:32:40');
INSERT INTO `tb_book` VALUES ('18', '大秦帝国', '9-107', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:42', '', '2020-02-06 16:32:42', '', '2020-02-06 16:32:42');
INSERT INTO `tb_book` VALUES ('19', '大秦帝国', '9-108', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:45', '', '2020-02-06 16:32:45', '', '2020-02-06 16:32:45');
INSERT INTO `tb_book` VALUES ('20', '大秦帝国', '9-109', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:47', '', '2020-02-06 16:32:47', '', '2020-02-06 16:32:47');
INSERT INTO `tb_book` VALUES ('21', '大秦帝国', '9-110', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:51', '', '2020-02-06 16:32:51', '', '2020-02-06 16:32:51');
INSERT INTO `tb_book` VALUES ('22', '大秦帝国', '9-111', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:53', '', '2020-02-06 16:32:53', '', '2020-02-06 16:32:53');
INSERT INTO `tb_book` VALUES ('23', '大秦帝国', '9-112', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:55', '', '2020-02-06 16:32:55', '', '2020-02-06 16:32:55');
INSERT INTO `tb_book` VALUES ('24', '大秦帝国', '9-113', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:57', '', '2020-02-06 16:32:57', '', '2020-02-06 16:32:57');
INSERT INTO `tb_book` VALUES ('25', '大秦帝国', '9-114', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:32:59', '', '2020-02-06 16:32:59', '', '2020-02-06 16:32:59');
INSERT INTO `tb_book` VALUES ('26', '大秦帝国', '9-115', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:33:02', '', '2020-02-06 16:33:02', '', '2020-02-06 16:33:02');
INSERT INTO `tb_book` VALUES ('27', '大秦帝国', '9-116', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:33:04', '', '2020-02-06 16:33:04', '', '2020-02-06 16:33:04');
INSERT INTO `tb_book` VALUES ('28', '大秦帝国', '9-117', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:33:07', '', '2020-02-06 16:33:07', '', '2020-02-06 16:33:07');
INSERT INTO `tb_book` VALUES ('29', '大秦帝国', '9-118', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:33:09', '', '2020-02-06 16:33:09', '', '2020-02-06 16:33:09');
INSERT INTO `tb_book` VALUES ('30', '大秦帝国', '9-119', '10', 'K　历史、地理', '孙皓晖', '7-302', '清华大学出版社-北京', '588.00', '1', '', 'CH', '汉语', '1200', '5000000', '一号架', '一号架', '122', '4', '', '', '', '2020-02-06 16:33:12', '', '2020-02-06 16:33:12', '', '2020-02-06 16:33:12');
INSERT INTO `tb_book` VALUES ('31', '走出剧情', '2020-001', '06', 'G　文化、科学、教育、体育', '李雪', '7-302', '清华大学出版社-北京', '12.00', '1', '', 'CH', '汉语', '20', '1200', '一号架', '一号架', '12', '12', '', null, null, null, null, '2020-02-07 16:12:10', null, '2020-03-11 23:45:50');
INSERT INTO `tb_book` VALUES ('32', '走出剧情', '10-001', '02', 'B　哲学、宗教', '米雪', '7-302', '清华大学出版社-北京', '123.00', '1', '水电费', 'CH', '汉语', '123', '12300', '一号架', '一号架', '0', '10', '', null, 'api/file/downloadImage/1b5cd5e64ed74163ace90521cd76390f.png', null, null, '2020-03-11 23:27:33', null, '2020-03-11 23:27:33');

-- ----------------------------
-- Table structure for tb_bookshelf
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookshelf`;
CREATE TABLE `tb_bookshelf` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `creater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookshelf
-- ----------------------------
INSERT INTO `tb_bookshelf` VALUES ('25', '二号架', '二号架', null, '2020-01-04 21:37:21', null, '2020-01-04 22:13:49');
INSERT INTO `tb_bookshelf` VALUES ('26', '三号架', '三号架', null, '2020-01-04 21:37:29', null, '2020-01-04 22:13:46');
INSERT INTO `tb_bookshelf` VALUES ('53', '一号架', '一号架', null, '2020-01-04 22:13:39', null, '2020-01-04 22:13:39');
INSERT INTO `tb_bookshelf` VALUES ('54', '四号架', '四号架', null, '2020-02-06 17:02:07', null, '2020-02-06 17:02:07');

-- ----------------------------
-- Table structure for tb_book_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_book_category`;
CREATE TABLE `tb_book_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `creater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book_category
-- ----------------------------
INSERT INTO `tb_book_category` VALUES ('7', '02', 'B　哲学、宗教', null, '2020-01-02 21:58:39', null, '2020-01-02 21:58:39');
INSERT INTO `tb_book_category` VALUES ('8', '03', 'D　政治、法律', null, '2020-01-02 21:58:50', null, '2020-01-02 21:58:50');
INSERT INTO `tb_book_category` VALUES ('9', '04', 'E　军事', null, '2020-01-02 21:59:02', null, '2020-01-02 21:59:02');
INSERT INTO `tb_book_category` VALUES ('10', '05', 'F　经济', null, '2020-01-02 21:59:19', null, '2020-01-02 21:59:19');
INSERT INTO `tb_book_category` VALUES ('11', '06', 'G　文化、科学、教育、体育', null, '2020-01-02 21:59:32', null, '2020-01-02 21:59:32');
INSERT INTO `tb_book_category` VALUES ('12', '07', 'H　语言、文字', null, '2020-01-02 21:59:43', null, '2020-01-02 21:59:43');
INSERT INTO `tb_book_category` VALUES ('13', '08', 'I　文学', null, '2020-01-02 21:59:52', null, '2020-01-02 21:59:52');
INSERT INTO `tb_book_category` VALUES ('14', '10', 'K　历史、地理', null, '2020-01-02 22:00:03', null, '2020-01-02 22:00:03');
INSERT INTO `tb_book_category` VALUES ('15', '11', 'P　天文学、地球科学', null, '2020-01-02 22:00:16', null, '2020-01-02 22:00:16');
INSERT INTO `tb_book_category` VALUES ('16', '09', 'J　艺术', null, '2020-01-02 22:01:15', null, '2020-01-02 22:01:15');
INSERT INTO `tb_book_category` VALUES ('17', '12', 'Q　生物科学', null, '2020-01-02 22:04:24', null, '2020-01-02 22:04:24');
INSERT INTO `tb_book_category` VALUES ('18', '13', 'S　农业科学', null, '2020-01-02 22:04:38', null, '2020-01-02 22:04:38');
INSERT INTO `tb_book_category` VALUES ('19', '14', 'T　工业技术', null, '2020-01-02 22:14:58', null, '2020-01-02 22:14:58');
INSERT INTO `tb_book_category` VALUES ('20', '15', 'U　交通运输', null, '2020-01-02 22:15:07', null, '2020-01-02 22:15:07');
INSERT INTO `tb_book_category` VALUES ('21', '16', 'V　航空、航天', null, '2020-01-02 22:15:15', null, '2020-01-02 22:15:15');
INSERT INTO `tb_book_category` VALUES ('22', '17', 'X　环境科学、安全科学', null, '2020-01-02 22:15:23', null, '2020-01-02 22:15:23');
INSERT INTO `tb_book_category` VALUES ('23', '18', '看见看见', null, '2020-01-02 22:15:31', null, '2020-01-02 22:15:31');
INSERT INTO `tb_book_category` VALUES ('24', '是的', '是的', null, '2020-01-04 21:41:08', null, '2020-01-04 21:41:29');
INSERT INTO `tb_book_category` VALUES ('25', '001', '是的', null, '2020-01-04 21:41:14', null, '2020-01-04 21:41:14');
INSERT INTO `tb_book_category` VALUES ('26', '0011', '是的', null, '2020-01-05 11:01:48', null, '2020-01-05 11:01:48');

-- ----------------------------
-- Table structure for tb_borrow
-- ----------------------------
DROP TABLE IF EXISTS `tb_borrow`;
CREATE TABLE `tb_borrow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reader_code` varchar(100) DEFAULT NULL COMMENT '图书名称',
  `book_isbn` varchar(100) DEFAULT NULL,
  `borrow_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `real_return_date` date DEFAULT NULL,
  `borrow_days` int(10) DEFAULT NULL,
  `reborrow_days` int(10) DEFAULT NULL,
  `borrow_status` tinyint(2) DEFAULT '0' COMMENT '0未还；1已还；2逾期',
  `remark` varchar(2000) DEFAULT NULL,
  `creater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_borrow
-- ----------------------------
INSERT INTO `tb_borrow` VALUES ('3', '123', '1223', '2020-01-13', '2020-02-12', '2020-02-01', null, null, '1', '', null, '2020-01-13 00:16:49', null, '2020-02-01 14:23:38');
INSERT INTO `tb_borrow` VALUES ('5', '123', '111222', '2020-01-16', '2020-02-15', '2020-02-01', '30', null, '1', '', null, '2020-01-16 01:06:28', null, '2020-02-01 14:23:41');
INSERT INTO `tb_borrow` VALUES ('6', 'sfs', '111222', '2020-01-16', '2020-06-27', null, '150', '120', null, '', null, '2020-01-16 01:07:09', null, '2020-03-11 23:25:38');
INSERT INTO `tb_borrow` VALUES ('7', '123', '111', '2020-01-30', '2020-04-26', '2020-02-01', '48', '2', '1', '', null, '2020-01-30 22:33:09', null, '2020-02-01 14:23:41');
INSERT INTO `tb_borrow` VALUES ('11', '123', '1223', '2020-02-01', '2020-03-02', '2020-03-11', '30', null, '1', '', null, '2020-02-01 14:58:32', null, '2020-03-11 23:17:19');
INSERT INTO `tb_borrow` VALUES ('12', '666', '111', '2020-02-02', '2020-03-03', '2020-02-04', '30', null, '1', '', null, '2020-02-02 10:16:01', null, '2020-02-04 15:21:03');
INSERT INTO `tb_borrow` VALUES ('13', 'sfs', '111', '2020-02-02', '2020-03-03', '2020-02-04', '30', null, '1', '', null, '2020-02-02 10:16:54', null, '2020-02-04 15:31:28');
INSERT INTO `tb_borrow` VALUES ('14', '001', '111', '2020-02-02', '2020-03-03', null, '30', null, '0', '', null, '2020-02-02 10:25:21', null, '2020-02-02 10:25:21');
INSERT INTO `tb_borrow` VALUES ('15', '001', '1223', '2020-02-02', '2020-03-03', null, '30', null, '0', '', null, '2020-02-02 10:25:37', null, '2020-02-02 10:25:37');
INSERT INTO `tb_borrow` VALUES ('16', '002', '111', '2020-02-02', '2020-03-03', null, '30', null, '0', '', null, '2020-02-02 10:25:43', null, '2020-02-02 10:25:43');
INSERT INTO `tb_borrow` VALUES ('17', '002', '1223', '2020-02-02', '2020-03-03', '2020-02-04', '30', null, '1', '', null, '2020-02-02 10:25:46', null, '2020-02-04 15:21:00');
INSERT INTO `tb_borrow` VALUES ('18', '123', '111', '2020-02-04', '2020-03-05', null, '30', null, '0', '', null, '2020-02-04 15:21:26', null, '2020-02-04 15:21:26');
INSERT INTO `tb_borrow` VALUES ('19', '123', '111222', '2020-02-04', '2020-03-05', null, '30', null, '0', '', null, '2020-02-04 15:21:33', null, '2020-02-04 15:21:33');

-- ----------------------------
-- Table structure for tb_language
-- ----------------------------
DROP TABLE IF EXISTS `tb_language`;
CREATE TABLE `tb_language` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `creater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_language
-- ----------------------------
INSERT INTO `tb_language` VALUES ('24', 'CH', '汉语', null, '2020-01-04 22:52:47', null, '2020-01-04 22:53:15');
INSERT INTO `tb_language` VALUES ('25', 'JP', '日语', null, '2020-01-04 22:52:58', null, '2020-01-04 22:53:20');
INSERT INTO `tb_language` VALUES ('26', 'EN', '英语', null, '2020-01-04 22:53:08', null, '2020-01-04 22:53:08');
INSERT INTO `tb_language` VALUES ('27', 'SPAN', '西班牙语', null, '2020-01-04 22:53:30', null, '2020-01-04 22:53:30');

-- ----------------------------
-- Table structure for tb_publisher
-- ----------------------------
DROP TABLE IF EXISTS `tb_publisher`;
CREATE TABLE `tb_publisher` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `creater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_publisher
-- ----------------------------
INSERT INTO `tb_publisher` VALUES ('24', '7-81029', '暨南大学出版社-广州', null, '2020-01-04 22:51:37', null, '2020-01-04 22:51:37');
INSERT INTO `tb_publisher` VALUES ('25', '7-302', '清华大学出版社-北京', null, '2020-01-04 22:52:00', null, '2020-01-04 22:52:00');
INSERT INTO `tb_publisher` VALUES ('26', '978-7-115', '人民邮电出版社-北京', null, '2020-01-04 22:52:12', null, '2020-01-04 22:52:12');

-- ----------------------------
-- Table structure for tb_reader
-- ----------------------------
DROP TABLE IF EXISTS `tb_reader`;
CREATE TABLE `tb_reader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL COMMENT '读者',
  `creater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('6', 'sfs', '单红霞', '男', 'sdf', null, '2020-01-11 19:36:23', null, '2020-02-06 17:03:19');
INSERT INTO `tb_reader` VALUES ('7', '555111', '张磊', '男', '555', null, '2020-01-12 00:04:26', null, '2020-02-06 17:03:05');
INSERT INTO `tb_reader` VALUES ('8', '666', '吴子林', '女', '666', null, '2020-01-12 00:07:46', null, '2020-02-06 17:03:12');
INSERT INTO `tb_reader` VALUES ('9', '123', '唐艺昕', '女', '132123123', null, '2020-01-12 01:18:02', null, '2020-01-12 01:18:02');
INSERT INTO `tb_reader` VALUES ('10', '001', '松林', '男', '18217377827', null, '2020-02-02 10:24:05', null, '2020-02-02 10:24:05');
INSERT INTO `tb_reader` VALUES ('11', '002', '徐三', '男', '13122345454', null, '2020-02-02 10:25:06', null, '2020-02-02 10:25:06');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('admin', 'e3d0c85bf9d69d7ff11c1440a870d6c7');
