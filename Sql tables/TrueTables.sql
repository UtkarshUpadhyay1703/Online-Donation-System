create database helping;
use helping;

create table SignupDonator(
DonatorId int auto_increment,
DonatorName varchar(30) not null,
DonatorAddress varchar(50) not null,
DonatorMobileNo int not null unique,
DonatorEmailId varchar(30) not null unique,
DonatorPassword varchar(20) not null,
DonatorStatus varchar(10) default "active",
constraint DonatorId_PK primary key(DonatorId)
);

create table SignupVendor(
VendorId int auto_increment,
#VName varchar(20) not null,
VendorCompanyName varchar(30) not null,
VendorCompanyAddress varchar(50) not null,
VendorMobNo int not null unique,
VendorAadharno int not null unique,
VendorCompanyBankAccountNo int not null unique,
VendorEmailid varchar(30) not null unique,
VendorPassword varchar(20) not null,
VendorStatus varchar(10) default "active",
constraint Vendorid_PK primary key(VendorId)
);

create table SignupEmployee(
EmployeeId int auto_increment,
EmployeeName varchar(30) not null,
EmployeeAddress varchar(50) not null,
EmployeeMobNo int not null unique,
EmployeeAadharNo int not null unique,
EmployeeBankAccountNo int not null unique,
EmployeeEmailId varchar(30) not null unique,
EmployeePassword varchar(20) not null,
EmployeeQualification varchar(10) not null,
EmployeeStatus varchar(10) default "active",
constraint EmployeeId_PK primary key(EmployeeId)
);

create table ItemDonation(
ItemId int auto_increment,
ItemType varchar(20),
DonatorId int,
EmployeeId int,
ItemPicViaDonator varchar(30),
ItemPicViaEmployee varchar(30),
ItemStatusDonation varchar(10) default "hold",
#iStatusDonated varchar(10) default notgiven ?
constraint ItemId_PK primary key(ItemId),
constraint DonatorId_FK foreign key(DonatorId) references SignupDonator(DonatorId),
constraint EmployeeId_FK foreign key(EmployeeId) references SignupEmployee(EmployeeId)
);

create table MoneyDonation(
MoneyId int auto_increment,
DonatorId int,
constraint MoneyId_PK primary key(MoneyId),
constraint DonatorIdM_PK foreign key(DonatorId) references SignupDonator(DonatorId)
);

create table BiddingTable(
BidId int,
VendorId int ,
LowPriceToy int,
LowPriceCloth int,
LowPriceNoteBook int,
LowPriceCycle int,
DateOfBid date,
BiddingStatusApprove varchar(20) default "Pending",
BiddingStatus varchar(20) default "not received",
constraint Bid_PK primary key(BidId),
constraint Vendorid_BiddingTable_FK foreign key(VendorId) references SignupVendor(VendorId)
);

#default now() for DateOfBid in BiddingTable;

-- create table banktable(
-- dateAndTime date,
-- amount int,
-- transactionId int
-- )

-- //////create function if needed

-- ///create a card on employee page in which a querry is fired to change the iStatusDonation to received

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

-- create table donatorAnonymous(
-- donatorId int,
-- dName varchar(30),
-- dAddress varchar(50),
-- dMobileNo int
-- )

-- create table donator(
-- donatorId int,
-- itemId int if donated item,
-- BankTable columns if donated money
-- make primary key and foreign key
-- )
