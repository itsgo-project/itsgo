package com.itsgo.domain.board;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Notice")
public class BoardNotice extends Board {
}
