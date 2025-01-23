
create table goods (
  goods_id mediumint(8) unsigned primary key auto_increment,
  goods_name varchar(120) not null default '',
  cat_id smallint(5) unsigned not null default '0',
  brand_id smallint(5) unsigned not null default '0',
  goods_sn char(15) not null default '',
  goods_number smallint(5) unsigned not null default '0',
  shop_price decimal(10,2) unsigned not null default '0.00',
  market_price decimal(10,2) unsigned not null default '0.00',
  click_count int(10) unsigned not null default '0'
) ;

insert into `goods` values (1,'kd876',4,8,'ecs000000',1,1388.00,1665.60,9),
(4,'诺基亚n85原装充电器',8,1,'ecs000004',17,58.00,69.60,0),
(3,'诺基亚原装5800耳机',8,1,'ecs000002',24,68.00,81.60,3),
(5,'索爱原装m2卡读卡器',11,7,'ecs000005',8,20.00,24.00,3),
(6,'胜创kingmax内存卡',11,0,'ecs000006',15,42.00,50.40,0),  
(7,'诺基亚n85原装立体声耳机hs-82',8,1,'ecs000007',20,100.00,120.00,0),
(8,'飞利浦9@9v',3,4,'ecs000008',1,399.00,478.79,10),
(9,'诺基亚e66',3,1,'ecs000009',4,2298.00,2757.60,20),
(10,'索爱c702c',3,7,'ecs000010',7,1328.00,1593.60,11),
(11,'索爱c702c',3,7,'ecs000011',1,1300.00,0.00,0),
(12,'摩托罗拉a810',3,2,'ecs000012',8,983.00,1179.60,13),
(13,'诺基亚5320 xpressmusic',3,1,'ecs000013',8,1311.00,1573.20,13),
(14,'诺基亚5800xm',4,1,'ecs000014',1,2625.00,3150.00,6),
(15,'摩托罗拉a810',3,2,'ecs000015',3,788.00,945.60,8),
(16,'恒基伟业g101',2,11,'ecs000016',0,823.33,988.00,3),
(17,'夏新n7',3,5,'ecs000017',1,2300.00,2760.00,2),
(18,'夏新t5',4,5,'ecs000018',1,2878.00,3453.60,0),
(19,'三星sgh-f258',3,6,'ecs000019',12,858.00,1029.60,7),
(20,'三星bc01',3,6,'ecs000020',12,280.00,336.00,14),
(21,'金立 a30',3,10,'ecs000021',40,2000.00,2400.00,4),
(22,'多普达touch hd',3,3,'ecs000022',1,5999.00,7198.80,16),
(23,'诺基亚n96',5,1,'ecs000023',8,3700.00,4440.00,17),
(24,'p806',3,9,'ecs000024',100,2000.00,2400.00,35),
(25,'小灵通/固话50元充值卡',13,0,'ecs000025',2,48.00,57.59,0),
(26,'小灵通/固话20元充值卡',13,0,'ecs000026',2,19.00,22.80,0),
(27,'联通100元充值卡',15,0,'ecs000027',2,95.00,100.00,0),
(28,'联通50元充值卡',15,0,'ecs000028',0,45.00,50.00,0),
(29,'移动100元充值卡',14,0,'ecs000029',0,90.00,0.00,0),
(30,'移动20元充值卡',14,0,'ecs000030',9,18.00,21.00,1),
(31,'摩托罗拉e8 ',3,2,'ecs000031',1,1337.00,1604.39,5),  
(32,'诺基亚n85',3,1,'ecs000032',4,3010.00,3612.00,9);

-- 分类表
create table category (
    cat_id smallint unsigned auto_increment primary key,
    cat_name varchar(90) not null default '',
    parent_id smallint unsigned
);

INSERT INTO `category` VALUES
(1,'手机类型',0),
(2,'CDMA手机',1),
(3,'GSM手机',1),
(4,'3G手机',1),
(5,'双模手机',1),
(6,'手机配件',0),
(7,'充电器',6),
(8,'耳机',6),
(9,'电池',6),
(11,'读卡器和内存卡',6),   
(12,'充值卡',0),
(13,'小灵通/固话充值卡',12),
(14,'移动手机充值卡',12),
(15,'联通手机充值卡',12);



-- 1:主键为32的商品
SELECT * FROM goods WHERE goods_id = 32;

-- 2:不属第3栏目的所有商品（category中id为3）
SELECT * FROM goods WHERE cat_id != 3;

-- 3:本店价格高于3000元的商品
SELECT * FROM goods WHERE market_price > 3000;

-- 4:本店价格低于或等于100元的商品
SELECT * FROM goods WHERE market_price <= 100;

-- 5:取出第4栏目或第11栏目的商品
SELECT * FROM goods WHERE cat_id IN(4,8);

-- 6:取出100<=价格<=500的商品
SELECT * FROM goods WHERE market_price >= 100 AND market_price <= 500;

-- 7:取出不属于第3栏目且不属于第11栏目的商品(and,或not in分别实现)
SELECT * FROM goods WHERE cat_id <> 3 AND cat_id <> 11;
SELECT * FROM goods WHERE cat_id NOT IN(3,11);

-- 8:取出价格大于100且小于300,或者大于4000且小于5000的商品()
SELECT * FROM goods WHERE (market_price > 100 AND market_price < 300) OR (market_price > 4000 AND market_price < 5000);

-- 9:取出第3个栏目下面价格<1000或>3000,并且点击量>5的系列商品
SELECT * FROM goods WHERE cat_id = 3 AND (market_price < 1000 OR market_price > 3000) AND click_count > 5;

-- 10:取出第1个栏目下面的商品(注意:1栏目下面没商品,但其子栏目下有)
SELECT * FROM goods WHERE cat_id IN (SELECT cat_id FROM category WHERE parent_id = 1);

-- 11:取出名字以"诺基亚"开头的商品
SELECT * FROM goods WHERE goods_name LIKE '诺基亚%';

-- 12:取出名字为"诺基亚nxx"的手机
SELECT * FROM goods WHERE goods_name LIKE '诺基亚n__';

-- 13:取出名字不以"诺基亚"开头的商品
SELECT * FROM goods WHERE goods_name NOT LIKE '诺基亚%';

-- 14:取出第3个栏目下面价格在<1000或者>3000,并且点击量>5 "诺基亚"开头的系列商品
SELECT * FROM goods WHERE cat_id = 3 AND (market_price < 1000 OR market_price > 3000) AND click_count > 5 AND goods_name LIKE '诺基亚%'

-- 15:把goods表中商品名为'诺基亚xxxx'的商品,改为'HTCxxxx',
-- 提示:大胆的把列看成变量,参与运算,甚至调用函数来处理
UPDATE goods
	SET goods_name = CONCAT('HTC',SUBSTRING(goods_name,4))
	WHERE goods_name LIKE '诺基亚%';
SELECT * FROM goods WHERE goods_name LIKE 'HTC%';

-- 15:计算指定分类(cat_id=3)下面商品的平均价格，计算评价价格时候去掉重复价格的
-- 只包含不同的值，指定DISTINCT参数
SELECT goods_name,AVG(DISTINCT market_price) '平均价格' FROM goods WHERE cat_id = 3 GROUP BY goods_name

-- order by 与 limit：
-- 1、按照栏目由低到高排序，栏目相同按照价格由高到低排序
SELECT * FROM goods ORDER BY cat_id ASC,market_price DESC

-- 2、取出价格最高的前三名商品
SELECT * FROM goods ORDER BY market_price DESC LIMIT 0,3

-- 3、取出点击量第三名到第五名的商品
SELECT * FROM goods ORDER BY click_count DESC LIMIT 2,3

-- group by having
-- 1、这个店积压的货款：
SELECT SUM(goods_number*shop_price) AS '总积压贷款' FROM goods;

-- 2、查询该店每个栏目下挤压的货款
SELECT cat_id,SUM(goods_number*shop_price) AS '积压贷款' FROM goods GROUP BY cat_id

-- 3、查询该店每个栏目下挤压的货款 > 100
SELECT cat_id,SUM(goods_number*shop_price) AS total_price FROM goods GROUP BY cat_id HAVING total_price > 100

SELECT * FROM goods;
SELECT * FROM category;