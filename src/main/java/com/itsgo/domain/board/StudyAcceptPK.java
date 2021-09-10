package com.itsgo.domain.board;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyAcceptPK implements Serializable {
    private Long user;

    private Long board;
}
