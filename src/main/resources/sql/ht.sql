/*
MySQL Data Transfer
Source Host: localhost
Source Database: ht
Target Host: localhost
Target Database: ht
Date: 2017/3/24 20:59:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for dept_p
-- ----------------------------
CREATE TABLE `dept_p` (
  `DEPT_ID` varchar(40) NOT NULL,
  `PARENT_ID` varchar(40) DEFAULT NULL COMMENT '自关联，多对一',
  `DEPT_NAME` varchar(50) DEFAULT NULL,
  `STATE` int(11) DEFAULT NULL COMMENT '1启用0停用',
  `CREATE_BY` varchar(40) DEFAULT NULL,
  `CREATE_DEPT` varchar(40) DEFAULT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(40) DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for module_p
-- ----------------------------
CREATE TABLE `module_p` (
  `MODULE_ID` varchar(40) NOT NULL,
  `PARENT_ID` varchar(40) DEFAULT NULL COMMENT '父模块ID',
  `NAME` varchar(100) DEFAULT NULL,
  `CTYPE` int(11) DEFAULT NULL COMMENT '1主菜单/2左侧菜单/3按钮',
  `STATE` int(11) DEFAULT NULL COMMENT '1启用0停用',
  `ORDER_NO` int(11) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `CREATE_BY` varchar(40) DEFAULT NULL,
  `CREATE_DEPT` varchar(40) DEFAULT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(40) DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_module_p
-- ----------------------------
CREATE TABLE `role_module_p` (
  `MODULE_ID` varchar(40) DEFAULT NULL,
  `ROLE_ID` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_p
-- ----------------------------
CREATE TABLE `role_p` (
  `ROLE_ID` varchar(40) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `REMARKS` varchar(100) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(40) DEFAULT NULL,
  `CREATE_DEPT` varchar(40) DEFAULT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(40) DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_user_p
-- ----------------------------
CREATE TABLE `role_user_p` (
  `ROLE_ID` varchar(40) DEFAULT NULL,
  `USER_ID` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info_p
-- ----------------------------
CREATE TABLE `user_info_p` (
  `USER_INFO_ID` varchar(40) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `CARD_NO` varchar(20) DEFAULT NULL,
  `MANAGER_ID` varchar(40) DEFAULT NULL,
  `JOIN_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SALARY` decimal(8,2) DEFAULT NULL,
  `BIRTHDAY` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `GENDER` varchar(40) DEFAULT NULL,
  `STATION` varchar(20) DEFAULT NULL,
  `TELEPHONE` varchar(100) DEFAULT NULL,
  `USER_LEVEL` char(1) DEFAULT NULL COMMENT '4-普通用户 3-部门经理 2-副总 1-总经理 0-超级管理员',
  `REMARK` varchar(600) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(40) DEFAULT NULL COMMENT '登录人编号',
  `CREATE_DEPT` varchar(40) DEFAULT NULL COMMENT '登录人所属部门编号',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDATE_BY` varchar(40) DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`USER_INFO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_p
-- ----------------------------
CREATE TABLE `user_p` (
  `USER_ID` varchar(40) NOT NULL,
  `DEPT_ID` varchar(40) DEFAULT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(40) DEFAULT NULL,
  `STATE` int(11) DEFAULT NULL COMMENT '1启用0停用',
  `CREATE_BY` varchar(40) DEFAULT NULL,
  `CREATE_DEPT` varchar(40) DEFAULT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(40) DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `dept_p` VALUES ('100', '', '集团总部', '1', null, null, '2017-03-24 20:27:28', null, '0000-00-00 00:00:00');
INSERT INTO `dept_p` VALUES ('100100', '100', '研发部', '1', null, null, '2017-03-24 20:27:25', null, '0000-00-00 00:00:00');
INSERT INTO `dept_p` VALUES ('100200', '100', '财务部', '1', null, null, '2017-03-24 20:31:01', null, '0000-00-00 00:00:00');
INSERT INTO `dept_p` VALUES ('100300', '100', '仓储部', '1', null, null, '2017-03-24 20:33:42', null, '0000-00-00 00:00:00');
INSERT INTO `dept_p` VALUES ('100400', '100', '销售部', '1', null, null, '2017-03-24 20:34:01', null, '0000-00-00 00:00:00');
INSERT INTO `dept_p` VALUES ('100500', '100', '采购部', '1', null, null, '2017-03-24 20:34:16', null, '0000-00-00 00:00:00');
INSERT INTO `module_p` VALUES ('143e95ad-a256-4e89-9632-84510834c6a2', '', '基础信息', '1', '1', '2', '基本信息的维护', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:46:54');
INSERT INTO `module_p` VALUES ('3b400561-471e-4490-8ab3-4f7393da3c38', 'a10cdf8a-8756-4157-8635-419534193cd0', '部门--修改', '3', '1', '9', '部门的修改', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:50:32');
INSERT INTO `module_p` VALUES ('4da326ea-849c-4e36-976b-96695610d1bb', '', '系统管理', '1', '1', '3', '系统管理的维护工作', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:47:13');
INSERT INTO `module_p` VALUES ('51f100f6-04e6-4945-8d8a-938ec0da8ee3', '4da326ea-849c-4e36-976b-96695610d1bb', '角色管理', '2', '1', '6', '角色模块的管理', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:49:17');
INSERT INTO `module_p` VALUES ('5cdab323-6fc1-479c-a293-a8b7428e242b', '4da326ea-849c-4e36-976b-96695610d1bb', '模块管理', '2', '1', '7', '负责模块的正常维护', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:49:42');
INSERT INTO `module_p` VALUES ('a10cdf8a-8756-4157-8635-419534193cd0', '4da326ea-849c-4e36-976b-96695610d1bb', '部门管理', '2', '1', '4', '部门的管理', null, null, '2017-03-24 20:48:02', null, '2017-03-24 20:48:02');
INSERT INTO `module_p` VALUES ('b2e715b9-dd3a-436e-9b98-86662f6a68e3', '', '货运管理', '1', '1', '1', '负责货物的运送', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:46:28');
INSERT INTO `module_p` VALUES ('da603afb-0fc2-4bce-b066-87cc6885e120', '4da326ea-849c-4e36-976b-96695610d1bb', '用户管理', '1', '1', '5', '负责用户的管理', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:48:40');
INSERT INTO `module_p` VALUES ('e6314888-8186-4bc2-a00d-1705447dec7b', 'a10cdf8a-8756-4157-8635-419534193cd0', '部门--新增', '3', '1', '8', '部门的新增按钮', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:50:07');
INSERT INTO `role_module_p` VALUES ('b2e715b9-dd3a-436e-9b98-86662f6a68e3', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('143e95ad-a256-4e89-9632-84510834c6a2', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('4da326ea-849c-4e36-976b-96695610d1bb', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('a10cdf8a-8756-4157-8635-419534193cd0', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('e6314888-8186-4bc2-a00d-1705447dec7b', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('3b400561-471e-4490-8ab3-4f7393da3c38', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('da603afb-0fc2-4bce-b066-87cc6885e120', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('51f100f6-04e6-4945-8d8a-938ec0da8ee3', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_module_p` VALUES ('5cdab323-6fc1-479c-a293-a8b7428e242b', 'e5fe6075-0e81-464f-beae-8f5458ad2968');
INSERT INTO `role_p` VALUES ('1ad04d83-2d19-4c47-bafb-59cc5797c63a', '仓储管理', '负责货物的管理和货物的发送', '2', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:43:11');
INSERT INTO `role_p` VALUES ('5127a60d-8c1b-4bda-b8b9-06096533a400', '货运管理', '负责货物的管理和销售工作', '1', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:42:34');
INSERT INTO `role_p` VALUES ('5f5fc576-d5c4-4805-b5aa-f6614c55cd35', '船运专责', '负责联系船运', '4', null, null, '2017-03-24 20:45:47', null, '2017-03-24 20:45:47');
INSERT INTO `role_p` VALUES ('e5fe6075-0e81-464f-beae-8f5458ad2968', '系统管理员', '负责系统的正常维护工作', '3', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:44:29');
INSERT INTO `role_user_p` VALUES ('e5fe6075-0e81-464f-beae-8f5458ad2968', 'f8002c8b-8a87-40bc-b563-bcb9cc6e101c');
INSERT INTO `user_info_p` VALUES ('70e263e4-6bcb-4e32-96a5-525c9e1faba9', '小影', '100200444555', 'f8002c8b-8a87-40bc-b563-bcb9cc6e101c', '2017-03-05 00:00:00', '6000.00', '2017-01-09 00:00:00', '男', '', '1231121321', '4', '普通员工', '2', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:41:53');
INSERT INTO `user_info_p` VALUES ('f8002c8b-8a87-40bc-b563-bcb9cc6e101c', '诺克萨斯之手', '100200300400', '', '2017-03-24 20:56:36', '50000.00', '2017-03-24 00:00:00', '男', '管理员', '13345661455', '4', '超级管理员', '1', null, null, '2017-03-24 00:00:00', null, '2017-03-24 20:39:59');
INSERT INTO `user_p` VALUES ('70e263e4-6bcb-4e32-96a5-525c9e1faba9', '100', 'root', '7410adb249055d9b0b2c048379055849', '1', null, null, '2017-03-24 20:42:07', null, '2017-03-24 20:41:53');
INSERT INTO `user_p` VALUES ('f8002c8b-8a87-40bc-b563-bcb9cc6e101c', '100', 'admin', '3fed7a346e430ea4c2aa10250928f4de', '1', null, null, '2017-03-24 20:42:07', null, '2017-03-24 20:39:59');
