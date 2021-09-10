package com.itsgo.domain.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 80, nullable = false)
    private String password;

    private String profileImageUrl;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer loginCount;

    private LocalDateTime lastLoginAt;

    @Column(updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createAt;
}
