drop database helping;
show databases;
create database helping;
use helping;
show tables;
create table signup_donor(
donor_id int unique,
donor_name varchar(30) not null,
donor_address varchar(50) not null,
donor_mobile_no varchar(10) not null unique,
donor_email_id varchar(30) not null unique,
donor_password varchar(20) not null,
donor_status varchar(10) default "active",
constraint donor_id_pk primary key(donor_id)
);

create table signup_vendor(
vendor_id int unique,
#vName varchar(20) not null,
vendor_company_name varchar(30) not null,
vendor_company_address varchar(50) not null,
vendo_mobile_no varchar(10) not null unique,
vendor_aadhar_no varchar(12) not null unique,
vendor_company_bank_account_no varchar(14) not null unique,
vendor_email_id varchar(30) not null unique,
vendor_password varchar(20) not null,
vendor_status varchar(10) default "active",
constraint vendor_id_pk primary key(vendor_id)
);

create table signup_employee(
employee_id int unique,
employee_name varchar(30) not null,
employee_address varchar(50) not null,
employee_mobile_no varchar(10) not null unique,
employee_aadhar_no varchar(12) not null unique,
employee_bank_account_no varchar(14) not null unique,
employee_email_id varchar(30) not null unique,
employee_password varchar(20) not null,
employee_qualification varchar(10) not null,
employee_status varchar(10) default "active",
constraint employee_id_pk primary key(employee_id)
);

create table item_donation(
item_id int unique,
item_type varchar(20),
donor_id int,
employee_id int,
item_pic_via_donator varchar(30),
item_pic_via_employee varchar(30),
item_status_donation varchar(10) default "hold",
#iStatusdonated varchar(10) default notgiven ?
constraint item_id_pk primary key(item_id),
constraint donor_id_item_donation_fk foreign key(donor_id) references signup_donor(donor_id),
constraint employee_id_item_donation_fk foreign key(employee_id) references signup_employee(employee_id)
);


-- create table Moneydonation(
-- Moneyid int unique,
-- donatorid int,
-- constraint Moneyid_PK primary key(Moneyid),
-- constraint donatoridM_PK foreign key(donatorid) references Signupdonator(donatorid)
-- );

create table bidding_table(
bid_id int unique,
vendor_id int ,
low_price_toy decimal(11,2),
low_price_cloth decimal(11,2),
low_price_notebook decimal(11,2),
low_price_cycle decimal(11,2),
date_of_bid date,
bidding_status_approve varchar(20) default "Pending",
-- bidding_status varchar(20) default "not received",
warehouse_receive_status varchar(20) default "not received",
constraint bid_pk primary key(bid_id),
constraint vendor_id_bidding_table_fk foreign key(vendor_id) references signup_vendor(vendor_id)
);

#default now() for dateOfbid in biddingTable;

create table anonymous_donor_table(
#Can we automatically generate id or generated via java or dotnet
anonymous_donor_id int,
anonymous_donor_name varchar(30),
-- anonymousdonatorAddress varchar(50),
anonymous_donor_mobile_no varchar(10) unique,
anonymous_donor_amount decimal(11,2),
constraint anonymous_donor_id_pk primary key(anonymous_donor_id)
);


create table bank_transaction_table(
transaction_id int,
anonymous_donor_id int,
donor_id int,
employee_id int,
vendor_id int,
date_and_time date,
amount_received decimal(11,2),
amount_send decimal(11,2),
balance decimal(11,2),
constraint transactionid_pk primary key(transaction_id),
constraint bank_transaction_table_donor_id_fk foreign key(donor_id) references signup_donor(donor_id)
);

-- //////create function if needed

-- ///create a card on employee page in which a querry is fired to change the iStatusdonation to received

-- ////create a querry to insert n number of items in the item donation table when employee tick teh received button
-- ///// by giving quantity and the type


-- ///
-- create table tender(
-- tenderid int,
-- tObjective varchar(50),
-- )
-- ///

-- ////After finishing of bidding process a querry fires auto_incrementally to select top 5 bidders and then display to employee webpage


-- ////After receiving the items from vendor employee will click recieved button then auto_incrementally a querry fired to change biddingStatus to received




-- create table donator(
-- donatorid int,
-- itemid int if donated item,
-- bankTable columns if donated money
-- make primary key and foreign key
-- )




-- create table Moneydonation(
-- Moneyid int unique,
-- donatorid int,
-- constraint Moneyid_PK primary key(Moneyid),
-- constraint donatoridM_PK foreign key(donatorid) references Signupdonator(donatorid)
-- );



-- //////create function if needed

-- ///create a card on employee page in which a querry is fired to change the iStatusdonation to received

-- ////create a querry to insert n number of items in the item donation table when employee tick teh received button
-- ///// by giving quantity and the type

-- ///
-- create table tender(
-- tenderid int,
-- tObjective varchar(50),
-- )
-- ///

-- ////After finishing of bidding process a querry fires auto_incrementally to select top 5 bidders and then display to employee webpage

-- ////After receiving the items from vendor employee will click recieved button then auto_incrementally a querry fired to change biddingStatus to received


-- create table donator(
-- donatorid int,
-- itemid int if donated item,
-- bankTable columns if donated money
-- make primary key and foreign key
-- )












-- insertion
-- create table signup_donor(
-- donor_id int unique,
-- donor_name varchar(30) not null,
-- donor_address varchar(50) not null,
-- donor_mobile_no int not null unique,
-- donor_email_id varchar(30) not null unique,
-- donor_password varchar(20) not null,
-- donor_status varchar(10) default "active",
-- constraint donor_id_pk primary key(donor_id)
-- );

insert into signup_donor(donor_id,donor_name,donor_address,donor_mobile_no,donor_email_id,donor_password) 
values(1,"Raju","IACSD Akurdi, Pimpri-Chinchwad, Pune",9103846472,"raju1@gmail.com","Raju$1");
select * from signup_donor;

-- employee_id int unique,
-- employee_name varchar(30) not null,
-- employee_address varchar(50) not null,
-- employee_mobile_no varchar(10) not null unique,
-- employee_aadhar_no varchar(12) not null unique,
-- employee_bank_account_no varchar(14) not null unique,
-- employee_email_id varchar(30) not null unique,
-- employee_password varchar(20) not null,
-- employee_qualification varchar(10) not null,
-- employee_status varchar(10) default "active",

insert into signup_employee(employee_id,employee_name,employee_address,employee_mobile_no,employee_aadhar_no,employee_bank_account_no,employee_email_id,employee_password,employee_qualification) 
values(1,"Ramesh","Pune","9457788965","123456789123","12345678912345","Ramesh1@gmail.com","Ramesh$1","12th");
select * from signup_employee;













#Queries

-- insert into signup_donor(donor_id,donor_name,donor_address,donor_mobile_no,donor_email_id,donor_password) values();
-- insert into signup_vendor(vendor_id,vendor_company_name,vendor_company_address,vendor_mobile_no,vendor_aadhar_no,vendor_company_bank_account_no,vendor_email_id,vendor_password) values();
-- insert into signup_employee(employee_id,employee_name,employee_address,employee_mobno,employee_aadhar_no,employee_bank_accountno,employee_email_id,employee_password,employee_qualification) values();
-- insert into item_donation(item_id,item_type,donor_id,employee_id,item_pic_via_donator,item_pic_via_employee) values();
-- insert into bidding_table(bid_id,vendor_id,low_price_toy,low_price_cloth,low_price_notebook,low_price_cycle,date_of_bid) values();
-- update signup_donor set donor_status ="inactive" where donor_id= @;
-- update signup_vendor set vendor_status = "inactive" where vendor_id=@;
-- update signup_employee set employee_status = "inactive" where employee_id=@; 
-- update item_donation set item_status_donation = "received" where item_id=@;
-- update bidding_table set bidding_status_approve= "received" where bid_id=@;
-- update bidding_table set warehouse_receive_status= "received" where bid_id=@;
-- insert into anonymous_donor_table(anonymous_donor_id,anonymous_donor_name,anonymous_donor_mobile_no,anonymous_donor_amount) values();
 

