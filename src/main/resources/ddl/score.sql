
-- 성적 정보 저장 테이블
CREATE TABLE score (
	stu_num INT(10) PRIMARY KEY AUTO_INCREMENT
    , stu_name VARCHAR(200) NOT NULL
    , kor INT(3) NOT NULL
    , eng INT(3) NOT NULL
    , math INT(3) NOT NULL
    , total INT(3) 
    , average DECIMAL(5, 2) 
    , grade CHAR(1)
);