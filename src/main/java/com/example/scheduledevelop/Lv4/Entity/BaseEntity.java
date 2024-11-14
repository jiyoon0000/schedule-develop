package com.example.scheduledevelop.Lv4.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
//다른 entity에서 상속받을 수 있도록 설정
@MappedSuperclass
//jpa auditing 기능을 사용하여 entity의 생성, 수정 시점에 자동으로 기록되게 함.
@EntityListeners(AuditingEntityListener.class)

public class BaseEntity {

    //entity가 생성된 시간을 자동으로 기록
    @CreatedDate
    //최초 생성 후에는 수정되지 않도록 설정
    @Column(updatable = false)
    private LocalDateTime createdAt;

    //entity가 수정된 시간을 자동으로 기록
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
