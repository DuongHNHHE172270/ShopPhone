create database shop1;
use shop1;
drop database shop1   
/*create table category*/
create table category
(
	categoryId int primary key,
    categoryName varchar(50) not Null,
	status int
);

INSERT INTO category VALUES 
(1, 'iPhone', 1),
(2, 'Samsung', 1),
(3, 'Xiaomi', 1),
(4, 'Huawei', 1);

/*create table product*/
create table product
(
	productId int primary key IDENTITY(1,1),
    productName varchar(100) not null,
    imagePath varchar(200),
    price int,
    originalPrice int,
    viewCount int,
    description varchar(500),
    status int,
    categoryId int,
    foreign key (categoryId) references category (categoryId)
);

insert into product values
('iPhone 13 128GB', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-13_2_.png', 2000, 1600, 12, 'The iPhone 13 phone uses a high-quality LPTS OLED panel and has a size of 6.1 inches, 60Hz. With this panel and ProMotion technology, iPhone 13 helps maximize battery savings when in use.
High-resolution OLED screen, strong brightness of 800 nits, and a maximum of up to 1200 nits with P3 wide color range, so users can see clearly in many different lighting conditions, including outdoors hot sun.', 1, 1),
('Samsung Galaxy S24', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lr5w3klke07t38_tn', 
1800, 1500, 10, 'Bigger screen. Save more battery. Better handling. 6 So much to love about the Galaxy S24 and S24+.
In particular, Galaxy S24+ has the highest screen resolution currently compared to all Galaxy series: QHD+.', 1, 2),
('Xiaomi Redmi 13C', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lpyt871mpeqa4e_tn', 
400, 300, 6, 'The smartphone has a more perfect design than the previous generation, with a weight of about 203g and a 
thickness of 9.6mm. Not to mention, the 6.74 inch screen and HD+ resolution allows all content to be displayed more fully and in more detail. In particular, 
the 50MP main camera and performance from the Helio G85 chip help meet usage and entertainment needs within the price range.', 1, 3),
('Huawei 90 5G', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lodjy5mupmgja4_tn', 
1100, 950, 8, 'Viettel Store Supermarket System is committed to providing genuine products to consumers .
Support VAT invoice issuance Customers please take a photo/record when receiving/unpacking the product to ensure your
rights regarding warranty and product return.', 1, 4),

('iPhone 15 128GB', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-llm05p5nkerg1c', 2200, 1950, 10, 'The iPhone 15 display has
rounded corners that follow a beautiful curved design, and these corners are within a standard rectangle.
When measured as a standard rectangular shape, the screen is 6.12 inches diagonally (actual viewable area is less).', 1, 1),
('Samsung Galaxy A05', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsv5oayfo3vde1', 
1800, 1550, 10, 'Internal memory: 128 GB. Rear camera: Main 50 MP & Secondary 2 MP, Front camera: 8 MP, CPU: MediaTek Helio G85.', 1, 2),
('Xiaomi Redmi A1', 'https://down-vn.img.susercontent.com/file/sg-11134201-22100-h69k0vqt1aiv8e', 
400, 250, 6, 'Equipped with a 6.52-inch screen with HD+ resolution (720 x 1600 Pixels) with the ability to 
reproduce relatively clear images so users can watch movies and read news comfortably.', 1, 3),
('HUAWEI NOVA 10', '	https://down-vn.img.susercontent.com/file/cn-11134207-7r98o-logdwaundmsi12', 
1100, 900, 8, 'Make sure the screen works perfectly before gluing/screwing. 
Parts warranty is voided if the product is damaged and misused such as: 
clear liquid, scratches, traces of glue and broken screen.', 1, 4),

('Samsung Galaxy Z', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-llbkf9fa9k1iec_tn', 2500, 2800, 11, 'Samsung Galaxy Z Flip is designed with a folding screen 
design inspired by the Galaxy Fold product line that made a lot of noise in 2019.', 1, 2),
('Samsung Galaxy M14', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lk9gwp8t042k3b', 
1800, 1450, 10, 'Samsung Galaxy M14 Bigger screen. Save more battery. Better handling. 6 So much to love about the Galaxy S24 and S24+.
In particular, Galaxy S24+ has the highest screen resolution currently compared to all Galaxy series: QHD+.', 1, 2),
('Huawei 90 5G', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lodjy5mupmgja4_tn', 
1100, 1000, 8, 'Viettel Store Supermarket System is committed to providing genuine products to consumers .
Support VAT invoice issuance Customers please take a photo/record when receiving/unpacking the product to ensure your
rights regarding warranty and product return.', 1, 4),
('iPhone 14', 'https://down-vn.img.susercontent.com/file/0982de1d517eed28495a9bbcaced5881', 2000, 1500, 12, 'The iPhone 14 phone uses a high-quality LPTS OLED panel and has a size of 6.1 inches, 60Hz. With this panel and ProMotion technology, iPhone 13 helps maximize battery savings when in use.
High-resolution OLED screen, strong brightness of 800 nits, and a maximum of up to 1200 nits with P3 wide color range, so users can see clearly in many different lighting conditions, including outdoors hot sun.', 1, 1),
('Samsung A14', 'https://down-vn.img.susercontent.com/file/sg-11134201-7rbkx-lm3eo4gjama314', 
1800, 1600, 10, 'Bigger screen. Save more battery. Better handling. 6 So much to love about the Galaxy S24 and S24+.
In particular, Galaxy S24+ has the highest screen resolution currently compared to all Galaxy series: QHD+.', 1, 2),
('Xiaomi Redmi Note 13', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lshvbsqzyvus54', 
700, 500, 6, 'Innovative design compared to Redmi Note 12 with frame and back made of plastic but feels 
sturdy and glass-like. High level of finishing with thin screen bezels.', 1, 3),
(' HUAWEI Y6 Pro', 'https://down-vn.img.susercontent.com/file/cn-11134207-7r98o-ll8przwuovjg21_tn', 
1100, 850, 8, 'Viettel Store Supermarket System is committed to providing genuine products to consumers .
Support VAT invoice issuance Customers please take a photo/record when receiving/unpacking the product to ensure your
rights regarding warranty and product return.', 1, 4),
('Samsung Galaxy A05S', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lr5w3klke07t38_tn', 
1800, 1200, 10, 'Large and Beautiful Design: The A05s large screen provides spacious display space, 
ideal for watching videos and playing games.', 1, 2),
('Samsung Galaxy A25', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lpadd8wiwxfy68', 
1800, 1400, 10, 'Samsung Galaxy A25 has a screen size of up to 6.5'', supports Full HD + resolution (1080 x 2340 Pixels), every detail is reproduced sharply, giving the feeling when playing games or watching movies. also becomes more realistic and lively. 
The device is equipped with a Super AMOLED panel that brings depth to displayed content.', 1, 2);
 
/*create table color*/
create table color
(
	colorId int primary key,
    name varchar(50)
);

insert into color values
(1, 'Red'),
(2, 'Orange'),
(3, 'Yellow'),
(4, 'Black'),
(5, 'Pink'),
(6, 'Grey'),
(7, 'Violet');
/*create table product_color*/

create table product_color
(
	productId int primary key references product(productId),
    colorId int references color(colorId),
);


insert into product_color values
(1, 7),
(2, 3),
(3, 4),
(4, 6),
(5, 5),
(6, 4),
(7, 4),
(8, 2),
(9, 6),
(10, 6),
(11, 6),
(12, 6),
(13, 6),
(14, 3),
(15, 1),
(16, 2),
(17, 4);

/*create table users*/
create table users
(
	userId int primary key IDENTITY(1,1),
	userName varchar(50),
    password varchar(50),
    fullName varchar(50),
    avatar varchar(100),
    phone varchar(20),
    address nvarchar(300),
    role int
);



insert into users values
( 'admin', '123', 'Duong', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0332638235', 'HaNoi', 0),
( 'Ha', '123', 'Ha', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0978338389', 'HaNoi', 1),
( 'Tu', '123', 'Tu', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0789338389', 'ChiNinh', 1),
( 'Tien', '123', 'Tien', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0578338388', 'HaiDuong', 1),
( 'Sy', '123', 'Sy', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0975683708', 'ThachThat', 1),
( 'Trung', '123', 'Trung', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0673727647', 'ThachThat', 1),
( 'Ngan', '123', 'Ngan', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0773783578', 'NamDinh', 1),
( 'Khoi', '123', 'Khoi', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0135895336', 'My', 1),
( 'Linh', '123', 'Linh', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0146832467', 'HaiPhong', 1),
( 'Duy', '123', 'Duy', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0268478957', 'Nga', 1),
( 'Ngoc', '123', 'Ngoc', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0954537893', 'Ba', 1),
( 'Thanh', '123', 'Thanh', 'https://img.lovepik.com/fonts/19/01/12/879bb97fa1f2c086e3ed6fd8c5a7b8af.jpg_wh860.jpg', '0567836785', 'Ninh', 1);

/*create table order*/
create table orders
(
	orderId int primary key IDENTITY(1,1),
    userId int,
    totalMoney int,   
    bookingDate datetime,
    foreign key (userId) references users(userId)
);


/*create table orderDetail*/
create table orderDetail
(
	orderDetailId int primary key IDENTITY(1,1), -- Thêm một cột khóa chính mới
    orderId int,
    productId int,
    quantity int,
	price float,
    foreign key (productId) references product(productId),
    foreign key (orderId) references orders(orderId)
);


