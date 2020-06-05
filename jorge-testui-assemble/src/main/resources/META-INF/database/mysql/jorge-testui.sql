/*
 Navicat Premium Data Transfer

 Source Server         : 172.17.100.8
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 172.17.100.8:3306
 Source Schema         : jorge-testui

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 11/12/2019 14:17:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_chart
-- ----------------------------
DROP TABLE IF EXISTS `c_chart`;
CREATE TABLE `c_chart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `status` varchar(32) DEFAULT NULL COMMENT '状态{enable:正常,disable:禁用}',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='图表-主题';

-- ----------------------------
-- Records of c_chart
-- ----------------------------
BEGIN;
INSERT INTO `c_chart` VALUES (1, '图表demo', 'enable', '2018-10-18 14:03:22', '2018-10-18 14:03:22', '');
INSERT INTO `c_chart` VALUES (2, '用例情况统计图', 'enable', '2019-12-06 13:51:36', '2019-12-06 17:27:52', '');
COMMIT;

-- ----------------------------
-- Table structure for c_chart_data
-- ----------------------------
DROP TABLE IF EXISTS `c_chart_data`;
CREATE TABLE `c_chart_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chart_id` bigint(20) NOT NULL COMMENT '主题id',
  `items_id` bigint(20) NOT NULL COMMENT '图表选项id',
  `sql_data` varchar(2048) NOT NULL COMMENT 'sql表达式',
  `field_mapped` varchar(512) NOT NULL COMMENT '数据字段',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='图表-数据项';

-- ----------------------------
-- Records of c_chart_data
-- ----------------------------
BEGIN;
INSERT INTO `c_chart_data` VALUES (1, 1, 1, 'select create_time, loop_time/1000 as loop_time,height,width from c_chart_items where chart_id=1 ORDER BY type ', '{\"create_time\":\"创建时间\",\"width\":\"宽度\",\"loop_time\":\"循环时间\",\"height\":\"高度\"}', '2018-10-22 16:04:34', '2018-10-22 16:23:36', NULL);
INSERT INTO `c_chart_data` VALUES (2, 1, 2, 'select create_time, loop_time/1000 as loop_time,height,width from c_chart_items where chart_id=1 ORDER BY type ', '{\"create_time\":\"创建时间\",\"height\":\"高度\",\"loop_time\":\"循环时间\",\"width\":\"宽度\"}', '2018-10-22 16:04:34', '2018-10-22 16:10:31', NULL);
INSERT INTO `c_chart_data` VALUES (3, 1, 3, 'select create_time, loop_time/1000 as loop_time,height,width from c_chart_items where chart_id=1 ORDER BY type ', '{\"create_time\":\"创建时间\",\"height\":\"高度\",\"loop_time\":\"循环时间\",\"width\":\"宽度\"}', '2018-10-22 16:04:34', '2018-10-22 16:18:57', NULL);
INSERT INTO `c_chart_data` VALUES (4, 2, 4, 'select case_no,\n count(case_no) as cc from parameters   GROUP BY case_no', '{\"cc\":\"用例数\",\"case_no\":\"用例编码\"}', '2019-12-06 14:24:04', '2019-12-06 14:56:06', NULL);
INSERT INTO `c_chart_data` VALUES (5, 2, 5, 'select project_no,\n count(project_no) as cc from parameters   GROUP BY project_no;', '{\"cc\":\"用例数量\",\"project_no\":\"系统名称\"}', '2019-12-06 14:29:03', '2019-12-06 14:30:24', NULL);
INSERT INTO `c_chart_data` VALUES (6, 2, 6, ' select interface_no,\n count(interface_no) as cc from parameters   GROUP BY interface_no;', '{\"interface_no\":\"接口编码\",\"cc\":\"用例数量\"}', '2019-12-06 14:47:59', '2019-12-06 14:47:59', NULL);
INSERT INTO `c_chart_data` VALUES (7, 2, 7, 'SELECT\n	DATE_FORMAT( create_time, \'%Y-%m-%d\' ) AS dateTime,\n	count( create_time ) AS cc \nFROM\n	parameters \nGROUP BY\n	DATE_FORMAT( create_time, \'%Y-%m-%d\' );', '{\"dateTime\":\"日期\",\"cc\":\"用例数量\"}', '2019-12-06 14:54:12', '2019-12-06 14:54:12', NULL);
INSERT INTO `c_chart_data` VALUES (8, 2, 8, '	SELECT\n	create_user,\n	count( create_user ) AS cc \nFROM\n	parameters \nGROUP BY\n	create_user;\n	', '{\"create_user\":\"创建者\",\"cc\":\"创建用例数量\"}', '2019-12-06 16:50:21', '2019-12-06 16:50:21', NULL);
INSERT INTO `c_chart_data` VALUES (9, 2, 9, 'SELECT\n	t1.dateTime,\n	t1.fail,\n	t2.success \nFROM\n	(\nSELECT\n	DATE_FORMAT( update_time, \'%Y-%m-%d\' ) AS dateTime,\n	count( update_time ) AS fail \nFROM\n	parameters \nWHERE\n	last_implement_result = \'0\' \nGROUP BY\n	DATE_FORMAT( update_time, \'%Y-%m-%d\' ) \n	) AS t1\n	LEFT JOIN (\nSELECT\n	DATE_FORMAT( update_time, \'%Y-%m-%d\' ) AS dateTime,\n	count( update_time ) AS success \nFROM\n	parameters \nWHERE\n	last_implement_result = \'1\' \nGROUP BY\n	DATE_FORMAT( update_time, \'%Y-%m-%d\' ) \n	) AS t2 ON t1.dateTime = t2.dateTime', '{\"dateTime\":\"日期\",\"fail\":\"用例失败数\",\"success\":\"用例成功数\"}', '2019-12-09 09:12:21', '2019-12-09 17:41:13', NULL);
COMMIT;

-- ----------------------------
-- Table structure for c_chart_items
-- ----------------------------
DROP TABLE IF EXISTS `c_chart_items`;
CREATE TABLE `c_chart_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `chart_id` bigint(20) NOT NULL COMMENT '主题id',
  `is_show` varchar(40) DEFAULT 'NO' COMMENT '是否显示数据',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `type` varchar(64) NOT NULL COMMENT '图表类型{line:折线图,bar:柱状图,pie:饼图}',
  `status` varchar(32) NOT NULL COMMENT '状态{enable:正常,disable:禁用}',
  `loop_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '循环时间',
  `height` bigint(20) NOT NULL DEFAULT '50' COMMENT '高',
  `width` bigint(20) NOT NULL DEFAULT '50' COMMENT '宽',
  `x_shaft` varchar(128) DEFAULT NULL COMMENT 'x轴',
  `y_shaft` varchar(128) NOT NULL COMMENT 'y轴',
  `order_time` datetime NOT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='图表-图表选项';

-- ----------------------------
-- Records of c_chart_items
-- ----------------------------
BEGIN;
INSERT INTO `c_chart_items` VALUES (1, 1, 'YES', '折线图demo', 'line', 'enable', 16000, 55, 65, '{\"create_time\":\"创建时间\"}', '{\"width\":\"宽度\",\"loop_time\":\"循环时间\",\"height\":\"高度\"}', '2019-12-06 17:37:15', '2018-10-22 16:04:34', '2019-12-06 17:37:15', '');
INSERT INTO `c_chart_items` VALUES (2, 1, 'YES', '柱状图demo', 'bar', 'enable', 26000, 50, 60, '{\"create_time\":\"创建时间\"}', '{\"height\":\"高度\",\"loop_time\":\"循环时间\",\"width\":\"宽度\"}', '2018-10-22 16:04:34', '2018-10-22 16:04:34', '2018-10-22 16:10:31', '');
INSERT INTO `c_chart_items` VALUES (3, 1, 'YES', '饼图demo', 'pie', 'enable', 36000, 40, 40, '{}', '{\"height\":\"高度\",\"loop_time\":\"循环时间\",\"width\":\"宽度\"}', '2018-10-22 16:04:34', '2018-10-22 16:04:34', '2018-10-22 16:18:57', '');
INSERT INTO `c_chart_items` VALUES (4, 2, 'YES', '用例接口统计数量', 'bar', 'enable', 0, 50, 50, '{\"case_no\":\"用例编码\"}', '{\"cc\":\"用例数\"}', '2019-12-06 14:24:04', '2019-12-06 14:24:04', '2019-12-06 14:56:06', '');
INSERT INTO `c_chart_items` VALUES (5, 2, 'YES', '系统用例数量', 'bar', 'enable', 0, 50, 50, '{\"project_no\":\"系统名称\"}', '{\"cc\":\"用例数量\"}', '2019-12-06 14:47:59', '2019-12-06 14:29:03', '2019-12-06 14:55:38', '');
INSERT INTO `c_chart_items` VALUES (6, 2, 'YES', '接口用例数量', 'line', 'enable', 0, 50, 50, '{\"interface_no\":\"接口编码\"}', '{\"cc\":\"用例数量\"}', '2019-12-06 14:29:03', '2019-12-06 14:47:59', '2019-12-06 14:55:38', '');
INSERT INTO `c_chart_items` VALUES (7, 2, 'YES', '当天用例增加数量', 'line', 'enable', 0, 50, 50, '{\"dateTime\":\"日期\"}', '{\"cc\":\"用例数量\"}', '2019-12-06 14:54:12', '2019-12-06 14:54:12', '2019-12-06 14:54:12', '');
INSERT INTO `c_chart_items` VALUES (8, 2, 'YES', '每个用户创建用例数量', 'bar', 'enable', 0, 50, 50, '{\"create_user\":\"创建者\"}', '{\"cc\":\"创建用例数量\"}', '2019-12-06 16:50:21', '2019-12-06 16:50:21', '2019-12-06 16:50:21', '');
INSERT INTO `c_chart_items` VALUES (9, 2, 'YES', '用例成功失败统计', 'bar', 'enable', 0, 50, 50, '{\"dateTime\":\"日期\"}', '{\"fail\":\"用例失败数\",\"success\":\"用例成功数\"}', '2019-12-09 09:12:20', '2019-12-09 09:12:20', '2019-12-09 17:41:13', '');
COMMIT;

-- ----------------------------
-- Table structure for case_request_parameter
-- ----------------------------
DROP TABLE IF EXISTS `case_request_parameter`;
CREATE TABLE `case_request_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `case_no` varchar(64) NOT NULL COMMENT '用例编码',
  `request_demo` varchar(8192) DEFAULT NULL COMMENT '用例请求参数模板',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `CASENO` (`case_no`) USING BTREE COMMENT '用例编码必须唯一'
) ENGINE=InnoDB AUTO_INCREMENT=14738 DEFAULT CHARSET=utf8mb4 COMMENT='请求参数demo表';

-- ----------------------------
-- Records of case_request_parameter
-- ----------------------------
BEGIN;
INSERT INTO `case_request_parameter` VALUES (14678, 'SignConfirmApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"bindNo\":\"\",\n	\"memberSignApplyOrder\":{\n		\"bankCode\":null,\n		\"bankNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"gid\":\"\",\n		\"memberType\":null,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"memberUnSignOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"merchOrderNo\":\"1912111404472CC80032\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"requestNo\":\"1912111404472CC80031\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"smsCode\":\"\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14679, 'WithdrawApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"amount\":\"\",\n	\"bindNo\":\"\",\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80140\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"requestNo\":\"1912111404472CC80139\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"tradeMemo\":\"\",\n	\"tradeTime\":null,\n	\"userIp\":\"\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14680, 'QueryInAccountApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"enterpriseRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCode\":null,\n		\"bizOrderNo\":\"\",\n		\"comName\":\"\",\n		\"comments\":\"\",\n		\"contactEmail\":\"\",\n		\"contactMobileNo\":\"\",\n		\"contactRealName\":\"\",\n		\"doorPhotoPath\":\"\",\n		\"gid\":\"\",\n		\"legalCertBackPath\":\"\",\n		\"legalCertFrontPath\":\"\",\n		\"legalCertNo\":\"\",\n		\"legalMobileNo\":\"\",\n		\"legalRealName\":\"\",\n		\"licenceNo\":\"\",\n		\"licencePath\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"openAccountPath\":\"\",\n		\"partnerId\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"individualRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comName\":\"\",\n		\"comments\":\"\",\n		\"doorPhotoPath\":\"\",\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"legalCertBackPath\":\"\",\n		\"legalCertFrontPath\":\"\",\n		\"legalCertNo\":\"\",\n		\"legalRealName\":\"\",\n		\"licenceNo\":\"\",\n		\"licencePath\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"merchOrderNo\":\"1912111404472CC80024\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"requestNo\":\"1912111404472CC80023\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14681, 'SignFacadeSignApplyTestFailOne', '{\n	\"gatewaySignApplyOrder\":{\n		\"bankCardNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"certNo\":\"\",\n		\"certType\":\"IDENTITY_CARD\",\n		\"cvv\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"fbankqftSignBindCardApply\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"tradeDate\":null,\n		\"userNo\":\"\",\n		\"validDate\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14682, 'EntrustBindCardApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"attorneyPowerPath\":\"\",\n	\"bankCardFrontPath\":\"\",\n	\"bankCardNo\":\"\",\n	\"certBackPath\":\"\",\n	\"certFrontPath\":\"\",\n	\"certNo\":\"\",\n	\"holdCertPath\":\"\",\n	\"merchOrderNo\":\"\",\n	\"message\":\"成功\",\n	\"mobileNo\":\"\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"realName\":\"\",\n	\"requestNo\":\"1912111404472CC80007\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14683, 'AliZhuScanPayApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80092\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80091\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14684, 'BankCardFacadeEntrustBindCardSuccess', '{\n	\"entrustBindCardOrder\":{\n		\"accessToken\":\"\",\n		\"attorneyPowerPath\":\"\",\n		\"bankCardFrontPath\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"gid\":\"\",\n		\"hasCheckToken\":true,\n		\"holdCertPath\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\",\n	\"unbindBankCardOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	}\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14685, 'testCaseOne', '{\n	\"accessKey\":\"\",\n	\"age\":null,\n	\"amount\":\"0\",\n	\"interfaces\":{\n		\"createTime\":1576044287771,\n		\"id\":null,\n		\"interfaceName\":\"\",\n		\"interfaceNo\":\"\",\n		\"new\":true,\n		\"projectNo\":\"\",\n		\"updateTime\":1576044287771\n	},\n	\"merchOrderNo\":\"1912111404472CC80049\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"requestInfo\":{\n		\"age\":null,\n		\"amount\":\"1\",\n		\"sex\":null,\n		\"userNo\":\"O1912111404472CC80050\"\n	},\n	\"requestNo\":\"1912111404472CC80048\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"sex\":null,\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14686, 'MemberSignFacadeSignConfirmSuccess', '{\n	\"memberSignApplyOrder\":{\n		\"bankCode\":null,\n		\"bankNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"gid\":\"\",\n		\"memberType\":null,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"memberSignConfirmOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"smsCode\":\"\",\n		\"smsOrderId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"memberUnSignOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14687, 'TradeCreateApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"amount\":\"\",\n	\"buyerUserNo\":\"\",\n	\"closeTime\":\"\",\n	\"goodsInfoDtoInfo\":null,\n	\"merchOrderNo\":\"1912111404472CC80116\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payeeUserNo\":\"\",\n	\"payerUserName\":\"\",\n	\"payerUserNo\":\"\",\n	\"requestNo\":\"1912111404472CC80115\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"sellerUserNo\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"tradeMemo\":\"\",\n	\"tradeName\":\"\",\n	\"tradeProfitInfoDtoInfo\":null,\n	\"tradeProfitType\":null,\n	\"tradeTime\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14688, 'NetBankPayFacadeAppPayTestFailTwo', '{\n	\"appPayOrder\":{\n		\"amount\":null,\n		\"appId\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"goodsMemo\":\"\",\n		\"isRaw\":\"1\",\n		\"mchCreateIp\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"recAccountName\":\"\",\n		\"recAccountNo\":\"\",\n		\"userNo\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14689, 'BankCardFacadeBindClearCardSuccess', '{\n	\"bindClearCardOrder\":{\n		\"accessToken\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCode\":null,\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"hasCheckToken\":true,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"publicTag\":null,\n		\"subbranch\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\",\n	\"unbindBankCardOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	}\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14690, 'WechatMiniPayApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"appId\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80128\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"openId\":\"\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80127\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14691, 'TradeFacadeWechatAppPayTestFailOne', '{\n	\"reconPeriod\":{\n		\"channelDataMemo\":\"\",\n		\"channelDataStatus\":\"\",\n		\"commemts\":\"\",\n		\"createTime\":1576044287829,\n		\"excessNo\":null,\n		\"failNo\":null,\n		\"gatewayDataMemo\":\"\",\n		\"gatewayDataStatus\":\"\",\n		\"gatewayDateNo\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"status\":\"\",\n		\"successNo\":null,\n		\"updateTime\":1576044287829\n	},\n	\"reconReconResult\":{\n		\"amountChannel\":null,\n		\"amountGateway\":null,\n		\"bizOrderNo\":\"\",\n		\"channelOrderNo\":\"\",\n		\"channelType\":\"\",\n		\"charge\":null,\n		\"createTime\":1576044287829,\n		\"finishTime\":null,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memo\":\"\",\n		\"merchantNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"sendBankSerialNo\":\"\",\n		\"status\":\"\",\n		\"tradeType\":\"\",\n		\"updateTime\":1576044287829\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	},\n	\"wechatAppPayOrder\":{\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"productInfo\":\"\",\n		\"userIp\":\"\",\n		\"wxAppid\":\"\"\n	},\n	\"wechatPublicPayOrder\":{\n		\"appId\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchTwoNumCode\":\"\",\n		\"openId\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"productInfo\":\"\",\n		\"userIp\":\"\"\n	}\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14692, 'TradeFacadeQuickPaymentApplyTestFailOne', '{\n	\"quickPaymentApplyOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"userIp\":\"\"\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	}\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14693, 'AliLifePayApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80080\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"openId\":\"\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80079\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14694, 'AliZhuScanPayApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80088\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80087\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14695, 'TradeCloseApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80108\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"origMerchOrdeNo\":\"\",\n	\"partnerId\":\"\",\n	\"requestNo\":\"1912111404472CC80107\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14696, 'testCaseTwo', '{\n	\"accessKey\":\"\",\n	\"age\":null,\n	\"amount\":\"0\",\n	\"interfaces\":{\n		\"createTime\":1576044287775,\n		\"id\":null,\n		\"interfaceName\":\"\",\n		\"interfaceNo\":\"\",\n		\"new\":true,\n		\"projectNo\":\"\",\n		\"updateTime\":1576044287775\n	},\n	\"merchOrderNo\":\"1912111404472CC80055\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"requestInfo\":{\n		\"age\":null,\n		\"amount\":\"1\",\n		\"sex\":null,\n		\"userNo\":\"O1912111404472CC80056\"\n	},\n	\"requestNo\":\"1912111404472CC80054\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"sex\":null,\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14697, 'AccountTransferApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"amount\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80068\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payeeUserNo\":\"\",\n	\"payerUserNo\":\"\",\n	\"requestNo\":\"1912111404472CC80067\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"tradeMemo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14698, 'WechatMiniPayApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"appId\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80124\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"openId\":\"\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80123\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14699, 'AccountTransferApiServiceTestFailTwo', '{\n	\"accessKey\":\"\",\n	\"amount\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80064\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payeeUserNo\":\"\",\n	\"payerUserNo\":\"\",\n	\"requestNo\":\"1912111404472CC80063\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"tradeMemo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14700, 'queryFundFacadeQueryFundSuccess', '{\n	\"parameters\":{\n		\"callCount\":0,\n		\"callFailCount\":0,\n		\"callSuccessCount\":0,\n		\"caseNo\":\"\",\n		\"createTime\":1576044287808,\n		\"createUser\":\"\",\n		\"description\":\"\",\n		\"id\":null,\n		\"interfaceNo\":\"\",\n		\"lastImplementResult\":false,\n		\"new\":true,\n		\"parameters\":\"\",\n		\"parametersNo\":\"\",\n		\"projectNo\":\"\",\n		\"updateTime\":1576044287808\n	},\n	\"queryFundOrder\":{\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:11', '2019-12-11 14:05:11');
INSERT INTO `case_request_parameter` VALUES (14701, 'QueryFundFacadeQueryFundPageSuccess', '{\n	\"queryFundPageOrder\":{\n		\"endTradeTime\":null,\n		\"fundStatus\":null,\n		\"fundType\":null,\n		\"gid\":\"\",\n		\"map\":null,\n		\"merchOrderNo\":\"\",\n		\"pageInfo\":null,\n		\"partnerId\":\"\",\n		\"sortMap\":null,\n		\"startTradeTime\":null,\n		\"tradeNo\":\"\",\n		\"userName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14702, 'AliBeiScanPayApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"authCode\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80076\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80075\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14703, 'TradeFacadeWechatAppPayTestSuccess', '{\n	\"reconPeriod\":{\n		\"channelDataMemo\":\"\",\n		\"channelDataStatus\":\"\",\n		\"commemts\":\"\",\n		\"createTime\":1576044287838,\n		\"excessNo\":null,\n		\"failNo\":null,\n		\"gatewayDataMemo\":\"\",\n		\"gatewayDataStatus\":\"\",\n		\"gatewayDateNo\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"status\":\"\",\n		\"successNo\":null,\n		\"updateTime\":1576044287838\n	},\n	\"reconReconResult\":{\n		\"amountChannel\":null,\n		\"amountGateway\":null,\n		\"bizOrderNo\":\"\",\n		\"channelOrderNo\":\"\",\n		\"channelType\":\"\",\n		\"charge\":null,\n		\"createTime\":1576044287838,\n		\"finishTime\":null,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memo\":\"\",\n		\"merchantNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"sendBankSerialNo\":\"\",\n		\"status\":\"\",\n		\"tradeType\":\"\",\n		\"updateTime\":1576044287838\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	},\n	\"wechatAppPayOrder\":{\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"productInfo\":\"\",\n		\"userIp\":\"\",\n		\"wxAppid\":\"\"\n	},\n	\"wechatPublicPayOrder\":{\n		\"appId\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchTwoNumCode\":\"\",\n		\"openId\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"productInfo\":\"\",\n		\"userIp\":\"\"\n	}\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14704, 'BindClearCardApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"bankCardNo\":\"\",\n	\"bankCode\":null,\n	\"merchOrderNo\":\"1912111404472CC80004\",\n	\"message\":\"成功\",\n	\"mobileNo\":\"\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"publicTag\":null,\n	\"requestNo\":\"1912111404472CC80003\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"subbranch\":\"\",\n	\"unbindBankCardOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14705, 'NetBankPayFacadeAppPayTestFailOne', '{\n	\"appPayOrder\":{\n		\"amount\":null,\n		\"appId\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"goodsMemo\":\"\",\n		\"isRaw\":\"1\",\n		\"mchCreateIp\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"recAccountName\":\"\",\n		\"recAccountNo\":\"\",\n		\"userNo\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14706, 'AliBeiScanPayApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"authCode\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80072\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80071\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14707, 'WechatAppPayServiceSuccess', '{\n	\"accessKey\":\"\",\n	\"appId\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80104\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"reconPeriod\":{\n		\"channelDataMemo\":\"\",\n		\"channelDataStatus\":\"\",\n		\"commemts\":\"\",\n		\"createTime\":1576044287791,\n		\"excessNo\":null,\n		\"failNo\":null,\n		\"gatewayDataMemo\":\"\",\n		\"gatewayDataStatus\":\"\",\n		\"gatewayDateNo\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"status\":\"\",\n		\"successNo\":null,\n		\"updateTime\":1576044287791\n	},\n	\"reconReconResult\":{\n		\"amountChannel\":null,\n		\"amountGateway\":null,\n		\"bizOrderNo\":\"\",\n		\"channelOrderNo\":\"\",\n		\"channelType\":\"\",\n		\"charge\":null,\n		\"createTime\":1576044287791,\n		\"finishTime\":null,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memo\":\"\",\n		\"merchantNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"sendBankSerialNo\":\"\",\n		\"status\":\"\",\n		\"tradeType\":\"\",\n		\"updateTime\":1576044287791\n	},\n	\"requestNo\":\"1912111404472CC80103\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	},\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14708, 'TradeFacadeQuickPaymentConfirmFailOne', '{\n	\"quickPaymentApplyOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"userIp\":\"\"\n	},\n	\"quickPaymentConfirmOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"smsCode\":\"\",\n		\"userIp\":\"\"\n	},\n	\"reconPeriod\":{\n		\"channelDataMemo\":\"\",\n		\"channelDataStatus\":\"\",\n		\"commemts\":\"\",\n		\"createTime\":1576044287822,\n		\"excessNo\":null,\n		\"failNo\":null,\n		\"gatewayDataMemo\":\"\",\n		\"gatewayDataStatus\":\"\",\n		\"gatewayDateNo\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"status\":\"\",\n		\"successNo\":null,\n		\"updateTime\":1576044287822\n	},\n	\"reconReconResult\":{\n		\"amountChannel\":null,\n		\"amountGateway\":null,\n		\"bizOrderNo\":\"\",\n		\"channelOrderNo\":\"\",\n		\"channelType\":\"\",\n		\"charge\":null,\n		\"createTime\":1576044287822,\n		\"finishTime\":null,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memo\":\"\",\n		\"merchantNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"sendBankSerialNo\":\"\",\n		\"status\":\"\",\n		\"tradeType\":\"\",\n		\"updateTime\":1576044287822\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	}\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14709, 'AliLifePayApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80084\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"openId\":\"\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80083\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14710, 'TradeFacadeQuickPaymentApplyTestSuccess', '{\n	\"quickPaymentApplyOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"userIp\":\"\"\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	}\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14711, 'BankCardFacadeBindClearCardFailTwo', '{\n	\"bindClearCardOrder\":{\n		\"accessToken\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCode\":null,\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"hasCheckToken\":true,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"publicTag\":null,\n		\"subbranch\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\",\n	\"unbindBankCardOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	}\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14712, 'AccountTransferApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"amount\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80060\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payeeUserNo\":\"\",\n	\"payerUserNo\":\"\",\n	\"requestNo\":\"1912111404472CC80059\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"tradeMemo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14713, 'PayengineDepositFacadeDeductForBindIdDepositFailOne', '{\n	\"accessKey\":\"\",\n	\"bankName\":\"\",\n	\"changeDirection\":\"\",\n	\"deductDepositOrder\":{\n		\"accountNo\":\"\",\n		\"amount\":null,\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"extContext\":null,\n		\"freezeAmount\":null,\n		\"freezeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"productCode\":\"\",\n		\"productInfo\":\"\",\n		\"productType\":\"\",\n		\"realPayeeAccountNo\":\"\",\n		\"realPayeeUserNo\":\"\",\n		\"tradeOrderType\":null,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"membermember\":{\n		\"agentId\":\"\",\n		\"aggregatePayStatus\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardPayStatus\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"email\":\"\",\n		\"emailAuth\":\"\",\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberStatus\":\"\",\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"merchantOpenStatus\":\"\",\n		\"mobileNo\":\"\",\n		\"mobileNoAuth\":\"\",\n		\"new\":true,\n		\"operatorAddStatus\":\"\",\n		\"partnerId\":\"\",\n		\"posPayStatus\":\"\",\n		\"realNameAuth\":\"\",\n		\"registerClient\":\"\",\n		\"registerSource\":\"\",\n		\"salesmanId\":\"\",\n		\"updateTime\":1576044287751,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"membermemberAccount\":{\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"bankAccountCoreNo\":\"\",\n		\"bankAccountNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"new\":true,\n		\"openStatus\":\"\",\n		\"partnerId\":\"\",\n		\"updateTime\":1576044287751,\n		\"userNo\":\"\"\n	},\n	\"membermemberAccountTwo\":{\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"bankAccountCoreNo\":\"\",\n		\"bankAccountNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"new\":true,\n		\"openStatus\":\"\",\n		\"partnerId\":\"\",\n		\"updateTime\":1576044287751,\n		\"userNo\":\"\"\n	},\n	\"membermemberBankCard\":{\n		\"attorneyPowerPath\":\"\",\n		\"bankCardFrontPath\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCardType\":\"\",\n		\"bankCnapsNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankSubbranch\":\"\",\n		\"bindNo\":\"\",\n		\"bindType\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardStatus\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"city\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"id\":null,\n		\"isFintechSms\":\"\",\n		\"isValidateSms\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"protocolNo\":\"\",\n		\"province\":\"\",\n		\"publicTag\":\"\",\n		\"purpose\":\"\",\n		\"realName\":\"\",\n		\"updateTime\":1576044287751,\n		\"userNo\":\"\",\n		\"validMessage\":\"\",\n		\"validStatus\":\"\"\n	},\n	\"membermemberBankCardTwo\":{\n		\"attorneyPowerPath\":\"\",\n		\"bankCardFrontPath\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCardType\":\"\",\n		\"bankCnapsNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankSubbranch\":\"\",\n		\"bindNo\":\"\",\n		\"bindType\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardStatus\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"city\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"id\":null,\n		\"isFintechSms\":\"\",\n		\"isValidateSms\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"protocolNo\":\"\",\n		\"province\":\"\",\n		\"publicTag\":\"\",\n		\"purpose\":\"\",\n		\"realName\":\"\",\n		\"updateTime\":1576044287751,\n		\"userNo\":\"\",\n		\"validMessage\":\"\",\n		\"validStatus\":\"\"\n	},\n	\"membermemberTwo\":{\n		\"agentId\":\"\",\n		\"aggregatePayStatus\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardPayStatus\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"email\":\"\",\n		\"emailAuth\":\"\",\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberStatus\":\"\",\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"merchantOpenStatus\":\"\",\n		\"mobileNo\":\"\",\n		\"mobileNoAuth\":\"\",\n		\"new\":true,\n		\"operatorAddStatus\":\"\",\n		\"partnerId\":\"\",\n		\"posPayStatus\":\"\",\n		\"realNameAuth\":\"\",\n		\"registerClient\":\"\",\n		\"registerSource\":\"\",\n		\"salesmanId\":\"\",\n		\"updateTime\":1576044287751,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"merchOrderNo\":\"1912111404472CC80036\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"paycoreactAccount\":{\n		\"accountChannel\":\"\",\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"balance\":null,\n		\"bankAccountNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"freeze\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"status\":\"\",\n		\"updateTime\":1576044287751,\n		\"userName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"paycoreactAccountTwo\":{\n		\"accountChannel\":\"\",\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"balance\":null,\n		\"bankAccountNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287751,\n		\"freeze\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"status\":\"\",\n		\"updateTime\":1576044287751,\n		\"userName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"publicTag\":\"\",\n	\"requestNo\":\"1912111404472CC80035\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"smsCaptchaSendOrder\":{\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"businessType\":null,\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"smsKey\":\"\",\n		\"tradeAmount\":null,\n		\"userNo\":\"\"\n	},\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14714, 'MemberSignFacadeSignApplyFailTwo', '{\n	\"memberSignApplyOrder\":{\n		\"bankCode\":null,\n		\"bankNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"gid\":\"\",\n		\"memberType\":null,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"memberUnSignOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14715, 'MemberSignFacadeUnSignSuccess', '{\n	\"memberSignApplyOrder\":{\n		\"bankCode\":null,\n		\"bankNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"gid\":\"\",\n		\"memberType\":null,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"memberSignConfirmOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"smsCode\":\"\",\n		\"smsOrderId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"memberUnSignOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14716, 'BalancePayApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80100\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payerUserName\":\"\",\n	\"payerUserNo\":\"\",\n	\"requestNo\":\"1912111404472CC80099\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14717, 'NetBankPayFacadeAppPayTestSuccess', '{\n	\"appPayOrder\":{\n		\"amount\":null,\n		\"appId\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"goodsMemo\":\"\",\n		\"isRaw\":\"1\",\n		\"mchCreateIp\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"recAccountName\":\"\",\n		\"recAccountNo\":\"\",\n		\"userNo\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14718, 'QueryAccountAndAuthInfoApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"enterpriseRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCode\":null,\n		\"bizOrderNo\":\"\",\n		\"comName\":\"\",\n		\"comments\":\"\",\n		\"contactEmail\":\"\",\n		\"contactMobileNo\":\"\",\n		\"contactRealName\":\"\",\n		\"doorPhotoPath\":\"\",\n		\"gid\":\"\",\n		\"legalCertBackPath\":\"\",\n		\"legalCertFrontPath\":\"\",\n		\"legalCertNo\":\"\",\n		\"legalMobileNo\":\"\",\n		\"legalRealName\":\"\",\n		\"licenceNo\":\"\",\n		\"licencePath\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"openAccountPath\":\"\",\n		\"partnerId\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"individualRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comName\":\"\",\n		\"comments\":\"\",\n		\"doorPhotoPath\":\"\",\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"legalCertBackPath\":\"\",\n		\"legalCertFrontPath\":\"\",\n		\"legalCertNo\":\"\",\n		\"legalRealName\":\"\",\n		\"licenceNo\":\"\",\n		\"licencePath\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"merchOrderNo\":\"1912111404472CC80016\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"requestNo\":\"1912111404472CC80015\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14719, 'TradeFacadeQuickPaymentConfirmFailTwo', '{\n	\"quickPaymentApplyOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"userIp\":\"\"\n	},\n	\"quickPaymentConfirmOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"smsCode\":\"\",\n		\"userIp\":\"\"\n	},\n	\"reconPeriod\":{\n		\"channelDataMemo\":\"\",\n		\"channelDataStatus\":\"\",\n		\"commemts\":\"\",\n		\"createTime\":1576044287824,\n		\"excessNo\":null,\n		\"failNo\":null,\n		\"gatewayDataMemo\":\"\",\n		\"gatewayDataStatus\":\"\",\n		\"gatewayDateNo\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"status\":\"\",\n		\"successNo\":null,\n		\"updateTime\":1576044287824\n	},\n	\"reconReconResult\":{\n		\"amountChannel\":null,\n		\"amountGateway\":null,\n		\"bizOrderNo\":\"\",\n		\"channelOrderNo\":\"\",\n		\"channelType\":\"\",\n		\"charge\":null,\n		\"createTime\":1576044287824,\n		\"finishTime\":null,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memo\":\"\",\n		\"merchantNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"sendBankSerialNo\":\"\",\n		\"status\":\"\",\n		\"tradeType\":\"\",\n		\"updateTime\":1576044287824\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	}\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14720, 'PayengineDepositFacadeDeductForBindIdDepositFailTwo', '{\n	\"accessKey\":\"\",\n	\"bankName\":\"\",\n	\"changeDirection\":\"\",\n	\"deductDepositOrder\":{\n		\"accountNo\":\"\",\n		\"amount\":null,\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"extContext\":null,\n		\"freezeAmount\":null,\n		\"freezeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"productCode\":\"\",\n		\"productInfo\":\"\",\n		\"productType\":\"\",\n		\"realPayeeAccountNo\":\"\",\n		\"realPayeeUserNo\":\"\",\n		\"tradeOrderType\":null,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"membermember\":{\n		\"agentId\":\"\",\n		\"aggregatePayStatus\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardPayStatus\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"email\":\"\",\n		\"emailAuth\":\"\",\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberStatus\":\"\",\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"merchantOpenStatus\":\"\",\n		\"mobileNo\":\"\",\n		\"mobileNoAuth\":\"\",\n		\"new\":true,\n		\"operatorAddStatus\":\"\",\n		\"partnerId\":\"\",\n		\"posPayStatus\":\"\",\n		\"realNameAuth\":\"\",\n		\"registerClient\":\"\",\n		\"registerSource\":\"\",\n		\"salesmanId\":\"\",\n		\"updateTime\":1576044287765,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"membermemberAccount\":{\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"bankAccountCoreNo\":\"\",\n		\"bankAccountNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"new\":true,\n		\"openStatus\":\"\",\n		\"partnerId\":\"\",\n		\"updateTime\":1576044287765,\n		\"userNo\":\"\"\n	},\n	\"membermemberAccountTwo\":{\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"bankAccountCoreNo\":\"\",\n		\"bankAccountNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"new\":true,\n		\"openStatus\":\"\",\n		\"partnerId\":\"\",\n		\"updateTime\":1576044287765,\n		\"userNo\":\"\"\n	},\n	\"membermemberBankCard\":{\n		\"attorneyPowerPath\":\"\",\n		\"bankCardFrontPath\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCardType\":\"\",\n		\"bankCnapsNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankSubbranch\":\"\",\n		\"bindNo\":\"\",\n		\"bindType\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardStatus\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"city\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"id\":null,\n		\"isFintechSms\":\"\",\n		\"isValidateSms\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"protocolNo\":\"\",\n		\"province\":\"\",\n		\"publicTag\":\"\",\n		\"purpose\":\"\",\n		\"realName\":\"\",\n		\"updateTime\":1576044287765,\n		\"userNo\":\"\",\n		\"validMessage\":\"\",\n		\"validStatus\":\"\"\n	},\n	\"membermemberBankCardTwo\":{\n		\"attorneyPowerPath\":\"\",\n		\"bankCardFrontPath\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCardType\":\"\",\n		\"bankCnapsNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankSubbranch\":\"\",\n		\"bindNo\":\"\",\n		\"bindType\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardStatus\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"city\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"id\":null,\n		\"isFintechSms\":\"\",\n		\"isValidateSms\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"protocolNo\":\"\",\n		\"province\":\"\",\n		\"publicTag\":\"\",\n		\"purpose\":\"\",\n		\"realName\":\"\",\n		\"updateTime\":1576044287765,\n		\"userNo\":\"\",\n		\"validMessage\":\"\",\n		\"validStatus\":\"\"\n	},\n	\"membermemberTwo\":{\n		\"agentId\":\"\",\n		\"aggregatePayStatus\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardPayStatus\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"email\":\"\",\n		\"emailAuth\":\"\",\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberStatus\":\"\",\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"merchantOpenStatus\":\"\",\n		\"mobileNo\":\"\",\n		\"mobileNoAuth\":\"\",\n		\"new\":true,\n		\"operatorAddStatus\":\"\",\n		\"partnerId\":\"\",\n		\"posPayStatus\":\"\",\n		\"realNameAuth\":\"\",\n		\"registerClient\":\"\",\n		\"registerSource\":\"\",\n		\"salesmanId\":\"\",\n		\"updateTime\":1576044287765,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"merchOrderNo\":\"1912111404472CC80040\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"paycoreactAccount\":{\n		\"accountChannel\":\"\",\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"balance\":null,\n		\"bankAccountNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"freeze\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"status\":\"\",\n		\"updateTime\":1576044287765,\n		\"userName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"paycoreactAccountTwo\":{\n		\"accountChannel\":\"\",\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"balance\":null,\n		\"bankAccountNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287765,\n		\"freeze\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"status\":\"\",\n		\"updateTime\":1576044287765,\n		\"userName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"publicTag\":\"\",\n	\"requestNo\":\"1912111404472CC80039\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"smsCaptchaSendOrder\":{\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"businessType\":null,\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"smsKey\":\"\",\n		\"tradeAmount\":null,\n		\"userNo\":\"\"\n	},\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14721, 'SignFacadeSignApplyTestSuccess', '{\n	\"gatewaySignApplyOrder\":{\n		\"bankCardNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"certNo\":\"\",\n		\"certType\":\"IDENTITY_CARD\",\n		\"cvv\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"fbankqftSignBindCardApply\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"tradeDate\":null,\n		\"userNo\":\"\",\n		\"validDate\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14722, 'MemberQueryBindCardApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"bindType\":null,\n	\"merchOrderNo\":\"1912111404472CC80012\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"purpose\":null,\n	\"requestNo\":\"1912111404472CC80011\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14723, 'TradeFacadeQuickPaymentConfirmSuccess', '{\n	\"quickPaymentApplyOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"userIp\":\"\"\n	},\n	\"quickPaymentConfirmOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"smsCode\":\"\",\n		\"userIp\":\"\"\n	},\n	\"reconPeriod\":{\n		\"channelDataMemo\":\"\",\n		\"channelDataStatus\":\"\",\n		\"commemts\":\"\",\n		\"createTime\":1576044287829,\n		\"excessNo\":null,\n		\"failNo\":null,\n		\"gatewayDataMemo\":\"\",\n		\"gatewayDataStatus\":\"\",\n		\"gatewayDateNo\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"status\":\"\",\n		\"successNo\":null,\n		\"updateTime\":1576044287829\n	},\n	\"reconReconResult\":{\n		\"amountChannel\":null,\n		\"amountGateway\":null,\n		\"bizOrderNo\":\"\",\n		\"channelOrderNo\":\"\",\n		\"channelType\":\"\",\n		\"charge\":null,\n		\"createTime\":1576044287829,\n		\"finishTime\":null,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memo\":\"\",\n		\"merchantNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"sendBankSerialNo\":\"\",\n		\"status\":\"\",\n		\"tradeType\":\"\",\n		\"updateTime\":1576044287829\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	}\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14724, 'BalancePayApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80096\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payerUserName\":\"\",\n	\"payerUserNo\":\"\",\n	\"requestNo\":\"1912111404472CC80095\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14725, 'TradeCreateApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"amount\":\"\",\n	\"buyerUserNo\":\"\",\n	\"closeTime\":\"\",\n	\"goodsInfoDtoInfo\":null,\n	\"merchOrderNo\":\"1912111404472CC80112\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payeeUserNo\":\"\",\n	\"payerUserName\":\"\",\n	\"payerUserNo\":\"\",\n	\"requestNo\":\"1912111404472CC80111\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"sellerUserNo\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"tradeMemo\":\"\",\n	\"tradeName\":\"\",\n	\"tradeProfitInfoDtoInfo\":null,\n	\"tradeProfitType\":null,\n	\"tradeTime\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14726, 'WechatBeiScanPayApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"authCode\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80120\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"payLimit\":\"\",\n	\"productInfo\":\"\",\n	\"requestNo\":\"1912111404472CC80119\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14727, 'TradeFacadeWechatAppPayTestFailTwo', '{\n	\"reconPeriod\":{\n		\"channelDataMemo\":\"\",\n		\"channelDataStatus\":\"\",\n		\"commemts\":\"\",\n		\"createTime\":1576044287834,\n		\"excessNo\":null,\n		\"failNo\":null,\n		\"gatewayDataMemo\":\"\",\n		\"gatewayDataStatus\":\"\",\n		\"gatewayDateNo\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"status\":\"\",\n		\"successNo\":null,\n		\"updateTime\":1576044287834\n	},\n	\"reconReconResult\":{\n		\"amountChannel\":null,\n		\"amountGateway\":null,\n		\"bizOrderNo\":\"\",\n		\"channelOrderNo\":\"\",\n		\"channelType\":\"\",\n		\"charge\":null,\n		\"createTime\":1576044287834,\n		\"finishTime\":null,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memo\":\"\",\n		\"merchantNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"periodNo\":\"\",\n		\"profitMemo\":\"\",\n		\"profitStatus\":\"\",\n		\"sendBankSerialNo\":\"\",\n		\"status\":\"\",\n		\"tradeType\":\"\",\n		\"updateTime\":1576044287834\n	},\n	\"tradeCheckOrder\":{\n		\"clearAmount\":0,\n		\"clearStatus\":\"\",\n		\"profitAmount\":0,\n		\"profitStatus\":\"\",\n		\"reconStatus\":\"\",\n		\"status\":\"\",\n		\"type\":\"\"\n	},\n	\"tradeCreateOrder\":{\n		\"amount\":null,\n		\"bizOrderNo\":\"\",\n		\"buyerUserNo\":\"\",\n		\"closeTime\":null,\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"goodsList\":null,\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payeeUserNo\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"profitList\":null,\n		\"profitType\":\"AUTO\",\n		\"sellerUserNo\":\"\",\n		\"tradeMemo\":\"\",\n		\"tradeName\":\"\",\n		\"tradeTime\":null\n	},\n	\"wechatAppPayOrder\":{\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"productInfo\":\"\",\n		\"userIp\":\"\",\n		\"wxAppid\":\"\"\n	},\n	\"wechatPublicPayOrder\":{\n		\"appId\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"gid\":\"\",\n		\"macAddress\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchTwoNumCode\":\"\",\n		\"openId\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"payerUserName\":\"\",\n		\"payerUserNo\":\"\",\n		\"platformType\":\"OPENAPI\",\n		\"productInfo\":\"\",\n		\"userIp\":\"\"\n	}\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14728, 'PayengineDepositFacadeDeductForBindIdDepositSuccess', '{\n	\"accessKey\":\"\",\n	\"bankName\":\"\",\n	\"changeDirection\":\"\",\n	\"deductDepositOrder\":{\n		\"accountNo\":\"\",\n		\"amount\":null,\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"deviceType\":\"PC\",\n		\"extContext\":null,\n		\"freezeAmount\":null,\n		\"freezeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"payLimit\":null,\n		\"productCode\":\"\",\n		\"productInfo\":\"\",\n		\"productType\":\"\",\n		\"realPayeeAccountNo\":\"\",\n		\"realPayeeUserNo\":\"\",\n		\"tradeOrderType\":null,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"membermember\":{\n		\"agentId\":\"\",\n		\"aggregatePayStatus\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardPayStatus\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"email\":\"\",\n		\"emailAuth\":\"\",\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberStatus\":\"\",\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"merchantOpenStatus\":\"\",\n		\"mobileNo\":\"\",\n		\"mobileNoAuth\":\"\",\n		\"new\":true,\n		\"operatorAddStatus\":\"\",\n		\"partnerId\":\"\",\n		\"posPayStatus\":\"\",\n		\"realNameAuth\":\"\",\n		\"registerClient\":\"\",\n		\"registerSource\":\"\",\n		\"salesmanId\":\"\",\n		\"updateTime\":1576044287769,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"membermemberAccount\":{\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"bankAccountCoreNo\":\"\",\n		\"bankAccountNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"new\":true,\n		\"openStatus\":\"\",\n		\"partnerId\":\"\",\n		\"updateTime\":1576044287769,\n		\"userNo\":\"\"\n	},\n	\"membermemberAccountTwo\":{\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"bankAccountCoreNo\":\"\",\n		\"bankAccountNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"new\":true,\n		\"openStatus\":\"\",\n		\"partnerId\":\"\",\n		\"updateTime\":1576044287769,\n		\"userNo\":\"\"\n	},\n	\"membermemberBankCard\":{\n		\"attorneyPowerPath\":\"\",\n		\"bankCardFrontPath\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCardType\":\"\",\n		\"bankCnapsNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankSubbranch\":\"\",\n		\"bindNo\":\"\",\n		\"bindType\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardStatus\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"city\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"id\":null,\n		\"isFintechSms\":\"\",\n		\"isValidateSms\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"protocolNo\":\"\",\n		\"province\":\"\",\n		\"publicTag\":\"\",\n		\"purpose\":\"\",\n		\"realName\":\"\",\n		\"updateTime\":1576044287769,\n		\"userNo\":\"\",\n		\"validMessage\":\"\",\n		\"validStatus\":\"\"\n	},\n	\"membermemberBankCardTwo\":{\n		\"attorneyPowerPath\":\"\",\n		\"bankCardFrontPath\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCardType\":\"\",\n		\"bankCnapsNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankSubbranch\":\"\",\n		\"bindNo\":\"\",\n		\"bindType\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardStatus\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"city\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"gid\":\"\",\n		\"holdCertPath\":\"\",\n		\"id\":null,\n		\"isFintechSms\":\"\",\n		\"isValidateSms\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"protocolNo\":\"\",\n		\"province\":\"\",\n		\"publicTag\":\"\",\n		\"purpose\":\"\",\n		\"realName\":\"\",\n		\"updateTime\":1576044287769,\n		\"userNo\":\"\",\n		\"validMessage\":\"\",\n		\"validStatus\":\"\"\n	},\n	\"membermemberTwo\":{\n		\"agentId\":\"\",\n		\"aggregatePayStatus\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardPayStatus\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"email\":\"\",\n		\"emailAuth\":\"\",\n		\"gid\":\"\",\n		\"id\":null,\n		\"memberStatus\":\"\",\n		\"memberType\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"merchantOpenStatus\":\"\",\n		\"mobileNo\":\"\",\n		\"mobileNoAuth\":\"\",\n		\"new\":true,\n		\"operatorAddStatus\":\"\",\n		\"partnerId\":\"\",\n		\"posPayStatus\":\"\",\n		\"realNameAuth\":\"\",\n		\"registerClient\":\"\",\n		\"registerSource\":\"\",\n		\"salesmanId\":\"\",\n		\"updateTime\":1576044287769,\n		\"userIp\":\"\",\n		\"userNo\":\"\"\n	},\n	\"merchOrderNo\":\"1912111404472CC80044\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"paycoreactAccount\":{\n		\"accountChannel\":\"\",\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"balance\":null,\n		\"bankAccountNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"freeze\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"status\":\"\",\n		\"updateTime\":1576044287769,\n		\"userName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"paycoreactAccountTwo\":{\n		\"accountChannel\":\"\",\n		\"accountNo\":\"\",\n		\"accountType\":\"\",\n		\"balance\":null,\n		\"bankAccountNo\":\"\",\n		\"comments\":\"\",\n		\"createTime\":1576044287769,\n		\"freeze\":null,\n		\"id\":null,\n		\"memo\":\"\",\n		\"new\":true,\n		\"partnerId\":\"\",\n		\"status\":\"\",\n		\"updateTime\":1576044287769,\n		\"userName\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"publicTag\":\"\",\n	\"requestNo\":\"1912111404472CC80043\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"smsCaptchaSendOrder\":{\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"businessType\":null,\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"smsKey\":\"\",\n		\"tradeAmount\":null,\n		\"userNo\":\"\"\n	},\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14729, 'MemberSignFacadeSignApplyFailOne', '{\n	\"memberSignApplyOrder\":{\n		\"bankCode\":null,\n		\"bankNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"gid\":\"\",\n		\"memberType\":null,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:12', '2019-12-11 14:05:12');
INSERT INTO `case_request_parameter` VALUES (14730, 'SignFacadeUnSignTestSuccess', '{\n	\"gatewaySignApplyOrder\":{\n		\"bankCardNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"certNo\":\"\",\n		\"certType\":\"IDENTITY_CARD\",\n		\"cvv\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"fbankqftSignBindCardApply\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"tradeDate\":null,\n		\"userNo\":\"\",\n		\"validDate\":\"\"\n	},\n	\"gatewaySignOrder\":{\n		\"bankCardNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"cardType\":\"DEBIT_CARD\",\n		\"certNo\":\"\",\n		\"certType\":\"IDENTITY_CARD\",\n		\"cvv\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"fbankqftSignBindCardConfirm\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"smsCode\":\"\",\n		\"smsOrderId\":\"\",\n		\"tradeDate\":null,\n		\"userNo\":\"\",\n		\"validDate\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\",\n	\"unSignOrder\":{\n		\"agreementNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"fbankqftUnSignBindCard\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	}\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
INSERT INTO `case_request_parameter` VALUES (14731, 'WechatPublicPayApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"appId\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80136\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"openId\":\"\",\n	\"partnerId\":\"\",\n	\"requestNo\":\"1912111404472CC80135\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
INSERT INTO `case_request_parameter` VALUES (14732, 'SignFacadeSignTestSuccess', '{\n	\"gatewaySignApplyOrder\":{\n		\"bankCardNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"certNo\":\"\",\n		\"certType\":\"IDENTITY_CARD\",\n		\"cvv\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"fbankqftSignBindCardApply\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"tradeDate\":null,\n		\"userNo\":\"\",\n		\"validDate\":\"\"\n	},\n	\"gatewaySignOrder\":{\n		\"bankCardNo\":\"\",\n		\"bankCode\":\"\",\n		\"bankKeyId\":null,\n		\"bizOrderNo\":\"\",\n		\"cardType\":\"DEBIT_CARD\",\n		\"certNo\":\"\",\n		\"certType\":\"IDENTITY_CARD\",\n		\"cvv\":\"\",\n		\"extendParam\":\"\",\n		\"gatewayChannelApi\":\"fbankqftSignBindCardConfirm\",\n		\"gatewayChannelType\":\"FBANKQFT\",\n		\"gatewayTradeType\":null,\n		\"gid\":\"\",\n		\"memo\":\"\",\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"smsCode\":\"\",\n		\"smsOrderId\":\"\",\n		\"tradeDate\":null,\n		\"userNo\":\"\",\n		\"validDate\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
INSERT INTO `case_request_parameter` VALUES (14733, 'SignApplyApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"bankCode\":null,\n	\"bankNo\":\"\",\n	\"cardType\":null,\n	\"memberType\":null,\n	\"memberUnSignOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"merchOrderNo\":\"1912111404472CC80028\",\n	\"message\":\"成功\",\n	\"mobileNo\":\"\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"requestNo\":\"1912111404472CC80027\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
INSERT INTO `case_request_parameter` VALUES (14734, 'QueryAccountBalanceApiServiceTestSuccess', '{\n	\"accessKey\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80020\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"partnerId\":\"\",\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"requestNo\":\"1912111404472CC80019\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userNo\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
INSERT INTO `case_request_parameter` VALUES (14735, 'WechatPublicPayApiServiceTestFailOne', '{\n	\"accessKey\":\"\",\n	\"appId\":\"\",\n	\"deviceType\":null,\n	\"macAddress\":\"\",\n	\"merchOrderNo\":\"1912111404472CC80132\",\n	\"message\":\"成功\",\n	\"notifyUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"openId\":\"\",\n	\"partnerId\":\"\",\n	\"requestNo\":\"1912111404472CC80131\",\n	\"resultCode\":\"SUCCESS\",\n	\"returnUrl\":\"http://127.0.0.1:8999/manage/index.html\",\n	\"securityKey\":\"\",\n	\"service\":\"\",\n	\"singType\":\"MD5\",\n	\"userIp\":\"\",\n	\"version\":\"1.0\"\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
INSERT INTO `case_request_parameter` VALUES (14736, 'BankCardFacadeBindClearCardFailOne', '{\n	\"bindClearCardOrder\":{\n		\"accessToken\":\"\",\n		\"bankCardNo\":\"\",\n		\"bankCode\":null,\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"hasCheckToken\":true,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"publicTag\":null,\n		\"subbranch\":\"\",\n		\"userNo\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
INSERT INTO `case_request_parameter` VALUES (14737, 'MemberSignFacadeSignApplySuccess', '{\n	\"memberSignApplyOrder\":{\n		\"bankCode\":null,\n		\"bankNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"cardType\":null,\n		\"gid\":\"\",\n		\"memberType\":null,\n		\"merchOrderNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"memberUnSignOrder\":{\n		\"bindNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"partnerId\":\"\",\n		\"userNo\":\"\"\n	},\n	\"personRegisterOrder\":{\n		\"accessToken\":\"\",\n		\"agentId\":\"\",\n		\"bankCardMobileNo\":\"\",\n		\"bankCardNo\":\"\",\n		\"bizOrderNo\":\"\",\n		\"certBackPath\":\"\",\n		\"certFrontPath\":\"\",\n		\"certNo\":\"\",\n		\"comments\":\"\",\n		\"gid\":\"\",\n		\"merchOrderNo\":\"\",\n		\"merchUserNo\":\"\",\n		\"mobileNo\":\"\",\n		\"partnerId\":\"\",\n		\"realName\":\"\",\n		\"registerClient\":null,\n		\"registerSource\":\"PAGE\",\n		\"salesmanId\":\"\"\n	},\n	\"resultCode\":\"SUCCESS\",\n	\"resultMessage\":\"成功\"\n}', '2019-12-11 14:05:13', '2019-12-11 14:05:13');
COMMIT;

-- ----------------------------
-- Table structure for case_temp
-- ----------------------------
DROP TABLE IF EXISTS `case_temp`;
CREATE TABLE `case_temp` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `case_no` varchar(20) DEFAULT NULL COMMENT '用例编号',
  `position` varchar(128) DEFAULT NULL COMMENT '标签位置',
  `action` varchar(64) DEFAULT NULL COMMENT '元素操作',
  `value` varchar(128) DEFAULT NULL COMMENT '元素值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for execute_log
-- ----------------------------
DROP TABLE IF EXISTS `execute_log`;
CREATE TABLE `execute_log` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `project_no` varchar(64) DEFAULT NULL,
  `interface_no` varchar(64) DEFAULT NULL,
  `case_no` varchar(64) DEFAULT NULL,
  `parameter_no` varchar(64) DEFAULT NULL,
  `parameters` text,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1842 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='原始请求日志表';

-- ----------------------------
-- Records of execute_log
-- ----------------------------


-- ----------------------------
-- Table structure for interface
-- ----------------------------
DROP TABLE IF EXISTS `interface`;
CREATE TABLE `interface` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interface_no` varchar(64) NOT NULL COMMENT '接口编号',
  `interface_name` varchar(32) NOT NULL COMMENT '接口名称',
  `project_no` varchar(20) NOT NULL COMMENT '所属项目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `interface_no_un` (`interface_no`) COMMENT '接口编号唯一'
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COMMENT='被测接口表';

-- ----------------------------
-- Records of interface
-- ----------------------------
BEGIN;
INSERT INTO `interface` VALUES (11, 'PayengineDepositFacade', '支付核心充值相关接口', 'cheyunpay-paycore', '2019-11-27 13:56:51', '2019-12-09 16:47:09');
INSERT INTO `interface` VALUES (12, 'accountTransfer', '单笔站内转账', 'cheyunpay-trade', '2019-11-27 15:35:55', '2019-11-27 15:35:55');
INSERT INTO `interface` VALUES (13, 'quickPaymentApply', '快捷支付申请-短信发送', 'cheyunpay-trade', '2019-11-27 16:29:48', '2019-11-27 16:29:48');
INSERT INTO `interface` VALUES (14, 'BankCardFacadeBindClearCard', '绑卡渠道清算卡', 'cheyunpay-member', '2019-11-28 09:31:27', '2019-11-28 09:31:27');
INSERT INTO `interface` VALUES (15, 'aliBeiScanPay', '支付宝被扫', 'cheyunpay-trade', '2019-11-28 15:14:11', '2019-11-28 15:14:11');
INSERT INTO `interface` VALUES (16, 'tradeCreate', '创建交易', 'cheyunpay-trade', '2019-11-28 15:32:18', '2019-11-28 15:32:18');
INSERT INTO `interface` VALUES (17, 'aliLifePay', '支付宝服务窗', 'cheyunpay-trade', '2019-11-28 17:49:37', '2019-11-28 17:49:37');
INSERT INTO `interface` VALUES (18, 'aliZhuScanPay', '支付宝主扫', 'cheyunpay-trade', '2019-11-29 09:02:10', '2019-11-29 09:02:10');
INSERT INTO `interface` VALUES (19, 'balancePay', '余额支付', 'cheyunpay-trade', '2019-11-29 10:09:53', '2019-11-29 10:09:53');
INSERT INTO `interface` VALUES (20, 'tradeClose', '交易关闭', 'cheyunpay-trade', '2019-11-29 10:37:22', '2019-11-29 10:37:22');
INSERT INTO `interface` VALUES (21, 'wechatBeiScanPay', '微信被扫', 'cheyunpay-trade', '2019-11-29 10:53:59', '2019-11-29 10:53:59');
INSERT INTO `interface` VALUES (22, 'wechatMiniPay', '微信小程序支付', 'cheyunpay-trade', '2019-11-29 11:04:30', '2019-11-29 11:04:30');
INSERT INTO `interface` VALUES (23, 'withdraw', '提现', 'cheyunpay-trade', '2019-11-29 11:24:08', '2019-11-29 11:24:08');
INSERT INTO `interface` VALUES (24, 'MemberSignFacadeSignApply', '签约申请接口&#40;发送短信&#41;', 'cheyunpay-member', '2019-11-29 14:42:42', '2019-11-29 14:42:42');
INSERT INTO `interface` VALUES (25, 'SignFacade.signApply', '签约申请', 'cheyunpay-gateway', '2019-11-29 15:07:51', '2019-11-29 15:07:51');
INSERT INTO `interface` VALUES (26, 'SignFacade.sign', '签约确认', 'cheyunpay-gateway', '2019-12-02 11:58:28', '2019-12-02 11:58:28');
INSERT INTO `interface` VALUES (27, 'quickPaymentConfirm', '快捷支付确认支付', 'cheyunpay-trade', '2019-12-02 14:05:24', '2019-12-02 14:05:24');
INSERT INTO `interface` VALUES (28, 'MemberSignFacadeSignConfirm', '确认签约', 'cheyunpay-member', '2019-12-02 17:21:47', '2019-12-02 17:21:47');
INSERT INTO `interface` VALUES (29, 'SignFacade.unSign', '解约', 'cheyunpay-gateway', '2019-12-02 17:30:34', '2019-12-02 17:30:34');
INSERT INTO `interface` VALUES (30, 'wechatPublicPay', '微信公众号支付', 'cheyunpay-trade', '2019-12-03 09:27:15', '2019-12-03 09:27:15');
INSERT INTO `interface` VALUES (31, 'MemberSignFacadeUnSign', '解约', 'cheyunpay-member', '2019-12-03 10:16:41', '2019-12-03 10:16:41');
INSERT INTO `interface` VALUES (32, 'BankCardFacadeEntrustBindCard', '委托绑卡', 'cheyunpay-member', '2019-12-03 15:16:52', '2019-12-03 15:16:52');
INSERT INTO `interface` VALUES (33, 'QueryAccountBalance', '查询余额', 'cheyunpay-member', '2019-12-03 19:09:28', '2019-12-03 19:09:28');
INSERT INTO `interface` VALUES (34, 'quickPaymentApplys', '快捷支付申请服务', 'cheyunpay-openapi', '2019-12-03 19:36:09', '2019-12-03 19:51:57');
INSERT INTO `interface` VALUES (35, 'MemberQueryBindCardApiService', '查询会员的绑卡信息', 'cheyunpay-member', '2019-12-04 10:08:33', '2019-12-04 10:08:33');
INSERT INTO `interface` VALUES (36, 'wechatAppPay', '微信APP支付', 'cheyunpay-trade', '2019-12-09 15:40:27', '2019-12-09 15:40:27');
INSERT INTO `interface` VALUES (37, 'NetBankPayFacade.appPay', '微信支付宝APP支付', 'cheyunpay-gateway', '2019-12-09 17:03:25', '2019-12-09 17:03:25');
INSERT INTO `interface` VALUES (41, 'wechatAppPays', '微信APP支付', 'cheyunpay-openapi', '2019-12-10 14:59:05', '2019-12-10 14:59:05');
INSERT INTO `interface` VALUES (42, 'readFile', '解析对账文件', 'cheyunpay-bill', '2019-12-11 13:49:57', '2019-12-11 13:49:57');
INSERT INTO `interface` VALUES (43, 'dealwithChannelFile', '处理文件', 'cheyunpay-bill', '2019-12-11 14:05:47', '2019-12-11 14:05:47');
INSERT INTO `interface` VALUES (44, 'downChannelFile', '下载文件', 'cheyunpay-bill', '2019-12-11 14:06:06', '2019-12-11 14:06:06');
COMMIT;

-- ----------------------------
-- Table structure for log_info
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `project_no` varchar(64) DEFAULT NULL COMMENT '项目名',
  `interface_no` varchar(64) DEFAULT NULL COMMENT '接口名',
  `case_no` varchar(64) DEFAULT NULL COMMENT '用例编号',
  `parameters_no` varchar(64) DEFAULT NULL COMMENT '用例执行参数编号',
  `request_info` varchar(1024) DEFAULT NULL COMMENT '请求接口参数',
  `result_info` varchar(1024) DEFAULT NULL COMMENT '接口返回参数',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `memo` varchar(64) DEFAULT NULL COMMENT '用例说明',
  `exexute_status` varchar(10) DEFAULT NULL COMMENT '用例执行状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1087 DEFAULT CHARSET=utf8mb4 COMMENT='接口请求日志表';

-- ----------------------------
-- Records of log_info
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `project_no` varchar(20) NOT NULL COMMENT '项目编号',
  `project_name` varchar(32) NOT NULL COMMENT '项目名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='被测系统表';

-- ----------------------------
-- Records of project
-- ----------------------------
BEGIN;
INSERT INTO `project` VALUES (6, 'cheyunpay-trade', '车云宝交易系统', '2019-11-27 13:54:02', '2019-11-27 13:54:02');
INSERT INTO `project` VALUES (7, 'cheyunpay-member', '车云宝会员系统', '2019-11-27 13:54:33', '2019-11-27 13:54:33');
INSERT INTO `project` VALUES (8, 'cheyunpay-paycore', '车云宝支付引擎', '2019-11-27 13:56:32', '2019-11-29 09:14:57');
INSERT INTO `project` VALUES (9, 'cheyunpay-gateway', '车云宝网关', '2019-11-29 15:07:34', '2019-11-29 15:07:34');
INSERT INTO `project` VALUES (10, 'cheyunpay-openapi', '车云宝开放平台', '2019-12-03 14:14:52', '2019-12-03 14:14:52');
INSERT INTO `project` VALUES (11, 'cheyunpay-bill', '车云宝对账系统', '2019-12-11 13:49:17', '2019-12-11 13:49:17');
COMMIT;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
BEGIN;
INSERT INTO `qrtz_locks` VALUES ('acooly-scheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('schedulerFactoryBean', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('schedulerFactoryBean', 'TRIGGER_ACCESS');
COMMIT;

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
BEGIN;
INSERT INTO `qrtz_scheduler_state` VALUES ('acooly-scheduler', 'mfldeMacBook-Pro.local1576043451147', 1576043921276, 20000);
INSERT INTO `qrtz_scheduler_state` VALUES ('schedulerFactoryBean', 'LAPTOP-NA7BPHU61576044294886', 1576045050598, 20000);
INSERT INTO `qrtz_scheduler_state` VALUES ('schedulerFactoryBean', 'NSE4166SHWAVXVM1576043982983', 1576045044656, 20000);
INSERT INTO `qrtz_scheduler_state` VALUES ('schedulerFactoryBean', 'X5J91K09WRIYURY1576035648776', 1576045051131, 20000);
COMMIT;

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for scheduler_rule
-- ----------------------------
DROP TABLE IF EXISTS `scheduler_rule`;
CREATE TABLE `scheduler_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_type` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `cron_string` varchar(255) DEFAULT NULL,
  `exception_at_last_execute` varchar(255) DEFAULT NULL,
  `execute_num` int(11) DEFAULT NULL,
  `last_execute_time` datetime DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `d_param` varchar(255) DEFAULT NULL COMMENT 'dubbo调用执行参数',
  `d_version` varchar(256) DEFAULT NULL COMMENT 'dubbo version',
  `d_group` varchar(256) DEFAULT NULL COMMENT 'dubbo group',
  `modifyer` varchar(255) DEFAULT NULL,
  `properties` varchar(255) DEFAULT NULL,
  `retry_time_on_exception` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `validity_end` datetime DEFAULT NULL,
  `validity_start` datetime DEFAULT NULL,
  `is_del` bit(1) DEFAULT b'0' COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `TITLE` varchar(64) NOT NULL COMMENT '标题',
  `NAME` varchar(64) NOT NULL COMMENT '名称',
  `VALUE` varchar(512) DEFAULT NULL COMMENT '值',
  `COMMENTS` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基础框架配置表';

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(20) NOT NULL COMMENT '父类id',
  `name` varchar(128) DEFAULT NULL COMMENT '机构名称',
  `status` varchar(32) DEFAULT NULL COMMENT '状态{valid:有效,invalid:无效}',
  `province` varchar(64) DEFAULT NULL COMMENT '省',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `county` varchar(64) DEFAULT NULL COMMENT '县',
  `mobile_no` varchar(20) DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `contacts` varchar(64) DEFAULT NULL COMMENT '联系人',
  `telephone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `email` varchar(64) DEFAULT NULL COMMENT '机构邮箱',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='组织机构';

-- ----------------------------
-- Records of sys_org
-- ----------------------------
BEGIN;
INSERT INTO `sys_org` VALUES (1, 0, 'acooly', 'valid', '重庆市', '重庆市', '渝北区', '13896177630', '重庆渝北', '张浦', '', 'zhangpu@acooly.cn', '2019-02-21 18:05:36', '2019-02-21 18:05:36', 'dev');
COMMIT;

-- ----------------------------
-- Table structure for sys_portallet
-- ----------------------------
DROP TABLE IF EXISTS `sys_portallet`;
CREATE TABLE `sys_portallet` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `TITLE` varchar(64) NOT NULL COMMENT '标题',
  `USER_NAME` varchar(32) DEFAULT NULL COMMENT '所属用户',
  `WIDTH` int(11) NOT NULL COMMENT '高度',
  `HEIGHT` int(11) NOT NULL COMMENT '宽度',
  `COLLAPSIBLE` int(11) NOT NULL COMMENT '可否收缩{1:true,0:false}',
  `LOAD_MODE` int(11) DEFAULT NULL COMMENT '内容类型{1:url,2:html}',
  `SHOW_MODE` int(11) DEFAULT NULL COMMENT '加载方式 {1:ajax,2:iframe}',
  `HREF` varchar(128) DEFAULT NULL COMMENT '连接地址',
  `CONTENT` varchar(4000) DEFAULT NULL COMMENT '内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='桌面管理';

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PARENTID` bigint(20) DEFAULT NULL COMMENT '父主键',
  `NAME` varchar(64) NOT NULL COMMENT '资源名称',
  `TYPE` varchar(64) NOT NULL COMMENT '资源类型 MENU FUNC URL',
  `SHOW_STATE` int(11) NOT NULL COMMENT '是否显示{0:显示,1:隐藏}',
  `ORDER_TIME` datetime NOT NULL COMMENT '排序时间',
  `VALUE` varchar(256) DEFAULT NULL COMMENT '资源值',
  `SHOW_MODE` int(11) DEFAULT NULL COMMENT '加载方式 (1:AJAXLOAD,2:IFRAME)',
  `ICON` varchar(64) DEFAULT NULL COMMENT '图标',
  `DESCN` varchar(256) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FKgn772upae8k25waob96nd73el` (`PARENTID`) USING BTREE,
  CONSTRAINT `FKgn772upae8k25waob96nd73el` FOREIGN KEY (`PARENTID`) REFERENCES `sys_resource` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2019022211 DEFAULT CHARSET=utf8mb4 COMMENT='系统资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource` VALUES (1, NULL, '系统管理', 'MENU', 0, '2014-01-07 00:00:00', NULL, 1, 'fa-cogs', NULL, '2019-07-04 11:16:58', '2019-07-04 11:16:58');
INSERT INTO `sys_resource` VALUES (2, 1, '账户管理', 'URL', 0, '2015-01-10 00:00:01', '/manage/system/user/index.html', 1, 'fa-user', NULL, '2019-07-04 11:16:58', '2019-07-04 11:16:58');
INSERT INTO `sys_resource` VALUES (3, 1, '角色管理', 'URL', 0, '2014-01-10 00:00:01', '/manage/system/role/index.html', 1, 'fa-user-circle-o', NULL, '2019-07-04 11:16:58', '2019-07-04 11:16:58');
INSERT INTO `sys_resource` VALUES (4, 1, '资源菜单', 'URL', 0, '2014-01-10 00:00:00', '/manage/system/resource/index.html', 1, 'fa-list', NULL, '2019-07-04 11:16:58', '2019-07-04 11:16:58');
INSERT INTO `sys_resource` VALUES (7, 1, '桌面管理', 'URL', 0, '2014-01-08 02:39:40', '/manage/system/portallet/index.html', 1, 'fa-dashboard', NULL, '2019-07-04 11:16:58', '2019-07-04 11:16:58');
INSERT INTO `sys_resource` VALUES (8, 1, '连接池监控', 'URL', 0, '2014-01-08 02:39:40', '/manage/druid/index.html', 2, 'fa-eye', NULL, '2019-07-04 11:16:58', '2019-07-04 11:16:58');
INSERT INTO `sys_resource` VALUES (201704071, 2019022201, '定时任务列表', 'URL', 0, '2017-04-07 14:43:54', '/manage/schedulerRule/index.html', 1, 'fa fa-clock-o', NULL, '2017-04-07 14:43:54', '2017-04-07 14:43:54');
INSERT INTO `sys_resource` VALUES (2016093009, 1, '机构管理', 'URL', 0, '2014-01-09 02:39:40', '/manage/module/security/org/index.html', 1, 'fa-sitemap', NULL, '2017-05-26 17:51:13', '2017-05-27 13:39:38');
INSERT INTO `sys_resource` VALUES (2018101010, NULL, '图形报表', 'MENU', 0, '2018-10-10 17:25:21', '', 1, 'icons-resource-app1', NULL, '2018-08-30 17:25:21', '2018-08-30 17:25:21');
INSERT INTO `sys_resource` VALUES (2018101011, 2018101010, '图表管理', 'URL', 0, '2018-10-10 17:25:19', '/manage/module/chart/chart/index.html', 1, 'icons-resource-tongji', NULL, '2018-08-30 17:26:01', '2018-10-16 17:45:05');
INSERT INTO `sys_resource` VALUES (2018101012, 2018101010, '图表选项', 'URL', 1, '2018-10-10 17:25:20', '/manage/module/chart/chartItems/index.html', 1, 'icons-resource-tongjibaobiao', NULL, '2018-08-30 17:26:11', '2018-10-16 17:45:22');
INSERT INTO `sys_resource` VALUES (2018101013, 2018101010, '图表数据项', 'URL', 1, '2018-10-10 17:25:20', '/manage/module/chart/chartData/index.html', 1, 'icons-resource-tongjibaobiao', NULL, '2018-08-30 17:26:11', '2018-10-16 17:45:19');
INSERT INTO `sys_resource` VALUES (2018101014, 2018101010, '图片展示', 'URL', 1, '2018-10-15 16:30:57', '/manage/module/echarts/index.html', 1, 'icons-resource-tongjixinxi', NULL, '2018-10-15 16:30:57', '2018-10-16 17:45:35');
INSERT INTO `sys_resource` VALUES (2019022201, NULL, '通用功能', 'MENU', 0, '2015-10-23 18:32:04', '', 1, 'fa-th', NULL, '2019-02-22 16:39:49', '2019-02-22 16:40:00');
INSERT INTO `sys_resource` VALUES (2019022202, NULL, '测试管理', 'MENU', 0, '2019-07-04 11:18:40', '', 1, 'fa-align-left', NULL, '2019-07-04 11:18:40', '2019-12-06 17:35:03');
INSERT INTO `sys_resource` VALUES (2019022203, 2019022202, '用例管理', 'URL', 0, '2019-07-16 16:22:37', '/manage/jorge/testCase/index.html', 1, 'fa-th-large', NULL, '2019-07-04 11:31:54', '2019-07-25 16:12:41');
INSERT INTO `sys_resource` VALUES (2019022204, 2019022202, '模块管理', 'URL', 0, '2019-07-04 11:32:20', '/manage/system/user/index.html', 1, 'fa-th-list', NULL, '2019-07-04 11:32:20', '2019-07-04 11:32:20');
INSERT INTO `sys_resource` VALUES (2019022205, 2019022202, '测试项目管理', 'URL', 0, '2019-07-16 16:22:39', '/manage/jorge/project/index.html', 1, 'fa-map', NULL, '2019-07-16 16:07:20', '2019-07-25 16:12:34');
INSERT INTO `sys_resource` VALUES (2019022206, 2019022202, '接口管理', 'URL', 1, '2019-07-16 16:22:38', '/manage/jorge/interface/index.html', 1, 'fa-align-left', NULL, '2019-07-16 16:22:38', '2019-10-29 10:29:28');
INSERT INTO `sys_resource` VALUES (2019022207, 2019022202, '用例参数管理', 'URL', 1, '2019-07-04 11:32:21', '/manage/jorge/parameters/index.html', 1, 'fa-list', NULL, '2019-07-23 15:30:52', '2019-07-25 16:26:08');
INSERT INTO `sys_resource` VALUES (2019022208, 2019022202, '请求参数模板', 'URL', 0, '2019-08-01 14:49:51', '/manage/jorge/caseRequestParameter/index.html', 1, 'fa-glass', NULL, '2019-08-01 14:49:51', '2019-08-01 14:49:51');
INSERT INTO `sys_resource` VALUES (2019022209, 2019022202, '执行日志', 'URL', 0, '2019-07-04 11:32:20', '/manage/jorge/executeLog/index.html', 1, 'fa-keyboard-o', NULL, '2019-12-02 09:56:32', '2019-12-06 17:31:48');
INSERT INTO `sys_resource` VALUES (2019022210, 2019022202, '接口实际请求记录', 'URL', 0, '2019-07-04 11:32:19', '/manage/jorge/logInfo/index.html', 1, 'fa-table', NULL, '2019-12-06 17:31:03', '2019-12-06 17:34:58');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) NOT NULL,
  `ORG_ID` int(11) DEFAULT NULL,
  `DESCN` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, 'ROLE_SYSTEM', NULL, '系统管理角色', '2019-07-04 11:16:58', '2019-12-06 17:32:10');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_resc
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resc`;
CREATE TABLE `sys_role_resc` (
  `ROLE_ID` bigint(20) NOT NULL,
  `RESC_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`RESC_ID`) USING BTREE,
  KEY `FKr7bg3ty0c90mqawgvqiscey2d` (`RESC_ID`) USING BTREE,
  CONSTRAINT `FK8pigxq0qepcfjdsva61ghvbsd` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`),
  CONSTRAINT `FKr7bg3ty0c90mqawgvqiscey2d` FOREIGN KEY (`RESC_ID`) REFERENCES `sys_resource` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_resc
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_resc` VALUES (1, 1);
INSERT INTO `sys_role_resc` VALUES (1, 2);
INSERT INTO `sys_role_resc` VALUES (1, 3);
INSERT INTO `sys_role_resc` VALUES (1, 4);
INSERT INTO `sys_role_resc` VALUES (1, 7);
INSERT INTO `sys_role_resc` VALUES (1, 8);
INSERT INTO `sys_role_resc` VALUES (1, 201704071);
INSERT INTO `sys_role_resc` VALUES (1, 2016093009);
INSERT INTO `sys_role_resc` VALUES (1, 2018101010);
INSERT INTO `sys_role_resc` VALUES (1, 2018101011);
INSERT INTO `sys_role_resc` VALUES (1, 2018101012);
INSERT INTO `sys_role_resc` VALUES (1, 2018101013);
INSERT INTO `sys_role_resc` VALUES (1, 2018101014);
INSERT INTO `sys_role_resc` VALUES (1, 2019022201);
INSERT INTO `sys_role_resc` VALUES (1, 2019022202);
INSERT INTO `sys_role_resc` VALUES (1, 2019022203);
INSERT INTO `sys_role_resc` VALUES (1, 2019022205);
INSERT INTO `sys_role_resc` VALUES (1, 2019022206);
INSERT INTO `sys_role_resc` VALUES (1, 2019022207);
INSERT INTO `sys_role_resc` VALUES (1, 2019022208);
INSERT INTO `sys_role_resc` VALUES (1, 2019022209);
INSERT INTO `sys_role_resc` VALUES (1, 2019022210);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(16) NOT NULL COMMENT '登录用户名',
  `REAL_NAME` varchar(32) DEFAULT NULL COMMENT '操作员姓名',
  `PASSWORD` varchar(128) NOT NULL COMMENT '登录密码',
  `SALT` varchar(32) DEFAULT NULL COMMENT '密码加密填充值',
  `USER_TYPE` int(11) NOT NULL COMMENT '用户类型 {1:管理员,2:操作员}',
  `EMAIL` varchar(64) DEFAULT NULL COMMENT '电子邮件',
  `MOBILE_NO` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `ORG_ID` int(11) DEFAULT NULL COMMENT '组织ID',
  `ORG_NAME` varchar(128) DEFAULT NULL COMMENT '组织名称(冗余)',
  `LAST_MODIFY_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  `EXPIRATION_TIME` datetime DEFAULT NULL COMMENT '密码过期时间',
  `UNLOCK_TIME` datetime DEFAULT NULL COMMENT '解锁时间',
  `LOGIN_STATUS` int(11) DEFAULT NULL COMMENT '是否登陆{1:未登陆,2:已登陆}',
  `LOGIN_FAIL_TIMES` int(11) DEFAULT NULL COMMENT '登录失败次数',
  `LOGIN_TIME` datetime DEFAULT NULL COMMENT '登陆时间',
  `STATUS` int(11) NOT NULL COMMENT '状态 {1:有效,2:过期,3:锁定,4:禁用}',
  `DESCN` varchar(256) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `USERNAME` (`USERNAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='操作员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '超级管理员', 'ab7cc1898fe24ef738595e56759b17893f2dbcc6', 'f10a5bda42097431', 1, 'zp820705@163.com', '13896177630', 1, 'acooly', '2019-12-09 15:38:21', NULL, NULL, 1, 1, NULL, 1, '', '2014-01-07 00:00:00', '2019-12-09 15:38:21');
INSERT INTO `sys_user` VALUES (2, 'mufanglin', '牟方林', '8c10ddada6f06f40dec3f79a73bff0ce352f73be', '7a6619110c28854d', 1, '280932756@qq.com', '13883317954', 1, 'acooly', '2019-12-11 13:37:41', '2020-03-05 16:52:58', NULL, 0, 0, NULL, 1, 'test', '2019-12-06 16:52:58', '2019-12-11 13:37:41');
INSERT INTO `sys_user` VALUES (3, 'wuchangkui', '吴长奎', 'dcb6bcb6f8737ec0071502cdd89dc041515d1961', 'e0bc216b2d68d4de', 1, '111@qq.com', '', 1, 'acooly', '2019-12-11 14:00:22', '2020-03-05 16:53:55', NULL, 0, 0, NULL, 1, '', '2019-12-06 16:53:55', '2019-12-11 14:00:22');
INSERT INTO `sys_user` VALUES (4, 'zhoudongling', '周冬玲', '1223856a3010dd9558b073cf173ff3c31848ba63', '9d6490f331288407', 1, '1111@gmail.com', '', 1, 'acooly', '2019-12-11 09:09:40', '2020-03-05 16:55:07', NULL, 0, 0, NULL, 1, '', '2019-12-06 16:55:07', '2019-12-11 09:09:40');
INSERT INTO `sys_user` VALUES (5, 'zhoutingting', '周婷婷', 'd37a1134704a0c0b1546f3bf359afd56b6c51505', '62ad59fda338f2ec', 1, '112@gmail.com', '', 1, 'acooly', '2019-12-11 11:16:34', '2020-03-05 16:55:47', NULL, 0, 0, NULL, 1, '', '2019-12-06 16:55:47', '2019-12-11 11:16:34');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ROLE_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`USER_ID`) USING BTREE,
  KEY `FKb40xxfch70f5qnyfw8yme1n1s` (`USER_ID`) USING BTREE,
  CONSTRAINT `FKb40xxfch70f5qnyfw8yme1n1s` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`ID`),
  CONSTRAINT `FKhh52n8vd4ny9ff4x9fb8v65qx` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (1, 3);
INSERT INTO `sys_user_role` VALUES (1, 4);
INSERT INTO `sys_user_role` VALUES (1, 5);
COMMIT;

-- ----------------------------
-- Table structure for test_case
-- ----------------------------
DROP TABLE IF EXISTS `test_case`;
CREATE TABLE `test_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `case_no` varchar(64) NOT NULL COMMENT '用例编号',
  `case_name` varchar(32) NOT NULL COMMENT '用例名称',
  `case_type` varchar(10) NOT NULL COMMENT '用例类别{SUCCESS:成功,FAILONE:参数异常,FAILTWO:业务异常}',
  `url` varchar(128) DEFAULT NULL COMMENT '请求地址',
  `input` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `protocol_type` varchar(10) NOT NULL COMMENT '协议类型{HTTP:HTTP,HTTPS:HTTPS, SOCKET:SOCKET}',
  `call_count` int(11) DEFAULT '0' COMMENT '用例执行次数',
  `call_success_count` int(11) DEFAULT '0' COMMENT '用例执行成功次数',
  `call_fail_count` int(11) DEFAULT '0' COMMENT '用例执行失败次数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `interface_no` varchar(64) NOT NULL,
  `project_no` varchar(64) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `CASENO` (`case_no`) USING BTREE COMMENT '测试用例编码唯一'
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COMMENT='测试用例表\n';

-- ----------------------------
-- Records of test_case
-- ----------------------------
BEGIN;
INSERT INTO `test_case` VALUES (11, 'PayengineDepositFacadeDeductForBindIdDepositSuccess', '代扣充值成功', 'SUCCESS', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-11-27 13:58:24', '2019-12-09 16:47:34', 'PayengineDepositFacade', 'cheyunpay-paycore');
INSERT INTO `test_case` VALUES (12, 'AccountTransferApiServiceTestSuccess', '单笔转账成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-27 15:37:55', '2019-11-27 15:37:55', 'accountTransfer', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (13, 'TradeFacadeQuickPaymentApplyTestSuccess', '快捷支付申请-成功用例', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-11-27 16:31:53', '2019-12-04 13:49:37', 'quickPaymentApply', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (14, 'AccountTransferApiServiceTestFailOne', '单笔转账参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-28 08:44:43', '2019-11-28 09:23:40', 'accountTransfer', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (15, 'AccountTransferApiServiceTestFailTwo', '单笔转账业务异常', 'FAILTWO', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-28 09:06:52', '2019-11-28 09:23:47', 'accountTransfer', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (16, 'BankCardFacadeBindClearCardSuccess', '绑卡渠道清算卡成功', 'SUCCESS', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-11-28 10:38:27', '2019-11-28 10:38:27', 'BankCardFacadeBindClearCard', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (17, 'AliBeiScanPayApiServiceTestSuccess', '支付宝被成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-28 15:15:01', '2019-11-28 15:16:10', 'aliBeiScanPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (18, 'TradeCreateApiServiceTestSuccess', '创建交易成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-28 15:34:17', '2019-11-28 15:34:17', 'tradeCreate', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (19, 'BankCardFacadeBindClearCardFailOne', '绑卡渠道清算参数异常', 'FAILONE', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-11-28 16:24:49', '2019-11-28 16:25:06', 'BankCardFacadeBindClearCard', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (20, 'BankCardFacadeBindClearCardFailTwo', '绑卡渠道清算卡业务异常', 'FAILTWO', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-11-28 16:26:11', '2019-11-28 16:26:11', 'BankCardFacadeBindClearCard', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (21, 'AliLifePayApiServiceTestSuccess', '支付宝服务窗成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-28 17:50:42', '2019-11-28 17:50:42', 'aliLifePay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (23, 'AliZhuScanPayApiServiceTestSuccess', '支付宝主扫成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-29 09:04:09', '2019-11-29 09:04:09', 'aliZhuScanPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (24, 'BalancePayApiServiceTestSuccess', '余额支付成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-29 10:11:25', '2019-11-29 10:11:25', 'balancePay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (25, 'TradeCloseApiServiceTestSuccess', '交易关闭成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-29 10:40:00', '2019-11-29 10:40:00', 'tradeClose', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (26, 'WechatBeiScanPayApiServiceTestSuccess', '微信被扫成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-29 10:55:09', '2019-11-29 10:55:09', 'wechatBeiScanPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (27, 'WechatMiniPayApiServiceTestSuccess', '微信小程序支付成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-29 11:05:53', '2019-11-29 11:05:53', 'wechatMiniPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (28, 'WithdrawApiServiceTestSuccess', '提现成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-11-29 11:25:14', '2019-11-29 11:25:14', 'withdraw', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (30, 'MemberSignFacadeSignApplySuccess', '签约申请接口成功', 'SUCCESS', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-11-29 14:44:08', '2019-12-11 11:19:42', 'MemberSignFacadeSignApply', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (31, 'SignFacadeSignApplyTestSuccess', '申请签约成功', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-11-29 15:26:45', '2019-11-29 15:26:45', 'SignFacade.signApply', 'cheyunpay-gateway');
INSERT INTO `test_case` VALUES (32, 'SignFacadeSignApplyTestFailOne', '申请签约参数异常', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-11-29 16:06:45', '2019-11-29 15:26:45', 'SignFacade.signApply', 'cheyunpay-gateway');
INSERT INTO `test_case` VALUES (33, 'PayengineDepositFacadeDeductForBindIdDepositFailOne', '代扣充值-failOne', 'FAILONE', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-11-29 18:09:27', '2019-12-09 16:47:49', 'PayengineDepositFacade', 'cheyunpay-paycore');
INSERT INTO `test_case` VALUES (34, 'MemberSignFacadeSignApplyFailTwo', '签约申请接口业务异常', 'FAILTWO', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-02 09:17:15', '2019-12-02 09:17:55', 'MemberSignFacadeSignApply', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (36, 'TradeFacadeQuickPaymentApplyTestFailOne', '快捷支付申请-参数验证', 'FAILONE', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-02 11:24:54', '2019-12-02 11:24:54', 'quickPaymentApply', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (37, 'SignFacadeSignTestSuccess', '签约确认成功', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-02 11:59:18', '2019-12-02 11:59:28', 'SignFacade.sign', 'cheyunpay-gateway');
INSERT INTO `test_case` VALUES (39, 'TradeFacadeQuickPaymentConfirmSuccess', '快捷支付确认-成功用例', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-02 14:06:55', '2019-12-04 13:49:59', 'quickPaymentConfirm', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (40, 'MemberSignFacadeSignApplyFailOne', '签约申请接口参数异常', 'FAILONE', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-02 16:17:30', '2019-12-02 16:17:59', 'MemberSignFacadeSignApply', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (41, 'MemberSignFacadeSignConfirmSuccess', '确认签约成功', 'SUCCESS', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-02 17:22:06', '2019-12-02 17:29:35', 'MemberSignFacadeSignConfirm', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (42, 'SignFacadeUnSignTestSuccess', '解约成功', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-02 17:44:18', '2019-12-02 17:44:18', 'SignFacade.unSign', 'cheyunpay-gateway');
INSERT INTO `test_case` VALUES (43, 'WechatPublicPayApiServiceTestSuccess', '公众号支付成功', 'SUCCESS', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-03 09:28:28', '2019-12-03 19:13:08', 'wechatPublicPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (44, 'MemberSignFacadeUnSignSuccess', '解约成功', 'SUCCESS', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-03 10:14:55', '2019-12-03 10:17:27', 'MemberSignFacadeUnSign', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (45, 'PayengineDepositFacadeDeductForBindIdDepositFailTwo', '代扣充值-failTwo', 'FAILTWO', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-03 13:44:58', '2019-12-09 16:47:54', 'PayengineDepositFacade', 'cheyunpay-paycore');
INSERT INTO `test_case` VALUES (46, 'TradeFacadeQuickPaymentConfirmFailTwo', '快捷支付确认-业务异常', 'FAILTWO', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-03 14:15:12', '2019-12-03 19:18:05', 'quickPaymentConfirm', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (47, 'BankCardFacadeEntrustBindCardSuccess', '委托绑卡成功', 'SUCCESS', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-03 15:17:02', '2019-12-03 15:17:51', 'BankCardFacadeEntrustBindCard', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (48, 'QueryAccountBalanceApiServiceTestSuccess', '查询会员的余额信息openapi', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-03 19:09:45', '2019-12-04 15:02:26', 'QueryAccountBalance', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (50, 'MemberQueryBindCardApiServiceTestSuccess', '查询会员的绑卡信息openapi', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 10:06:18', '2019-12-04 15:02:16', 'MemberQueryBindCardApiService', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (51, 'BindClearCardApiServiceTestSuccess', '标准绑卡接口openapi', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 11:02:24', '2019-12-04 15:02:05', 'BankCardFacadeBindClearCard', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (52, 'EntrustBindCardApiServiceTestSuccess', '委托绑卡Openapi', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 14:13:32', '2019-12-04 14:14:15', 'BankCardFacadeEntrustBindCard', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (53, 'AliZhuScanPayApiServiceTestFailOne', '支付宝主扫参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 14:29:15', '2019-12-04 14:31:47', 'aliZhuScanPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (54, 'WechatPublicPayApiServiceTestFailOne', '公众号支付参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 14:35:40', '2019-12-04 14:36:21', 'wechatPublicPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (55, 'AliBeiScanPayApiServiceTestFailOne', '支付宝被扫参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 15:57:30', '2019-12-04 15:58:13', 'aliBeiScanPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (56, 'AliLifePayApiServiceTestFailOne', '支付宝服务窗参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 16:26:31', '2019-12-04 16:27:22', 'aliLifePay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (57, 'SignApplyApiServiceTestSuccess', '签约申请Openapi', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 16:28:29', '2019-12-04 16:29:25', 'MemberSignFacadeSignApply', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (58, 'BalancePayApiServiceTestFailOne', '余额支付参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 16:55:01', '2019-12-04 16:55:46', 'balancePay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (59, 'SignConfirmApiServiceTestSuccess', '确认签约Openapi', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 17:05:20', '2019-12-04 17:05:52', 'MemberSignFacadeSignConfirm', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (60, 'WechatMiniPayApiServiceTestFailOne', '微信小程序支付参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 17:11:33', '2019-12-04 17:12:27', 'wechatMiniPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (61, 'TradeCreateApiServiceTestFailOne', '创建交易参数异常', 'FAILONE', 'http://172.17.100.40:8080/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-04 17:51:57', '2019-12-04 17:52:53', 'tradeCreate', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (62, 'QueryInAccountApiServiceTestSuccess', '查询会员的入金账户信息openapi', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-05 11:00:00', '2019-12-05 11:00:43', 'QueryAccountBalance', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (63, 'QueryAccountAndAuthInfoApiServiceTestSuccess', '查询会员账户信息和会员认证信息', 'SUCCESS', 'http://127.0.0.1:8086/gateway.do', NULL, 'HTTP', 0, 0, 0, '2019-12-05 14:38:15', '2019-12-05 14:39:13', 'QueryAccountBalance', 'cheyunpay-member');
INSERT INTO `test_case` VALUES (64, 'TradeFacadeQuickPaymentConfirmFailOne', '快捷支付申请-参数验证', 'FAILONE', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-09 10:00:09', '2019-12-09 10:00:09', 'quickPaymentConfirm', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (65, 'TradeFacadeWechatAppPayTestSuccess', '微信APP支付-成功用例', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-09 15:43:14', '2019-12-09 15:43:14', 'wechatAppPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (66, 'TradeFacadeWechatAppPayTestFailOne', '微信APP支付-参数异常', 'FAILONE', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-09 15:44:13', '2019-12-09 15:44:13', 'wechatAppPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (67, 'TradeFacadeWechatAppPayTestFailTwo', '微信APP支付-业务异常', 'FAILTWO', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-09 15:44:45', '2019-12-09 15:44:45', 'wechatAppPay', 'cheyunpay-trade');
INSERT INTO `test_case` VALUES (68, 'PayengineDepositFacadeWechatAppDepositTestSuccess', '微信app充值', 'SUCCESS', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-09 16:57:21', '2019-12-09 16:57:21', 'PayengineDepositFacade', 'cheyunpay-paycore');
INSERT INTO `test_case` VALUES (69, 'NetBankPayFacadeAppPayTestSuccess', '微信支付宝APP支付-成功用例', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-09 17:04:14', '2019-12-09 17:06:07', 'NetBankPayFacade.appPay', 'cheyunpay-gateway');
INSERT INTO `test_case` VALUES (70, 'WechatAppPayServiceSuccess', 'OpenApi-微信APP支付', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-10 15:11:46', '2019-12-10 15:11:46', 'wechatAppPays', 'cheyunpay-openapi');
INSERT INTO `test_case` VALUES (72, 'NetBankPayFacadeAppPayTestFailOne', '微信支付宝APP支付-参数异常', 'FAILONE', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-10 16:02:29', '2019-12-10 16:03:18', 'NetBankPayFacade.appPay', 'cheyunpay-gateway');
INSERT INTO `test_case` VALUES (73, 'NetBankPayFacadeAppPayTestFailTwo', '微信支付宝APP支付-业务异常', 'FAILTWO', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-10 16:03:27', '2019-12-10 16:03:50', 'NetBankPayFacade.appPay', 'cheyunpay-gateway');
INSERT INTO `test_case` VALUES (74, 'PayengineDepositFacadeWechatAppDepositTestFailOne', '微信APP充值-failone', 'FAILONE', 'xx', NULL, 'HTTP', 0, 0, 0, '2019-12-11 09:31:59', '2019-12-11 09:31:59', 'PayengineDepositFacade', 'cheyunpay-paycore');
INSERT INTO `test_case` VALUES (75, 'DownChannelFileServiceReadFileTestSuccess', '解析对账文件-成功用例', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-11 13:51:39', '2019-12-11 13:51:39', 'readFile', 'cheyunpay-bill');
INSERT INTO `test_case` VALUES (76, 'DownChannelFileServiceDownChannelFileSuccess', '下载文件-成功用例', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-11 14:07:39', '2019-12-11 14:07:39', 'downChannelFile', 'cheyunpay-bill');
INSERT INTO `test_case` VALUES (77, 'DownChannelFileServiceDealwithChannelFileSuccess', '处理文件--成功', 'SUCCESS', 'test', NULL, 'HTTP', 0, 0, 0, '2019-12-11 14:08:41', '2019-12-11 14:08:41', 'dealwithChannelFile', 'cheyunpay-bill');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
