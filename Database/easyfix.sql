create database easyfix

use easyfix

create table Customers(
ID int primary key,
Name varchar(50) not null,
email varchar(50) not null,
[Password] varchar(50),
wallet float,
[Address] varchar(50),
favorite int
)


insert into Customers VALUES ('1','noor','noor14211','qwerty','0','wapdat town lahore','100')

insert into Customers VALUES('2','ali','ali111','qwerty','0','wapda town lahore','200');

insert into Customers VALUES('3','arsalan','arsalan444','qwerty','0','valencia lahore','100');


create table worker(
id int,
average_rating int,
hourly_rate int, 
city varchar(50),
area varchar(50),
speciality varchar(50),
rating int


)



--does user exist
go
Create Procedure does_user_exist @uname varchar(50), @pass varchar(50), @output int OUTPUT
As
Begin

	if  not exists (select * 
			From Customers 
			Where Name=@uname and [Password]=@pass)
	Begin
	set @output=0
	print 'Error! Username and password combination incorrect'
	return
	End

	set @output=1
	print 'login successful!'
End



go
Create Procedure storeuser @vid int, @uname varchar(50), @vemail varchar(50),@vpass varchar(50),@wall float, @vAddress varchar(50),@vfavorite int
As
Begin

	insert into Customers values(@vid,@uname, @vemail ,@vpass ,@wall , @vAddress,@vfavorite)
End




