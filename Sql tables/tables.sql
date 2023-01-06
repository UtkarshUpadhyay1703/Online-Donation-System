create table SignupDonator(
DonatorId int auto_increment,
DonatorName varchar(30) not null,
DonatorAddress varchar(50) not null,
DonatorMobileNo int not null,
DonatorEmailId varchar(30) not null,
DonatorPassword varchar(20) not null,
DonatorStatus varchar(10) default "active"
)

create table ItemDonation(
ItemId int auto_increment,
ItemType varchar(20),
dId int,
empid int,
iPicViaDonator varchar(30),
iPicViaEmployee varchar(30),
iStatusDonation varchar(10) default hold,
#iStatusDonated varchar(10) default notgiven ?
)

create table moneyDonation(
moneyId int automatic,
dId int,
bank
)

//////create function if needed

///create a card on employee page in which a querry is fired to change the iStatusDonation to received

////create a querry to insert n number of items in the item donation table when employee tick teh received button
///// by giving quantity and the type

create table signupVendor(
Vid int automatic,
//////VName varchar(20) not null,
VCompanyName varchar(30) not null,
VCompanyAddress varchar(50) not null,
VMobno int not null,
VAadharno int not null,
VCompanyBankAccountNo int not null,
VEmailid varchar(30) not null,
VPassword varchar(20) not null,
status varchar(10) default active
)


create table biddingtable(
tenderid int,
Vid int ,
lPriceToy int,
lPriceCloth int,
lPriceNoteBook int,
lPriceCycle int,
dateofbid Date automatic default now(),
biddingStatus varchar(10) default notreceived
)
///
-- create table tender(
-- tenderid int,
-- tObjective varchar(50),
-- )
///

////After finishing of bidding process a querry fires automatically to select top 5 bidders and then display to employee webpage

////After receiving the items from vendor employee will click recieved button then automatically a querry fired to change biddingStatus to received



create table signupEmployee(
eID int automatic,
eName varchar(30) not null,
eAddress varchar(50) not null,
eMobNo int not null,
eAadharNo int not null,
eBankAccountNo int not null,
eEmailId varchar(30) not null,
ePassword varchar(20) not null,
eQualification varchar(10) not null,
status varchar(10) default active
)




-- create table employee(
-- empid int,
-- ename varchar(30) not null,
-- eAddress varchar(50) not null,
-- eAaddharNo int,
-- eBankAccountNo int,

-- )

-- create table vendor(
-- vendorid int,
-- vName varchar(30) not null,
-- vAddress varchar(50) not null,
-- vMobNo int,
-- vAadharNo int,
-- vCompanyPancardNo varchar(20),
-- vEmailid varchar(30),
-- vBankAccountNo int
-- )

create table banktable(
dateAndTime date,
amount int,
transactionId int
)

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





















