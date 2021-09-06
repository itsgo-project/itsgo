package com.itsgo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class NBoard
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
}
