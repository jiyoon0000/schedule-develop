# CH3. 일정관리 앱 Develop

## Lv0. API 명세서 및 ERD 작성
### API 명세서 작성 - postman 사용
https://documenter.getpostman.com/view/39376424/2sAY55ayAZ

----
### ERD 작성 - DB diagram 사용
<img width="1098" alt="스크린샷 2024-11-14 오전 10 00 15" src="https://github.com/user-attachments/assets/cdbe71ab-2a2f-4535-8bf0-c1c28636da20">

----
### SQL 작성
#### root 경로의 schedule.sql에 생성
```
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
```

----
## Lv1. 일정 CRUD
### 1. 일정을 저장, 조회, 수정, 삭제할 수 있다.
### 2. 일정이 가지는 필드
#### - 작성 유저명, 할일 제목, 할일 내용, 작성일, 수정일
##### - 작성/수정일 필드는 JPA Auditing 활용
----
## Lv2. 유저 CRUD
### 1. 유저를 저장, 조회, 삭제할 수 있다.
### 2. 유저가 가지는 필드
#### - 유저명, 이메일, 작성일, 수정일
#### - 작성/수정일 필드는 JPA Auditing 활용
### 3. 연관관계 구현
#### - 일정은 작성 유저명 필드 대신 유저 고유 식별자 필드를 가진다.
----
## Lv3. 회원가입
### 1. 유저에 비밀번호 필드 추가
----
## Lv4. 로그인(인증)
### 1.설명
#### - Cookie/Session을 활용해 로그인 기능을 구현
#### - 필터를 활용해 인증 처리를 할 수 있다.
#### - @Configuration을 활용해 필터를 등록할 수 있다.


### 2. 조건
#### - 이메일과 비밀번호를 활용해 로그인 기능을 구현
#### - 회원가입, 로그인 요청은 인증 처리에서 제외

### 3. 예외처리
#### - 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환
