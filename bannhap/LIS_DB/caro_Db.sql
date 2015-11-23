create table user_tbl(
  u_id number not null,
  u_name VARCHAR2(30) not null,
  u_email varchar2(30) not null,
  u_pass varchar2(30) not null,
  u_ip varchar2(10),
  u_status varchar2(10)
);

alter table user_tbl modify u_status varchar2(10);
alter table user_tbl add constraint pk_user primary key (u_id)
--drop table history_tbl;
--history
create table history_tbl(
  h_user_id number not null,
  h_player_id number,
  h_time date,
  h_results varchar2(20)
);

alter table history_tbl add constraint fr_his foreign key (h_user_id) references user_tbl(u_id)
--alter table playCurrent_tbl drop constraint fr_pla

--friend
create table friend_tbl(
  f_user_id number,
  f_player_id number,
  f_desc varchar2(100)
);
alter table friend_tbl add constraint fr_fri foreign key (f_user_id) references user_tbl(u_id)

--chatting
create table chatting_tbl(
  c_id number,
  c_time date,
  c_desc VARCHAR2(500)
);
alter table chatting_tbl add constraint pk_cha primary key (c_id)
alter table chatting_tbl add constraint pk_cha primary key (c_id)

--play current/room_tbl -- trang thai phong status = true het trong
create table room_tbl(
  r_id number,
  r_user_id number not null,
  r_player_id number,
  r_status varchar2(10),
  r_port number,
  r_inet varchar2(50) not null
);
--alter table playCurrent_tbl  rename to room_tbl
--alter table room_tbl rename column p_time to r_time
--alter table room_tbl drop column r_time
--alter table room_tbl add r_status varchar2(10)
alter table room_tbl add constraint pk_pla primary key (p_id)
alter table room_tbl add constraint fr_pla foreign key (p_user_id) references user_tbl(u_id)
alter table room_tbl add constraint fr_pla foreign key (p_user_id) references chatting_tbl(c_id)

--move
create table move_tbl(
  m_playCurrent_id number,
  m_player_id number,
  m_x number,
  m_y number
)
alter table move_tbl add constraint fr_mov foreign key (m_playCurrent_id) references playCurrent_tbl(p_id)

create sequence user_id
increment by 1
start with 10
nocache
nocycle

--drop sequence user_id

desc user_tbl
--mang tinh minh hoa
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro','pdkpro@gmail.com','pdkpro');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro1','pdkpro1@gmail.com','pdkpro1');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro2','pdkpro2@gmail.com','pdkpro2');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro3','pdkpro3@gmail.com','pdkpro3');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro4','pdkpro4@gmail.com','pdkpro4');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro5','pdkpro5@gmail.com','pdkpro5');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro6','pdkpro6@gmail.com','pdkpro6');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro7','pdkpro7@gmail.com','pdkpro7');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro8','pdkpro8@gmail.com','pdkpro8');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro9','pdkpro9@gmail.com','pdkpro9');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro10','pdkpro10@gmail.com','pdkpro10');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro11','pdkpro11@gmail.com','pdkpro11');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro12','pdkpro12@gmail.com','pdkpro12');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro13','pdkpro13@gmail.com','pdkpro13');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro14','pdkpro14@gmail.com','pdkpro14');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(user_id.nextval,'pdkpro15','pdkpro15@gmail.com','pdkpro15');
insert into user_tbl (U_ID,U_NAME,U_EMAIL,U_PASS) values(5,'pdkpro4','pdkpro4@gmail.com','pdkpro4');
--delete from  user_tbl where u_id = 1

--select * from user_tbl where U_NAME = 'pdkpro' or U_EMAIL = 'pdkpro2@gmail.com' or U_PASS = 'pdkpro3';
delete user_tbl
desc USER_TBL
select * from user_tbl
delete from user_tbl where u_id = 161
select * from(select u_id from user_tbl order by u_id desc) where rownum < 2
select * from user_tbl where U_NAME = 'pdkpro' and u_pass= 'pdkpro' or U_EMAIL = 'pdkpro@gmail.com' and u_pass='pdkpro'

update user_tbl set u_ip = '/127.0.0.1', u_status = 'online' where u_id = 30

select u_status,u_name from user_tbl

--playCurrent_tbl
create sequence room_id
increment by 1
start with 1
nocache
nocycle

desc room_tbl
select * from room_tbl

alter table room_tbl drop  column port 
alter table room_tbl add r_inet varchar2(50) not null

update  room_tbl set r_status = 'trong' where r_status = 'true'

delete room_tbl
drop sequence room_tbl

insert into room_tbl (r_id,r_user_id,r_status) values(room_id.nextval,10,'false');
insert into room_tbl (r_id,r_user_id,r_status) values(room_id.nextval,12,'false');
insert into room_tbl (r_id,r_user_id,r_status) values(room_id.nextval,13,'false');
insert into room_tbl (r_id,r_user_id,r_status) values(room_id.nextval,14,'false');
insert into room_tbl (r_id,r_user_id,r_status) values(room_id.nextval,15,'false');
insert into room_tbl (r_id,r_user_id,r_status) values(room_id.nextval,16,'false');
insert into room_tbl (r_id,r_user_id,r_player_id,r_status) values(room_id.nextval,10,11,'true');
insert into room_tbl (r_id,r_user_id,r_player_id,r_status) values(room_id.nextval,10,11,'true');
insert into room_tbl (r_id,r_user_id,r_player_id,r_status) values(room_id.nextval,15,16,'true');

select r_status from room_tbl where r_id = 1
update room_tbl set r_status = 'true' where r_id = 8
COMMIT


