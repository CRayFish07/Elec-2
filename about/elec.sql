/*
MySQL Data Transfer
Source Host: localhost
Source Database: elec
Target Host: localhost
Target Database: elec
Date: 2016/4/20 21:00:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for elec_commonmsg
-- ----------------------------
DROP TABLE IF EXISTS `elec_commonmsg`;
CREATE TABLE `elec_commonmsg` (
  `ComId` varchar(50) NOT NULL,
  `StationRun` varchar(1000) DEFAULT NULL,
  `DevRun` varchar(1000) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ComId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for elec_systemddl
-- ----------------------------
DROP TABLE IF EXISTS `elec_systemddl`;
CREATE TABLE `elec_systemddl` (
  `seqId` int(11) NOT NULL COMMENT '����id',
  `keyword` varchar(20) NOT NULL COMMENT '���͹ؼ���',
  `ddlCode` int(11) NOT NULL COMMENT '����code',
  `ddlname` varchar(30) NOT NULL COMMENT '������',
  PRIMARY KEY (`seqId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for elec_text
-- ----------------------------
DROP TABLE IF EXISTS `elec_text`;
CREATE TABLE `elec_text` (
  `elecid` varchar(32) NOT NULL DEFAULT '',
  `elecname` varchar(30) NOT NULL,
  `electime` datetime DEFAULT NULL,
  `elecremark` varchar(200) DEFAULT NULL,
  `textid` varchar(50) DEFAULT NULL,
  `textname` varchar(50) DEFAULT NULL,
  `textdate` datetime DEFAULT NULL,
  `textremark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`elecid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for elec_user
-- ----------------------------
DROP TABLE IF EXISTS elec_user;
CREATE TABLE `elec_user` (
  `UserId` int NOT NULL auto_increment,
  `JctId` varchar(50) NOT NULL COMMENT '������λcode',
  `UserName` varchar(50) NOT NULL COMMENT '�û�����',
  `LogonName` varchar(50) NOT NULL COMMENT '��¼��',
  `LogonPassword` varchar(50) NOT NULL COMMENT '��¼����',
  `SexId` varchar(10) NOT NULL COMMENT '�Ա�',
  `BirthDay` datetime DEFAULT NULL COMMENT '����',
  `Address` varchar(100) DEFAULT NULL COMMENT '��ַ',
  `ContactTel` varchar(50) DEFAULT NULL COMMENT '��ϵ�绰',
  `Email` varchar(50) DEFAULT NULL COMMENT '����',
  `Mobile` varchar(50) DEFAULT NULL COMMENT '�ֻ���',
  `IsDuty` varchar(10) DEFAULT NULL COMMENT '�Ƿ���ְ',
  `OnDutyDate` datetime DEFAULT NULL COMMENT '��ְʱ��',
  `OffDutyDate` datetime DEFAULT NULL COMMENT '��ְʱ��',
  `remark` varchar(500) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists Elec_User_Role;
create table Elec_User_Role (
	seqId int not null primary key auto_increment,
	userId int not null,
	roleId int not null,
	remark varchar(500) null
);

drop table if exists Elec_Role_Popedom;
create table Elec_Role_Popedom (
	roleId int not null primary key auto_increment,
	popedomCode varchar(50) null,
	remark varchar(500)
);
	
	
-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `elec_commonmsg` VALUES ('1', '还好正常', '貌似不正常', '2016-03-06 13:47:51');
INSERT INTO `elec_commonmsg` VALUES ('2', 'fdsgdfs', 'gfh', '2016-03-26 11:15:57');

INSERT INTO `elec_systemddl` VALUES ('1', '所属单位', '1', '重庆');
INSERT INTO `elec_systemddl` VALUES ('2', '所属单位', '2', '上海');
INSERT INTO `elec_systemddl` VALUES ('3', '性别', '1', '女');
INSERT INTO `elec_systemddl` VALUES ('4', '性别', '2', '男');
INSERT INTO `elec_systemddl` VALUES ('5', '是否在职', '1', '在职');
INSERT INTO `elec_systemddl` VALUES ('6', '是否在职', '2', '离职');
INSERT INTO `elec_systemddl` VALUES ('7', '所属单位', '3', '北京');

insert elec_systemddl values( 8,'角色类型',1,'系统管理员');
insert elec_systemddl values( 9,'角色类型',2,'高级管理员');
insert elec_systemddl values( 10,'角色类型',3,'中级管理员');
insert elec_systemddl values( 11,'角色类型',4,'业务用户' );
insert elec_systemddl values( 12,'角色类型',5,'一般用户' );
insert elec_systemddl values( 13,'角色类型',6,'普通用户' );

INSERT INTO `elec_text` VALUES ('40288ac8527775a201527775af8a0001', 'yzx', '2016-01-25 14:25:46', '测试mark', null, null, null, null);
INSERT INTO `elec_user` VALUES ('1', '1', '张三', 'zhangsan', '123456', '1', null, null, '155556666', null, null, '1', '2016-04-20 13:44:42', null, null);
INSERT INTO `elec_user` VALUES ('2', '2', '李四', 'lisi', '1234567', '2', null, null, '125478965', null, null, '1', '2016-04-21 13:45:39', null, null);

select case roleId 
 when '1' then '1' else '0' end as flag,
 elec_user.UserId,
 elec_user.UserName,
 elec_user.LogonName
 from elec_user_role
 right join elec_user
 on elec_user_role.userId = elec_user.UserId
