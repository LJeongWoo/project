
CREATE TABLE web_member(
	email varchar2(100),
	pw	varchar2(100),
	tel	varchar2(100),
	address	varchar2(100)
);

select * from web_member;


create table web_message(
	num number(36),
	sendname varchar2(100),
	receiveEmail varchar2(100),
	message varchar2(100),
	m_date date
);


drop sequence num_message ;

create sequence num_message
start with 1
increment by 1;


select * from web_message;



create table board(
	num number(10),
	like_it number(10)
);

insert into board values(1,50);
select * from BOARD;



