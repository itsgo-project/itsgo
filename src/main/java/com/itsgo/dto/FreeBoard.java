package com.itsgo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
@Setter
public class FreeBoard
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private int hit;
    @Column
    private String writer;
    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date createDate;
    @Column(insertable = false, updatable = false, columnDefinition = "null")
    private Date modifyDate;
}
