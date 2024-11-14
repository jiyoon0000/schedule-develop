-- User 테이블
CREATE TABLE User(
    id BIGINT AUTO_INCREMENT PRIMARY KEY, --고유 식별자
    username VARCHAR(50) NOT NULL, -- 사용자 이름
    email VARCHAR(100) NOT NULL UNIQUE, -- 사용자 이메일
    password VARCHAR(100) NOT NULL, --비밀번호
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, --작성일/수정일 (자동 생성 & 업데이트)
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
-- Schedule 테이블
CREATE TABLE SCHEDULE(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL, --user table 참조하는 외래키
    title VARCHAR(50) NOT NULL, --일정 제목
    contents TEXT, --일정 내용
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, --작성일/수정일 (자동 생성 & 업데이트)
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- 외래키 설정
    CONSTRAINT fk_user_schedule FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE
)