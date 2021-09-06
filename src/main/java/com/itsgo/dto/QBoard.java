package com.itsgo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
public class QBoard
{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private int hit;
    private String content;
    private String write;
    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date createDate;
    @Column(insertable = false)
    private Date modifyDate;
//    0. 공개 1. 비공개
    private int secret;
//    0 미확인, 1 확인, 2 답변완료
    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private int processing;
}
