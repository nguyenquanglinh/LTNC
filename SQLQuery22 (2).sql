create database ManageWatch
go
use ManageWatch
go
create table Categories(
	CatId nvarchar(10) primary key not null,
	CatName nvarchar(50),
	CatStatus bit,
	Descriptons ntext,
	)
	go
	Create table WebUser(
	UserId int identity(1,1) primary key not null,
	Mail nvarchar(50),
	Phone varchar(12),
	UserName nvarchar(50),
	Passwords nvarchar(50),
	Addresss nvarchar(100),
	UserStatus bit,
	BirthDay date
	)
	go
Create table Producers(
	ProducersId nvarchar(10) primary key not null,
	ProducersName nvarchar(50),
	ProductStatus bit
	)
	go
	Create table Orders(
	OrderId int identity(1,1) primary key not null,
	UserId int foreign key references WebUser(UserId),
	Name nvarchar(50),
	Created date,
	OrderStatus bit,
	Phone varchar(12),
	Mail nvarchar(50),
	Addresss nvarchar(100)
	)
	go
create table Product(
	ProductId nvarchar(10) primary key not null,
	ProductName nvarchar(100),
	ProducersId nvarchar(10) foreign key references Producers(ProducersId),
	Price float,
	Title ntext,
	Descriptions ntext,
	CatId nvarchar(10) foreign key references Categories(CatId),
	Created date,
	Discount int,
	Quantity int,
	ImageLink ntext,
	ProductStatus bit
	)
go
create table Images(
	ImageId int identity(1,1) primary key not null,
	ImageLink ntext,
	ProductId nvarchar(10) foreign key references Product(ProductId),
	)
	go
Create table Banner(
	BannerId nvarchar(10) primary key not null,
	BannerName nvarchar(50),
	ImageLink ntext,
	BannerStatus bit
	)
	go
create table OrderDetail(
	OrderId int foreign key references Orders(OrderId),
	ProductId nvarchar(10) foreign key references Product(ProductId),
	Quantity int,
	primary key (OrderId,ProductId)
	)
	go

	
Create table Admins(
	
	NameAdmin nvarchar(50) primary key not null,
	PassAdmin nvarchar(50)
	)