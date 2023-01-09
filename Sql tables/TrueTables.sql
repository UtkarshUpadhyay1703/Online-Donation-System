drop database helping;

create database helping;
use helping;

create table signup_donor(
donor_id int unique,
donor_name varchar(30) not null,
donor_address varchar(50) not null,
donor_mobileNo int not null unique,
donor_emailid varchar(30) not null unique,
donor_password varchar(20) not null,
donor_status varchar(10) default "active",
constraint donor_id_pk primary key(donor_id)
);

create table signup_vendor(
vendor_id int unique,
#vName varchar(20) not null,
vendor_company_name varchar(30) not null,
vendor_company_address varchar(50) not null,
vendo_mobno int not null unique,
vendor_aadhar_no int not null unique,
vendor_company_bank_account_no int not null unique,
vendor_emailid varchar(30) not null unique,
vendor_password varchar(20) not null,
vendor_status varchar(10) default "active",
constraint vendor_id_pk primary key(vendor_id)
);

create table signup_employee(
employee_id int unique,
employee_name varchar(30) not null,
employee_address varchar(50) not null,
employee_mobNo int not null unique,
employee_aadhar_no int not null unique,
employee_bank_account_no int not null unique,
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
bidding_status varchar(20) default "not received",
constraint bid_pk primary key(bid_id),
constraint vendor_id_bidding_table_fk foreign key(vendor_id) references signup_vendor(vendor_id)
);

#default now() for dateOfbid in biddingTable;

create table anonymous_donor_table(
#Can we automatically generate id or genereted via java or dotnet
anonymous_donor_id int,
anonymous_donor_name varchar(30),
-- anonymousdonatorAddress varchar(50),
anonymous_donor_mobile_no int unique,
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
)

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
































drop database helping;

create database helping;
use helping;

create table signup_donator(
donator_id int unique,
donator_name varchar(30) not null,
donator_address varchar(50) not null,
donator_mobileNo int not null unique,
donator_emailid varchar(30) not null unique,
donator_password varchar(20) not null,
donator_status varchar(10) default "active",
constraint donatorid_PK primary key(donator_id)
);

create table Signupvendor(
vendorid int unique,
#vName varchar(20) not null,
vendorCompanyName varchar(30) not null,
vendorCompanyAddress varchar(50) not null,
vendorMobNo int not null unique,
vendorAadharno int not null unique,
vendorCompanybankAccountNo int not null unique,
vendoremailid varchar(30) not null unique,
vendorPassword varchar(20) not null,
vendorStatus varchar(10) default "active",
constraint vendorid_PK primary key(vendorid)
);

create table Signupemployee(
employeeid int unique,
employeeName varchar(30) not null,
employeeAddress varchar(50) not null,
employeeMobNo int not null unique,
employeeAadharNo int not null unique,
employeebankAccountNo int not null unique,
employeeemailid varchar(30) not null unique,
employeePassword varchar(20) not null,
employeeQualification varchar(10) not null,
employeeStatus varchar(10) default "active",
constraint employeeid_PK primary key(employeeid)
);

create table itemdonation(
itemid int unique,
itemType varchar(20),
donatorid int,
employeeid int,
itemPicviadonator varchar(30),
itemPicviaemployee varchar(30),
itemStatusdonation varchar(10) default "hold",
#iStatusdonated varchar(10) default notgiven ?
constraint itemid_PK primary key(itemid),
constraint donatorid_FK foreign key(donatorid) references Signupdonator(donatorid),
constraint employeeid_FK foreign key(employeeid) references Signupemployee(employeeid)
);


-- create table Moneydonation(
-- Moneyid int unique,
-- donatorid int,
-- constraint Moneyid_PK primary key(Moneyid),
-- constraint donatoridM_PK foreign key(donatorid) references Signupdonator(donatorid)
-- );

create table biddingTable(
bidid int unique,
vendorid int ,
lowPriceToy decimal(11,2),
lowPriceCloth decimal(11,2),
lowPriceNotebook decimal(11,2),
lowPriceCycle decimal(11,2),
dateOfbid date,
biddingStatusApprove varchar(20) default "Pending",
biddingStatus varchar(20) default "not received",
constraint bid_PK primary key(bidid),
constraint vendorid_biddingTable_FK foreign key(vendorid) references Signupvendor(vendorid)
);

#default now() for dateOfbid in biddingTable;


create table anonymousdonator_table(
#Can we automatically generate id or genereted via java or dotnet
anonymousdonatorid int,
anonymousdonatorName varchar(30),
-- anonymousdonatorAddress varchar(50),
anonymousdonatorMobileNo int unique,
anonymousdonatorAmount double(11,2),
constraint anonymousdonatorid_PK primary key(anonymousdonatorid)
);


create table bank_transaction_table(
transaction_id int,
anonymousdonatorid int,
donatorid int,
employeeid int,
vendorid int,
dateAndTime date,
amountReceived decimal(11,2),
amountSend decimal(11,2),
balance decimal(11,2),
constraint transactionid_PK primary key(transaction_id),
constraint donatoridM_PK foreign key(donatorid) references Signupdonator(donatorid)
)

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
