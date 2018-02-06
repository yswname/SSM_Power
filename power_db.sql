
CREATE SEQUENCE seq_demo;

create table DM_USER
(
  UR_ID        INTEGER not null,
  UR_USER_NAME VARCHAR2(20) not null,
  UR_PASSWORD  VARCHAR2(200),
  UR_AGE       INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_USER
  add primary key (UR_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_USER
  add unique (UR_USER_NAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating DM_ID_CARD...
create table DM_ID_CARD
(
  IC_ID      NUMBER(10) not null,
  IC_CODE    VARCHAR2(18 CHAR) not null,
  IC_NAME    VARCHAR2(100 CHAR) not null,
  IC_ADDRESS VARCHAR2(200 CHAR) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ID_CARD
  add primary key (IC_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ID_CARD
  add unique (IC_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ID_CARD
  add constraint FK7CDF39FEE7ACD9A8 foreign key (IC_ID)
  references DM_USER (UR_ID);

prompt Creating DM_LOCK...
create table DM_LOCK
(
  LC_ID      INTEGER not null,
  LC_NAME    VARCHAR2(20),
  LC_VERSION NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_LOCK
  add primary key (LC_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating DM_MODUL...
create table DM_MODUL
(
  MD_ID     INTEGER not null,
  MD_NAME   VARCHAR2(50) not null,
  MD_REMARK VARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_MODUL
  add primary key (MD_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_MODUL
  add unique (MD_NAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating DM_ORDER...
create table DM_ORDER
(
  OD_ID    NUMBER(10) not null,
  OD_CODE  VARCHAR2(20 CHAR) not null,
  OD_UR_ID NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ORDER
  add primary key (OD_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ORDER
  add unique (OD_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ORDER
  add constraint FKC26AAC183F0AC25B foreign key (OD_UR_ID)
  references DM_USER (UR_ID);

prompt Creating DM_POWER_ITEM...
create table DM_POWER_ITEM
(
  PI_ID     INTEGER not null,
  PI_NAME   VARCHAR2(50) not null,
  PI_URL    VARCHAR2(300) not null,
  PI_REMARK VARCHAR2(500),
  PI_MD_ID  INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_POWER_ITEM
  add primary key (PI_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_POWER_ITEM
  add constraint FK_PI_MD_ID foreign key (PI_MD_ID)
  references DM_MODUL (MD_ID);

prompt Creating DM_ROLE...
create table DM_ROLE
(
  RL_ID     NUMBER(10) not null,
  RL_NAME   VARCHAR2(50 CHAR) not null,
  RL_REMARK VARCHAR2(500 CHAR)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ROLE
  add primary key (RL_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DM_ROLE
  add unique (RL_NAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating MAP_UR_RL...
create table MAP_UR_RL
(
  MP_UR_ID NUMBER(10) not null,
  MP_RL_ID NUMBER(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MAP_UR_RL
  add primary key (MP_UR_ID, MP_RL_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MAP_UR_RL
  add constraint FK4AF19679E9E4C397 foreign key (MP_RL_ID)
  references DM_ROLE (RL_ID);
alter table MAP_UR_RL
  add constraint FK4AF19679EA132FA9 foreign key (MP_UR_ID)
  references DM_USER (UR_ID);

prompt Disabling triggers for DM_USER...
alter table DM_USER disable all triggers;
prompt Disabling triggers for DM_ID_CARD...
alter table DM_ID_CARD disable all triggers;
prompt Disabling triggers for DM_LOCK...
alter table DM_LOCK disable all triggers;
prompt Disabling triggers for DM_MODUL...
alter table DM_MODUL disable all triggers;
prompt Disabling triggers for DM_ORDER...
alter table DM_ORDER disable all triggers;
prompt Disabling triggers for DM_POWER_ITEM...
alter table DM_POWER_ITEM disable all triggers;
prompt Disabling triggers for DM_ROLE...
alter table DM_ROLE disable all triggers;
prompt Disabling triggers for MAP_UR_RL...
alter table MAP_UR_RL disable all triggers;
prompt Disabling foreign key constraints for DM_ID_CARD...
alter table DM_ID_CARD disable constraint FK7CDF39FEE7ACD9A8;
prompt Disabling foreign key constraints for DM_ORDER...
alter table DM_ORDER disable constraint FKC26AAC183F0AC25B;
prompt Disabling foreign key constraints for DM_POWER_ITEM...
alter table DM_POWER_ITEM disable constraint FK_PI_MD_ID;
prompt Disabling foreign key constraints for MAP_UR_RL...
alter table MAP_UR_RL disable constraint FK4AF19679E9E4C397;
alter table MAP_UR_RL disable constraint FK4AF19679EA132FA9;
prompt Deleting MAP_UR_RL...
delete from MAP_UR_RL;
commit;
prompt Deleting DM_ROLE...
delete from DM_ROLE;
commit;
prompt Deleting DM_POWER_ITEM...
delete from DM_POWER_ITEM;
commit;
prompt Deleting DM_ORDER...
delete from DM_ORDER;
commit;
prompt Deleting DM_MODUL...
delete from DM_MODUL;
commit;
prompt Deleting DM_LOCK...
delete from DM_LOCK;
commit;
prompt Deleting DM_ID_CARD...
delete from DM_ID_CARD;
commit;
prompt Deleting DM_USER...
delete from DM_USER;
commit;
prompt Loading DM_USER...
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (1, 'zhangsan', '888888', 20);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (4, 'lisi', '111111', 20);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (47, 'w1', 'w1', 1);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (48, 'w3', 'w3', 3);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (6, 'testUser2', 'abc', 22);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (7, 'testUser3', 'abc3', 22);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (10, 'testUser4', 'abc3', 22);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (61, 'MyUser', '1234', 11);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (62, 'MyUser2', '444444', 12);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (63, 'myBatis1', '1111', 22);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (64, 'uuuu', 'ssss', 11);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (22, 'userName2', '222222', 12);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (24, 'userName1', '111111', 11);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (3, 'zhangsan1', 'asfdsa', 30);
insert into DM_USER (UR_ID, UR_USER_NAME, UR_PASSWORD, UR_AGE)
values (5, 'testUser1', 'abc', 22);
commit;
prompt 15 records loaded
prompt Loading DM_ID_CARD...
insert into DM_ID_CARD (IC_ID, IC_CODE, IC_NAME, IC_ADDRESS)
values (6, '111111112', '张三2', '长沙');
insert into DM_ID_CARD (IC_ID, IC_CODE, IC_NAME, IC_ADDRESS)
values (5, '111111111', '张三', '长沙');
commit;
prompt 2 records loaded
prompt Loading DM_LOCK...
insert into DM_LOCK (LC_ID, LC_NAME, LC_VERSION)
values (1050, 'aaaaa', 30);
insert into DM_LOCK (LC_ID, LC_NAME, LC_VERSION)
values (1, 'abc', null);
insert into DM_LOCK (LC_ID, LC_NAME, LC_VERSION)
values (3, 'test', 1);
commit;
prompt 3 records loaded
prompt Loading DM_MODUL...
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (13, '用户模块', null);
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (14, '权限模块', null);
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (15, '订单模块', null);
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (16, '商品模块', null);
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (42, '********', '!!!!!!!!');
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (43, '********2', '!!!!!!!!2');
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (44, '********3', '!!!!!!!!3');
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (45, '********4', '!!!!!!!!4');
insert into DM_MODUL (MD_ID, MD_NAME, MD_REMARK)
values (46, 'mm111', 'm1111');
commit;
prompt 9 records loaded
prompt Loading DM_ORDER...
insert into DM_ORDER (OD_ID, OD_CODE, OD_UR_ID)
values (8, 'od2', 7);
insert into DM_ORDER (OD_ID, OD_CODE, OD_UR_ID)
values (9, 'od1', 7);
insert into DM_ORDER (OD_ID, OD_CODE, OD_UR_ID)
values (11, '1od2', 10);
insert into DM_ORDER (OD_ID, OD_CODE, OD_UR_ID)
values (12, '1od1', 10);
commit;
prompt 4 records loaded
prompt Loading DM_POWER_ITEM...
insert into DM_POWER_ITEM (PI_ID, PI_NAME, PI_URL, PI_REMARK, PI_MD_ID)
values (42, '添加商品', 'shopAction!add.action', 'test', 16);
insert into DM_POWER_ITEM (PI_ID, PI_NAME, PI_URL, PI_REMARK, PI_MD_ID)
values (18, 'demo2sss', 'demo2urlsss', 'sss', 13);
insert into DM_POWER_ITEM (PI_ID, PI_NAME, PI_URL, PI_REMARK, PI_MD_ID)
values (19, 'demo3111', 'demo1ur311', '1111', 14);
insert into DM_POWER_ITEM (PI_ID, PI_NAME, PI_URL, PI_REMARK, PI_MD_ID)
values (44, '查询权限项', 'powerItemAction!search.action', '查询权限项', 14);
insert into DM_POWER_ITEM (PI_ID, PI_NAME, PI_URL, PI_REMARK, PI_MD_ID)
values (20, 'addUser', 'userAction!addUser.ation', 'demo', 13);
insert into DM_POWER_ITEM (PI_ID, PI_NAME, PI_URL, PI_REMARK, PI_MD_ID)
values (62, '111123213', '222234', '3333ew', 13);
insert into DM_POWER_ITEM (PI_ID, PI_NAME, PI_URL, PI_REMARK, PI_MD_ID)
values (67, '33332', '3332', '3332', 14);
commit;
prompt 7 records loaded
prompt Loading DM_ROLE...
insert into DM_ROLE (RL_ID, RL_NAME, RL_REMARK)
values (21, 'role1', null);
insert into DM_ROLE (RL_ID, RL_NAME, RL_REMARK)
values (23, 'role2', null);
commit;
prompt 2 records loaded
prompt Loading MAP_UR_RL...
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (1, 23);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (3, 21);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (3, 23);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (4, 21);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (4, 23);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (6, 21);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (22, 21);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (22, 23);
insert into MAP_UR_RL (MP_UR_ID, MP_RL_ID)
values (24, 21);
commit;
prompt 9 records loaded
prompt Enabling foreign key constraints for DM_ID_CARD...
alter table DM_ID_CARD enable constraint FK7CDF39FEE7ACD9A8;
prompt Enabling foreign key constraints for DM_ORDER...
alter table DM_ORDER enable constraint FKC26AAC183F0AC25B;
prompt Enabling foreign key constraints for DM_POWER_ITEM...
alter table DM_POWER_ITEM enable constraint FK_PI_MD_ID;
prompt Enabling foreign key constraints for MAP_UR_RL...
alter table MAP_UR_RL enable constraint FK4AF19679E9E4C397;
alter table MAP_UR_RL enable constraint FK4AF19679EA132FA9;
prompt Enabling triggers for DM_USER...
alter table DM_USER enable all triggers;
prompt Enabling triggers for DM_ID_CARD...
alter table DM_ID_CARD enable all triggers;
prompt Enabling triggers for DM_LOCK...
alter table DM_LOCK enable all triggers;
prompt Enabling triggers for DM_MODUL...
alter table DM_MODUL enable all triggers;
prompt Enabling triggers for DM_ORDER...
alter table DM_ORDER enable all triggers;
prompt Enabling triggers for DM_POWER_ITEM...
alter table DM_POWER_ITEM enable all triggers;
prompt Enabling triggers for DM_ROLE...
alter table DM_ROLE enable all triggers;
prompt Enabling triggers for MAP_UR_RL...
alter table MAP_UR_RL enable all triggers;

--添加角色同权限项的关系表
CREATE TABLE map_rl_pi(
   mp_rl_id INTEGER NOT NULL,
   mp_pi_id INTEGER NOT NULL,
   
   CONSTRAINT pk_rl_pi PRIMARY KEY (mp_rl_id,mp_pi_id),
   CONSTRAINT fk_mp_rl_id FOREIGN KEY (mp_rl_id) REFERENCES dm_role (rl_id),
   CONSTRAINT fk_mp_pi_id FOREIGN KEY (mp_pi_id) REFERENCES dm_power_item (pi_id)
);
prompt Done.


---参考脚本------------
select * from dm_user
commit;
update dm_user set ur_password='$shiro1$SHA-512$1$$vSYhYNYP/H6x3kVXWYQXXv8AMBwu5Lfq+H58EfzRajmG17hWy8aAmcSL/oMTv0L7czQcj2VCmkally9xPLRpsA==' where ur_user_name='lisi';
update dm_user set ur_password='$shiro1$SHA-512$1$$xwtd2ev7b1HQnUEytxcMnSB1CnhS8AaA9lZY8DEOgQBW5nY8NMmgCw6UAHb1RJXBafwjAszrMSA5JxxDRpUH3A==' where ur_id=48;

select rl.rl_name from dm_role rl, dm_user ur, map_ur_rl mp where ur.ur_user_name=? and ur.ur_id=mp.mp_ur_id and rl.rl_id=mp.mp_rl_id;
select pi.pi_url from dm_power_item pi, dm_role rl, map_rl_pi mp where rl.rl_name='role2' and rl.rl_id=mp.mp_rl_id and pi.pi_id=mp.mp_pi_id;

select * from map_rl_pi;
select * from map_ur_rl;
select * from dm_role;

insert into dm_role values(seq_demo.nextval, 'userManager',null);-- 81 47
insert into dm_role values(seq_demo.nextval, 'admin',null); --82  1
insert into map_ur_rl values(47,81);
insert into map_ur_rl values(1,82);

select * from dm_modul;--13
select * from dm_power_item;
insert into dm_power_item values(seq_demo.nextval,'添加用户','/user/createUserServlet', null,13);--83
insert into dm_power_item values(seq_demo.nextval,'修改用户','/user/updateUserServlet', null,13);--84
insert into dm_power_item values(seq_demo.nextval,'删除用户','/user/deleteUserServlet', null,13);--85
insert into dm_power_item values(seq_demo.nextval,'查询用户','/user/queryUserServlet', null,13);--86
insert into dm_power_item values(seq_demo.nextval,'超级操作','/admin/adminServlet', null,13);--87
select * from map_rl_pi;
insert into map_rl_pi values(82,83);
insert into map_rl_pi values(82,84);
insert into map_rl_pi values(82,85);
insert into map_rl_pi values(82,86);
insert into map_rl_pi values(82,87);

insert into map_rl_pi values(81,83);
insert into map_rl_pi values(81,84);
insert into map_rl_pi values(81,85);
insert into map_rl_pi values(81,86);

commit;

select rl.rl_name from dm_role rl, dm_user ur, map_ur_rl mp where ur.ur_user_name='zhangsan' and ur.ur_id=mp.mp_ur_id and rl.rl_id=mp.mp_rl_id