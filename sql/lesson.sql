drop database if exists lesson;
create database lesson;
use lesson;

create table genre(
	genre_id int not null auto_increment,
	item_genre varchar(50) not null unique,
	registration_date datetime not null default current_timestamp,
	updated_date datetime not null default current_timestamp on update current_timestamp,
	primary key(genre_id)
);

create table item(
	item_id int auto_increment,
	item_name varchar(100) not null unique,
	item_genre varchar(50) not null,
	item_author varchar(50) not null,
	release_date varchar(50) not null,
	page int,
	isbm varchar(20),
	price decimal(7,2) not null,
	item_detail varchar(500),
	item_img01 varchar(255) not null default 'img/Product/noImage.png',
	item_img02 varchar(255),
	item_img03 varchar(255),
	stock int not null,
	delete_flg boolean not null default FALSE,
	registration_date datetime not null default current_timestamp,
	updated_date datetime not null default current_timestamp on update current_timestamp,
	primary key(item_id),
	foreign key(item_genre) references genre(item_genre) on update cascade on delete cascade
);

create table cart(
	user_id int not null,
	item_id int not null,
	item_name varchar(100) not null,
	order_count int not null,
	subtotal decimal(10,2) not null,
	item_img01 varchar(255) not null default 'img/Product/noImage.png',
	delete_flg boolean default FALSE,
	registration_date datetime not null default current_timestamp,
	updated_date datetime not null default current_timestamp on update current_timestamp,
	primary key(item_id,user_id),
	foreign key(item_id) references item(item_id) on update cascade on delete cascade
);

ALTER TABLE cart ADD FOREIGN KEY (item_name) REFERENCES item(item_name) on update cascade;


create table purchase(
	purchase_id int not null auto_increment,
	user_id int not null,
	item_id int not null,
	item_name varchar(100),
	item_img01 varchar(255) not null default 'img/Product/noImage.png',
	order_count int not null,
	subtotal decimal not null,
	payment_method int not null,
	shipping_address varchar(255) not null,
	purchase_date datetime not null default current_timestamp,
	updated_date datetime not null default current_timestamp,
	primary key(purchase_id,item_id)
	);

create table brand(
	credit_id int primary key not null,
	brand_name varchar(25) not null,
	brand_num int(6) not null
	);



/*TODO 商品担当 本番用インサート文です。 */

insert into genre(
item_genre)values
('Ｊａｖａ'),
('C言語'),
('データベース'),
('資格関連');

insert into item(item_name,item_genre,item_Author,release_date,page,isbm,price,item_detail,item_img01,stock)
values(
  'スッキリわかるJava入門 第2版',
  'Ｊａｖａ',
  '中山 清喬',
  '2014年08月',
  657,
  '978-4-8443-3638-9',
  2600,
  'Javaの「どうして?」「なぜそうなる?」が必ずわかる入門書の決定版!
  本書は、Javaの基礎から初学者には難しいとされるオブジェクト指向まで、
  膨らむ疑問にしっかり対応し、Javaプログラミングの「なぜ?」がわかる解説と約300点の豊富なイラストで、
  楽しく・詳しく・スッキリとマスターできる構成となっています。
  「なんとなくJavaを使っているけれど、オブジェクト指向の理解には自信がない」「学習の途中で挫折してしまった」という方にもおススメです。',
  'j001.jpg',
   50
),('Ｊａｖａの絵本  Ｊａｖａが好きになる新しい９つの扉  ゼロから学べる初心者の味方',
  'Ｊａｖａ',
  'アンク',
  '2016年12月',
  223,
  '978-4-7981-5037-6',
  1580,
  '本書はまずプログラミンとは何かというところから、Ｊａｖａ言語の基礎を知ってもらえるように書かれています。
  基礎に徹した内容で、Ｗｅｂアプリケーション、Ａｎｄｒｏｉｄプログラミング開発の手始めに読んでいただけるでしょう。
  イラストを多用し、難しいと言われるクラスやオブジェクトについても概念をすぐに理解できるようにした、もっとも簡単なＪａｖａ入門書です。',
  'j002.jpg',
   50
),('スッキリわかるＪａｖａ入門  実践編',
  'Ｊａｖａ',
  '中山清喬',
  '2014年09月',
  627,
  '978-4-8443-3677-8',
  2800,
  '大手ネット書店部門ランキング1位の『スッキリわかるJava入門』に続き、『実践編』でも改訂版が登場！
  ラムダ式や日付APIなどJava8の注目機能の解説を増補！
  さらにアジャイル関連やデザインパターンについての解説も徹底強化！
  本作では、正規表現やコレクション、データベース連携、開発ツール、リファクタリング、並列処理など、現場で必須の知識を広く取り上げていますので、
  基本文法やオブジェクト指向の概念はわかった、さらにステップアップするための知識を習得したい、という方にお勧めです！',
  'j003.jpg',
   50
),(
  'スッキリわかるサーブレット＆ＪＳＰ入門',
  'Ｊａｖａ',
  '国本大悟',
  '2014年05月',
  535,
  '978-4-8443-3580-1',
  2800,
  '現在、業務用Ｗｅｂシステム開発で幅広く利用されている「サーブレット」と「ＪＳＰ」は、
  非常に強力である一方、独学が難しい技術です。ＨＴＭＬやＨＴＴＰといった各種仕様、セッションやスコープをといった概念など、
  学習内容は多岐に及びます。本書は、それら学習内容をしくみやコツも含め、入門者の方が一歩ずつ着実に学べる一冊です。
  また、「エラー解決・虎の巻」もしっかり収録していますので、つまずいても安心です。',
  'j004.jpg',
   50
),(
  'パーフェクトＪａｖａＥＥ',
  'Ｊａｖａ',
  '井上誠一郎,槙俊明,上妻宜人,菊田洋一 ',
  '2016年08月',
  591,
  '978-4-7741-8316-9',
  3200,
  'サーバサイドのJavaで開発を行う人へのバイブル的1冊です。
  JavaEE7からJava EEの標準技術のみで大規模開発が可能になりました。
  そこで本書は、Java EEの標準技術をDI/Web層/データアクセス層に分け解説することで,
  大規模Webアプリケーション開発をする上での実践的な知識を一冊に凝縮しています。',
  'j005.jpg',
   50
),(
  '新・明解Ｊａｖａ入門',
  'Ｊａｖａ',
  '柴田望洋',
  '2016年06月',
  553,
  '978-4-7973-8760-5',
  2700,
  'この一冊で、Ｊａｖａの基礎からオブジェクト指向プログラミングまでを完全マスターしよう。
  プログラミング言語教育界の巨匠による、Ｊａｖａ入門書の最高峰！！
  適切なサンプルプログラム２５８編と分かりやすい図表２８４点を使い、一つ一つのステップを着実に進んでいく、ていねいな解説。',
  'j006.jpg',
   50
);


insert into item(item_name,item_genre,item_Author,release_date,page,isbm,price,item_detail,item_img01,stock)
values(
  '新・明解C言語 入門編 (明解シリーズ)',
  'C言語',
  '柴田 望洋',
  '2014年08月',
  416,
  '978-4-7973-7702-6',
  2300,
  '適切なサンプルプログラムと図表を使って、一つ一つのステップを着実に進めていく、
  語り口調の解説により、C言語の基礎を確実にマスターできます。
「最も明快で、最も正確なC言語入門書」として、
  日本で最も多くの読者から圧倒的な支持を受けているC言語入門書の大改訂版。',
  'c001.jpg',
   50
),('Ｃの絵本  Ｃ言語が好きになる新しい９つの扉  イラストだからわかる！イメージできる！',
  'C言語',
  'アンク',
  '2016年12月',
  195,
  '978-4-7981-5038-3',
  1380,
  'Ｃ言語には難解なトピックもあるため、文章だけではなかなかイメージがつかめず、
  理解しづらいものですね。本書はイラストで解説しているので、直観的にイメージをとらえることができ、
  理解も進みます。さあ、Ｃ言語への扉を開き、プログラマへの道を進んでいきましょう！',
  'c002.jpg',
   50
),('新・解きながら学ぶＣ言語',
  'C言語',
  '柴田望洋  由梨かおる',
  '2016年02月',
  343,
  '978-4-7973-8409-3',
  2000,
  'C言語入門書の最高峰『新・明解C言語入門編』の全演習問題を収録。
  一つ一つの問題を解きながら、C言語の基礎を身につけ、
  プログラミング能力を高めることができる、新しいスタイルの入門書。',
  'c003.jpg',
   50
),(
  '１２歳からはじめるゼロからのＣ言語ゲームプログラミング教室',
  'C言語',
  '大槻　有一郎',
  '2016年03月',
  295,
  '978-4-89977-445-7',
  2280,
  '本書では、簡単なプログラムでちょっと派手なことができる学習支援ツール「グラフィカルコンソール」を用意しました。
  たとえば画像を表示したいときは、1行書くだけでOKです。
  その結果、「ロールプレイングゲーム」や「恋愛シミュレーションゲーム」
  といったミニゲームを作りながら、楽しく基礎が学べます。',
  'c004.jpg',
   50
),(
  '苦しんで覚えるＣ言語',
  'C言語',
  'ＭＭＧａｍｅｓ',
  '2011年07月',
  479,
  '978-4-7980-3014-2',
  2200,
  'いつの時代も基本はC言語。ネットで人気のC講座を書籍化',
  'c005.jpg',
   50
),(
  'やさしいＣ',
  'C言語',
  '高橋　麻奈',
  '2012年09月',
  476,
  '9978-4-7973-7098-0',
  2500,
  'Ｃ言語入門のロングセラーが待望の改訂
  わかりやすさで定評のあるプログラミング入門書のベストセラー、高橋麻奈の「やさしい」シリーズ。
  Ｃ言語の基本を、スラスラ読める文と、シンプルでわかりやすいサンプルプログラムを使った解説で、
  プログラミング経験ゼロからでもスッキリ理解できます。',
  'c006.jpg',
   50
);

insert into brand(
	credit_id,
	brand_name,
	brand_num
)values(
	1,
	"Visa",
	411111
);


insert into brand(
	credit_id,
	brand_name,
	brand_num
)values(
	2,
	"MasterCard",
	555555
);


insert into brand(
	credit_id,
	brand_name,
	brand_num
)values(
	3,
	"American Express",
	378282
);


