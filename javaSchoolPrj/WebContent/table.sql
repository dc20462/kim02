CREATE TABLE member(
id VARCHAR2(20) PRIMARY KEY,
pw VARCHAR2(10) NOT NULL,
name VARCHAR2(13) NOT NULL,
gender VARCHAR2(10),
addr VARCHAR2(100),
tel VARCHAR2(20)
);

CREATE TABLE board(
bno NUMBER PRIMARY KEY ,
member_id VARCHAR2(20) references member(id),
title VARCHAR2(100) not null,
content VARCHAR2(1000) not null,
write_date DATE default sysdate,
read_count NUMBER DEFAULT 0,
reply_count NUMBER DEFAUlT 0,
filename VARCHAR2(50)
);

CREATE TABLE tbl_member(
id VARCHAR2(20) PRIMARY KEY,
pw VARCHAR2(10) NOT NULL,
name VARCHAR2(13) NOT NULL,
jumin VARCHAR2(20) NOT NULL,
address VARCHAR2(100),
tel VARCHAR2(20),
type VARCHAR2(10)
);

CREATE TABLE tbl_banner(
banner_no NUMBER PRIMARY KEY,
filename VARCHAR2(50)
);

create sequence banner_seq;

CREATE TABLE tbl_hits(
today_date DATE DEFAULT SYSDATE PRIMARY KEY,
today_hits NUMBER DEFAULT 0,
total_hits NUMBER DEFAUlT 0 
);

CREATE TABLE tbl_albumboard(
ano NUMBER PRIMARY KEY ,
id VARCHAR2(20) REFERENCES tbl_member(id),
title VARCHAR2(100) NOT NULL,
content VARCHAR2(1000) NOT NULL,
write_date DATE DEFAULT SYSDATE,
filename VARCHAR2(50) 
);

create sequence album_seq;

CREATE TABLE tbl_freeboard(
bno NUMBER PRIMARY KEY ,
id VARCHAR2(20) REFERENCES tbl_member(id),
title VARCHAR2(100) NOT NULL,
content VARCHAR2(1000) NOT NULL,
write_date DATE DEFAULT SYSDATE,
read_count NUMBER DEFAULT 0,
reply_count NUMBER DEFAUlT 0
);

create sequence free_seq;

create table tbl_freereply(
rno number primary key,
bno number references tbl_freeboard(bno),
member_id varchar2(20) references tbl_member(id),
re_date date default sysdate,
content varchar2(500) not null);

create sequence freereply_seq;

CREATE TABLE tbl_secretboard(
bno NUMBER PRIMARY KEY ,
title VARCHAR2(100) NOT NULL,
content VARCHAR2(1000) NOT NULL,
write_date DATE DEFAULT SYSDATE,
read_count NUMBER DEFAULT 0
);

create sequence secret_seq;

CREATE TABLE tbl_noticeboard(
notice_no NUMBER PRIMARY KEY ,
notice_title VARCHAR2(100) NOT NULL,
notice_content VARCHAR2(1000) NOT NULL,
notice_date DATE DEFAULT SYSDATE,
notice_read_count NUMBER DEFAULT 0,
notice_filename VARCHAR2(50) 
);

create sequence notice_seq;

CREATE TABLE tbl_newsboard(
news_no NUMBER PRIMARY KEY ,
news_title VARCHAR2(100) NOT NULL,
news_content VARCHAR2(1000) NOT NULL,
news_date DATE DEFAULT SYSDATE,
news_read_count NUMBER DEFAULT 0,
news_filename VARCHAR2(50) 
);

create sequence news_seq;

CREATE TABLE tbl_mealboard(
meal_no NUMBER PRIMARY KEY ,
meal_title VARCHAR2(100) NOT NULL,
meal_content VARCHAR2(1000) NOT NULL,
meal_date DATE DEFAULT SYSDATE,
meal_read_count NUMBER DEFAULT 0,
meal_filename VARCHAR2(50) 
);

-- 수정
drop table tbl_noticeboard;
drop table tbl_newsboard;
drop table tbl_mealboard;

CREATE TABLE tbl_noticeboard(
notice_no NUMBER PRIMARY KEY ,
notice_id VARCHAR2(20) REFERENCES tbl_member(id),
notice_title VARCHAR2(100) NOT NULL,
notice_content VARCHAR2(1000) NOT NULL,
notice_date DATE DEFAULT SYSDATE,
notice_read_count NUMBER DEFAULT 0,
notice_filename VARCHAR2(50) 
);

CREATE TABLE tbl_newsboard(
news_no NUMBER PRIMARY KEY ,
news_id VARCHAR2(20) REFERENCES tbl_member(id),
news_title VARCHAR2(100) NOT NULL,
news_content VARCHAR2(1000) NOT NULL,
news_date DATE DEFAULT SYSDATE,
news_read_count NUMBER DEFAULT 0,
news_filename VARCHAR2(50) 
);

CREATE TABLE tbl_mealboard(
meal_no NUMBER PRIMARY KEY ,
meal_id VARCHAR2(20) REFERENCES tbl_member(id),
meal_title VARCHAR2(100) NOT NULL,
meal_content VARCHAR2(1000) NOT NULL,
meal_date DATE DEFAULT SYSDATE,
meal_read_count NUMBER DEFAULT 0,
meal_filename VARCHAR2(50) 
);