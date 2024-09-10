drop database if exists fitnessclub;
create database fitnessclub;
use fitnessclub;
create table billinfo
(
bno int primary key,
date text,
m text,
mn text,
pn text,
pc text,
sn text,
samt text,
cf text,
tot text
);
create table mem_ber
(
mid int primary key,
mname text,
maddr text,
mobno text,
emailid text,
gender text,
iname text,
batch text,
jdate text,
height text,
weight text,
subscription text,
clubfees text
);
create table empinfo
(
empid int,
name text,
addr text,
mobno text,
d text,
p text,
edate date,
g text,
q text,
sal double,
des text
);
create table icardinstructor
(
icid int,
name text,
addr text,
mobno bigint,
email text,
b text
);
create table icardmember
(
imid int,
name text,
addr text, 
mobno bigint,
email text,
i text,
b text
);
create table instructor
(
instid int,
instname text,
instaddr text,
instmobno bigint,
instemailid text,
instgender text,
instjdate text,
mid text,
instsal double
);
create table product
(
pid int primary key,
mid int references mem_ber,
pdate text,
pname text,
price text,
qty int,
tprice text
);
create table services
(
sid int primary key,
mid int references mem_ber,
sdate text,
sname text,
samt text
);